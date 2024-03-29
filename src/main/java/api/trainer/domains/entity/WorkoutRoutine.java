package api.trainer.domains.entity;

import api.trainer.domains.model.WorkoutRoutineDto;
import api.trainer.enums.Difficulty;
import api.trainer.enums.Goal;
import api.trainer.enums.TypeOfTraining;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "workout_routine")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_workout_routine")
    private Long id;
    @Column(name = "observation")
    private String observation;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "final_date")
    private LocalDate finalDate;
    @Column(name = "periodization")
    private Boolean periodization;
    @Column(name = "goal")
    @Enumerated(EnumType.STRING)
    private Goal goal;
    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Column(name = "type_of_training")
    @Enumerated(EnumType.STRING)
    private TypeOfTraining group;
    @OneToMany(mappedBy = "workoutRoutine")
    private List<Training> trainings;

    public WorkoutRoutine(WorkoutRoutineDto workoutRoutineDto) {
        this.id = workoutRoutineDto.getId();
        this.observation = workoutRoutineDto.getObservation();
        this.startDate = workoutRoutineDto.getStartDate();
        this.finalDate = workoutRoutineDto.getFinalDate();
        this.periodization = workoutRoutineDto.getPeriodization();
        this.goal = workoutRoutineDto.getGoal();
        this.difficulty = workoutRoutineDto.getDifficulty();
        this.group = workoutRoutineDto.getGroup();
        this.trainings = new ArrayList<>();
    }
}
