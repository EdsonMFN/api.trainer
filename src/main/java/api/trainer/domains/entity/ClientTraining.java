package api.trainer.domains.entity;

import api.trainer.convertrs.CustomLocalDateTimeDeserializer;
import api.trainer.enums.TrainingIntensity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "client_training")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client_training")
    private Long id;
    @Column(name = "feedback")
    private String feedback;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @Column(name = "startTraining")
    private LocalDateTime startTraining;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endTraining")
    private LocalDateTime endTraining;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_training")
    private Training training;
    @Column(name = "training_intensity")
    @Enumerated(EnumType.STRING)
    private TrainingIntensity trainingIntensity;

}