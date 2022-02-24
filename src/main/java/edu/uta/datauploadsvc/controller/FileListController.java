package edu.uta.datauploadsvc.controller;

import edu.uta.datauploadsvc.domain.UploadedFile;
import edu.uta.datauploadsvc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileListController {

    @Autowired
    FileService fileService;

    @GetMapping("/getFiles")
    public List<UploadedFile> getFiles() {
        return fileService.getFiles();

    }
}
