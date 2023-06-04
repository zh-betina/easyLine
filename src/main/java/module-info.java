module com.easyline {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.easyline to javafx.fxml;
    exports com.easyline;
}
