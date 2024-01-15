package api.trainer.file;

import api.trainer.domains.entity.Training;

public interface FileCreationStrategy {

     void createFile (String filePath, Training training);
}
