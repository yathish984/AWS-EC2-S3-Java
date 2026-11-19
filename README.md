
# AWS EC2 to S3 File Upload Using Java

## Project Overview
This project demonstrates how to upload files directly from an AWS EC2 Linux instance to an Amazon S3 bucket using Java and the AWS SDK for Java 2.x.

## Architecture
Java Application → AWS SDK → IAM Role → Amazon S3

## Technologies Used
- Java 17
- AWS EC2
- Amazon S3
- AWS IAM
- AWS SDK for Java 2.x
- Maven
- Amazon Linux 2023

## Project Structure
```text
AWS-EC2-S3-Java/
├── files/
│   └── sample.txt
├── src/
│   └── main/java/com/aws/
│       └── S3FileUpload.java
├── pom.xml
├── README.md
└── .gitignore
```

## How It Works
1. A Java application runs on an EC2 instance.
2. The application reads files from the `files` folder.
3. AWS SDK connects to Amazon S3.
4. The EC2 IAM role provides permission to upload files.
5. Files are uploaded to the configured S3 bucket.

## Prerequisites
- AWS EC2 instance running Amazon Linux 2023.
- An Amazon S3 bucket.
- An IAM role attached to EC2 with `s3:PutObject` permission for the target bucket.
- Java 17 and Maven installed.

## Run the Project

Clone the repository:

```bash
git clone https://github.com/yathish984/AWS-EC2-S3-Java.git
cd AWS-EC2-S3-Java
```

Build the project:

```bash
mvn clean package
```

Run the Java application:

```bash
mvn org.codehaus.mojo:exec-maven-plugin:3.5.0:java -Dexec.mainClass="com.aws.S3FileUpload"
```

## Expected Output

```text
Uploaded: sample.txt
All uploads completed!
```

## AWS Security
- Uses an EC2 IAM role for AWS credentials.
- Does not store AWS access keys in the source code.
- Grants only the required S3 upload permission.

## Author
Yathish Gowda M

