package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository
;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.MyDept;
import com.example.domain.MyEmp;

public interface MyEmpRepository extends JpaRepository<MyEmp, Integer > {

	List<MyEmp> queryByEname(String ename);
	
	@Query("select mgr from MyEmp mgr "
	+"inner join MyEmp emp "
	+"on mgr.empno = emp.mgr "
	+"where emp.ename = :ename")
	List<MyEmp> queryMgrByEname(@Param("ename")String ename);
}
