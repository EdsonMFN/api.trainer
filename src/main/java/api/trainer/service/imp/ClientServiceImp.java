package api.trainer.service.imp;

import api.trainer.domains.entity.Address;
import api.trainer.domains.entity.Client;
import api.trainer.domains.entity.Trainer;
import api.trainer.domains.model.ClientDto;
import api.trainer.domains.repository.AddressRepository;
import api.trainer.domains.repository.ClientRepository;
import api.trainer.domains.repository.TrainerRepository;
import api.trainer.exception.handles.HandlerEntityNotFoundException;
import api.trainer.exception.handles.HandlerError;
import api.trainer.rest.response.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImp{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    public ClientResponse createClient(ClientDto request,Long idAddress,Long idTrainer) {

        clientRepository.save(builderClient(request,idAddress,idTrainer));

        return new ClientResponse(request, "Client, created successfully");
    }
    public List<ClientResponse> findAllClient() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> responses = new ArrayList<>();
        try {
            clients.parallelStream().forEach(client -> {
                ClientResponse response = new ClientResponse(ClientDto.builder()
                        .id(client.getId())
                        .status(client.isStatus())
                        .tpGroup(client.getTpGroup())
                        .brithday(client.getBrithday())
                        .build());

                responses.add(response);
            });
            return responses;
        } catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ClientResponse findByIdClient(Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Address not found with id:" + idClient));
        try {
            return new ClientResponse(ClientDto.builder()
                    .id(client.getId())
                    .status(client.isStatus())
                    .tpGroup(client.getTpGroup())
                    .brithday(client.getBrithday())
                    .build());
        } catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ClientResponse updateClient(ClientDto request, Long idClient, Long idAddress, Long idTrainer) {
        try {
            Client client = clientRepository.findById(idClient)
                    .orElseThrow(() -> new HandlerEntityNotFoundException("Address not found with id:" + idClient));
            Address address = addressRepository.findById(idAddress)
                    .orElseThrow(() -> new HandlerEntityNotFoundException("Address not found with id:"+idAddress));
            Trainer trainer = trainerRepository.findById(idTrainer)
                    .orElseThrow(() -> new HandlerEntityNotFoundException("Trainer not found with id:"+ idTrainer));
            new Client(request);
            client.setAddress(address);
            client.setTrainer(trainer);
            clientRepository.save(client);

            return new ClientResponse(request, "Client, update successfully");
        } catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ClientResponse deleteClient(Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Address not found with id:" + idClient));
        try {
            clientRepository.delete(client);
            return new ClientResponse("Client, deleted with successfully");
        } catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public Client builderClient(ClientDto request,Long idAddress,Long idTrainer) {
        Address address = addressRepository.findById(idAddress)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Address not found with id:"+idAddress));
        Trainer trainer = trainerRepository.findById(idTrainer)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Trainer not found with id:"+ idTrainer));
        try {
            Client client = new Client(request);
            client.setAddress(address);
            client.setTrainer(trainer);

            return client;
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    private String costumerPhone(String numberPhone){
        if (numberPhone.length() == 11 && numberPhone.matches("\\d+")){
            return String.format("(%s) %s",
                    numberPhone.substring(0,2),
                    numberPhone.substring(3,11)
            );
        }else{
            throw new HandlerError("Invalid number, enter numbers only!");
        }
    }
}
