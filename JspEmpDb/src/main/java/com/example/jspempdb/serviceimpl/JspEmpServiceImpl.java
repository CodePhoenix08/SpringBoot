package com.example.jspempdb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jspempdb.exception.ResourceNotFoundException;
import com.example.jspempdb.module.JspEmp;
import com.example.jspempdb.repository.JspEmpRepo;
import com.example.jspempdb.service.JspEmpService;

@Service
public class JspEmpServiceImpl implements JspEmpService {
	@Autowired
	JspEmpRepo repo;
	@Override
	public JspEmp saveEmp(JspEmp e) {
		return repo.save(e);
	}
	@Override
	public List<JspEmp> allDetails() {
		return repo.findAll();
		
	}
	@Override
	public JspEmp getEmpById(int eid) {
		return repo.findById(eid).orElseThrow(()-> new ResourceNotFoundException("JspEmp","eid",eid));
	}
	@Override
	public List<JspEmp> getEmpByEcource(String ecource) {
		
		return repo.findByEcource(ecource);
	}
	@Override
	public JspEmp deleteByIdEmp(int eid) {
		if(repo.existsById(eid)) {
			//repo.getById(null);
			JspEmp e1=repo.findById(eid).orElseThrow(()-> new ResourceNotFoundException("JspEmp","eid",eid));
			repo.deleteById(eid);
			return e1;
		}
		else {
			return null;
		}
	}
	@Override
	public JspEmp updateEmp(JspEmp e, int eid) {
JspEmp ExistEmp=repo.findById(eid).orElseThrow(()-> new ResourceNotFoundException("JspEmp","eid",eid));
ExistEmp.setEname(e.getEname());
ExistEmp.setEcource(e.getEcource());
ExistEmp.setDesignation(e.getDesignation());
ExistEmp.setAge(e.getAge());

		return repo.save(ExistEmp);
	}
	
	
}
