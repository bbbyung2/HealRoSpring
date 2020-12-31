package com.health.restcontroller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.CardioTb;
import com.health.entity.Comment;
import com.health.entity.CoronaryTb;
import com.health.entity.DiabetesTb;
import com.health.entity.User;
import com.health.repository.CardioRepository;
import com.health.service.CardioService;
import com.health.service.CommentService;
import com.health.service.CoronaryTbService;
import com.health.service.DiabeteService;
import com.health.service.FileDownloadService;
import com.health.service.FileUploadService;


@RestController
public class CommunityRestController {
	
	@Autowired
	CoronaryTbService coronaryService;
	
	@Autowired
	DiabeteService diaService;
	
	@Autowired
	CardioService cardioService;
	
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	FileDownloadService fileDownloadService;
	
	@Autowired
	CommentService comService;

	
	@GetMapping("/post")
	public ModelAndView post(@RequestParam("type") String type) {
		ModelAndView mv = new ModelAndView();
		System.out.println("---------------"+type);
		mv.setViewName("post");
		mv.addObject("type",type);
		return mv;
	}
	
	@PostMapping("/createCoronary")
	public int createCoronary(@RequestBody CoronaryTb coro)
	{
		Date now = new Date(System.currentTimeMillis());
		coro.setTime(now);
		coronaryService.create(coro);
		return 0;
		
	}
	
	@PostMapping("/createCardio")
	public int createCardio(@RequestBody CardioTb cardio)
	{
		Date now = new Date(System.currentTimeMillis());
		cardio.setTime(now);
		cardioService.create(cardio);
		return 0;
		
	}
	
	@PostMapping("/createDiabete")
	public int createDiabete(@RequestBody DiabetesTb dia)
	{
		Date now = new Date(System.currentTimeMillis());
		dia.setTime(now);
		diaService.create(dia);
		return 0;
		
	}
	
	
	@PostMapping("/createComment")
	public int createDiabete(@RequestBody Comment com)
	{
		Date now = new Date(System.currentTimeMillis());
		com.setTime(now);
		comService.create(com);
		return 0;
		
	}
	
	@PostMapping("/deleteComment")
	public int deleteComment(@RequestBody int id)
	{
		
		comService.deleteByid(id);
		return 0;
		
	}
	
	

	@ResponseBody
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String uploadImage(@RequestParam(value = "img") MultipartFile file)
	{

		fileUploadService.restore(file);
		
		
		return file.getOriginalFilename();
	}
	private static final String SAVE_PATH = System.getProperty("user.dir")+"/src/main/resources/templates/files/img/";
	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> download(@RequestParam("img" )String name, HttpServletResponse response) throws IOException {
    	try
        {
 
    		System.out.println(SAVE_PATH + name);
    	File file = new File( SAVE_PATH + name);
    	
    	 if(file.exists())
         {
         	System.out.println("YSSSSSSSSSSSSSSSSSSSSS");
         }
    	
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
      

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        
        
        file.exists();
        
       
        	
        	
        	 return ResponseEntity.ok()
                     .headers(headers)
                     .contentLength(file.length())
                     .contentType(MediaType.parseMediaType("text/plain"))
                     .body(resource);
        }
        catch(Exception e)
        {
        	PrintWriter out = response.getWriter();
        	response.setContentType("text/html; charset=utf-8");
        	out.println("<script language = 'javascript'>");
        	out.println("alert('NO FILE');");
        	out.println("</script>");
        	out.flush();
        }
		return null;
        
        

       
    }
	
}
