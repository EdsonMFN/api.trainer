package api.trainer.rest.controller;

import api.trainer.domains.model.ExerciseDto;
import api.trainer.rest.response.ExerciseResponse;
import api.trainer.service.imp.ExerciseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseServiceImp service;

    @PostMapping
    public ResponseEntity<ExerciseResponse> createExercise(@RequestBody ExerciseDto request){
        ExerciseResponse response=service.createExercise(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
