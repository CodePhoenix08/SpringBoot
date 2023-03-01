package com.example.jspempdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jspempdb.module.JspEmp;

public interface JspEmpRepo  extends JpaRepository<JspEmp,Integer>{
	@Query(value="select * from jsp_emp where ecource=?1",nativeQuery=true)
	List<JspEmp> findByEcource(String ecource);
}
