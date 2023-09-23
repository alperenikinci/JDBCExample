package com.bilgeadam.utility;

import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ConnectionProvider {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean openConnection(){

        try {
            //ctrl + numpaddeki "/"
//            Driver.class.forName("org.postgresql.Driver");
            DatabaseConnection.getConnection();
            System.out.println(DatabaseConnection.dbName + " veritabanina basariyla baglanildi...");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeConnection(){
        try {
            if(!DatabaseConnection.getConnection().isClosed()){
                DatabaseConnection.getConnection().close();
                System.out.println("Baglanti sonlandirildi...");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public PreparedStatement getPreparedStatement(String sql){
        if(openConnection()){
            try {
                preparedStatement=DatabaseConnection.getConnection().prepareStatement(sql);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                closeConnection();
                throw new RuntimeException(e);
            }
        }
        return preparedStatement;
    }

    public Optional<ResultSet> getData(String sql){
            if(openConnection()){
                try {
                    preparedStatement=DatabaseConnection.getConnection().prepareStatement(sql);
                    resultSet = preparedStatement.executeQuery();
                    closeConnection();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    closeConnection();
                    throw new RuntimeException(e);
                }
            }
            return Optional.ofNullable(resultSet); //Optional.empty
    }

}
