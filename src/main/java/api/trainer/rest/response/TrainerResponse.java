package api.trainer.rest.response;

import api.trainer.domains.model.TrainerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainerResponse {
    private TrainerDto trainer;

    private String msg;

    public TrainerResponse(TrainerDto trainer) {
        this.trainer = trainer;
    }

    public TrainerResponse(String msg) {
        this.msg = msg;
    }
}
