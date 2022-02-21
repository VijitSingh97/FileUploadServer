package edu.uta.datauploadsvc.controller;

import edu.uta.datauploadsvc.domain.Constants;
import edu.uta.datauploadsvc.domain.Response;
import edu.uta.datauploadsvc.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    Logger log = LoggerFactory.getLogger(DeleteController.class);

    @Autowired
    FileService fileService;

    @DeleteMapping("/delete")
    public Response delete(@RequestBody String name){
        if (fileService.deleteFile(name)) {
            log.info("deleted file");
            return new Response(Constants.SUCCESS);
        } else {
            log.error("failed to delete file");
            return new Response(Constants.FAILURE);
        }
    }

}
