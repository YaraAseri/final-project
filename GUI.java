package reenad1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, null, null)));
        Label title = new Label("                --- Bakery Site  System ---");
        title.setFont(Font.font(20));
        grid.add(title, 0, 0, 2, 1);
        title.setTextFill(Color.PURPLE);

        Label nameLabel = new Label("Dessert Name:");
        TextField nameField = new TextField();
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        nameLabel.setTextFill(Color.PURPLE);

        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField();
        grid.add(priceLabel, 0, 2);
        grid.add(priceField, 1, 2);
        priceLabel.setTextFill(Color.PURPLE);

        Label sugarLabel = new Label("Sugar-Free (yes/no):");
        TextField sugarField = new TextField();
        grid.add(sugarLabel, 0, 3);
        grid.add(sugarField, 1, 3);
        sugarLabel.setTextFill(Color.PURPLE);

        Button addButton = new Button("Add Dessert");
        Button showButton = new Button("Show All Desserts");
        grid.add(addButton, 0, 4);
        grid.add(showButton, 1, 4);
        showButton.setStyle("-fx-background-color: #E6E6FA; -fx-text-fill: black; -fx-padding: 8px 15px;");
        addButton.setStyle("-fx-background-color: #E6E6FA; -fx-text-fill: black; -fx-padding: 8px 15px;");

        TextArea outputArea = new TextArea();
        outputArea.setWrapText(true);
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);
        grid.add(outputArea, 0, 5, 2, 1);

        addButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                boolean isSugarFree = sugarField.getText().trim().equalsIgnoreCase("yes");

                Desserts dessert = new Desserts(isSugarFree, name, price);
                Main.menuItems.add(dessert);
                System.out.println("Dessert added");

            } catch (Exception ex) {
                outputArea.setText("Error: Please enter valid values.");
            }
        });

        showButton.setOnAction(e -> {
            String s = "";
            for (MenuItem d : Main.menuItems) {
                if (d instanceof Desserts) {
                    s += d + "\n------------------\n";
                }

            }
            outputArea.setText(s.toString());
        });

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Desserts ");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
