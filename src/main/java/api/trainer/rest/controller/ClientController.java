package api.trainer.rest.controller;

import api.trainer.domains.model.ClientDto;
import api.trainer.rest.response.ClientResponse;
import api.trainer.service.imp.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientServiceImp service;

    @PostMapping("/address{idAddress}/trainer{idTrainer}")
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientDto request, @PathVariable Long idAddress, @PathVariable Long idTrainer){
        ClientResponse response = service.createClient(request,idAddress,idTrainer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAllClient(){
        List<ClientResponse> responses = service.findAllClient();
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }
    @GetMapping("/{idClient}")
    public ResponseEntity<ClientResponse> findByIdClient(@PathVariable Long idClient){
        ClientResponse response = service.findByIdClient(idClient);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/client{idClient}/address{idAddress}/trainer{idTrainer}")
    public ResponseEntity<ClientResponse> updateClient(@RequestBody ClientDto request,@PathVariable Long idClient, @PathVariable Long idAddress, @PathVariable Long idTrainer){
        ClientResponse response = service.updateClient(request,idClient,idAddress,idTrainer);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{idClient}")
    public ResponseEntity<ClientResponse> deleteClient(@PathVariable Long idClient){
        ClientResponse response = service.deleteClient(idClient);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
