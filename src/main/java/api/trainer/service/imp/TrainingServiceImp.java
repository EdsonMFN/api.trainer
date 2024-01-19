package api.trainer.service.imp;

import api.trainer.domains.entity.*;
import api.trainer.domains.model.TrainingDto;
import api.trainer.domains.repository.*;
import api.trainer.exception.handles.HandlerEntityNotFoundException;
import api.trainer.exception.handles.HandlerError;
import api.trainer.file.FilePDF;
import api.trainer.file.FileXlsx;
import api.trainer.rest.response.TrainingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImp {
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
    private FilePDF filePDF;
    @Autowired
    private FileXlsx fileXlsx;


    public TrainingResponse createExercise(TrainingDto request, Long idClient,Long idWorkoutRoutine){
        Client client = clientRepository.findById(idClient)
                .orElseThrow(()->new HandlerEntityNotFoundException("Client not found with id:" + idClient));
        WorkoutRoutine workoutRoutine = workoutRoutineRepository.findById(idWorkoutRoutine)
                .orElseThrow(()->new HandlerEntityNotFoundException("Workout Routine not found with id:" + idWorkoutRoutine));

        Training training = new Training(request);
        training.setClient(client);
        training.setWorkoutRoutine(workoutRoutine);

        training = trainingRepository.save(training);

        Training finalTraining = training;
        request.getTrainingExercises()
                .forEach(trainingExercisesDto -> {
                    Exercise exercise = exerciseRepository.findById(trainingExercisesDto.getExercise().getId())
                            .orElseThrow(()->new HandlerEntityNotFoundException("Exercise not found with id:" + trainingExercisesDto.getExercise().getId()));

                    TrainingExercises trainingExercises = new TrainingExercises(trainingExercisesDto);
                    trainingExercises.setTraining(finalTraining);
                    trainingExercises.setExercise(exercise);

            trainingExerciseRepository.save(trainingExercises);
        });
        return new TrainingResponse("Created training successfully");
    }
    public TrainingResponse findAllExercise(){
        return null;
    }
    public TrainingResponse findByIdExercise(Long idTraining){
        return null;
    }
    public TrainingResponse updateExercise(Long idTraining){
        return null;
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
        private boolean copyTraining (TrainingDto request){
            try {
                if (request.isCopy()) {
                    Training training = trainingRepository.findById(request.getId())
                            .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + request.getId()));

                    training.setTrainingIntensity(training.getTrainingIntensity());
                    training.setFeedback(training.getFeedback());
                    training.setTrainingExercises(training.getTrainingExercises());
                    trainingRepository.save(training);
                    new TrainingResponse("Copy with successfully");
                }
                return request.isCopy();
            } catch (Exception ex) {
                throw new HandlerError(ex.getMessage());
            }
        }
}
