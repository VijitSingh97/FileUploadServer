package edu.uta.datauploadsvc.controller;

import edu.uta.datauploadsvc.domain.Constants;
import edu.uta.datauploadsvc.domain.Response;
import edu.uta.datauploadsvc.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    Logger log = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public Response upload(@RequestBody MultipartFile file) {
        try {
            fileService.saveFile(file);
        } catch(Exception e) {
            log.error("failed to save file");
            e.printStackTrace();
            return new Response(Constants.FAILURE);
        }
        log.info("saved file");
        return new Response(Constants.SUCCESS);
    }

}
