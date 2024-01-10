package api.trainer.service.imp;

import api.trainer.domains.entity.Exercise;
import api.trainer.domains.model.ExerciseDto;
import api.trainer.domains.repository.ExerciseRepository;
import api.trainer.exception.handles.HandlerEntityNotFoundException;
import api.trainer.exception.handles.HandlerError;
import api.trainer.rest.response.ExerciseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImp {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public ExerciseResponse createExercise(ExerciseDto request){

        Exercise exercise = new Exercise(request);
        exerciseRepository.save(exercise);
        return new ExerciseResponse("Exercise created successfully");
    }
    public List<ExerciseResponse> findAllExercise(){
        List<Exercise> exercises = exerciseRepository.findAll();
        List<ExerciseResponse> responses = new ArrayList<>();

        exercises.forEach(exercise -> {

            ExerciseResponse response = new ExerciseResponse(ExerciseDto.builder()
                    .id(exercise.getId())
                    .nome(exercise.getNome())
                    .muscleGroup(exercise.getMuscleGroup())
                    .build());
            responses.add(response);
        });
        return responses;
    }
    public ExerciseResponse findByIdExercise(Long idExercise){
        Exercise exercise = exerciseRepository.findById(idExercise)
                .orElseThrow(()-> new HandlerEntityNotFoundException("Exercise not fund with id:" + idExercise));

        return new ExerciseResponse(ExerciseDto.builder()
                .id(exercise.getId())
                .nome(exercise.getNome())
                .muscleGroup(exercise.getMuscleGroup())
                .build());
    }
    public ExerciseResponse updateExercise(ExerciseDto request,Long idExercise){
        Exercise exercise = exerciseRepository.findById(idExercise)
                .orElseThrow(()-> new HandlerEntityNotFoundException("Exercise not fund with id:" + idExercise));
        exerciseRepository.save(exercise);
        return new ExerciseResponse("Exercise update successfully");
    }
    public ExerciseResponse deleteExercise(Long idExercise){
        Exercise exercise = exerciseRepository.findById(idExercise)
                .orElseThrow(()-> new HandlerEntityNotFoundException("Exercise not fund with id:" + idExercise));
        try {
            exerciseRepository.delete(exercise);
            return new ExerciseResponse("Exercise deleted successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
}
