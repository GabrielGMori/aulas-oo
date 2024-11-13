module com.alunos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.alunos to javafx.fxml;
    exports com.alunos;
}
