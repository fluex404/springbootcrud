package com.fluex404.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluex404.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
