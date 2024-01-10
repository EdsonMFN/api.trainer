package api.trainer.domains.model;

import api.trainer.domains.entity.Training;
import api.trainer.enums.MuscleGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseDto {

    private Long id;
    private String nome;
    private String media;
    private MuscleGroup muscleGroup;
    private Training training;
}
