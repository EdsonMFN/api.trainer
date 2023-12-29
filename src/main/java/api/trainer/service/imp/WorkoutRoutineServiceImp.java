package api.trainer.service.imp;

import api.trainer.domains.repository.WorkoutRoutineRepository;
import api.trainer.service.WorkoutRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutRoutineServiceImp implements WorkoutRoutineService {
    @Autowired
    private WorkoutRoutineRepository workoutRoutineRepository;
}
