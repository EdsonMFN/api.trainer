package api.trainer.rest.controller;

import api.trainer.domains.model.TrainingDto;
import api.trainer.rest.response.TrainingResponse;
import api.trainer.service.imp.TrainingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private TrainingServiceImp service;

    @PostMapping(value = "/{idTraining}")
    public ResponseEntity<TrainingResponse> createPDF(@RequestBody TrainingDto request, @PathVariable Long idTraining){
        TrainingResponse response = service.exportFile(request,idTraining);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
