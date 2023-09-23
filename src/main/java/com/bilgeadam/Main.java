package com.bilgeadam;

import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.DatabaseConnection;
//TODO ctrl+d klon yapiyor.
public class Main {
    public static void main(String[] args) {
        FutbolcuRepository futbolcuRepository = new FutbolcuRepository();
        Futbolcu futbolcu = new Futbolcu("Alperen","Orta Saha", 10,1L);
        futbolcuRepository.save(futbolcu);
    }
}