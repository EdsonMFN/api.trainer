package api.trainer.domains.entity;

import api.trainer.domains.model.ExerciseDto;
import api.trainer.enums.MuscleGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "exercise")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercise")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "media")
    private String media;
    @Column(name = "muscle_group")
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;
    @OneToMany(mappedBy = "exercise")
    private List<TrainingExercise> trainingExercises;

    public Exercise(ExerciseDto exerciseDto) {
        this.id = exerciseDto.getId();
        this.nome = exerciseDto.getNome();
        this.media = exerciseDto.getMedia();
        this.muscleGroup = exerciseDto.getMuscleGroup();
    }
}
