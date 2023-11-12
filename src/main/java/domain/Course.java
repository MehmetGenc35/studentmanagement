package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Course sınıfı, bir dersin adını, kodunu, kredisini ve bölümünü içerecektir.
@Entity
@Table(name = "t_courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "course_name",nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String code;

    @Column(name = "credit",nullable = false)
    private int courseCredit;

    @Column(name = "course_department",nullable = false)
    private String department;

    @ManyToMany(mappedBy = "courseList",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Student> studentList=new ArrayList<>();

    //Getter-Setter


    public Long getId() {
        return Id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Student> getStudentList() {
        return studentList;
    }


    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + Id +
                ", courseName='" + courseName + '\'' +
                ", code=" + code +
                ", courseCredit=" + courseCredit +
                ", department='" + department + '\'' +
                '}';
    }
}
