package api.trainer.domains.entity;

import api.trainer.enums.Difficulty;
import api.trainer.enums.Goal;
import api.trainer.enums.TypeOfTraining;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    @Column(name = "file_PDF")
    private boolean filePDF;
    @Column(name = "time_raining")
    private boolean timeTraining;
    @Column(name = "periodization")
    private boolean periodization;
    @Column(name = "goal")
    @Enumerated(EnumType.STRING)
    private Goal goal;
    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Column(name = "type_of_training")
    @Enumerated(EnumType.STRING)
    private TypeOfTraining group;
}
