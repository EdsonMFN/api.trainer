package api.trainer.enums;

import api.trainer.file.FileCreationStrategy;
import api.trainer.file.FilePDF;
import api.trainer.file.FileXlsx;
import lombok.Getter;

@Getter
public enum TypeFile {

        XLSX("training export.xlsx",new FileXlsx()),
        PDF("training export.pdf", new FilePDF());

        private final String typeFile;
        private final FileCreationStrategy description;

    TypeFile(String typeFile, FileCreationStrategy description) {
        this.typeFile = typeFile;
        this.description = description;
    }

}
