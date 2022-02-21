package edu.uta.datauploadsvc.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public interface FileService {
    public void saveFile(MultipartFile file) throws IOException;
    public boolean deleteFile(String name);
    public File downloadFile(String name);
    public boolean renameFile(String oldName, String newName);
}