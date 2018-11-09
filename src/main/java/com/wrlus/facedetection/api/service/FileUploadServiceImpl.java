package com.wrlus.facedetection.api.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public File saveUploadFile(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUploadFile(String path) {
		// TODO Auto-generated method stub
		return false;
	}

}
