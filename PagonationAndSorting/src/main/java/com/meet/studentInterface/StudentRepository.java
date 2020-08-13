package com.meet.studentInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meet.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
