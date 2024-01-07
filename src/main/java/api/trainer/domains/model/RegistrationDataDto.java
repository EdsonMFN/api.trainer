package api.trainer.domains.model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class RegistrationDataDto {

    private String name;
    private String email;
    private String phone;
    private String gender;
}
