package com.example.demo.layer5;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;
//import org.springframework.web.bind.annotation.*;
//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Department5;
import com.example.demo.layer4.DepartmentService;
import com.example.demo.layer4.exceptions.DepartmentAlreadyExsisException;
import com.example.demo.layer4.exceptions.DepartmentNotFoundException;

@RestController  //REpresentational State Transfer html xml json
public class DepartmentController {

	@Autowired
	DepartmentService deptServ;
	
	@GetMapping(path="/getDept/{mydno}") //Get Request in Postman http://localhost:8080/getDept/1
	@ResponseBody
	public ResponseEntity<Department5> getDepartment(@PathVariable("mydno") Integer dno) throws DepartmentNotFoundException  {
		System.out.println("Department Controller....Understanding client and talking to service layer...");
		Department5 dept = null;
			dept = deptServ.findDepartmentService(dno);
			if(dept == null) {
				Map m = new HashMap();
				m.put("message",  "Dept Not found");
				//HeadersBuilder hb = ResponseEntity.notFound();
				
				HttpStatus status =HttpStatus.NOT_FOUND;
				//return new ResponseEntity(m,status);
				return ResponseEntity.notFound().build();
				//return new 
				
			}
			else {
				return ResponseEntity.ok(dept);
			}
	}
	
	
	@GetMapping(path="/getDepts")
	@ResponseBody
	public List<Department5> getAllDepartments() {
		System.out.println("Department Controller....Understanding client and talking to service layer...");
		List<Department5> deptList = deptServ.findDepartmentsService();
		return deptList;
		
	}
	
	@PostMapping(path="/addDept")
	public String addDepartment(@RequestBody Department5 dept) {
		String statusMsg = null;
		try {
			statusMsg = deptServ.addDepartmentService(dept);
		} catch (DepartmentAlreadyExsisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return statusMsg;
		
	}
	
	@PutMapping(path="/modifyDept")
	public String modifyDepartment(@RequestBody Department5 dept) {
		String statusMsg = null;
		try {
			statusMsg = deptServ.modifyDepartmentService(dept);
		} catch (DepartmentNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return e.getMessage();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return statusMsg;
		
	}
	
	@DeleteMapping(path="/deleteDept")
	public String deleteDepartment(@RequestBody Department5 dept) {
		String statusMsg = null;
		try {
			statusMsg = deptServ.removeDepartmentService(dept.getDepartmentNumber());
		} catch (DepartmentNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return e.getMessage();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return statusMsg;
		
	}
	
}
