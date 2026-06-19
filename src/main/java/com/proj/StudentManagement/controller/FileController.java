package com.proj.StudentManagement.controller;

import com.proj.StudentManagement.entity.File;
import com.proj.StudentManagement.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping("/students/{id}/files")
    public File uploadFile(@PathVariable Integer id, @RequestParam("file") MultipartFile file) throws IOException {
        return fileService.uploadFile(id, file);
    }
    @GetMapping("/files/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id) throws IOException {
        Resource resource = fileService.downloadFile(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
    }
    @DeleteMapping("/files/{id}")
    public String deleteFile(@PathVariable Integer id) throws IOException {
        return fileService.deleteFile(id);
    }
    @GetMapping("/students/{id}/files")
    public List<File> getFilesByStudent(@PathVariable Integer id) {
        return fileService.getFilesByStudent(id);
    }
}