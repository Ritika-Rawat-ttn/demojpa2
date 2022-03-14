package com.example.demojpa2;

import com.example.demojpa2.employee.Emptable;
import com.example.demojpa2.repos.employeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;



@SpringBootTest
class Demojpa2ApplicationTests {


	@Autowired
	employeeRepo repository;

	@Test
	void testemployeecreate() {
		Emptable employee=new Emptable();
		employee.setFirstName("Ritika");
		employee.setLastName("RAwat");
		employee.setAge(21);
		employee.setSalary(20000);

		Emptable employee1=new Emptable();
		employee1.setFirstName("swarnim");
		employee1.setLastName("singh");
		employee1.setAge(22);
		employee1.setSalary(30000);

		Emptable employee2=new Emptable();
		employee2.setFirstName("saurabh");
		employee2.setLastName("kumar");
		employee2.setAge(23);
		employee2.setSalary(40000);
		Emptable employee3=new Emptable();
		employee3.setFirstName("saurabh");
		employee3.setLastName("kumar");
		employee3.setAge(53);
		employee3.setSalary(40000);
		repository.save(employee2);
		repository.save(employee1);
		repository.save(employee);
		repository.save(employee3);
	}

//	//JPQL TEST CASES


	//1
	@Test
	public void testFindByGreaterThanAvg(){
		Sort sort=Sort.by("age").ascending().and(Sort.by("salary").descending());
		List<Object[]> partialData=repository.findAllEmployeeAvg(sort);
		for (Object[] objects:partialData){
			System.out.println(objects[0]+" "+objects[1]);
		}
	}
//2
	@Test
	@Transactional
	@Rollback(value = false)
	public void testupdateSalaryOfEmployeeLessthanAvg(){
		int salary=30000;
		int avgsalary=repository.findAverageSalary();
		repository.updateSalaryOfEmployeeLessthanAvg(salary,avgsalary);

	}
//3
	@Test
	@Transactional
	@Rollback(value = false)
	public void testdeleteEmployeeWithMinSalary(){
		int minSalary=repository.findMinimumSalary();
		repository.deleteAllEmployeeSalaryMin(minSalary);

	}

	//NATIVE JPQL TEST CASES
	@Test
	public void testNameEndsWithSingh(){
		List<Object[]> empdate= repository.findAllEmployeeNameEndsWithSingh();
		for (Object []objects:empdate){
			System.out.println(objects[0]+""+objects[1]+""+objects[2]);
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testdeleteAllEmployeeAgeGreaterThan(){
		repository.deleteAllEmployeeAgeGreaterThan(45);
	}







}
