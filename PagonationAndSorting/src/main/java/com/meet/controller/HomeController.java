package com.meet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meet.entity.Student;
import com.meet.service.StudentServiceInterface;

@Controller
public class HomeController {

	private StudentServiceInterface studentServiceInterface;
	
	@Autowired
	public HomeController(StudentServiceInterface studentServiceInterface) {
		super();
		this.studentServiceInterface = studentServiceInterface;
	}

	@RequestMapping("/students")
	public String getAllStudent(Model model) {
	
		return viewPaage(1,"username","asc",model);
	}
	
	@GetMapping("/page/{pageNo}")
	public String viewPaage(@PathVariable(value = "pageNo")int pageNo ,
			@RequestParam("sortField")String sortField,
			@RequestParam("sortDir")String sortDir,
			Model model) {
		int pageSize = 3;
		
		Page<Student> page = studentServiceInterface.findPginated(pageNo, pageSize , sortField,sortDir);
	
		
		List<Student> listOfStudent = page.getContent();
		
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		
		model.addAttribute("listOfStudent",listOfStudent);

		return "HomePage";
	}
	
}
