package api.trainer.rest.response;

import api.trainer.domains.model.ExerciseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseResponse {
    private ExerciseDto exercise;

    private String msg;

    public ExerciseResponse(ExerciseDto exercise) {
        this.exercise = exercise;
    }

    public ExerciseResponse(String msg) {
        this.msg = msg;
    }
}
