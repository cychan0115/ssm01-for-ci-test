package com.print.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.print.model.Student;
import com.print.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentService studentService;

	@RequestMapping("/addStu")
	public ModelAndView addStu(HttpServletRequest request, Model model) {

		String username = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		Student student = new Student();
		student.setName(username);
		student.setAge(age);
		student.setSex(sex);
		int i = this.studentService.addStu(student);
		String url = "addStu";
		if(i>0&&username!=null){
			url="success";
		}
		else{
			url="addStu";
		}
		ModelAndView view = new ModelAndView(url);
		return view;
	}

	@RequestMapping("/delStu")
	public ModelAndView delStu(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		int id1 = Integer.valueOf(id);
		int i = this.studentService.DelStu(id1);
		String url = "delStu";	
		ModelAndView view = new ModelAndView(url);
		return view;
	}	
	
	@RequestMapping("/updateStu")  
	public String updateStu(HttpServletRequest request,Model model){
	int id=new Integer(request.getParameter("id"));
    String name=request.getParameter("name");
    String age=request.getParameter("age");
    String sex=request.getParameter("sex");
    Student student=new Student();
    student.setAge(age);
    student.setId(id);
    student.setName(name);
    student.setSex(sex);
    int i=this.studentService.updateStu(student);
	return "success";
	 }
	 @RequestMapping("/selectStudentByID")  
	 public ModelAndView selectStudentByID(HttpServletRequest request,Model model){
		int id = new Integer(request.getParameter("id"));		
		Student student=this.studentService.selectStudentByID(id);
	    ModelAndView view = new ModelAndView();
		view.setViewName("updateStu");
		view.addObject("student", student);
		return view;
	 }
	 
	
	@RequestMapping("/getAllStu")
	public ModelAndView getAllStu() {
		List<Student> students=new ArrayList<Student>();
		students=this.studentService.getAllStu();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Studentlist");
		modelAndView.addObject("xxx", students);
		return modelAndView;
	}
	 @RequestMapping("/getStudentByName")  
	 public ModelAndView getStudentByName(HttpServletRequest request,Model model){
		 String name = request.getParameter("name");
		 List<Student> students = new ArrayList<Student>();
		 if (name!=null) {
			 students=this.studentService.getStuByName(name);
			 
		 }
			ModelAndView view = new ModelAndView();
			view.setViewName("getStudentByName");
			view.addObject("xxx", students);
			 return view;
	 }
	
	 @RequestMapping("/up")  
	 public String up(HttpServletRequest request,Model model){
	return "Studentlist";
	 }

}
