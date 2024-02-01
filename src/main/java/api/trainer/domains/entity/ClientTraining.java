package api.trainer.domains.entity;

import api.trainer.enums.TrainingIntensity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "client_training")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client_training")
    private Long id;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "startTraining")
    private LocalDateTime startTraining;
    @Column(name = "endTraining")
    private LocalDateTime endTraining;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_training")
    private Training training;
    @Column(name = "training_intensity")
    @Enumerated(EnumType.STRING)
    private TrainingIntensity trainingIntensity;

}