package api.trainer.domains.entity;

import api.trainer.enums.TrainingIntensity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "training")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    private Long id;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "training_intensity")
    @Enumerated(EnumType.STRING)
    private TrainingIntensity trainingIntensity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_workoutRoutine")
    private WorkoutRoutine workoutRoutine;
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Exercise> exercises;

}
