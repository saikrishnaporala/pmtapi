package com.pmt.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class ImageUpload {

	private static String UPLOAD_DIR = "http://localhost:8080/companyprofiles/";

	public String saveUploadedFiles(MultipartFile file, String s) throws IOException {

		// Make sure directory exists!
		File uploadDir = new File(UPLOAD_DIR + s);
		uploadDir.mkdirs();

		StringBuilder sb = new StringBuilder();

		if (file.isEmpty()) {

		}
		String uploadFilePath = UPLOAD_DIR + "/" + file.getOriginalFilename();

		byte[] bytes = file.getBytes();
		Path path = Paths.get(uploadFilePath);
		Files.write(path, bytes);

		sb.append(uploadFilePath).append("<br/>");
		return sb.toString();
	}
}
