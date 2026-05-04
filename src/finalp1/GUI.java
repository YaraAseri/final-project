package finalp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Parking Spot Booking System");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color: #d0e8ff; -fx-padding: 20;");

        Label title = new Label("Parking Spot Booking System");
        title.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        grid.add(title, 0, 0, 2, 1);

        Label lblSpot = new Label("Spot Number:");
        TextField tfSpot = new TextField();
        grid.add(lblSpot, 0, 1);
        grid.add(tfSpot,  1, 1);

        Label lblFloor = new Label("Floor Number:");
        TextField tfFloor = new TextField();
        grid.add(lblFloor, 0, 2);
        grid.add(tfFloor,  1, 2);

        Label lblSection = new Label("Section:");
        TextField tfSection = new TextField();
        grid.add(lblSection, 0, 3);
        grid.add(tfSection,  1, 3);

        Label lblAvail = new Label("Available (true/false):");
        TextField tfAvail = new TextField();
        grid.add(lblAvail, 0, 4);
        grid.add(tfAvail,  1, 4);

        Label lblCovered = new Label("Covered (true/false):");
        TextField tfCovered = new TextField();
        grid.add(lblCovered, 0, 5);
        grid.add(tfCovered,  1, 5);

        Button btnAdd  = new Button("Add Regular Spot");
        Button btnShow = new Button("Show All Spots");
        grid.add(btnAdd,  0, 6);
        grid.add(btnShow, 1, 6);

        TextArea taOutput = new TextArea();
        taOutput.setEditable(false);
        taOutput.setPrefRowCount(8);
        grid.add(taOutput, 0, 7, 2, 1);

        btnAdd.setOnAction(e -> {
            try {
                int     spotNum  = Integer.parseInt(tfSpot.getText().trim());
                int     floorNum = Integer.parseInt(tfFloor.getText().trim());
                String  section  = tfSection.getText().trim();
                boolean avail    = Boolean.parseBoolean(tfAvail.getText().trim());
                boolean covered  = Boolean.parseBoolean(tfCovered.getText().trim());
                RegularSpot spot = new RegularSpot(spotNum, floorNum, section, avail, covered);
                Main.system.addSpot(spot);
                taOutput.setText("Spot added successfully:\n" + spot.toString());
            } catch (Exception ex) {
                taOutput.setText("Error: " + ex.getMessage());
            }
        });

        btnShow.setOnAction(e -> {
            if (Main.system.getSpots().size() == 0) {
                taOutput.setText("No spots registered.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < Main.system.getSpots().size(); i++) {
                    sb.append(Main.system.getSpots().get(i).toString());
                    sb.append("\n------------------\n");
                }
                taOutput.setText(sb.toString());
            }
        });

        Scene scene = new Scene(grid, 400, 520);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
