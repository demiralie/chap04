package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository
;

import com.example.domain.MyDept;

public interface MyDeptRepository extends JpaRepository<MyDept, Integer > {

}
