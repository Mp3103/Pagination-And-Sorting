package com.meet.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meet.entity.Student;
import com.meet.studentInterface.StudentInterface;

@Service
public class StudentService implements StudentServiceInterface {

	private StudentInterface studentInterface;
	
	@Autowired
	public StudentService(StudentInterface studentInterface) {
		super();
		this.studentInterface = studentInterface;
	}



	@Override
	public Page<Student> studentList(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return studentInterface.findAll(pageable);
	}

}
