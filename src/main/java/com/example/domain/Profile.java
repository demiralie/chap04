package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_profile")
@EqualsAndHashCode(of = "fn")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
	
	@Id
	@TableGenerator(name="idgen", table="id_gen", pkColumnName="seq_name",valueColumnName="nextval", allocationSize=100, initialValue=1000) //채번 TABLE
	@GeneratedValue(strategy = GenerationType.TABLE, generator="idgen")
	private Long fn;
	private String fname;
	private boolean curr;
}
