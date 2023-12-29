package api.trainer.domains.model;

import api.trainer.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private Long id;
    private String address;
    private int number;
    private State state;
    private String district;
    private String complement;
    private String cep;
}
