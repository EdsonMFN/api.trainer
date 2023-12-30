package api.trainer.service.imp;

import api.trainer.domains.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExeciseServiceImp {
    @Autowired
    private ExerciseRepository exerciseRepository;
}
