package kr.co.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.domain.SellBoardVO;
import kr.co.service.SellBoardService;
import kr.co.util.FileUploadDownloadUtils;

@Controller
@RequestMapping(value = "/sellboard")
public class SellBoardController {

	@Inject
	private SellBoardService sellboardService; 
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(SellBoardVO vo) {
		
		sellboardService.insert(vo);
		
		return "redirect/sellboard/read/"+vo.getBnum();
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/upload", 
					method = RequestMethod.POST,
					produces = "application/text;charset=utf8")
	public String upload(MultipartHttpServletRequest request,
			HttpSession session) throws Exception {
		String uploadPath = session.getServletContext()
									.getRealPath(this.uploadPath);
		
		MultipartFile file = request.getFile("file");
		
		String fileUploadPath = FileUploadDownloadUtils
								.upload(file, uploadPath);
		
		System.out.println(uploadPath);
		return fileUploadPath;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public void upload() {
		
	}
	
	@RequestMapping(value = "/read/{bnum}")
	public String read(@PathVariable("bnum")int bnum, Model model) {
		SellBoardVO vo = sellboardService.read(bnum);
		model.addAttribute("vo", vo);
		
		
		return "sellboard/read";
	}
	
	
}
