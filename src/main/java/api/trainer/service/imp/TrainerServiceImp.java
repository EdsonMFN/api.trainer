package api.trainer.service.imp;

import api.trainer.domains.model.TrainerDto;
import api.trainer.domains.repository.TrainerRepository;
import api.trainer.rest.response.ExerciseResponse;
import api.trainer.rest.response.TrainerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImp {
    @Autowired
    private TrainerRepository trainerRepository;

    public TrainerResponse createExercise(TrainerDto request){
        return null;
    }
    public TrainerResponse findAllExercise(){
        return null;
    }
    public TrainerResponse findByIdExercise(Long idTrainer){
        return null;
    }
    public TrainerResponse updateExercise(Long idTrainer){
        return null;
    }
    public TrainerResponse deleteExercise(Long idTrainer){
        return null;
    }
}
