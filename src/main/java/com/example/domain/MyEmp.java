package com.example.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "tbl_emp")
@Data
@ToString(exclude = { "mgr", "dept" })
public class MyEmp {

	public enum Gender {
		M, F;
	}

	@Id
	@TableGenerator(name="idgen", table="id_gen", pkColumnName="seq_name",valueColumnName="nextval", allocationSize=10, initialValue=7000) //채번 TABLE
	@GeneratedValue(strategy = GenerationType.TABLE, generator="idgen")
	private Integer empno;
	private String ename;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String job;

	// private Integer mgr;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mgr")
	private MyEmp mgr;

	@Temporal(TemporalType.DATE)
	private Date hiredate;
	private BigDecimal sal;
	private BigDecimal comm;

	// private Integer deptno;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "deptno")
	private MyDept dept;

}