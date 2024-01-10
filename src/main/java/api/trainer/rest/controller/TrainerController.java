package api.trainer.rest.controller;

import api.trainer.domains.model.TrainerDto;
import api.trainer.rest.response.TrainerResponse;
import api.trainer.service.imp.TrainerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    private TrainerServiceImp service;

    @PostMapping
    public ResponseEntity<TrainerResponse> createTrainer(@RequestBody TrainerDto request){
        TrainerResponse response = service.createTrainer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
