package com.example.ritmic.database;

import com.example.ritmic.model.Data;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectQueries {
    private DatabaseConnection dc = new DatabaseConnection();
    private List<Data> l = new ArrayList<>();
    private Connection conn;
    public SelectQueries()
    {
        try{
            conn = dc.connect();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Data> ExpectedDay(String day)
    {
        String sql = "EXEC GetExpectedData1 ?";
        l.clear();
        try (
             CallableStatement stmt = conn.prepareCall(sql))
        {
            stmt.setString(1, day);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                //System.out.println(l);
                l.add(new Data(
                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
                        rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14),
                        rs.getInt(15), rs.getInt(16)
                ));
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return l;
    }

    public List<Data> RealisedDay(String date)
    {
        String sql = "EXEC GetRealisedData1 ?";
        l.clear();
        try (
                CallableStatement stmt = conn.prepareCall(sql))
        {
            if(date.isBlank())
                stmt.setString(1, LocalDate.now().toString());
            else
                stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                //System.out.println(l);
                l.add(new Data(
                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
                        rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14),
                        rs.getInt(15), rs.getInt(16)
                ));
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return l;
    }

    public int AddReserved(String date){
        int result = 0;
        String sql = "DECLARE @result INT; EXEC CreateRealized ?, @result OUTPUT; SELECT @result;";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = rs.getInt(1);  // Get the output value
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet getTotal(String name)
    {
        List<String> dates = new ArrayList<>(Arrays.asList(name.split(" ", 2)));
        if(name.isEmpty())
        {
            dates.remove(0);
            dates.add(LocalDate.now().toString());
            dates.add(LocalDate.now().toString());

        }
        else if(dates.size() == 1)
            dates.add(dates.get(0));
        System.out.println(dates.get(0) + "    " + dates.get(1));
        String sql = "EXEC DateTotal ?, ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dates.get(0));
            stmt.setString(2, dates.get(1));
            ResultSet rs = stmt.executeQuery();
            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
