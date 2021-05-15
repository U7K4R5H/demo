package com.example.demo.layer3;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Department5;



@Repository
public class DeparmentRepositoryImpl implements DepartmentRepository {//isA
	
	
	@PersistenceContext
	 EntityManager entityManager;//auto injected by spring by reading 
										//persistance.xml file
	
	@Transactional//no need of begin transaction and commit rollback
	public void addDepartment(Department5 dRef) {//usesA
		entityManager.persist(dRef);

	}
	
	@Transactional
	public Department5 findDepartment(int dno) {//producesA Department obj
		System.out.println("Department repo....NO scope of bussiness logic here...");
		Department5 dept5Obj = entityManager.find(Department5.class, dno);
		System.out.println(dept5Obj);
		return dept5Obj;
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Department5> findDepartments() {
		List<Department5> deptList;
		deptList = new ArrayList<Department5>();
		
			String queryString = "from Department5";
			Query query = entityManager.createQuery(queryString);
			deptList = query.getResultList();
					
		return deptList;
		
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Department5> findSqlDepartments() {
		List<Department5> deptList;
		deptList = new ArrayList<Department5>();
		
			
			Query query = entityManager.createNativeQuery("select * from dept6",Department5.class);
			deptList = query.getResultList();
			
		
		return deptList;
		
		
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Department5> findJpqlDepartments() {
		List<Department5> deptList;
		deptList = new ArrayList<Department5>();
		
			
			Query query = entityManager.createQuery("select i from Department5 i",Department5.class);
			deptList = query.getResultList();
			
		
		return deptList;
		
		
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Department5> findJpql2Departments() {
		List<Department5> deptList;
		deptList = new ArrayList<Department5>();
		
			
			Query query = entityManager.createQuery("select i from Department5 i where i.departmentLocation=:mylocation",Department5.class).setParameter("mylocation", "MUMBAI");
			deptList = query.getResultList();
			
		
		return deptList;
		
		
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Department5> findJpql3Departments() {
		List<Department5> deptList;
		deptList = new ArrayList<Department5>();
		
			
			Query query = entityManager.createNamedQuery("deptMUMBAI",Department5.class).setParameter("mylocation", "MUMBAI");
			deptList = query.getResultList();
			
		
		return deptList;
		
		
	}
	@Transactional
	public void modifyDepartment(Department5 dRef) {
		entityManager.merge(dRef);

	}

	@Transactional
	public void removeDepartment(int dno) {
		Department5 dTemp = entityManager.find(Department5.class,dno);
		entityManager.remove(dTemp);
		
	}

}
