package com.example.msuploadblobstorage.services.impl;

import com.example.msuploadblobstorage.dto.UploadFileDto;
import com.example.msuploadblobstorage.services.IUploadFileService;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.*;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.Base64;

@Service
public class UploadFileServiceImpl implements IUploadFileService {
    @Override
    public String uploadFileAzure(UploadFileDto uploadFileDto) {
        String resultService ="";
        String storageConnectionAzure="DefaultEndpointsProtocol=https;AccountName=accountfiles;AccountKey=RJoHQmAUURb03/c5XXxkjE0+/vbFXYIsMFhjhiosRCOhOidzr53ZVoKkkgF1oPwZJRUkR3ot/OPikp8kN2V+ASkkgutf7NRzw==;EndpointSuffix=core.windows.net";
        String nameContainer="files";

        try {
            CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionAzure);
            CloudBlobClient serviceClient = account.createCloudBlobClient();
            CloudBlobContainer container = serviceClient.getContainerReference(nameContainer);

            CloudBlob blob;
            blob = container.getBlockBlobReference(uploadFileDto.getName());
            byte[] decodedBytes = Base64.getDecoder().decode(uploadFileDto.getFileBase64());
            blob.uploadFromByteArray(decodedBytes,0,decodedBytes.length);

            resultService = "OK";

        }catch (Exception e){
            resultService = e.getMessage();
        }
        return resultService;
    }

    @Override
    public String downloadFileAzure(UploadFileDto uploadFileDto) {
        String resultService ="";
        String storageConnectionAzure="DefaultEndpointsProtocol=https;AccountName=accountfiles;AccountKey=RJoHQmAU789jjjfhURb03/c5XXxkjE0+/vbFXYIsMFsRCOhOidzr53ZVoKgF1oPwZJRUkR3ot/OPikp8kN2V+AStf7NRzw==;EndpointSuffix=core.windows.net";
        String nameContainer="files";
        try {
            CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionAzure);
            CloudBlobClient serviceClient = account.createCloudBlobClient();
            CloudBlobContainer container = serviceClient.getContainerReference(nameContainer);

            CloudBlockBlob blockBlob = container.getBlockBlobReference(uploadFileDto.getName());
            File file = new File("C:\\Users\\neise\\Downloads\\"+ uploadFileDto.getName());
            blockBlob.downloadToFile(file.getAbsolutePath());

            resultService = "Download success!!!";

        }catch (Exception e){
            resultService = e.getMessage();
        }
        return resultService;
    }

    @Override
    public String deleteFileAzure(UploadFileDto uploadFileDto) {
        String resultService ="";
        String storageConnectionAzure="DefaultEndpointsProtocol=https;AccountName=accountfiles;AccountKey=RJoHQmAUURjhjygg8798//b03/c5XXxkjE0+/vbFXYIsMFsRCOhOidzr53ZVoKgF1oPwZJRUkR3ot/OPikp8kN2V+AStf7NRzw==;EndpointSuffix=core.windows.net";
        String nameContainer="files";
        try {
            CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionAzure);
            CloudBlobClient serviceClient = account.createCloudBlobClient();
            CloudBlobContainer container = serviceClient.getContainerReference(nameContainer);

            CloudBlockBlob blockBlob = container.getBlockBlobReference(uploadFileDto.getName());
            blockBlob.deleteIfExists();

            resultService = "Delete success!!!";

        }catch (Exception e){
            resultService = e.getMessage();
        }
        return resultService;
    }
}