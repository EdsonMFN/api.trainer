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

import java.util.List;

@Service
public class ClientServiceImp{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    public ClientResponse createClient(ClientDto request,Long idAddres,Long idTrainer) {

        clientRepository.save(builderClient(request,idAddres,idTrainer));

        return new ClientResponse(request, "Client: {}, created successfully");
    }

    public List<ClientResponse> findAllClient() {
        return null;
    }

    public ClientResponse findByIdClient(Long idClient) {
        return null;
    }

    public ClientResponse updateClient(ClientDto request) {
        return null;
    }

    public ClientResponse deleteClient(Long idClient) {
        return null;
    }

    public Client builderClient(ClientDto request,Long idAddres,Long idTrainer)
    {
        Address address = addressRepository.findById(idAddres)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Address not found whith id: {}",request.getAddress().getId()));
        Trainer trainer = trainerRepository.findById(idTrainer)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Trainer not found whith id: {}", request.getTrainer().getId()));
        Client client = new Client(request);
        client.setAddress(address);
        client.setTrainer(trainer);

        return client;
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
