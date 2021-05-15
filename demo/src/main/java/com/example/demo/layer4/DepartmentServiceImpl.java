package com.example.demo.layer4;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.Department5;
import com.example.demo.layer3.DepartmentRepository;
import com.example.demo.layer4.exceptions.DepartmentAlreadyExsisException;
import com.example.demo.layer4.exceptions.DepartmentNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
		
	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public String addDepartmentService(Department5 dRef) throws DepartmentAlreadyExsisException {
		System.out.println("Department Service....Some scope of bussiness logic here...");
		try {
			deptRepo.addDepartment(dRef);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DepartmentAlreadyExsisException("Department Already Exsist");
		}
		return "Department added successfully";
	}

	@Override
	public Department5 findDepartmentService(int dno) throws DepartmentNotFoundException {
		System.out.println("Department Service....Some scope of bussiness logic here...");
		Department5 dept = deptRepo.findDepartment(dno);
		if(dept == null) {
			throw new DepartmentNotFoundException("Department Not Found");
		}
		return dept;
	}

	@Override
	public List<Department5> findDepartmentsService() {
		System.out.println("Department Service....Some scope of bussiness logic here...");
		return deptRepo.findDepartments();
	}

	@Override
	public String modifyDepartmentService(Department5 dRef) throws DepartmentNotFoundException {
		
			Department5 dept = deptRepo.findDepartment(dRef.getDepartmentNumber());
			if(dept == null) {
				throw new DepartmentNotFoundException("Department Not Found");
				
			}
			else {
				deptRepo.modifyDepartment(dRef);
			}
				
		return "Department modifed successfully";
	}



	@Override
	public String removeDepartmentService(int dno) throws DepartmentNotFoundException {
		Department5 dept = deptRepo.findDepartment(dno);
		if(dept == null) {
			throw new DepartmentNotFoundException("Department Not Found");
			
		}
		else {
			deptRepo.removeDepartment(dno);
		}
			
	return "Department Deleted successfully";

	}

}
