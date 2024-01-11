package api.trainer.domains.repository;

import api.trainer.domains.entity.TrainingExercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingExerciseRepository extends JpaRepository<TrainingExercises,Long> {
}
