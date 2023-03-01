package com.example.jspempdb.service;

import java.util.List;

import com.example.jspempdb.module.JspEmp;

public interface JspEmpService {
	
    JspEmp saveEmp(JspEmp e);
    
    List<JspEmp> allDetails();
    
    JspEmp getEmpById(int eid);
    
    List<JspEmp> getEmpByEcource(String ecource);
    
    JspEmp deleteByIdEmp(int eid);
    
    JspEmp updateEmp(JspEmp e,int eid);
     
    
}
