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

    @PostMapping(value = "/client/{idClient}/workoutRoutine/{idWorkoutRoutine}/trainer/{idTrainer}")
    public ResponseEntity<TrainingResponse> createdTraining(@RequestBody TrainingDto request,@PathVariable Long idClient,@PathVariable Long idWorkoutRoutine,@PathVariable Long idTrainer){
        TrainingResponse response = service.createExercise(request,idClient,idWorkoutRoutine,idTrainer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping(value = "/{idTraining}")
    public  ResponseEntity<TrainingResponse> updateTraining(@RequestBody TrainingDto request,@PathVariable Long idTraining){
        TrainingResponse response = service.updateStartTrainingAndWeight(request,idTraining);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping(value = "/{idTraining}/client/{idClient}")
    public  ResponseEntity<TrainingResponse> updateTraining(@RequestBody TrainingDto request,@PathVariable Long idTraining,@PathVariable Long idClient){
        TrainingResponse response = service.trainerUpdateTraining(request,idTraining,idClient);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
