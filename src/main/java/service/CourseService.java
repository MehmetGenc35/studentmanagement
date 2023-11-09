package service;

import domain.Course;

import java.util.Scanner;

public class CourseService implements Service<Course> {
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
                    //TODO:kurs ekleme metodu?
                    break;
                case 2:
                    //TODO:kurs silme;
                    break;
                case 3:
                    //TODO:Kursları listele
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



    @Override
    public void add(Course obj) {

    }

    @Override
    public void remove(Course obj) {

    }

    @Override
    public void getAll() {

    }

    public Course getCourseByCode(String courseCode){


        return null;
    }
}
