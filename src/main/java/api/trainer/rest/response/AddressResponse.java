package api.trainer.rest.response;

import api.trainer.domains.model.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {

    private AddressDto addressDto;

    private String msg;

    public AddressResponse(String msg) {
        this.msg = msg;
    }
}
