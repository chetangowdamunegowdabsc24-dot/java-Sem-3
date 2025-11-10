import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.collections.*;

public class StudentForm extends Application {

    private ObservableList<Student> studentList;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🎓 Student Record System");

        // Labels and Input Fields
        Label lblId = new Label("Student ID:");
        TextField txtId = new TextField();
        txtId.setPromptText("Enter ID");

        Label lblName = new Label("Student Name:");
        TextField txtName = new TextField();
        txtName.setPromptText("Enter Name");

        Label lblCourse = new Label("Course:");
        TextField txtCourse = new TextField();
        txtCourse.setPromptText("Enter Course");

        // Buttons
        Button btnAdd = new Button("Add Student");
        Button btnClear = new Button("Clear");

        // ListView to display students
        studentList = FXCollections.observableArrayList();
        ListView<Student> listView = new ListView<>(studentList);
        listView.setPrefHeight(180);

        // Event Handling
        btnAdd.setOnAction(e -> {
            String id = txtId.getText().trim();
            String name = txtName.getText().trim();
            String course = txtCourse.getText().trim();

            if (id.isEmpty() || name.isEmpty() || course.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill all fields.");
            } else {
                Student s = new Student(id, name, course);
                studentList.add(s);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student added successfully!");
                txtId.clear();
                txtName.clear();
                txtCourse.clear();
            }
        });

        btnClear.setOnAction(e -> {
            txtId.clear();
            txtName.clear();
            txtCourse.clear();
            listView.getItems().clear();
        });

        // Layout
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(20));
        formGrid.add(lblId, 0, 0);
        formGrid.add(txtId, 1, 0);
        formGrid.add(lblName, 0, 1);
        formGrid.add(txtName, 1, 1);
        formGrid.add(lblCourse, 0, 2);
        formGrid.add(txtCourse, 1, 2);
        formGrid.add(btnAdd, 0, 3);
        formGrid.add(btnClear, 1, 3);

        VBox layout = new VBox(15, formGrid, new Label("Student Records:"), listView);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method for alerts
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}