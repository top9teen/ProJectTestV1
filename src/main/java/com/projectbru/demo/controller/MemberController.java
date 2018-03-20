package com.projectbru.demo.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectbru.demo.dao.MemberDao;
import com.projectbru.demo.model.MemberBean;

@Controller
public class MemberController {
	@Autowired
	 MemberDao memberDao;

	@RequestMapping("/")
	public String login(Model model) {
		model.addAttribute("messessError","");
		return "login";
	}
	@RequestMapping("/11")
	public String test() {
		return "welcomeMember";
	}
	// goto register
	@RequestMapping("/gotoregister")
	public String gotoInsert(Model model) {	
		model.addAttribute("messes", "");
		return "register";
	}
	
	// Loging Member

	@RequestMapping("/login")
	public String outhenlogin( String username ,String password,String roleId, Model model ,HttpServletRequest request, String status) {
		String outhen ="";
		
		MemberBean bean = new MemberBean();
		List<MemberBean> findAll = new ArrayList<MemberBean>();
		try {
			bean = memberDao.meber(username, password,roleId,status);
			findAll = memberDao.findAll();
			if(bean.getMemUsername()!=null){
				request.getSession().setAttribute("LoginMember", bean);
				request.getSession().setAttribute("listMember", findAll);
				 model.addAttribute("messessError","L");
				 if(roleId.equals("1")) {
					 outhen ="welcomePersonnel";
					 }
				 
				 if(roleId.equals("2")) {
					 
					 
					 outhen ="welcomeMember";
				 }
			}else {
		 model.addAttribute("messessError", "F");
		       outhen ="login";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return outhen;
	}
	
	@RequestMapping("/logout")
	public String Loout(HttpServletRequest request , Model model) {
		request.getSession().removeAttribute("LoginMember");
		request.getSession().removeAttribute("listMember");
		 model.addAttribute("messessError","L");
		 return  "login";
	}
	
	//Register  Not SEC
	@RequestMapping("/register")
	public String insert(Model model,@ModelAttribute("SpringWeb") MemberBean bean,String username,String password,String name,String address,String Phone,String c1,String c2,HttpServletRequest request) {	
		     
		List<MemberBean> findAll = new ArrayList<MemberBean>();
		try {
	
			bean = memberDao.ckuser(username);
			findAll = memberDao.findAll();
			if(bean.getMemUsername()==null){
				request.getSession().setAttribute("LoginMember", bean);
				request.getSession().setAttribute("listMember", findAll);
		//MemberBean bean = new MemberBean();
		bean.setMemUsername(username);
		bean.setMemPassword(password);
		bean.setMemName(name);
		bean.setMemAdd(address);
		bean.setMemPhone(Phone);
		bean.setMemCreateDate(c1);
		bean.setMemEditdata(c2);
		
	
		
		try {
			memberDao.insert(bean);
			model.addAttribute("messes", "S");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("messes", "F");
		}
	}
	else {
		model.addAttribute("messes", "B");
	}
}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("messes", "F");
		}
		return "register";
}
	//profile
	@RequestMapping("/ProfileMember")
	public String profile() {
		
		return "ProfileMember";
	}
	
	// End Class
}