package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Department5;
import com.example.demo.layer4.exceptions.DepartmentAlreadyExsisException;
import com.example.demo.layer4.exceptions.DepartmentNotFoundException;
@Service
public interface DepartmentService {
	String addDepartmentService(Department5 dRef) throws DepartmentAlreadyExsisException;  //C - add/create
	Department5 findDepartmentService(int dno) throws DepartmentNotFoundException;    //R - find/reading
	List<Department5> findDepartmentsService();     //R - find all/reading all
	String modifyDepartmentService(Department5 dRef) throws DepartmentNotFoundException; //U - modify/update
	String removeDepartmentService(int dno) throws DepartmentNotFoundException; //D - remove/delete
}
