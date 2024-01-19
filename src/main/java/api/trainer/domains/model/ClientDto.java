package api.trainer.domains.model;

import api.trainer.enums.TpGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
    private Boolean active = true;
    private TpGroup tpGroup;
    private LocalDate brithday;
    private AddressDto address;
    private List<TrainingDto> trainings;
    private TrainerDto trainer;

//    public ClientDto(Client client){
//        builder(client);
//    }
//    public ClientDto builder(Client client){
//        return ClientDto.builder()
//                .id(client.getId())
//                .active(client.getActive())
//                .tpGroup(client.getTpGroup())
//                .brithday(client.getBrithday())
//                .name(client.getName())
//                .email(client.getEmail())
//                .phone(client.getPhone())
//                .gender(client.getGender())
//                .build();
//    }
}
