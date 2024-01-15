package api.trainer.rest.controller;

import api.trainer.domains.model.TrainingDto;
import api.trainer.rest.response.TrainingResponse;
import api.trainer.service.imp.TrainingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingServiceImp service;

    @PostMapping(value = "/client/{idClient}/workoutRoutine/{idWorkoutRoutine}")
    public ResponseEntity<TrainingResponse> createdTraining(@RequestBody TrainingDto request,@PathVariable Long idClient,@PathVariable Long idWorkoutRoutine){
        TrainingResponse response = service.createExercise(request,idClient,idWorkoutRoutine);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
