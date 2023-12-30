package api.trainer.service.imp;

import api.trainer.domains.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImp {
    @Autowired
    private TrainingRepository trainingRepository;
}
