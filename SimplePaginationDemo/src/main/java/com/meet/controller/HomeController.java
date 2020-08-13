package com.meet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meet.StudentService.StudentServiceInterface;
import com.meet.entity.Student;

@Controller
public class HomeController {

	private StudentServiceInterface studentServiceInterface;

	@Autowired
	public HomeController(StudentServiceInterface studentServiceInterface) {
		super();
		this.studentServiceInterface = studentServiceInterface;
	}

	@RequestMapping("/")
	public String getAllStudent(Model model) {
		return paginationPart(1, model);
	}

	@RequestMapping("page/{pageNo}")
	public String paginationPart(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 3;

		Page<Student> page = studentServiceInterface.studentList(pageNo, pageSize);

		List<Student> listOfStudent = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listOfStudent",listOfStudent);
			
		return "HomePage";
	}
}
