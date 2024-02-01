package api.trainer.service.imp;

import api.trainer.domains.entity.*;
import api.trainer.domains.model.ClientTrainingDto;
import api.trainer.domains.model.TrainingDto;
import api.trainer.domains.model.TrainingExercisesDto;
import api.trainer.domains.repository.*;
import api.trainer.exception.handles.HandlerEntityNotFoundException;
import api.trainer.exception.handles.HandlerError;
import api.trainer.file.FilePDF;
import api.trainer.file.FileXlsx;
import api.trainer.rest.response.TrainingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingServiceImp {
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TrainingExerciseRepository trainingExerciseRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private WorkoutRoutineRepository workoutRoutineRepository;
    @Autowired
    private ClientTrainingRepository clientTrainingRepository;
    @Autowired
    private FilePDF filePDF;
    @Autowired
    private FileXlsx fileXlsx;


    public TrainingResponse createExercise(TrainingDto request, Long idClient,Long idWorkoutRoutine,Long idTrainer){
        Client client = clientRepository.findById(idClient)
                .orElseThrow(()->new HandlerEntityNotFoundException("Client not found with id:" + idClient));
        WorkoutRoutine workoutRoutine = workoutRoutineRepository.findById(idWorkoutRoutine)
                .orElseThrow(()->new HandlerEntityNotFoundException("Workout Routine not found with id:" + idWorkoutRoutine));
        Trainer trainer = trainerRepository.findById(idTrainer)
                .orElseThrow(()->new HandlerEntityNotFoundException("Client not found with id:" + idClient));

        Training training = new Training(request);
        training.setClient(client);
        training.setWorkoutRoutine(workoutRoutine);
        training.setTrainer(trainer);
        
        training = trainingRepository.save(training);
        
        Training finalTraining = training;
        request.getTrainingExercises()
                .forEach(trainingExercisesDto -> {
                    Exercise exercise = exerciseRepository.findById(trainingExercisesDto.getExercise().getId())
                            .orElseThrow(()->new HandlerEntityNotFoundException("Exercise not found with id:" + trainingExercisesDto.getExercise().getId()));

                    TrainingExercise trainingExercise = new TrainingExercise(trainingExercisesDto);
                    trainingExercise.setTraining(finalTraining);
                    trainingExercise.setExercise(exercise);

            trainingExerciseRepository.save(trainingExercise);
        });
        return new TrainingResponse("Created training successfully");
    }
    public TrainingResponse findAllExercise(){
        return null;
    }
    public TrainingResponse findByIdExercise(Long idTraining){
        return null;
    }

    public TrainingResponse updateStartTrainingAndWeight(TrainingDto request,Long idTraining){

        Training training = trainingRepository.findById(idTraining)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + idTraining));
        ClientTraining clientTraining = clientTrainingRepository.findByStartTraining(LocalDateTime.now());

        List<ClientTraining> clientTrainings = training.getClientTrainings();

        var requestClientTraining = request.getClientTraining();

        if (clientTraining != null){

            clientTraining.setEndTraining(requestClientTraining.getEndTraining());
            clientTraining.setFeedback(requestClientTraining.getFeedback());
            clientTraining.setTrainingIntensity(requestClientTraining.getTrainingIntensity());
            clientTrainings.add(clientTraining);
        }else {
            ClientTraining clientTrainingStart = new ClientTraining();

            clientTrainingStart.setStartTraining(LocalDateTime.now());
            training.getClientTrainings().add(clientTrainingStart);
            clientTraining = clientTrainingStart;
        }

        clientTraining.setTraining(training);
        clientTraining.setFeedback(requestClientTraining.getFeedback());
        clientTraining.setEndTraining(requestClientTraining.getEndTraining());
        clientTraining.setTrainingIntensity(requestClientTraining.getTrainingIntensity());
        clientTrainingRepository.save(clientTraining);

        training.setClientTrainings(clientTrainings);
        training.setTrainingExercises(clientUpdateWeight(request,idTraining));
        trainingRepository.save(training);

        ClientTrainingDto clientTrainingDto = ClientTrainingDto.builder()
                .id(clientTraining.getId())
                .trainingIntensity(clientTraining.getTrainingIntensity())
                .duration(timeTraining(LocalDateTime.now(),clientTraining.getEndTraining()))
                .build();

        return new TrainingResponse(TrainingDto.builder()
                .id(training.getId())
                .clientTraining(clientTrainingDto)
                .build());
    }

    public TrainingResponse trainerUpdateTraining(TrainingDto request,Long idTraining,Long idClient){
        Training training = trainingRepository.findById(idTraining)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + idTraining));
        Client client = clientRepository.findById(idClient)
                .orElseThrow(()->new HandlerEntityNotFoundException("Client not found with id:" + idClient));

        training.setTrainingIntensity(request.getTrainingIntensity());
        training.setClient(client);
        trainingRepository.save(training);

        request.getTrainingExercises().forEach(trainingExercisesDto -> {
            Exercise exercise = exerciseRepository.findById(trainingExercisesDto.getExercise().getId())
                    .orElseThrow(()->new HandlerEntityNotFoundException("Exercise not found with id:" + trainingExercisesDto.getExercise().getId()));

            TrainingExercise trainingExercise = new TrainingExercise(trainingExercisesDto);
            trainingExercise.setTraining(training);
            trainingExercise.setExercise(exercise);

            trainingExerciseRepository.save(trainingExercise);
        });
        return new TrainingResponse("Update training successfully");
    }
    public TrainingResponse deleteExercise(Long idTraining){
        return null;
    }

    public TrainingResponse exportFile(TrainingDto request,Long idTraining) {
        Training training = trainingRepository.findById(idTraining)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + idTraining));
        try {
                request.getTypeFile().getDescription().createFile(request.getTypeFile().getTypeFile(),training);
            return new TrainingResponse("Training file in format "+ String.valueOf(request.getTypeFile()) +", exported successfully");
        } catch (Exception e) {
            throw new HandlerError("Erro ao criar o PDF: Arquivo não encontrado");
        }
    }
    private Boolean copyTraining (TrainingDto request){
        try {
            if (request.getCopy()) {
                Training training = trainingRepository.findById(request.getId())
                        .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + request.getId()));

                training.setTrainingIntensity(training.getTrainingIntensity());
                training.setTrainingExercises(training.getTrainingExercises());
                trainingRepository.save(training);
                new TrainingResponse("Copy with successfully");
            }
            return request.getCopy();
        } catch (Exception ex) {
            throw new HandlerError(ex.getMessage());
        }
    }
    private String timeTraining(LocalDateTime startTraining, LocalDateTime endTraining){
        String timeTotal = String.valueOf(endTraining);
        Duration duration = Duration.between(startTraining,endTraining);

        long hours = duration.toHours() %24;
        long minutes = duration.toMinutes() %60;

        return timeTotal + " the duration of the training was, " + hours+":"+minutes ;
    }
    private List<TrainingExercise>clientUpdateWeight(TrainingDto request,Long idTraining){
        Training training = trainingRepository.findById(idTraining)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + idTraining));

        List<TrainingExercise>trainingExercises = training.getTrainingExercises();

        request.getTrainingExercises()
                .forEach(trainingExercisesDto -> {

                    TrainingExercise trainingExercise = trainingExerciseRepository.findFirstByExerciseIdAndTrainingId
                            (trainingExercisesDto.getExercise().getId(),
                                    idTraining);

                    if (trainingExercise.getWeight() != null){
                        final TrainingExercise trainingExerciseNew = getTrainingExercise(trainingExercisesDto,trainingExercise);
                        trainingExercise = trainingExerciseNew;

                        trainingExercises.add(trainingExerciseNew);
                    }
                    else {
                        trainingExercise.setWeight(trainingExercisesDto.getWeight());

                        trainingExercises.add(trainingExercise);
                    }

                    trainingExercise.setExercise(trainingExercise.getExercise());
                    trainingExercise.setTraining(trainingExercise.getTraining());
                    trainingExerciseRepository.save(trainingExercise);

                });
        return trainingExercises;
    }
    private static TrainingExercise getTrainingExercise(TrainingExercisesDto trainingExercisesDto, TrainingExercise trainingExercise) {
        TrainingExercise trainingExerciseNew = new TrainingExercise();
        trainingExerciseNew.setExercise(trainingExercise.getExercise());
        trainingExerciseNew.setTraining(trainingExercise.getTraining());
        trainingExerciseNew.setTimeInterval(trainingExercise.getTimeInterval());
        trainingExerciseNew.setObservation(trainingExercise.getObservation());
        trainingExerciseNew.setRepetitions(trainingExercise.getRepetitions());
        trainingExerciseNew.setSeries(trainingExercise.getSeries());
        trainingExerciseNew.setWeight(trainingExercisesDto.getWeight());
        return trainingExerciseNew;
    }
}
