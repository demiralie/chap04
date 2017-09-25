package com.example.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.MyDept;
import com.example.domain.MyEmp;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class MyDeptRepositoryTest {

	@Inject
	MyDeptRepository deptRepository;

	@Inject
	MyEmpRepository empRepository;

	@Test
	@Transactional
	public void testDeptAll() {

		System.out.println(deptRepository.getClass());
		System.out.println(empRepository.getClass());
		
		MyDept dept = new MyDept();
		dept.setDeptno(10);
		Example<MyDept> example = Example.of(dept);
		
		deptRepository.findAll(example).forEach(e -> {
			System.out.println(e);
//			System.out.println(e.getEmps());
		});
	}
	@Test
	@Transactional
	public void testEmpAll() {

		System.out.println(deptRepository.getClass());
		System.out.println(empRepository.getClass());
		
		Optional<MyEmp> optional = empRepository.findById(1001);
		MyEmp emp = optional.get();
		System.out.println(emp);
		System.out.println(emp.getMgr().getEmpno());
		System.out.println(emp.getDept());
//		empRepository.findAll().forEach(e -> {
//			System.out.println(e);
//		});
	}

	@Test
	public void test2() {
		List<MyEmp> emp = empRepository.queryByEname("김사랑");
		System.out.println(emp);
	}
	
	@Test
	public void test3() {
		List<MyEmp> emps = empRepository.queryMgrByEname("김사랑");
		System.out.println(emps);
	}
}
