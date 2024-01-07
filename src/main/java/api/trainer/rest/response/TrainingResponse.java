package api.trainer.rest.response;

import api.trainer.domains.model.TrainingDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingResponse {
    private TrainingDto training;

    private String msg;

    public TrainingResponse(TrainingDto training) {
        this.training = training;
    }

    public TrainingResponse(String msg) {
        this.msg = msg;
    }
}
