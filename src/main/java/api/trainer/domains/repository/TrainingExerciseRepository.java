package api.trainer.domains.repository;

import api.trainer.domains.entity.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise,Long> {

//    TrainingExercise findByExerciseId(Long exercise);


//    TrainingExercise findFirstByExerciseId(Long idExercise);

    TrainingExercise findFirstByExerciseIdAndTrainingId(Long idExercise,Long idTraining);
}
