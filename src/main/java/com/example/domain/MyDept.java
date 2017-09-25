package com.example.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;
import lombok.ToString;

// 1. @OneToOne
// 2. @OnetoMany
// 3. @ManyToOne
// 4. @ManyToMany

@Entity
@Table(name="tbl_dept")
@Data
@ToString(exclude={"emps"})
public class MyDept {

	@Id
	@TableGenerator(name="idgen", table="id_gen", pkColumnName="seq_name",valueColumnName="nextval", allocationSize=10, initialValue=100) //채번 TABLE
	@GeneratedValue(strategy = GenerationType.TABLE, generator="idgen")
	Integer deptno;
	String dname;
	String loc;
	
	@OneToMany(mappedBy="dept", fetch=FetchType.LAZY)
	List<MyEmp> emps;
}
