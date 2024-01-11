package api.trainer.rest.controller;

import api.trainer.domains.model.WorkoutRoutineDto;
import api.trainer.rest.response.WorkoutRoutineResponse;
import api.trainer.service.imp.WorkoutRoutineServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workoutRoutine")
public class WorkoutRoutineController {

    @Autowired
    private WorkoutRoutineServiceImp service;

    @PostMapping
    public ResponseEntity<WorkoutRoutineResponse> createdWorkoutRoutine(@RequestBody WorkoutRoutineDto request){
        WorkoutRoutineResponse response = service.createExercise(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
