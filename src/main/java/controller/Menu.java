package controller;

import service.CourseService;
import service.StudentService;

import java.util.Scanner;

public class Menu {
    static StudentService studentService=new StudentService();
    static CourseService courseService=new CourseService();


    public static void showMenu(){

        Scanner inp = new Scanner(System.in);
        int select=-1;
        do {
            System.out.println("1-Öğrenci Menü\n2-Kurs Menü\n0-Çıkış");
            System.out.println("Lütfen bir menü seçiniz: ");
            select=inp.nextInt();inp.nextLine();

            switch (select){
                case 1:
                    studentService.showMenu();
                    break;
                case 2:
                    courseService.showMenu();
                    break;
                case 0:
                    System.out.println("İyi günler...");
                    break;
                default:
                    System.out.println("Hatalı bir giriş yaptınız...");
                    break;
            }



        }while(select!=0);


    }


}
