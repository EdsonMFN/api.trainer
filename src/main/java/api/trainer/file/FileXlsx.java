package api.trainer.file;

import api.trainer.domains.entity.Exercise;
import api.trainer.domains.entity.Training;
import api.trainer.domains.entity.TrainingExercise;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class FileXlsx implements FileCreationStrategy{
    //todo:O aluno pode escolher o tipo de formatação do arquivo para fazer o download.O arquivo pode ser em PDF ou em XLX ou txt.O front do arq que o client escolheu;
    //todo: Parte tecnica: Usar padrão de projeto, strategy;

    @Override
    public void createFile(String filePath, Training training) {

        try (var workbook = new XSSFWorkbook();
             var fileOutput = new FileOutputStream(filePath)) {
            var spreadsheet = workbook.createSheet("Gym Training Report");

            int accountant = 0;
            addHeader(spreadsheet, accountant++);


            var line = spreadsheet.createRow(accountant);
            for (TrainingExercise trainingExercise : training.getTrainingExercises()) {
                line = spreadsheet.createRow(accountant++);
                Exercise exercise = trainingExercise.getExercise();
                addCell(line, 0, (exercise.getNome()));

                addCell(line, 1, (trainingExercise.getSeries() + "x"));
                addCell(line, 2, String.valueOf((trainingExercise.getRepetitions())));
                addCell(line, 3, (trainingExercise.getTimeInterval() + "s"));
                addCell(line, 4, (trainingExercise.getObservation()));
            }
            addCell(line, 5, String.valueOf((training.getTrainingIntensity())));
//            addCell(line, 6, (training.getFeedbacks()));
            workbook.write(fileOutput);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
    private void addHeader(XSSFSheet spreadsheet, int accountant){
        var line = spreadsheet.createRow(accountant);
        addCell(line,0,"Name");
        addCell(line,1,"Series");
        addCell(line,2,"Repetitions");
        addCell(line,3,"TimeInterval");
        addCell(line,4,"Observation");
        addCell(line,5,"Training Intensity");
        addCell(line,6,"Feedback");
    }
    private void addCell(Row line, int column, String value ){
        Cell cell = line.createCell(column);
        cell.setCellValue(value);
    }
}
