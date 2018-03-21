package com.projectbru.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectbru.demo.dao.AdminDao;
import com.projectbru.demo.model.AdminBean;


@Controller
public class AdminController {
	
	@Autowired
	AdminDao adminDao ;
	
	@RequestMapping("/1234")
	public String login(Model model) {
		model.addAttribute("messessError","");
		return "adminlogin";
	}
	
	@RequestMapping("/adminlogin")
	public String outhenlogin( String username ,String password, Model model ,HttpServletRequest request, String status  ) {
		String outhen ="";
		AdminBean bean = new AdminBean();
		List<AdminBean> findAll = new ArrayList<AdminBean>();
		try {
			bean = adminDao.admin(username, password);
			findAll = adminDao.findAll();
			if(bean.getAdminUsername()!=null){
				request.getSession().setAttribute("LoginAdmin", bean);
				request.getSession().setAttribute("listMember", findAll);
				
			outhen = "welcomeAdmin";
			}else {
		 model.addAttribute("messessError", "F");
		       outhen ="adminlogin";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return outhen;
	}
	
	@RequestMapping("/logoutadmin")
	public String Loout(HttpServletRequest request , Model model) {
		request.getSession().removeAttribute("LoginMember");
		request.getSession().removeAttribute("listMember");
		 model.addAttribute("messessError","L");
		 return  "adminlogin";
	}
	
	@RequestMapping("/welcomeAdmin")
	public String welcomeAdmin() {
		
		return "welcomeAdmin";
	}
	
	@RequestMapping("/widgets")
	public String widgets() {
		
		return "admin/widgets";
	}
	@RequestMapping("/charts")
	public String charts() {
		
		return "admin/charts";
	}
	@RequestMapping("/elements")
	public String elements() {
		
		return "admin/elements";
	}
	@RequestMapping("/panelsl")
	public String panelsl() {
		
		return "admin/panelsl";
	}
	//End Class
}


