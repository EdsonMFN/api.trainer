package api.trainer.domains.model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TrainerDto extends RegistrationDataDto{

    private Long id;
    private String description;
    private String Instagram;
    private String cref;
    private List<ClientDto> client;
}
