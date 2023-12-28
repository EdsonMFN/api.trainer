package api.trainer.rest.response;

import api.trainer.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponse {

    private Long id;
    private String address;
    private int number;
    private State state;
    private String district;
    private String complement;
    private String cep;

    private String msg;

    public ClientResponse(String msg) {
        this.msg = msg;
    }

    public ClientResponse(Long id, String address, int number, State state, String district, String complement, String cep) {
        this.id = id;
        this.address = address;
        this.number = number;
        this.state = state;
        this.district = district;
        this.complement = complement;
        this.cep = cep;
    }
}
