package api.trainer.domains.model;

import api.trainer.domains.entity.Training;
import api.trainer.enums.TrainingIntensity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientTrainingDto {
    private Long id;
    private String feedback;
    private LocalDateTime startTraining;
    private LocalDateTime endTraining;
    private String duration;
    private Training training;
    private TrainingIntensity trainingIntensity;

}
