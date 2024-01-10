package api.trainer.domains.model;

import api.trainer.enums.TpGroup;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ClientDto extends RegistrationDataDto{

    private Long id;
    private boolean status;
    private TpGroup tpGroup;
    private LocalDate brithday;
    private AddressDto address;
    private List<TrainingDto> trainings;
    private TrainerDto trainer;
}
