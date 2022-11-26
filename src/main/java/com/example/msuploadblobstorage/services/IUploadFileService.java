package com.example.msuploadblobstorage.services;

import com.example.msuploadblobstorage.dto.UploadFileDto;

public interface IUploadFileService {
    public String uploadFileAzure(UploadFileDto uploadFileDto);
    public String downloadFileAzure(UploadFileDto uploadFileDto);
    public String deleteFileAzure(UploadFileDto uploadFileDto);
}
