package online.lahiru.sprinngbotrestapi.controller;

import online.lahiru.sprinngbotrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1, "lahiru", "San");
        return student;

    }

    @GetMapping("listStu")
    public List<Student> getStudents(){
        List<Student> students= new ArrayList<>();
        students.add(new Student(1,"lara","rj"));
        students.add(new Student(2,"jaya","sakis"));
        students.add(new Student(3,"kakka","bara"));

        return  students;
    }

}
