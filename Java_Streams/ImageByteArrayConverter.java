package com.streams;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageByteArrayConverter {

    // Convert image file to byte array
    public static byte[] imageToByteArray(String inputPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputPath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    // Write byte array back to an image file
    public static void byteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Compare two files byte-by-byte
    public static boolean compareFiles(String file1Path, String file2Path) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(new File(file1Path).toPath());
        byte[] file2Bytes = Files.readAllBytes(new File(file2Path).toPath());
        return Arrays.equals(file1Bytes, file2Bytes);
    }

    public static void main(String[] args) {
        String inputImage = "original.jpg";
        String outputImage = "copy.jpg";

        try {
            // Step 1: Convert image to byte array
            byte[] imageBytes = imageToByteArray(inputImage);
            System.out.println("Image successfully converted to byte array.");

            // Step 2: Write byte array to new image file
            byteArrayToImage(imageBytes, outputImage);
            System.out.println("Byte array written back to image file.");

            // Step 3: Verify files are identical
            boolean identical = compareFiles(inputImage, outputImage);
            System.out.println("Verification result: " + (identical ? "Files are identical ✅" : "Files differ ❌"));

        } catch (IOException e) {
            System.err.println("I/O error occurred: " + e.getMessage());
        }
    }
}
