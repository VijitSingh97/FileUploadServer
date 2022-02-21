package edu.uta.datauploadsvc.domain;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class RenameRequest {
    @NonNull
    private String oldName;
    @NonNull
    private String newName;
}
