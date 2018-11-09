package com.wrlus.facedetection.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrlus.facedetection.api.service.FaceDetectionServiceImpl;
import com.wrlus.facedetection.api.service.FileUploadServiceImpl;

@Controller
@RequestMapping("/face")
public class FaceDetectionController {
	@Autowired
	private FileUploadServiceImpl uploadService;
	@Autowired
	private FaceDetectionServiceImpl faceService;
	
	@ResponseBody
	@RequestMapping("/UploadFaceImage")
	public Object uploadFaceImage(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/FaceDetect")
	public Object faceDetect(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
}
