package com.proj.StudentManagement.service;

import com.proj.StudentManagement.entity.File;
import com.proj.StudentManagement.entity.Stud;
import com.proj.StudentManagement.repository.FileRepo;
import com.proj.StudentManagement.repository.StudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Service
public class FileService {
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    private FileRepo fileRepo;
    @Autowired
    private StudRepo studRepo;
    public File uploadFile(Integer studId, MultipartFile file) throws IOException {
        Stud stud = studRepo.findById(studId).orElse(null);
        if (stud == null) {
            return null;
        }
        Path folder = Paths.get(uploadDir);
        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        }
        String fileName = file.getOriginalFilename();
        Path path = folder.resolve(fileName);
        Files.copy(file.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
        File studentFile = new File();
        studentFile.setFileName(fileName);
        studentFile.setFileType(file.getContentType());
        studentFile.setFilePath(path.toString());
        studentFile.setStud(stud);
        return fileRepo.save(studentFile);
    }
    public Resource downloadFile(Integer fileId) throws IOException {
        File studentFile = fileRepo.findById(fileId).orElse(null);
        if (studentFile == null) {
            return null;
        }
        Path path = Paths.get(studentFile.getFilePath());
        return new UrlResource(path.toUri());
    }
}