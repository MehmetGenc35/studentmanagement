package service;

import config.HibernateUtils;
import domain.Course;
import domain.Student;
import repository.CourseRepository;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseService implements Service<Course> {
    private Repository<Course> repo=new CourseRepository();
    private Student student=new Student();

    @Override
    public void showMenu() {
        Scanner inp = new Scanner(System.in);
        int select=-1;
        do {
            System.out.println("1-Ders Ekle\n2-Ders Sil\n3-Dersleri Listele\n0-Ana Menü");
            System.out.println("Lütfen bir seçim yapınız: ");
            select=inp.nextInt();inp.nextLine();

            switch (select){
                case 1:
                    add(informationCourse());
                    break;
                case 2:
                    Course course=findCourseById(findCourseId());
                    remove(course);
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
    public Course informationCourse(){
        Course course=new Course();
        Scanner inp = new Scanner(System.in);
        System.out.println("Ders adı: ");
        course.setCourseName(inp.nextLine());
        System.out.println("Bölüm: ");
        course.setDepartment(inp.nextLine());
        System.out.println("Kurs kodu: ");
        course.setCode(inp.nextLine());
        System.out.println("Kurs kredisi: ");
        course.setCourseCredit(inp.nextInt());
        inp.nextLine();



        return course;
    }



    @Override
    public void add(Course obj) {

        student.getCourseList().add(obj);
        repo.save(obj);
    }

    @Override
    public void remove(Course obj) {

        repo.remove(obj);
    }

    @Override
    public void getAll() {
        repo.getAll();

    }

    public Course findCourseById(Long id){
        return repo.getById(id);

    }


    public Long findCourseId(){
        Scanner inp = new Scanner(System.in);
        System.out.println("*********Dersler**************");
        getAll();
        System.out.println("******************************");
        System.out.println("Silmek istediğiniz dersin id bilgisini listeden seçip giriniz: ");
        Long courseId=inp.nextLong();
        inp.nextLine();
        return courseId;
    }

}
