package com.javalec.spring_pjt_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_board.command.BCommand;
import com.javalec.spring_pjt_board.command.BContentCommand;
import com.javalec.spring_pjt_board.command.BDeleteCommand;
import com.javalec.spring_pjt_board.command.BListCommand;
import com.javalec.spring_pjt_board.command.BModifyCommand;
import com.javalec.spring_pjt_board.command.BReplyCommand;
import com.javalec.spring_pjt_board.command.BReplyViewCommand;
import com.javalec.spring_pjt_board.command.BWriteCommand;


@Controller
public class BController 
{
	BCommand cmd;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		System.out.println("Start list method.");
		
		cmd = new BListCommand();
		cmd.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		
		System.out.println("Start write_view method.");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest req, Model model) {
		
		System.out.println("Start write method.");
		
		model.addAttribute("request", req);
		cmd = new BWriteCommand();
		cmd.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest req, Model model) {
		
		System.out.println("Start content_view method.");
		
		model.addAttribute("request", req);
		cmd = new BContentCommand();
		cmd.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest req, Model model) {
		
		System.out.println("Start modify method.");
		
		model.addAttribute("request", req);
		cmd = new BModifyCommand();
		cmd.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest req, Model model) {
		
		System.out.println("Start reply_view method.");
		
		model.addAttribute("request", req);
		cmd = new BReplyViewCommand();
		cmd.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest req, Model model) {
		
		System.out.println("Start reply method.");
		
		model.addAttribute("request", req);
		cmd = new BReplyCommand();
		cmd.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		
		System.out.println("Start delete method.");
		
		model.addAttribute("request", req);
		cmd = new BDeleteCommand();
		cmd.execute(model);
		
		return "redirect:list";
	}
}
