package api.trainer.service.imp;

import api.trainer.domains.repository.WorkoutRoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutRoutineServiceImp {
    @Autowired
    private WorkoutRoutineRepository workoutRoutineRepository;
}
