package com.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.Wares;
import com.ssm.service.WaresService;

@Controller
@RequestMapping("/wares")
public class WaresController extends HttpServlet {

	@Resource
	private WaresService waresService;


	@RequestMapping(value="/add",method=RequestMethod.GET)
    public String add(){
    	return "/add";
    }

	@RequestMapping(value="/createWares",method=RequestMethod.POST)
    public String createWares(Wares wares){
		wares.setId(""+UUID.randomUUID());
		waresService.add(wares);
    	return "/introduce";
    }

	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ModelAndView get(Wares wares) throws Exception{
		 Wares w = waresService.getWares(wares);
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("wares", w);
		 mav.setViewName("/update");
		 return mav;
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Wares wares) throws Exception{
		waresService.update(wares);
		return "/introduce";
	}



	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Wares wares){
		waresService.delete(wares);
		return "/introduce";
	}

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String  getUserList(Model model){
		List<Wares> wares = waresService.getUserList();
		Map<String, Wares> mapList = new HashMap<String, Wares>();
		for (Wares w : wares) {
			mapList.put(w.getId(), w);
		}
		model.addAttribute("mapList",mapList);
		return "/list";
	}
	@RequestMapping(value="keyWord",method=RequestMethod.GET)
	public ModelAndView keyWord(HttpServletRequest request) throws IOException {
		String keyWord = request.getParameter("keyWord");
		byte[] bytes=  keyWord.getBytes("ISO-8859-1");
		keyWord= new String(bytes,"UTF-8");
		List<Wares> wares = waresService.keyWord(keyWord);
	Map<String, Wares> mapList = new HashMap<String, Wares>();
		for (Wares w : wares) {
			mapList.put(w.getId(), w);
		}
	return new ModelAndView("/list", "mapList",mapList);
	}


}
