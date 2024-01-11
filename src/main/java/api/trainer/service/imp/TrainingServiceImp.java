package api.trainer.service.imp;

import api.trainer.domains.entity.Client;
import api.trainer.domains.entity.Exercise;
import api.trainer.domains.entity.Training;
import api.trainer.domains.entity.TrainingExercises;
import api.trainer.domains.model.TrainingDto;
import api.trainer.domains.repository.ClientRepository;
import api.trainer.domains.repository.ExerciseRepository;
import api.trainer.domains.repository.TrainingExerciseRepository;
import api.trainer.domains.repository.TrainingRepository;
import api.trainer.exception.handles.HandlerEntityNotFoundException;
import api.trainer.exception.handles.HandlerError;
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

    public TrainingResponse createExercise(TrainingDto request, Long idClient){
        Client client = clientRepository.findById(idClient)
                .orElseThrow(()->new HandlerEntityNotFoundException("Client not found with id:" + idClient));

        Training training = new Training(request);
        training.setCopy(copyTraining(request));
        training.setClient(client);
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

    public boolean copyTraining (TrainingDto request){

        try {
            if (request.isCopy()){
                Training training = trainingRepository.findById(request.getId())
                        .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + request.getId()));

                training.setTrainingIntensity(training.getTrainingIntensity());
                training.setFeedback(training.getFeedback());
                training.setTrainingExercises(training.getTrainingExercises());
                trainingRepository.save(training);
                new TrainingResponse("Copy with successfully");
            }
        return request.isCopy();
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
}
