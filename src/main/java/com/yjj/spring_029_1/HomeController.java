package com.yjj.spring_029_1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.yjj.spring_029_1.Dao.IDao;
import com.yjj.spring_029_1.Dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
//	ContentDao dao;
//	
//
//	@Autowired
//	public void setDao(ContentDao dao) {
//		this.dao = dao;
//	}
//	
	
	@Autowired
	private SqlSession sqlsession;
	
	
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "redirect:list";
	}
	

	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		dao.writeDao(mwriter, mcontent);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		dao.deleteDao(request.getParameter("mnum"));
		
		
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		ArrayList<ContentDto> dtos = dao.listDao();
		
		model.addAttribute("list", dtos);
		
		return "list";
	}
	
	
	@RequestMapping("/mview")
	public String mview(HttpServletRequest request, Model model) {
		
		IDao dao = sqlsession.getMapper(IDao.class);
		
		ContentDto dto = dao.mviewDao(request.getParameter("mnum"));
		
		model.addAttribute("dto", dto);
		
		return "mview";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

