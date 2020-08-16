
package com.deptempspbsecurityi18;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.deptempspbsecurityi18.dao.DeptEmpDao;
import com.deptempspbsecurityi18.dao.DeptRepo;
import com.deptempspbsecurityi18.dao.EmpRepo;
import com.deptempspbsecurityi18.model.Department;
import com.deptempspbsecurityi18.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Deptempspbsecurityi18ApplicationTests {

	@Autowired
	private DeptEmpDao deptDao;

	@MockBean
	DeptRepo deptRepo;

	@MockBean
	EmpRepo empRepo;

	
	@SuppressWarnings("unused")
	@Test()
	public void saveDeptTestDao() {
		Department dep9 = new Department(1, "training", "pune");

		if (dep9 == null) {
			assertNotNull("object should not be null", dep9);
		} else {
			when(deptRepo.save(dep9)).thenReturn(dep9);
			assertTrue(deptDao.createDept(dep9));
		}

		/*
		 * assertThrows(Exception.class, (Executable) deptRepo.save(dep9),
		 * "some exception occured");
		 */

	}

	@Test
	public void getAllDeptTest() {
		
		
		when(deptRepo.findAll())
				.thenReturn(Stream.of(new Department(1, "training", "pune"), new Department(2, "HR", "palakkad"))
						.collect(Collectors.toList()));
		if(deptDao.readAllDept() ==null)
		{
			assertNotNull("list values should not be empty", deptDao.readAllDept());
		}else
		{
		
		Assert.assertEquals(2, deptDao.readAllDept().size());
		}
	}

	@Test
	public void getEmpFromDeptTest() {
		int id = 1;
		Department dept = new Department();
		dept.setDeptId(id);
		if(id==0)
		{
			assertNotNull("id value is zero ", id);
		}else
		{
		when(empRepo.findByDepartment(id)).thenReturn(Stream
				.of(new Employee(1, "Udhay", "29-05-1989", "udhaya2cse@gmail.com", 9876542310L, 98562.26f, "HCl", dept),
						new Employee(2, "Raj", "19-09-1995", "raj@gmail.com", 9986542310L, 98562.26f, "Infosys", dept))
				.collect(Collectors.toList()));
		Assert.assertEquals(2, deptDao.readEmpFromDept(id).size());
	}}

	@SuppressWarnings("unused")
	@Test
	public void saveDeptTest() {
		Department dep2 = new Department(3, "support", "chhennai");

		if(dep2 ==null)
		{
			assertNotNull("object is null", dep2);
		}else
		{
		when(deptRepo.save(dep2)).thenReturn(dep2);
		assertEquals(true, deptDao.createDept(dep2));
	}}

	@SuppressWarnings("unused")
	@Test public void deleteDeptTest() {
	  
	  Department dep = new Department(5,"sales","pune");
	  
	  if(dep==null)
	  {
		  assertNotNull("object is null", dep);
	  }else
	  {
	  deptDao.delteDept(dep.getDeptId());
	  verify(deptRepo,times(1)).deleteByDeptId(dep.getDeptId()); 
	   
	  }}

	@Test
	public void getAllEmpTest() {
		int deptId = 1;
		Department dps = new Department();
		dps.setDeptId(deptId);
		
		if(deptId == 0)
		{
			assertNotNull("id value is zero", deptId);
		}else {
		when(empRepo.findByDepartment(deptId)).thenReturn(Stream
				.of(new Employee(23, "manoj", "mano@gmail.com", "1993-02-26", 894315697, 46953.56f, "tcs", dps),
						new Employee(25, "rakesh", "rake@gmail.com", "1991-03-26", 894315697, 32953.56f, "cts", dps))
				.collect(Collectors.toList()));
		Assert.assertEquals(2, deptDao.readEmpFromDept(deptId).size());
		}
	}

	@SuppressWarnings("unused")
	@Test
	public void updateDeptTest() {
		Department df = new Department(5, "support", "chennai");

		if(df ==null)
		{
			assertNotNull("null values for the object", df);
		}else {
		df.setDeptLoc("Pune");
		when(deptRepo.save(df)).thenReturn(df);
		assertEquals(true, deptDao.updateDept(df));
		}
	}

	@SuppressWarnings("unused")
	@Test
	public void createEmpTest() {
		
		Department dep1 = new Department();
		dep1.setDeptId(2);
		if(dep1 == null)
		{
			assertNotNull("values should not be null", dep1);
		}
		
		else {		Employee emp2 = new Employee(26, "kiraan", "ksh@gmail.com", "1996-02-26", 894315697, 26953.56f, "ibm", dep1);
		Employee emp4 = new Employee(29, "Kumar", "kum@gmail.com", "1990-08-26", 894315697, 36953.56f, "infomatica",
				dep1);

		when(empRepo.save(emp2)).thenReturn(emp2);
		when(empRepo.save(emp4)).thenReturn(emp4);
		assertEquals(true, deptDao.createEmp(emp4));
		assertEquals(true, deptDao.createEmp(emp2));
		}
	}

	@SuppressWarnings("unused")
	@Test
	public void updateEmpTest() {
		Department dep = new Department();
		dep.setDeptId(5);
		if(dep == null)
		{
			assertNotNull("object null for dept value", dep);
		}else {
		
		Employee emp2 = new Employee(26, "kiraan", "ksh@gmail.com", "1996-02-26", 894315697, 26953.56f, "ibm", dep);

		emp2.setCompanyName("IBM");

		when(empRepo.save(emp2)).thenReturn(emp2);
		assertEquals(true, deptDao.updateEmp(emp2));
		}
	}

	@Test
	public void DeleteEmpTest() {
		int deptId = 2;
		int empId = 1;
if(deptId ==0 || empId==0)
{
	assertNotNull("ids are null values", deptId );
	
}else {
		deptDao.deleteEmpFromDept(deptId, empId);
		verify(empRepo, times(1)).deleteByEmpIdAndDepartment(empId, deptId);
	}}

}