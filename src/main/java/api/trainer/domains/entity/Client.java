package api.trainer.domains.entity;

import api.trainer.domains.model.ClientDto;
import api.trainer.enums.TpGroup;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Table(name = "client")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Client extends RegistrationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;
    @Column(name = "status")
    private boolean status;
    @Column(name = "tpGroup")
    @Enumerated(EnumType.STRING)
    private TpGroup tpGroup;
    @Column(name = "brithday")
    private LocalDate brithday;
    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Training> trainings;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trainer")
    private Trainer trainer;

    public Client(ClientDto clientDto) {
        super(
                clientDto.getName(),
                clientDto.getEmail(),
                clientDto.getPhone(),
                clientDto.getGender()
        );
        this.id = clientDto.getId();
        this.status = clientDto.isStatus();
        this.tpGroup = clientDto.getTpGroup();
        this.brithday = clientDto.getBrithday();
        if (clientDto.getAddress()!=null){
            this.address = new Address(clientDto.getAddress());
        }
        if (clientDto.getTrainer()!=null){
            this.trainer = new Trainer(clientDto.getTrainer());
        }
    }
}
