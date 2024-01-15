package api.trainer.file;

import api.trainer.domains.entity.Exercise;
import api.trainer.domains.entity.Training;
import api.trainer.domains.entity.TrainingExercises;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FilePDF implements FileCreationStrategy{
    //todo:O aluno pode escolher o tipo de formatação do arquivo para fazer o download.O arquivo pode ser em PDF ou em XLX ou txt.O front do arq que o client escolheu;
    //todo: Parte tecnica: Usar padrão de projeto, strategy;

    @Override
    public void createFile(String filePath, Training training) {
        try (com.itextpdf.kernel.pdf.PdfWriter writer = new PdfWriter(filePath);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)) {
            // Adiciona título
            document.add(new Paragraph("Gym Training Report"));

            for (TrainingExercises trainingExercises : training.getTrainingExercises()) {
                // Adiciona espaçamento entre exercícios
                Exercise exercise = trainingExercises.getExercise();
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Name: " + exercise.getNome()));
                // Adiciona imagem (substitua 'path_para_imagem' pelo caminho real da imagem)
//                    Image img = new Image(ImageDataFactory.create(exercise.getMedia()));
//                    document.add(img);

                document.add(new Paragraph("Series: " + trainingExercises.getSeries() + "x"));
                document.add(new Paragraph("Repetitions: " + trainingExercises.getRepetitions()));
                document.add(new Paragraph("TimeInterval: " + trainingExercises.getTimeInterval()+ "s"));
                document.add(new Paragraph("Observation: " + trainingExercises.getObservation()));
            }
            // Adiciona dados do treino
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Feedback: " + training.getFeedback()));
            document.add(new Paragraph("Training Intensity: " + training.getTrainingIntensity()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
