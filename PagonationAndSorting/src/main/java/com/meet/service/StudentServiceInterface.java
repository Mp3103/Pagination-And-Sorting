package com.meet.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.meet.entity.Student;

public interface StudentServiceInterface {

	public List<Student> findAllStudent();
	
	public Page<Student> findPginated(int pageNo , int pageSize , String sortInUsername , String setOrder);

	
}
