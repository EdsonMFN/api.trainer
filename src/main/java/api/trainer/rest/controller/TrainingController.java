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

    @PostMapping(value = "/client/{idClient}")
    public ResponseEntity<TrainingResponse> createdTraining(@RequestBody TrainingDto request,@PathVariable Long idClient){
        TrainingResponse response = service.createExercise(request,idClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
