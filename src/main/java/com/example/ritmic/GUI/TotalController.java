package com.example.ritmic.GUI;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.*;

public class TotalController {
    @FXML
    private TableView<Map<String, Object>> TotalTable;
    @FXML
    private TableColumn<Map<String, Object>, String> c1;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c2;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c3;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c4;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c5;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c6;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c7;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c8;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c9;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c10;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c11;
    @FXML
    private TableColumn<Map<String, Object>, Integer> c12;


    private String date;
    private String[][] array;

    @FXML
    public void initialize()
    {
        NumberFormat nf =NumberFormat.getInstance(Locale.US);
        c1.setCellValueFactory(cellData ->
                new SimpleStringProperty((String) cellData.getValue().get("c1"))
        );
        c2.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c2")).asObject()
        );
        c3.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c3")).asObject()
        );
        c4.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c4")).asObject()
        );
        c5.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c5")).asObject()
        );
        c6.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c6")).asObject()
        );
        c7.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c7")).asObject()
        );
        c8.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c8")).asObject()
        );
        c9.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c9")).asObject()
        );
        c10.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c10")).asObject()
        );
        c11.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c11")).asObject()
        );
        c12.setCellValueFactory(cellData ->
                new SimpleIntegerProperty((Integer) cellData.getValue().get("c12")).asObject()
        );
        c2.setStyle("-fx-alignment: CENTER-RIGHT");
        c3.setStyle("-fx-alignment: CENTER-RIGHT");
        c4.setStyle("-fx-alignment: CENTER-RIGHT");
        c5.setStyle("-fx-alignment: CENTER-RIGHT");
        c6.setStyle("-fx-alignment: CENTER-RIGHT");
        c7.setStyle("-fx-alignment: CENTER-RIGHT");
        c8.setStyle("-fx-alignment: CENTER-RIGHT");
        c9.setStyle("-fx-alignment: CENTER-RIGHT");
        c10.setStyle("-fx-alignment: CENTER-RIGHT");
        c11.setStyle("-fx-alignment: CENTER-RIGHT");
        c12.setStyle("-fx-alignment: CENTER-RIGHT");


    }

    public void setDate(String name)
    {
        date = name;
    }

    public void setRows(ResultSet rs)
    {
        ObservableList<Map<String, Object>> data = FXCollections.observableArrayList();
        NumberFormat nf =NumberFormat.getInstance(Locale.US);
        array = new String[3][12];
        int y = 0;
        try {
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("c1", rs.getString(1));
                for(int i=2;i<=12;i++)
                {
                    row.put("c" + i, rs.getInt(i));
                }

                data.add(row);
                for(int j = 0;j < 12;j++)
                {
                    array[y][j] = row.get("c" + (j+1)).toString();
                }
                y+=1;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println(data.get(0).get("c1"));
        TotalTable.setItems(data);
    }

    public void MakeExcel()
    {
        String[] titles = {"", "Maturat mecanic carosabil (mp)", "Maturat mecanic trotuar (mp)", "Maturat manual carosabil (mp)",
        "Maturat manual trotuar (mp)", "Intretinere carosabil (mp)", "Intretinere trotuar (mp)", "Razuit rigola (mp)",
                "Stropit carosabil (mp)", "Stropit trotuar (mp)", "Spalat carosabil (mp)", "Spalat trotuar (mp)\n"};
        List<String> dates = new ArrayList<>(Arrays.asList(date.split(" ", 2)));
        String name = "Total_";
        //NumberFormat nf =NumberFormat.getInstance(Locale.of("ro", "RO"));
        NumberFormat nf =NumberFormat.getInstance(Locale.US);
        if(date.isEmpty())
        {
            name = name + LocalDate.now().toString() + ".pdf";
        }
        else if(dates.size() == 1)
            name = name + dates.get(0) + ".pdf";
        else
            name = name + dates.get(0) + "-" + dates.get(1) + ".pdf";
        try{
            PdfWriter writer = new PdfWriter(name);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc, PageSize.A4.rotate());

            Table table = new Table(12);
            for(String cell : titles) {
                String cellText = (cell == null) ? "" : cell; // Ensure no null values
                Cell c = new Cell().add(new Paragraph(cellText));
                table.addCell(c);
            }
            System.out.println(array.length);
            for (String[] row : array){
                int i = 0;
                for (String cell : row) {
                    String cellText = (cell == null) ? "" : cell; // Ensure no null values
                    if(i == 0)
                    {
                        Cell c = new Cell().add(new Paragraph(cellText));
                        i = 1;
                        c.setTextAlignment(TextAlignment.LEFT);
                        table.addCell(c);
                    }
                    else {
                        int nr = Integer.parseInt(cellText);
                        Cell c = new Cell().add(new Paragraph(nf.format(nr)));
                        c.setTextAlignment(TextAlignment.RIGHT);
                        table.addCell(c);
                    }
                }
            }
            document.add(table);
            document.close();
            openPDF(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void openPDF(String name){
        try{
            File file = new File(name);
            if(!file.exists()){
                System.out.println("File does not exist: " + name);
                return;
            }

            if (Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            }else{
                System.out.println("Desktop is not supported on this system");
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
