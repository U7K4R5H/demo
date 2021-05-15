package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Department5;


@Repository
public interface DepartmentRepository {//same as DeparmentDAO

	void addDepartment(Department5 dRef);   //C - add/create
	Department5 findDepartment(int dno);     //R - find/reading
	List<Department5> findDepartments();     //R - find all/reading all
	void modifyDepartment(Department5 dRef); //U - modify/update
	void removeDepartment(int dno); //D - remove/delete
	 List<Department5> findSqlDepartments(); 
	 List<Department5> findJpqlDepartments();
	 List<Department5> findJpql2Departments();
	 List<Department5> findJpql3Departments();
}
