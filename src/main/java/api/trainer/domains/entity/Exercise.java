package api.trainer.domains.entity;

import api.trainer.enums.MuscleGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "exercise")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercise")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "copy")
    private boolean copy;
    @Column(name = "media")
    private boolean media;
    @Column(name = "observation")
    private String observation;
    @Column(name = "series")
    private Integer series;
    @Column(name = "repetitions")
    private Integer repetitions;
    @Column(name = "time_interval")
    private int timeInterval;
    @Column(name = "muscle_group")
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_training")
    private Training training;

}
