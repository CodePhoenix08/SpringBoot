package com.example.jspempdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jspempdb.module.JspEmp;
import com.example.jspempdb.service.JspEmpService;

@RestController
public class JspEmpController {
	@Autowired
	JspEmpService s;
	
	@PostMapping("/saveEmp")
	ResponseEntity<JspEmp> saveEmp(@RequestBody JspEmp e){
		return new ResponseEntity<JspEmp>(s.saveEmp(e),HttpStatus.CREATED);
	}
	
	@GetMapping("/Details")
	List<JspEmp> empDetails(){
		return s.allDetails();
	}
	
	@GetMapping("/findById/{eid}")
	ResponseEntity<JspEmp> EmpbyId(@PathVariable int eid){
		return new ResponseEntity<JspEmp>(s.getEmpById(eid),HttpStatus.OK);
	}
	
	@GetMapping("/Details/{ecource}")
	List<JspEmp> empDetailsBycource(@PathVariable String ecource){
		return s.getEmpByEcource(ecource);
	}
	
	@DeleteMapping("/delete/{eid}")
	ResponseEntity<JspEmp> delete(@PathVariable int eid){
		return new ResponseEntity<JspEmp>(s.deleteByIdEmp(eid),HttpStatus.OK);
	}
	
	@PutMapping("/update/{eid}")
	ResponseEntity<JspEmp> updateEmp(@RequestBody JspEmp e,@PathVariable int eid){
		return new ResponseEntity<JspEmp>(s.updateEmp(e, eid),HttpStatus.OK);
	}
	
	
}





