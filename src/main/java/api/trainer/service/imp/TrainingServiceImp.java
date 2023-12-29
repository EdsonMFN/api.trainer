package api.trainer.service.imp;

import api.trainer.domains.repository.TrainingRepository;
import api.trainer.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImp implements TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;
}
