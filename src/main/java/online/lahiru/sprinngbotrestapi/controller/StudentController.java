package online.lahiru.sprinngbotrestapi.controller;

import online.lahiru.sprinngbotrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("listStu/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFullName());
        System.out.println(student.getLastName());
        return  student;
    }

    @GetMapping("student")
    public ResponseEntity<Student>   getStudent2() {
        Student student = new Student(1, "lahiru", "San");
//        return new ResponseEntity<>(student, HttpStatus.OK);
//return  ResponseEntity.ok(student);
// This both return types are ok

        return  ResponseEntity.ok().header("custome-header", "lara")
                .body(student);

    }

}
