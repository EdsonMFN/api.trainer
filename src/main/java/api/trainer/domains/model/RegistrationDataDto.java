package api.trainer.domains.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@SuperBuilder
public class RegistrationDataDto {

    private String name;
    private String cpf;
    private String email;
    private String phone;
    private String gender;
}
