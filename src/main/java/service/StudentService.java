package service;

import domain.Course;
import domain.Student;
import repository.Repository;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements Service<Student> {

    private Repository<Student> repo=new StudentRepository();
    private Course course=new Course();
    private CourseService courseService=new CourseService();


    @Override
    public void showMenu() {
        Scanner inp = new Scanner(System.in);
        int select=-1;
        do {
            System.out.println("1-Öğrenci Ekle\n2-Öğrenci Sil\n3-Öğrencileri Listele\n0-Ana Menü");
            System.out.println("Lütfen bir seçim yapınız: ");
            select=inp.nextInt();inp.nextLine();

            switch (select){
                case 1:
                    add(informationStudent());
                    break;
                case 2:
                    Student student=findStudentById(findStudentId());
                    remove(student);
                    break;
                case 3:
                    getAll();
                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("Hatalı bir giriş yaptınız...");
                    break;
            }



        }while(select!=0);
    }
    public Student informationStudent(){
        Student student=new Student();
        Scanner inp = new Scanner(System.in);
        System.out.println("Öğrencinin adı: ");
        student.setName(inp.nextLine());
        System.out.println("Öğrencinin soyadı: ");
        student.setSurname(inp.nextLine());
        System.out.println("Öğrencinin numarası: ");
        student.setStudentNumber(inp.nextInt());
        inp.nextLine();
        System.out.println("Öğrencinin bölümü: ");
        student.setDepartment(inp.nextLine());

        List<Course> studentCourses=new ArrayList<>();
        Long courseId;
        do {
            courseService.getAll();
            System.out.println("Öğrencinin almak istediği dersin id sini listeden seçiniz: \nÇıkış için 0 giriniz!");
            courseId=inp.nextLong();inp.nextLine();
            Course course=courseService.findCourseById(courseId);
            studentCourses.add(course);

        }while (courseId!=0);
        student.setCourseList(studentCourses);


        return student;
    }

    @Override
    public void add(Student obj) {

        course.getStudentList().add(obj);

        repo.save(obj);


    }

    @Override
    public void remove(Student obj) {
        repo.remove(obj);
    }

    @Override
    public void getAll() {

        repo.getAll();
    }

    public Student findStudentById(Long id){
        return repo.getById(id);

    }
    public Long findStudentId(){
        Scanner inp = new Scanner(System.in);
        System.out.println("*********Öğrenciler**************");
        getAll();
        System.out.println("******************************");
        System.out.println("Silmek istediğiniz öğrencinin id bilgisini listeden seçip giriniz: ");
        Long studentId=inp.nextLong();
        inp.nextLine();
        return studentId;
    }


}
