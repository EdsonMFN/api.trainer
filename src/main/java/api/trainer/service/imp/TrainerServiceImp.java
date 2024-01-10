package api.trainer.service.imp;

import api.trainer.domains.entity.Trainer;
import api.trainer.domains.model.TrainerDto;
import api.trainer.domains.repository.TrainerRepository;
import api.trainer.rest.response.TrainerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImp {
    @Autowired
    private TrainerRepository trainerRepository;

    public TrainerResponse createTrainer(TrainerDto request){
        Trainer trainer = new Trainer(request);
        trainerRepository.save(trainer);
        return new TrainerResponse("Created trainer successfully");
    }
    public TrainerResponse findAllTrainer(){
        return null;
    }
    public TrainerResponse findByIdTrainer(Long idTrainer){
        return null;
    }
    public TrainerResponse updateTrainer(Long idTrainer){
        return null;
    }
    public TrainerResponse deleteTrainer(Long idTrainer){
        return null;
    }
}
