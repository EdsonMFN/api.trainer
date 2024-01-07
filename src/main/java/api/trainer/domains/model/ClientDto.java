package api.trainer.domains.model;

import api.trainer.enums.TpGroup;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class ClientDto extends RegistrationDataDto{

    private Long id;
    private boolean status;
    private TpGroup tpGroup;
    private LocalDate brithday;
    private AddressDto address;
    private List<TrainingDto> trainings;
    private TrainerDto trainer;
}
