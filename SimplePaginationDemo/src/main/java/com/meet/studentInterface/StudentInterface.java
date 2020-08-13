package com.meet.studentInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meet.entity.Student;

public interface StudentInterface extends JpaRepository<Student, Integer>{

}
