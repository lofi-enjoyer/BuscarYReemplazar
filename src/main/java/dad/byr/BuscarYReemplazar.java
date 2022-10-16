package dad.byr;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class BuscarYReemplazar extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox();

        String[] btnStrings = {
                "Buscar",
                "Reemplazar",
                "Reemplazar todo",
                "Cerrar",
                "Ayuda"
        };

        VBox rightPane = new VBox();
        rightPane.setSpacing(5);
        for (String btnText : btnStrings) {
            Button btn = new Button(btnText);
            btn.setMaxWidth(Double.MAX_VALUE);
            rightPane.getChildren().add(btn);
        }
        rightPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setMinWidth(200);

        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(5));
        leftPane.setHgap(5);
        leftPane.setVgap(5);
        leftPane.setGridLinesVisible(false);

        leftPane.addRow(0, new Label("Buscar:"), new TextArea());
        leftPane.addRow(1, new Label("Reemplazar:"), new TextArea());

        GridPane optionsPane = new GridPane();
        optionsPane.addRow(0, new CheckBox("Mayúsculas y minúsculas"), new CheckBox("Buscar hacia atrás"));
        optionsPane.addRow(1, new CheckBox("Expresión regular"), new CheckBox("Resaltar resultados"));

        leftPane.addRow(2, new Label(""), optionsPane);

        ColumnConstraints[] cols = {
                new ColumnConstraints(),
                new ColumnConstraints(),
                new ColumnConstraints()
        };
        leftPane.getColumnConstraints().setAll(cols);

        RowConstraints[] rows = new RowConstraints[8];
        for (int i = 0; i < 8; i++) {
            rows[i] = new RowConstraints();
            rows[i].setPrefHeight(30);
        }
        leftPane.getRowConstraints().setAll(rows);

        root.getChildren().add(leftPane);
        root.getChildren().add(rightPane);
        HBox.setHgrow(rightPane, Priority.ALWAYS);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}