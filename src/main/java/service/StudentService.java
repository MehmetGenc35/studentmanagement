package service;

import domain.Student;

import java.util.Scanner;

public class StudentService implements Service<Student> {
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
                    //TODO:öğrenci ekleme metodu?
                    break;
                case 2:
                    //TODO:öğrenci silme;
                    break;
                case 3:
                    //TODO:öğrencileri listele
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
    public void add(Student obj) {

    }

    @Override
    public void remove(Student obj) {

    }

    @Override
    public void getAll() {

    }

    public Student getStudentByNumber(int studentNumber){


        return null;
    }
}
