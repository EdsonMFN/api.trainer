package api.trainer.domains.repository;

import api.trainer.domains.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training,Long> {
}
