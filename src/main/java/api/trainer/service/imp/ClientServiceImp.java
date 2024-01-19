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
import api.trainer.rest.request.TypesToSearch;
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

    public ClientResponse createClient(ClientDto request,Long idTrainer) {

        clientRepository.save(builderClient(request,idTrainer));

        return new ClientResponse("Client, created successfully");
    }
    public List<ClientResponse> findAllClient() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> responses = new ArrayList<>();
        try {
            clients.forEach(client -> {
                responses.add(new ClientResponse( ClientDto.builder()
                        .id(client.getId())
                        .phone(client.getPhone())
                        .email(client.getEmail())
                        .name(client.getName())
                        .gender(client.getGender())
                        .brithday(client.getBrithday())
                        .tpGroup(client.getTpGroup())
                        .active(client.getActive())
                        .cpf(client.getCpf())
                        .build()));
            });
            return responses;
        } catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public List<ClientResponse> findByFilter(TypesToSearch filter){
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> responses = new ArrayList<>();
            clients.stream()
                    .filter(client -> client.getActive().equals(filter.getDisabledClint()) ||
                            client.getId().equals(filter.getIdClient()) ||
                            (filter.getNameClient() != null && client.getName().toLowerCase().contains(filter.getNameClient().toLowerCase())))
                    .forEach(client -> {
                    ClientResponse response = new ClientResponse(ClientDto.builder()
                            .id(client.getId())
                            .phone(client.getPhone())
                            .email(client.getEmail())
                            .name(client.getName())
                            .gender(client.getGender())
                            .brithday(client.getBrithday())
                            .tpGroup(client.getTpGroup())
                            .active(client.getActive())
                            .cpf(client.getCpf())
                            .build());

                    responses.add(response);
            });
            return responses;
    }
    public ClientResponse updateClient(ClientDto request, Long idClient, Long idAddress, Long idTrainer) {
        try {
            Client client = clientRepository.findById(idClient)
                    .orElseThrow(() -> new HandlerEntityNotFoundException("Client not found with id:" + idClient));
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
                .orElseThrow(() -> new HandlerEntityNotFoundException("Client not found with id:" + idClient));
        try {
            if (client.getActive()){
                client.setActive(false);
                clientRepository.save(client);
               return new ClientResponse("Client successfully deactivated");
            }
            else {
                client.setActive(true);
                clientRepository.save(client);
               return new ClientResponse("Client successfully active");
            }

        } catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public Client builderClient(ClientDto request,Long idTrainer) {

        Trainer trainer = trainerRepository.findById(idTrainer)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Trainer not found with id:"+ idTrainer));
            var addressRequest = request.getAddress();
        try {
            Address address = new Address();
            address.setAddress(addressRequest.getAddress());
            address.setCep(addressRequest.getCep());
            address.setNumber(addressRequest.getNumber());
            address.setDistrict(addressRequest.getDistrict());
            address.setState(addressRequest.getState());
            address.setComplement(addressRequest.getComplement());
            addressRepository.save(address);

            Client client = new Client(request);
            client.setPhone(costumerPhone(request.getPhone()));
            client.setAddress(address);
            client.setTrainer(trainer);

            return client;
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    private static String costumerPhone(String numberPhone){
        if (numberPhone.length() == 11 && numberPhone.matches("\\d+")){
            return String.format("(%s)%s",
                    numberPhone.substring(0,2),
                    numberPhone.substring(3,11)
            );
        }else{
            throw new HandlerError("Invalid number, enter numbers only!");
        }
    }
}
