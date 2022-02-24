package edu.uta.datauploadsvc.service.impl;

import edu.uta.datauploadsvc.domain.UploadedFile;
import edu.uta.datauploadsvc.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    @Value("${file-server.data-dir}")
    private String dataDir;

    @Override
    public void saveFile(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(dataDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Files.copy(file.getInputStream(),
                uploadPath.resolve(StringUtils.cleanPath(file.getOriginalFilename())),
                StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public boolean deleteFile(String name) {
        File file = Paths.get("")
                .resolve(dataDir + name)
                .toFile();
        log.info("deleting {}", file.getAbsolutePath());
        return file.delete();
    }

    @Override
    public File downloadFile(String name) {
        File file = Paths.get("")
                .resolve(dataDir + name)
                .toFile();
        // update time stamps for sync
        file.setLastModified(System.currentTimeMillis());
        log.info("downloading {}", file.getAbsolutePath());
        return file;
    }

    @Override
    public boolean renameFile(String oldName, String newName) {

        File oldFile = Paths.get("")
                .resolve(dataDir + oldName)
                .toFile();

        File newFile = Paths.get("")
                .resolve(dataDir + newName)
                .toFile();

        log.info("renaming {} to {}", oldFile.getAbsolutePath(), newFile.getAbsolutePath());
        return oldFile.renameTo(newFile);
    }

    @Override
    public List<UploadedFile> getFiles() {
        File serverStore = Paths.get("").resolve(dataDir).toFile();
        List<File> rawFiles = Arrays.asList(serverStore.listFiles());
        List<UploadedFile> files = new ArrayList<>();
        rawFiles.forEach(f -> {
            files.add(new UploadedFile(f.getName(), f.lastModified()));
        });
        return files;
    }
}
