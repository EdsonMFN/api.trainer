package api.trainer.service.imp;

import api.trainer.domains.repository.ExerciseRepository;
import api.trainer.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExeciseServiceImp implements ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;
}
