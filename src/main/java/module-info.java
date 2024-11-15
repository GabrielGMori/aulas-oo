module com.alunos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.alunos to javafx.fxml;
    opens com.alunos.controller to javafx.fxml;
    exports com.alunos;
}
