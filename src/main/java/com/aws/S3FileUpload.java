
package com.aws;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;

import java.nio.file.*;
import java.io.IOException;

public class S3FileUpload {

    public static void main(String[] args) {

        String bucketName = "yathish-ec2-file-upload-project";

        String folderPath = "files";

        try (S3Client s3 = S3Client.create()) {

            Path folder = Paths.get(folderPath);

            try (DirectoryStream<Path> files =
                    Files.newDirectoryStream(folder)) {

                for (Path file : files) {

                    if (Files.isRegularFile(file)) {

                        String fileName =
                                file.getFileName().toString();

                        PutObjectRequest request =
                                PutObjectRequest.builder()
                                .bucket(bucketName)
                                .key(fileName)
                                .build();

                        s3.putObject(
                                request,
                                RequestBody.fromFile(file)
                        );

                        System.out.println(
                                "Uploaded: " + fileName
                        );
                    }
                }
            }

            System.out.println("All uploads completed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
