package api.trainer.domains.entity;

import api.trainer.domains.model.TrainingDto;
import api.trainer.enums.TrainingIntensity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    @Column(name = "training_intensity")
    @Enumerated(EnumType.STRING)
    private TrainingIntensity trainingIntensity;
    @Column(name = "copy")
    private Boolean copy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_workoutRoutine")
    private WorkoutRoutine workoutRoutine;
    @OneToMany(mappedBy = "training")
    private List<TrainingExercise> trainingExercises;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trainer")
    private Trainer trainer;
    @OneToMany(mappedBy = "training")
    private List<ClientTraining> clientTrainings;

    public Training(TrainingDto trainingDto) {
        this.id = trainingDto.getId();
        this.trainingIntensity = trainingDto.getTrainingIntensity();
        this.copy = trainingDto.getCopy();
        this.client = new Client();
        this.workoutRoutine = new WorkoutRoutine();
        this.trainingExercises = new ArrayList<>();
        this.trainer = new Trainer();
        this.clientTrainings = new ArrayList<>();
    }
}