package api.trainer.rest.controller;

import api.trainer.domains.model.ClientDto;
import api.trainer.rest.response.ClientResponse;
import api.trainer.service.imp.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientServiceImp service;

    @PostMapping("/address{idAddress}/trainer{idTrainer}")
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientDto request,Long idAddress,Long idTrainer){
        ClientResponse response = service.createClient(request,idAddress,idTrainer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
