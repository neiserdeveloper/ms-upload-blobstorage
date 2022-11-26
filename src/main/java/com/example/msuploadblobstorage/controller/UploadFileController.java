package com.example.msuploadblobstorage.controller;

import com.example.msuploadblobstorage.dto.UploadFileDto;
import com.example.msuploadblobstorage.services.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blobstorage-azure")
public class UploadFileController {
    @Autowired
    private IUploadFileService iUploadFileService;

    @PostMapping(path = "/upload-file")
    public ResponseEntity<String> uploadFileBlobStorage(@RequestBody UploadFileDto uploadFileDto){
        String resultService = iUploadFileService.uploadFileAzure(uploadFileDto);
        return new ResponseEntity<String>(resultService, HttpStatus.OK);
    }

    @PostMapping(path = "/download-file")
    public ResponseEntity<String> downloadFileBlobStorage(@RequestBody UploadFileDto uploadFileDto){
        String resultService = iUploadFileService.downloadFileAzure(uploadFileDto);
        return new ResponseEntity<String>(resultService, HttpStatus.OK);
    }

    @PostMapping(path = "/delete-file")
    public ResponseEntity<String> deleteFileBlobStorage(@RequestBody UploadFileDto uploadFileDto){
        String resultService = iUploadFileService.deleteFileAzure(uploadFileDto);
        return new ResponseEntity<String>(resultService, HttpStatus.OK);
    }
}
