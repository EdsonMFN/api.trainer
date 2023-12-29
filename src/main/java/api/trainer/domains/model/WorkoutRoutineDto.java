package api.trainer.domains.model;

import api.trainer.enums.Difficulty;
import api.trainer.enums.Goal;
import api.trainer.enums.TypeOfTraining;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutRoutineDto {
    private Long id;
    private String observation;
    private LocalDate startDate;
    private LocalDate finalDate;
    private boolean filePDF;
    private boolean timeTraining;
    private boolean periodization;
    private Goal goal;
    private Difficulty difficulty;
    private TypeOfTraining group;
}
