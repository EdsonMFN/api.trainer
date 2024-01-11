package api.trainer.file;

import api.trainer.domains.entity.Exercise;
import api.trainer.domains.entity.Training;
import api.trainer.domains.entity.TrainingExercises;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.io.IOException;

public class File {

        public static void generatePdf(String filePath, Training training) throws FileNotFoundException{
            try (com.itextpdf.kernel.pdf.PdfWriter writer = new PdfWriter(filePath);
                 PdfDocument pdf = new PdfDocument(writer);
                 Document document = new Document(pdf)) {

                // Adiciona título
                document.add(new Paragraph("Relatório de Treino de Academia"));

                // Adiciona dados do treino
                document.add(new Paragraph("Feedback: " + training.getFeedback()));
                document.add(new Paragraph("Intensidade: " + training.getTrainingIntensity()));

                for (TrainingExercises trainingExercises : training.getTrainingExercises()) {
                    document.add(new Paragraph("Observação: " + trainingExercises.getObservation()));
                    document.add(new Paragraph("Séries: " + trainingExercises.getSeries()));
                    document.add(new Paragraph("Repetições: " + trainingExercises.getRepetitions()));

                    // Adiciona imagem (substitua 'path_para_imagem' pelo caminho real da imagem)
                    Exercise exercise = trainingExercises.getExercise();
                    Image img = new Image(ImageDataFactory.create(exercise.getMedia()));
                    document.add(img);
                    ;

                    // Adiciona espaçamento entre exercícios
                    document.add(new Paragraph("\n"));
                }

                document.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
