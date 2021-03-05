package kr.co.ezen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.util.FileUploadDownloadUtils;
import kr.co.util.MediaUtils;

@Controller
public class TestUploadController {
	
	@Resource(name = "uploadPath")
	private String uploadPath;
		
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public String deleteFile(String fileName, HttpSession session) {
		String result = null;
		
		fileName = fileName.replace('/', File.separatorChar);
		
		
		String uploadPath = session.getServletContext().getRealPath(this.uploadPath);
		
		
		int idx = fileName.lastIndexOf(".")+1;
		String type = fileName.substring(idx);
		MediaType mType = MediaUtils.getMediaType(type);
		
		boolean exe0 = true;
		
		if(mType != null) {
			String pre = fileName.substring(0, 12);
			String suf = fileName.substring(14);
			
			String oriName = pre + suf;
			File f2 = new File(uploadPath+oriName);
			exe0 = f2.delete();
		}
		
		
		
		File f = new File(uploadPath+fileName);
		boolean exe1 = f.delete();
		
		if(exe1 && exe0) {
			result = "o";
		}else {
			result = "x";
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/displayFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename, HttpSession session){
		
		ResponseEntity<byte[]> entity = null;
		byte[] arr = null;
		InputStream in = null;
		
		try {
			int idx = filename.lastIndexOf(".")+1;
			String type = filename.substring(idx);
			System.out.println(type+"..................");
			MediaType mType = MediaUtils.getMediaType(type);
			System.out.println(mType+":::::::::::::::::::");
			HttpHeaders headers = new HttpHeaders();
			
			String uploadPath = session.getServletContext()
										.getRealPath(this.uploadPath);
			in = new FileInputStream(uploadPath+filename);
			
			
			if (mType != null) {
				headers.setContentType(mType);
			} else {
				String fileName = filename.substring(filename.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment;filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1") +"\"");
			}
			
			arr = IOUtils.toByteArray(in);
			
			entity = new ResponseEntity<byte[]>(arr, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return entity;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/ajaxtest", 
					method = RequestMethod.POST,
					produces = "application/text;charset=utf8")
	public String ajaxtest(MultipartHttpServletRequest request,
			HttpSession session) throws Exception {
		String uploadPath = session.getServletContext()
									.getRealPath(this.uploadPath);
		
		MultipartFile file = request.getFile("file");
		
		String fileUploadPath = FileUploadDownloadUtils
								.upload(file, uploadPath);
		return fileUploadPath;
	}
	
	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	public void ajaxtest() {
		
	}
	
	
	@RequestMapping(value = "/noajax", method = RequestMethod.POST)
	public String noajax(MultipartHttpServletRequest request, 
											HttpSession session) throws Exception {
		
		String id = request.getParameter("id");
		MultipartFile file = request.getFile("file");
		
		String uploadPath = session.getServletContext()
									.getRealPath(this.uploadPath);
		
		//String savedName = FileUploadDownloadUtils.makeFileName(file.getOriginalFilename());
		//FileUploadDownloadUtils.upload(file, uploadPath, savedName);
		FileUploadDownloadUtils.upload(file, uploadPath);
		
		
		return "uploadResult";
		
	}
	
	
	
	@RequestMapping(value = "/noajax", method = RequestMethod.GET)
	public void noajax() {
		
	}
	
	
	
	
	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public void uploadForm(MultipartHttpServletRequest request, 
							HttpSession session) throws Exception {
		
		String id = request.getParameter("id");
		
		MultipartFile file = request.getFile("file");
		
		String uploadPath = 
			session.getServletContext().getRealPath(this.uploadPath);
		
		String savedName =
		FileUploadDownloadUtils.makeFileName(file.getOriginalFilename());
		
		FileUploadDownloadUtils.upload(file, uploadPath, savedName);
	}
	
	
	
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		
	}

}
