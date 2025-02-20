package com.example.ritmic.database;

import com.example.ritmic.model.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateQueries {
    private DatabaseConnection dc = new DatabaseConnection();
    private Connection conn;
    public updateQueries()
    {
        try{
            conn = dc.connect();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateReservedinSQL(Data rowData, String columnName, int newValue, String date){
        String sql = "UPDATE Realizat SET " + columnName + " = ? WHERE data_realizare = ? AND LocID = (Select LocID FROM Loc Where Strada = ?)";
        System.out.println(date);
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1,newValue);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setString(3, rowData.getDenumire());

            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateExpectedinSQL(Data rowData, String columnName, int newValue, String day){
        String sql = "UPDATE ExpectedData SET " + columnName + " = ? WHERE Zi = ? AND LocID = (Select LocID FROM Loc Where Strada = ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1,newValue);
            stmt.setString(2, day);
            stmt.setString(3, rowData.getDenumire());

            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
