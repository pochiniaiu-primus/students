package com.luxcampus.controller;

import com.luxcampus.entity.Student;
import com.luxcampus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String showAllStudents(Model model) {
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("allStudents", allStudents);
        return "show-all-students";
    }

    @RequestMapping("/addNewStudent")
    public String addNewStudent(Model model) {
        Student student = new Student();
        //add modelAttribute="student" from student-info.jsp
        model.addAttribute("student", student);
        return "student-info";
    }

    //When we push on button OK, after changing data in form student-info
    @RequestMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @RequestMapping("/updateInfoAboutStudent")
    public String updateStudent(@RequestParam("studId") int id,
                                Model model) {
        Student student = studentService.getStudent(id);//get Student from DataBase per id
        //I get id from button "UPDATE" in show-all-students.jsp
        //After push on button "UPDATE" we call updateStudent()
        //Now we can add student in attribute model
        //student-info work with attribute "student"
        model.addAttribute("student", student);
        //Now when we call view student-info from method updateStudent() displayed with completed forms
        return "student-info";
    }

    @RequestMapping("/deleteInfoAboutStudent")
    public String deleteStudent(@RequestParam("studId") int id,
                                Model model) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

}