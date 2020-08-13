package com.meet.StudentService;

import org.springframework.data.domain.Page;

import com.meet.entity.Student;

public interface StudentServiceInterface {

	public Page<Student> studentList(int pageNo , int pageSize);
}
