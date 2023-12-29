package api.trainer.service.imp;

import api.trainer.domains.repository.ClientRepository;
import api.trainer.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
}
