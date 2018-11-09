package com.wrlus.facedetection.api.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {
	public File saveUploadFile(HttpServletRequest request);
	public boolean removeUploadFile(String path);
}
