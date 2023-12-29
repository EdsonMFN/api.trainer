package api.trainer.service.imp;

import api.trainer.domains.repository.TrainerRepository;
import api.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImp implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;
}
