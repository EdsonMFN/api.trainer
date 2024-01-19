package api.trainer.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypesToSearch {

    private Boolean disabledClint;
    private String nameClient;
    private Long idClient;

}
