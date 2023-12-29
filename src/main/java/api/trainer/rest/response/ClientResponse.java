package api.trainer.rest.response;

import api.trainer.domains.model.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponse {

    private ClientDto clientDto;

    private String msg;

    public ClientResponse(String msg) {
        this.msg = msg;
    }


}
