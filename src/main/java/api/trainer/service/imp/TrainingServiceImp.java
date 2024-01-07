package api.trainer.service.imp;

import api.trainer.domains.model.TrainingDto;
import api.trainer.domains.repository.TrainingRepository;
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
}
