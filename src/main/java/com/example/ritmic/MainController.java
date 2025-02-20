package com.example.ritmic;

import com.example.ritmic.GUI.HelpController;
import com.example.ritmic.GUI.SelectController;
import com.example.ritmic.GUI.TotalController;
import com.example.ritmic.database.SelectQueries;
import com.example.ritmic.model.Data;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class MainController {
    @FXML
    private TextField AddDay;
    @FXML
    private Button ChangeRButton;
    @FXML
    private TextArea DateChange;
    @FXML
    private Button MonthButton;
    @FXML
    private TextField SeeMonth;
    @FXML
    private Button DataButton;
    @FXML
    private TextField SeeDate;
    @FXML
    private Button DayButton;
    @FXML
    private TextField SeeDay;
    @FXML
    private TextField SeeTotalDate;
    @FXML
    private Button HelpButton;
    @FXML
    private Label Feedback;

    private SelectQueries sq = new SelectQueries();

    public void initialize()
    {

    }

    @FXML
    private void CreateRealizedDate() throws SQLException {
        String name = AddDay.getText();
        LocalDate cD = LocalDate.now();
        if(name.isEmpty())
            name = cD.toString();
        int r = sq.AddReserved(name);
        System.out.println(r);
        if(r == 1)
        {
            Feedback.setText("Command executed!");
        }
        else{
            Feedback.setText("The date was already added");
        }
    }

    @FXML
    private void ChangeRealizedDate()
    {
        Feedback.setText("Not yet implemented ChangeRealizedDate");
    }

    @FXML
    private void ChangeExpected()
    {
        Feedback.setText("Not yet implemented ChangeExpected");
    }

    @FXML
    private void SeeDateTotal(){
        String name = SeeTotalDate.getText();
        ResultSet rows = sq.getTotal(name);
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("total.fxml"));
            Parent root = loader.load();
            TotalController controller =  loader.getController();
            controller.setDate(name);
            controller.setRows(rows);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Total");
            stage.show();
        } catch (IOException e) {
            Feedback.setText(e.toString());
        }

    }

    @FXML
    private void SeeMonthTotal()
    {
        String name = SeeMonth.getText();
        String date ="";
        if(name.isEmpty())
        {
            date = date + LocalDate.now().getYear()+"-"+String.format("%02d",LocalDate.now().getMonthValue())+"-01" + " " + LocalDate.now();
        }
        else{
            date = name + "-01 " + name + "-" +YearMonth.parse(name).lengthOfMonth();
        }
        ResultSet rows = sq.getTotal(date);
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("total.fxml"));
            Parent root = loader.load();
            TotalController controller =  loader.getController();
            controller.setDate(name);
            controller.setRows(rows);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Total");
            stage.show();
        } catch (IOException e) {
            Feedback.setText(e.toString());
        }
    }

    @FXML
    private void SeeWorkRealised()
    {
        String name = SeeDate.getText();
        List<Data> l = sq.RealisedDay(name);
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("select.fxml"));
            Parent root = loader.load();
            SelectController controler = loader.getController();
            controler.getResultSet(l);
            controler.setType(1);
            controler.setDate(name);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            if(name.isBlank())
                stage.setTitle("View today");
            else
                stage.setTitle("View " + name);
            stage.show();
        } catch (IOException e) {
            Feedback.setText(e.toString());
        }

    }

    @FXML
    private void SeeExpected()
    {


        String name = SeeDay.getText();
        List<Data> l = sq.ExpectedDay(name);
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("select.fxml"));
            Parent root = loader.load();
            SelectController controler = loader.getController();
            controler.getResultSet(l);
            controler.setType(2);
            controler.setDay(name);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("View " + name);
            stage.show();
        } catch (IOException e) {
            Feedback.setText(e.toString());
        }
    }

    @FXML
    private void GetHelp()
    {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("help.fxml"));
            Parent root = loader.load();

            HelpController controler = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Help");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/help.png")));
            stage.show();
        } catch (IOException e) {
            Feedback.setText(e.toString());
        }


    }


}