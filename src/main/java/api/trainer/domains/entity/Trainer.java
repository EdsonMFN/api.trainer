package api.trainer.domains.entity;

import api.trainer.domains.model.RegistrationData;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "trainer")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Trainer extends RegistrationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trainer")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "Instagram")
    private String Instagram;
    @Column(name = "cref")
    private String cref;
    @OneToMany(mappedBy = "trainer",cascade = CascadeType.ALL)
    private List<Client> client;

}
