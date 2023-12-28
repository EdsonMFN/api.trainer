package api.trainer.domains.repository;

import api.trainer.domains.entity.WorkoutRoutine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRoutineRepository extends JpaRepository<WorkoutRoutine,Long> {
}
