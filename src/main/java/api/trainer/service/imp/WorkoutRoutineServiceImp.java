package api.trainer.service.imp;

import api.trainer.domains.entity.WorkoutRoutine;
import api.trainer.domains.model.WorkoutRoutineDto;
import api.trainer.domains.repository.ExerciseRepository;
import api.trainer.domains.repository.TrainingExerciseRepository;
import api.trainer.domains.repository.TrainingRepository;
import api.trainer.domains.repository.WorkoutRoutineRepository;
import api.trainer.rest.response.WorkoutRoutineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutRoutineServiceImp {
    @Autowired
    private WorkoutRoutineRepository workoutRoutineRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TrainingExerciseRepository trainingExerciseRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    public WorkoutRoutineResponse createExercise(WorkoutRoutineDto request){
        WorkoutRoutine workoutRoutine = new WorkoutRoutine(request);
        workoutRoutine.setFilePDF(request.isFilePDF());
        workoutRoutine.setPeriodization(request.isPeriodization());
        workoutRoutine.setTimeTraining(request.isTimeTraining());
        workoutRoutineRepository.save(workoutRoutine);
        return new WorkoutRoutineResponse("Created workout routine success");
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
