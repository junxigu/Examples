package com.uploadFile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.domain.UploadResult;
import com.uploadFile.service.UploadService;

@Controller
public class FileOperateController {

	private UploadService service;

	public FileOperateController(UploadService service) {
		this.service = service;
	}

	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("file") MultipartFile file)
			throws Exception {

		UploadResult result = service
				.parseAndUploadExcel(file.getInputStream());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);

		return new ModelAndView("uploadResult.jsp", map);

	}

}