package com.meet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.meet.entity.Student;
import com.meet.studentInterface.StudentRepository;
@Service
public class StudentService implements StudentServiceInterface{

	private StudentRepository studentInterface;
	
	
	@Autowired
	public StudentService(StudentRepository studentInterface) {
		super();
		this.studentInterface = studentInterface;
	}


	@Override
	public List<Student> findAllStudent() {
		return studentInterface.findAll();
	}


	@Override
	public Page<Student> findPginated(int pageNo, int pageSize,String sortInUsername , String setOrder) {
		
		Sort sort = setOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortInUsername).ascending():
					Sort.by(sortInUsername).descending();
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize , sort);
		
		return studentInterface.findAll(pageable);
	}

}
