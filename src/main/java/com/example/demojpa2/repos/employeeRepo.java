package com.example.demojpa2.repos;
import com.example.demojpa2.employee.Emptable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface employeeRepo extends CrudRepository<Emptable,Integer> {
    //JPQL REPO
//1

    @Query("select emp.firstname, emp.lastname from empTable emp where emp.salary>(select AVG(salary) from empTable)")
    List<Object[]> findAllEmployeeAvg(Sort sort);

//  //2

    @Modifying
    @Query("update empTable set salary=:salary where salary <:avgsalary")
    void updateSalaryOfEmployeeLessthanAvg(@Param("salary")int salary, @Param("avgsalary") int avgsalary);

    @Query("select avg(salary from empTable")
    int findAverageSalary();
//

    @Query("select min(Salary) from empTable")
    int findMinimumSalary();
//////3
    @Modifying
    @Query("delete from empTable where salary=:minsalary")
    void deleteAllEmployeeSalaryMin(@Param("minsalary") int salary);


//
////NATIVE JPQL repo

    @Query(value = "select * from emptable where empLastName=:lastName", nativeQuery = true)
    List<Emptable> findAllEmployeeByLastNamewithsingh(@Param("lastName") String lastName);



    @Modifying
    @Query(value = "delete from emptable where empage>:age",nativeQuery = true)
    void deleteAllEmployeeAgeGreaterThan(@Param("age") int age);


}
