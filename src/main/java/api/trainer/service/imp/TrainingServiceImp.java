package api.trainer.service.imp;

import api.trainer.domains.entity.Training;
import api.trainer.domains.model.TrainingDto;
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

    public TrainingResponse createExercise(TrainingDto request){
        return null;
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

    public TrainingResponse copyTraining (TrainingDto request,Long idTraining){
        Training training = trainingRepository.findById(idTraining)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + idTraining));
        try {
            if (training.isCopy()){
//                training.setExercises(request.getExercises());
                training.setTrainingIntensity(request.getTrainingIntensity());
                training.setObservation(request.getObservation());
                training.setFeedback(request.getFeedback());
                training.setSeries(request.getSeries());
                training.setRepetitions(request.getRepetitions());
                training.setTimeInterval(training.getTimeInterval());
            }
            return new TrainingResponse("Copy with successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
}
