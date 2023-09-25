package com.bilgeadam;

import com.bilgeadam.controller.FutbolcuController;
import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.DatabaseConnection;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//TODO ctrl+d klon yapiyor.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    FutbolcuController futbolcuController;

    public Main(){
        this.futbolcuController = new FutbolcuController();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
//        FutbolcuRepository futbolcuRepository = new FutbolcuRepository();
//        Futbolcu futbolcu = new Futbolcu("Alperen","Orta Saha", 10,1L);
//        futbolcuRepository.save(futbolcu);

//        Futbolcu futbolcu1 = new Futbolcu("Muhammet","Forvet",9,15000L,3L);
//        futbolcu1.setId(2L);
//        futbolcuRepository.update(futbolcu1);

//        Optional<Futbolcu> futbolcu = futbolcuRepository.findById(6L);
//        if(futbolcu.isPresent()){
//            System.out.println(futbolcu);
//        } else {
//            System.out.println("Boyle bir futbolcu bulunamadi...");
//        }
//        List<Futbolcu> futbolcular = futbolcuRepository.findAll();
//        futbolcular.forEach(System.out::println);
//        futbolcuRepository.delete(3L);
//        List<Futbolcu> futbolcular1 = futbolcuRepository.findAll();
//        futbolcular1.forEach(System.out::println);

    }
    
    
    public void menu(){
        
        int input = 0;

        do{
            System.out.println("1 - Futbolcu Olustur");
            System.out.println("2 - Futbolcu Duzenle");
            System.out.println("3 - Futbolcu Sil");
            System.out.println("4 - Futbolcu Bul");
            System.out.println("5 - Futbolculari Getir");
            System.out.println("0 - Cikis");
            System.out.print("Lutfen bir secim yapiniz : ");
            input = Integer.parseInt(scanner.nextLine());
            
            switch (input){
                case 1:
                    futbolcuOlustur();
                    break;
                case 2:
                    futbolcuDuzenle();
                    break;
                case 3:
                    futbolcuSil();
                    break;
                case 4:
                    futbolcuBul();
                    break;
                case 5:
                    futbolculariGetir();
                    break;
                case 0:
                    System.out.println("Cikis yapiliyor...");
                    break;
            }
        } while (input!=0);
      
        
    }

    private void futbolculariGetir() {
        System.out.println("### FUTBOLCU LISTESI ###");
        futbolcuController.findAll().forEach(System.out::println);

    }

    private void futbolcuBul() {
        System.out.print("Lutfen bir futbolcu id'si giriniz : ");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println(futbolcuController.findById(id));
    }

    private void futbolcuSil() {
        System.out.print("Lutfen sil istediginiz futbolcunun id'sini giriniz :");
        Long id = Long.parseLong(scanner.nextLine());
        futbolcuController.delete(id);
    }

    private void futbolcuDuzenle() {
        System.out.print("Lutfen bir isim giriniz : ");
        String isim = scanner.nextLine();
        System.out.print("Lutfen bir mevki giriniz : ");
        String mevki = scanner.nextLine();
        System.out.print("Lutfen bir forma no giriniz : ");
        int formaNo = Integer.parseInt(scanner.nextLine());
        System.out.print("Lutfen bir piyasa degeri giriniz : ");
        Long deger = Long.parseLong(scanner.nextLine());
        System.out.print("Lutfen bir takim id giriniz : ");
        Long takimId = Long.parseLong(scanner.nextLine());
        System.out.print("Lutfen guncellemek istediginiz futbolcunun id'sini giriniz : ");
        Long id = Long.parseLong(scanner.nextLine());
        Futbolcu futbolcu = new Futbolcu(id,isim,mevki,formaNo,deger,takimId);
        futbolcuController.update(futbolcu);
    }

    //Long id, String isim, String mevki, int formaNo, Long deger, Long takimId
    private void futbolcuOlustur() {
        System.out.print("Lutfen bir isim giriniz : ");
        String isim = scanner.nextLine();
        System.out.print("Lutfen bir mevki giriniz : ");
        String mevki = scanner.nextLine();
        System.out.print("Lutfen bir forma no giriniz : ");
        int formaNo = Integer.parseInt(scanner.nextLine());
        System.out.print("Lutfen bir piyasa degeri giriniz : ");
        Long deger = Long.parseLong(scanner.nextLine());
        System.out.print("Lutfen bir takim id giriniz : ");
        Long takimId = Long.parseLong(scanner.nextLine());
        Futbolcu futbolcu = new Futbolcu(isim,mevki,formaNo,deger,takimId);
        futbolcuController.save(futbolcu);
    }
}