package edu.uta.datauploadsvc.controller;

import edu.uta.datauploadsvc.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class DownloadController {

    Logger log = LoggerFactory.getLogger(DownloadController.class);

    @Autowired
    FileService fileService;

    @GetMapping("/download")
    public ResponseEntity download(@RequestBody String name) {
        File file = fileService.downloadFile(name);
        Resource fileSystemResource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .body(fileSystemResource);
    }

}
