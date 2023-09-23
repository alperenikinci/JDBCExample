package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;

import java.sql.PreparedStatement;
import java.util.List;

public class FutbolcuRepository implements ICrud<Futbolcu>{

    private String sql="";
    private ConnectionProvider connectionProvider;

    private PreparedStatement preparedStatement;

    public FutbolcuRepository() {
        this.connectionProvider = new ConnectionProvider();
    }

    @Override
    public void save(Futbolcu futbolcu) {
        sql = "INSERT INTO futbolcular(isim,mevki,forma_no,takim_id) VALUES(?,?,?,?)";
        try {
           preparedStatement = connectionProvider.getPreparedStatement(sql);
           preparedStatement.setString(1, futbolcu.getIsim());
           preparedStatement.setString(2, futbolcu.getMevki());
           preparedStatement.setInt(3,futbolcu.getFormaNo());
           preparedStatement.setLong(4,futbolcu.getTakimId());
           preparedStatement.executeUpdate();
           connectionProvider.closeConnection();

       } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Futbolcu futbolcu) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Futbolcu> findAll() {
        return null;
    }

    @Override
    public Futbolcu findById(Long id) {
        return null;
    }
}
