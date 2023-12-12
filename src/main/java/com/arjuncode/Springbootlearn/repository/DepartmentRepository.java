package com.arjuncode.Springbootlearn.repository;

import com.arjuncode.Springbootlearn.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> { //Department entity and Long primary key type
}
