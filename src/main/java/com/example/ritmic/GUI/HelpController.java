package com.example.ritmic.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelpController {
    @FXML
    private TextArea HelpText;

    public void initialize()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("For add for a day if left empty it will automatically do the current day,\notherwise it needs to be specified as dd-mm-yyyy\n\n");
        sb.append("For change realized on the first line the date should be specified,\nif it's not it will also do on the current date,\ngiving an error if there" +
                "is no such date,\nsame going if the inserted data is wrong,\nthe error will be told in the Feedback label\n\n");
        sb.append("For change expected on the first line a day is required: e.g. luni, marti, etc;\nAfterwards all the columns should be put one under another" +
                "\nIf the combination of Street and Category doesn't exist,\nit is added to the expected table\n\n\n");
        sb.append("Contact: Malos Alexandru-Razvan\nmalosalexandru2004@gmail.com\n");
        HelpText.setText(sb.toString());

    }
}
