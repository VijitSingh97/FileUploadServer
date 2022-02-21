package edu.uta.datauploadsvc.controller;

import edu.uta.datauploadsvc.domain.Constants;
import edu.uta.datauploadsvc.domain.RenameRequest;
import edu.uta.datauploadsvc.domain.Response;
import edu.uta.datauploadsvc.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenameController {

    Logger log = LoggerFactory.getLogger(RenameController.class);

    @Autowired
    FileService fileService;

    @PutMapping("/rename")
    public Response rename(@RequestBody RenameRequest renameRequest) {
        if(fileService.renameFile(renameRequest.getOldName(), renameRequest.getNewName())) {
            log.info("renamed file");
            return new Response(Constants.SUCCESS);
        } else {
            log.error("failed to rename file");
            return new Response(Constants.FAILURE);
        }
    }
}
