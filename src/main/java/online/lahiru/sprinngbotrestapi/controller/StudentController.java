package online.lahiru.sprinngbotrestapi.controller;

import online.lahiru.sprinngbotrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "lahiru", "San");
        return student;

    }

    @GetMapping("listStu")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "lara", "rj"));
        students.add(new Student(2, "jaya", "sakis"));
        students.add(new Student(3, "kakka", "bara"));

        return students;
    }

    @GetMapping("listStu/{id}")
    public Student studentPathVariable(@PathVariable("id") int stuId) {
        return new Student(stuId, "LARA", "RJ");

    }
//    http://localhost:8080/listStu/query?id=2
    @GetMapping("listStu/query")
    public Student studentRequestVariable(@RequestParam int id){
        return  new Student(id,"Ramesh","fadatare");
    }
}
