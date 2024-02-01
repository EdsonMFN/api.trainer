package api.trainer.domains.model;

import api.trainer.enums.TrainingIntensity;
import api.trainer.enums.TypeFile;
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
    private ClientTrainingDto clientTraining;
    private TrainingIntensity trainingIntensity;
    private Boolean copy;
    private ClientDto client;
    private WorkoutRoutineDto workoutRoutine;
    private List<TrainingExercisesDto> trainingExercises;
    private TypeFile typeFile;
}
