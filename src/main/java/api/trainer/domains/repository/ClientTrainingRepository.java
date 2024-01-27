package api.trainer.domains.repository;

import api.trainer.domains.entity.ClientTraining;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ClientTrainingRepository extends JpaRepository<ClientTraining,Long> {

    ClientTraining findByStartTraining(LocalDateTime startTraining);
}
