package api.trainer.domains.model;

import api.trainer.enums.TpGroup;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class ClientDto extends RegistrationDataDto{
    private Long id;
    private boolean status;
    private TpGroup tpGroup;
    private LocalDate brithday;
    private AddressDto address;
    private List<TrainingDto> trainings;
    private TrainerDto trainer;
}
