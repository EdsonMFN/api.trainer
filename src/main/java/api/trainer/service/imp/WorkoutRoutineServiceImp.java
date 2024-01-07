package api.trainer.service.imp;

import api.trainer.domains.model.WorkoutRoutineDto;
import api.trainer.domains.repository.WorkoutRoutineRepository;
import api.trainer.rest.response.WorkoutRoutineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutRoutineServiceImp {
    @Autowired
    private WorkoutRoutineRepository workoutRoutineRepository;

    public WorkoutRoutineResponse createExercise(WorkoutRoutineDto request){
        return null;
    }
    public WorkoutRoutineResponse findAllExercise(){
        return null;
    }
    public WorkoutRoutineResponse findByIdExercise(Long idWorkoutRoutine){
        return null;
    }
    public WorkoutRoutineResponse updateExercise(Long idWorkoutRoutine){
        return null;
    }
    public WorkoutRoutineResponse deleteExercise(Long idWorkoutRoutine){
        return null;
    }
}
