package api.trainer.domains.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingExercisesDto {

    private Long id;
    private String observation;
    private Integer series;
    private Integer repetitions;
    private Integer timeInterval;
    private TrainingDto training;
    private ExerciseDto exercise;
}
