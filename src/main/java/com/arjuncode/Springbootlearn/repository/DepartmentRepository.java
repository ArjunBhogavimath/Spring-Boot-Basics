package com.arjuncode.Springbootlearn.repository;

import com.arjuncode.Springbootlearn.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> { //Department entity and Long primary key type

    //the naming should be strictly followed
    //the prefix should be the operation (findBy)
    //and the suffix should be declared variable in entity class i.e., departmentName \
    //but the first letter should be capital i.e., DepartmentName
    public Department findByDepartmentName(String departmentName);

    //the above 1 is strictly checks case
    //so we can create another method to ignore case
    public Department findByDepartmentNameIgnoreCase(String departmentName);

}

//to get the understanding of how the naming convention works
//goto docs/spring.io/spring-data
//6th -> JPA Repositories
//6.3.2 Query creation

//if the method is complex and couldn't be able to written in methods as above
//then we can use @Query("",native query=true) annotation above
//if the query is sql make sure to add native query=true part
//if the query is native query then for 1st paramter add ?1 and for second parameter it will be ?2
