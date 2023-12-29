package api.trainer.domains.model;

import api.trainer.enums.TrainingIntensity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingDto {
    private Long id;
    private String feedback;
    private TrainingIntensity trainingIntensity;
    private ClientDto client;
    private WorkoutRoutineDto workoutRoutine;
    private List<ExerciseDto> exercises;
}
