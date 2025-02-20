package com.example.ritmic.GUI;

import com.example.ritmic.database.SelectQueries;
import com.example.ritmic.database.updateQueries;
import com.example.ritmic.model.Data;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.time.LocalDate;
import java.util.List;

public class SelectController {
    private List<Data> listRes;
    @FXML
    private TableView<Data> tbl;
    @FXML
    private TableColumn<Data, String> c1;
    @FXML
    private TableColumn<Data, String> c2;
    @FXML
    private TableColumn<Data, String> c3;
    @FXML
    private TableColumn<Data, String> c4;
    @FXML
    private TableColumn<Data, String> c5;
    @FXML
    private TableColumn<Data, Integer> c6;
    @FXML
    private TableColumn<Data, Integer> c7;
    @FXML
    private TableColumn<Data, Integer> c8;
    @FXML
    private TableColumn<Data, Integer> c9;
    @FXML
    private TableColumn<Data, Integer> c10;
    @FXML
    private TableColumn<Data, Integer> c11;
    @FXML
    private TableColumn<Data, Integer> c12;
    @FXML
    private TableColumn<Data, Integer> c13;
    @FXML
    private TableColumn<Data, Integer> c14;
    @FXML
    private TableColumn<Data, Integer> c15;
    @FXML
    private TableColumn<Data, Integer> c16;
    private int type = -1;
    private updateQueries u = new updateQueries();
    String date;
    String day;

    @FXML
    public void initialize()
    {
        tbl.setEditable(true);
        c1.setCellFactory(TextFieldTableCell.forTableColumn());
        c2.setCellFactory(TextFieldTableCell.forTableColumn());
        c3.setCellFactory(TextFieldTableCell.forTableColumn());
        c4.setCellFactory(TextFieldTableCell.forTableColumn());
        c5.setCellFactory(TextFieldTableCell.forTableColumn());
        c6.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c7.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c8.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c9.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c10.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c11.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c12.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c13.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c14.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c15.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        c16.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    public void getResultSet(List<Data> l)
    {
        tbl.getItems().clear();
        listRes = l;
        FillTable();
    }

    public void setType(int t)
    {
        type = t; // if 1 its expected values table, if 2 its realised
    }

    public void setDay(String d)
    {
        day=d;
    }

    public void setDate(String d)
    {
        if(d.isEmpty())
            date = LocalDate.now().toString();
        else
            date = d;
        System.out.println(date);
    }

    public void FillTable()
    {
        tbl.setItems(FXCollections.observableArrayList(listRes));
        c1.setCellValueFactory(cellData -> cellData.getValue().opProperty());
        c2.setCellValueFactory(cellData -> cellData.getValue().cartierProperty());
        c3.setCellValueFactory(cellData -> cellData.getValue().denumireProperty());
        c4.setCellValueFactory(cellData -> cellData.getValue().tipProperty());
        c5.setCellValueFactory(cellData -> cellData.getValue().categProperty());
        c6.setCellValueFactory(cellData -> cellData.getValue().matMecCarProperty().asObject());
        c7.setCellValueFactory(cellData -> cellData.getValue().matMecTrotProperty().asObject());
        c8.setCellValueFactory(cellData -> cellData.getValue().matManCarProperty().asObject());
        c9.setCellValueFactory(cellData -> cellData.getValue().matManTrotProperty().asObject());
        c10.setCellValueFactory(cellData -> cellData.getValue().intrCarProperty().asObject());
        c11.setCellValueFactory(cellData -> cellData.getValue().intrTrotProperty().asObject());
        c12.setCellValueFactory(cellData -> cellData.getValue().razuitRigProperty().asObject());
        c13.setCellValueFactory(cellData -> cellData.getValue().stropCarProperty().asObject());
        c14.setCellValueFactory(cellData -> cellData.getValue().stroTotProperty().asObject());
        c15.setCellValueFactory(cellData -> cellData.getValue().spalatCarProperty().asObject());
        c16.setCellValueFactory(cellData -> cellData.getValue().spalatTrotProperty().asObject());
        c6.setStyle("-fx-alignment: CENTER-RIGHT");
        c7.setStyle("-fx-alignment: CENTER-RIGHT");
        c8.setStyle("-fx-alignment: CENTER-RIGHT");
        c9.setStyle("-fx-alignment: CENTER-RIGHT");
        c10.setStyle("-fx-alignment: CENTER-RIGHT");
        c11.setStyle("-fx-alignment: CENTER-RIGHT");
        c12.setStyle("-fx-alignment: CENTER-RIGHT");
        c13.setStyle("-fx-alignment: CENTER-RIGHT");
        c14.setStyle("-fx-alignment: CENTER-RIGHT");
        c15.setStyle("-fx-alignment: CENTER-RIGHT");
        c16.setStyle("-fx-alignment: CENTER-RIGHT");
    }

    public void updateDatabase(CellEditEvent<Data, Integer> event) {
        Integer newValue = event.getNewValue();
        String columnName = event.getTableColumn().getText();
        Data rowData = event.getRowValue();

        if (type == 1)
            u.updateReservedinSQL(rowData, columnName, newValue, date);
        if (type == 2)
            u.updateExpectedinSQL(rowData, columnName, newValue, day);

        // Refresh the table after updating the database
        refreshTable();
    }

    private void refreshTable() {
        List<Data> updatedList = (type == 1) ? new SelectQueries().RealisedDay(date)
                : new SelectQueries().ExpectedDay(day);
        getResultSet(updatedList);
    }

}
