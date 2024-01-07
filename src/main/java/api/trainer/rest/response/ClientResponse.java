package api.trainer.rest.response;

import api.trainer.domains.model.ClientDto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponse {

    private ClientDto client;

    private String msg;

    public ClientResponse(String msg) {
        this.msg = msg;
    }

    public ClientResponse(ClientDto client) {
        this.client = client;
    }
}
