package api.trainer.service.imp;

import api.trainer.domains.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImp {
    @Autowired
    private TrainerRepository trainerRepository;
}
