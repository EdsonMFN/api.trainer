package api.trainer.service.imp;

import api.trainer.domains.entity.Training;
import api.trainer.domains.model.WorkoutRoutineDto;
import api.trainer.domains.repository.ExerciseRepository;
import api.trainer.domains.repository.TrainingExerciseRepository;
import api.trainer.domains.repository.TrainingRepository;
import api.trainer.domains.repository.WorkoutRoutineRepository;
import api.trainer.exception.handles.HandlerEntityNotFoundException;
import api.trainer.file.File;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;

public class FilePDFServiceImp {
    @Autowired
    private WorkoutRoutineRepository workoutRoutineRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TrainingExerciseRepository trainingExerciseRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    private boolean localePDF (WorkoutRoutineDto workoutRoutine){
        // todo:Crie objetos Training, TrainingExercises e Exercise conforme necessário
        // ...
        workoutRoutine.getTrainings().forEach(trainingDto -> {
            Training training = trainingRepository.findById(trainingDto.getId())
                    .orElseThrow(() -> new HandlerEntityNotFoundException("Training not found with id:" + trainingDto.getId()));

            // todo:Gere o PDF
            try {
                File.generatePdf("treino_academia.pdf", training);
                System.out.println("PDF criado com sucesso em: treino_academia.pdf");
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao criar o PDF: Arquivo não encontrado");
                e.printStackTrace();
            }
        });
        return workoutRoutine.isFilePDF();
    }
}
