package com.deptempspbsecurityi18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deptempspbsecurityi18.dao.DeptEmpDao;
import com.deptempspbsecurityi18.model.Department;
import com.deptempspbsecurityi18.model.Employee;


@Service
@Transactional
public class DeptEmpServImpl implements DeptEmpService {
    
	@Autowired
	DeptEmpDao dempServ;
	@Override
	public boolean createDeptServ(Department dept) {
		
		dempServ.createDept(dept);
		return true;
	}

	@Override
	public boolean updateDeptServ(Department dept) {

          dempServ.updateDept(dept);
		return true;
	}

	@Override
	public List<Department> readAllDeptServ() {
		List<Department> lisDept = dempServ.readAllDept();
		for (Department department : lisDept) {
			System.out.println("depart values " +department.getDeptName());
		}
		
		return lisDept;
	}

	@Override
	public boolean delteDeptServ(int deptId) {
	dempServ.delteDept(deptId);
	System.out.println("id from test "+deptId);
		return true;
	}

	@Override
	public boolean createEmpServ(Employee employee) {
		dempServ.createEmp(employee);
		System.out.println("create employee "+employee.getEmpName());
		return true;
	}

	@Override
	public boolean updateEmpServ(Employee employee) {
		dempServ.updateEmp(employee);
		
		System.out.println("update Employee"+employee.getCompanyName());
		return true;
	}

	@Override
	public List<Employee> readEmpFromDeptServ(int empId) {
		List<Employee> lisEmp = dempServ.readEmpFromDept(empId);
		System.out.println("readEmpFromDeptServ :- id is " +empId);
		return lisEmp;
	}

	@Override
	public boolean deleteEmpFromDeptServ(int deptId, int empId) {
		dempServ.deleteEmpFromDept(deptId, empId);
		System.out.println("deleteEmpFromDeptServ :- id is " +empId + "deptId "+deptId);
		return true;
	}

	@Override
	public Page<Department> readAllDeptPage(Pageable pageable) {
		Page<Department> pgf =dempServ.readAllDeptPage(pageable);
		return pgf;
	}


}
