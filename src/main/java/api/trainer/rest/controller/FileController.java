package api.trainer.rest.controller;

import api.trainer.rest.response.TrainingResponse;
import api.trainer.service.imp.TrainingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private TrainingServiceImp service;

    @PostMapping(value = "/{idTraining}")
    public ResponseEntity<TrainingResponse> createPDF(@PathVariable Long idTraining){
        TrainingResponse response = service.createPDF(idTraining);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping(value = "/xlsx/{idTraining}")
    public ResponseEntity<TrainingResponse> createXlsx(@PathVariable Long idTraining){
        TrainingResponse response = service.createXlsx(idTraining);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
