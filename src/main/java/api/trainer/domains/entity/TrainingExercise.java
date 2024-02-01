package api.trainer.domains.entity;

import api.trainer.domains.model.TrainingExercisesDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "training_exercise")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training_exercise")
    private Long id;
    @Column(name = "observation")
    private String observation;
    @Column(name = "series")
    private Integer series;
    @Column(name = "repetitions")
    private Integer repetitions;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "time_interval")
    private Integer timeInterval;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_training")
    private Training training;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

    public TrainingExercise(TrainingExercisesDto tgExercisesDto) {
        this.observation = tgExercisesDto.getObservation();
        this.series = tgExercisesDto.getSeries();
        this.repetitions = tgExercisesDto.getRepetitions();
        this.weight = tgExercisesDto.getWeight();
        this.timeInterval = tgExercisesDto.getTimeInterval();
        this.training = new Training();
        this.exercise = new Exercise();
    }
}
