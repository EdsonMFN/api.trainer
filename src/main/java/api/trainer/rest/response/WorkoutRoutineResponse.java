package api.trainer.rest.response;

import api.trainer.domains.model.WorkoutRoutineDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutRoutineResponse {
    private WorkoutRoutineDto workoutRoutine;

    private String msg;

    public WorkoutRoutineResponse(WorkoutRoutineDto workoutRoutine) {
        this.workoutRoutine = workoutRoutine;
    }

    public WorkoutRoutineResponse(String msg) {
        this.msg = msg;
    }
}
