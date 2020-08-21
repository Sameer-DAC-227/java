package p2;

import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private String deptId;
	private double salary;
	private Date joinDate;
	
	public Employee(int id, String name, String deptId, double salary, Date joinDate) {
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.salary = salary;
		this.joinDate = joinDate;
	}
	
	public boolean equals(Object obj) {
		Employee emp = (Employee)obj;
		if((this.id==emp.id) && (this.deptId.equals(emp.deptId)))
				return true;
		else
			return false;
	}
}
