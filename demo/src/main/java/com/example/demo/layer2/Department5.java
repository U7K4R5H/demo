package com.example.demo.layer2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@NamedQuery(name="deptMUMBAI",query="select i from Department5 i where i.departmentLocation=:mylocation")
@Entity
@Table(name="dept6")
public class Department5 {
	@Id
	//@GeneratedValue//it is to generate the primary key value automatically
	@Column(name="DEPTNO")
	private int departmentNumber;
	@Column(name="DNAME",length = 10)
	private String departmentName;
	@Column(name="LOC",length = 10)
	private String departmentLocation;

	/*
	 * @OneToMany(mappedBy = "dept6", fetch = FetchType.EAGER, cascade =
	 * CascadeType.ALL ) Set<Employee> emplist = new HashSet<Employee>();
	 */
	public Department5() {
		super();
		System.out.println("Department5 ctor() is called");
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	

	/*
	 * public Set<Employee> getEmplist() { return emplist; }
	 * 
	 * public void setEmplist(Set<Employee> emplist) { this.emplist = emplist; }
	 */

//	@Override
//	public String toString() {
//		return "Department [departmentNumber=" + departmentNumber + ", departmentName=" + departmentName
//				+ ", departmentLocation=" + departmentLocation + "]";
//	}
	
}
