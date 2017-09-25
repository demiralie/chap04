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
import com.example.domain.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class ProfileRepositoryTest {

	@Inject
	ProfileRepository repo;

	@Inject
	MyDeptRepository deptrepository;

	@Inject
	MyEmpRepository emprepository;

	@Test
	@Transactional
	public void testGeneratorValue() {
		Profile profile = new Profile();
		profile.setFname("user01_profile");
		repo.save(profile);

		repo.findAll().forEach(e -> {
			System.out.println(e);
		});
		
		MyDept dept = new MyDept();
		dept.setDname("개발부");
		dept.setLoc("서울");
		deptrepository.save(dept);
		
		deptrepository.findAll().forEach(e-> {
			System.out.println(e);
		});
		
		MyEmp emp = new MyEmp();
		emp.setEname("홍길동");
		emprepository.save(emp);
		
		emprepository.findAll().forEach(e1->{
			System.out.println(e1);
		});
		
	}

	@Test
	@Transactional
	public void testProfileSave() {
		for (int i = 0; i < 10; i++) {
			Profile profile = new Profile();
			profile.setFname("user01_profile" + i);

			repo.save(profile);
		}

		repo.findAll().forEach(e -> {
			System.out.println(e);
		});
	}

	@Test
	@Transactional
	public void testProfileAll() {
		repo.findAll().forEach(e -> {
			System.out.println(e);
		});
	}
}
