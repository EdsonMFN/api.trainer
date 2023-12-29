package api.trainer.domains.model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@MappedSuperclass
public class TrainerDto extends RegistrationDataDto{

    private Long id;
    private String description;
    private String Instagram;
    private String cref;
    private List<ClientDto> client;
}
