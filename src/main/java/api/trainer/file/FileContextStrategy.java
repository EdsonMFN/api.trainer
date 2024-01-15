package api.trainer.file;

import api.trainer.domains.entity.Training;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class FileContextStrategy {
    @Autowired
    private FileCreationStrategy strategy;

    public void createFile(String filePath, Training training) {
        if (strategy != null) {
            strategy.createFile(filePath,training);
        } else {
            System.out.println("No defined strategy.");
        }
    }
}
