package com.arjuncode.Springbootlearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data //IT WILL HAVE ALL THE GETTER SETTER HASH EVERYTHING @GETTER @SETTER WILL PRESNT WITH THIS ANNOTATION
@NoArgsConstructor //Default CONSTRUCTOR
@AllArgsConstructor //Paramterized contrsutor
@Builder //entire builder pattern will be implemented
public class Department {

    @Id //TO MAKE departmentId AS PRIMARY KEY @Id added
    @GeneratedValue(strategy = GenerationType.AUTO) // this is how to generate primary key
    private Long departmentId;

    @NotBlank(message = "Please Add Department Name")
    /*@Length(max = 5,min = 1)
    @Size(max = 10, min = 0)
    @Email //we can add regex
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent*/
    //all of this are differnt validations we can utilize
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


    /* WILL REMOVE THIS BECAUSE WE CAN ACHIEVE THIS BY DIRECTLY USING LOMBOK ANNOTATION
     ALL THESE ARE BOILERPLATE CODES , SO WE DONT NEED TO ADD THIS
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    //constructor
    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    //default constructor
    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }

     */
}


//To make this class as an Entity so it can interact with DB
// we need to add @Entity annotation