package edu.uta.datauploadsvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadedFile {
    private String name;
    private long lastModified;
}
