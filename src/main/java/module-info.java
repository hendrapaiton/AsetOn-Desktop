module AsetOn {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires gson;
    requires okhttp3;
    requires okhttp3.logging;
    requires retrofit2;
    requires retrofit2.converter.gson;
    opens id.web.hikmasoft.aseton.desktop to javafx.fxml;
    opens id.web.hikmasoft.aseton.desktop.Model to gson;
    exports id.web.hikmasoft.aseton.desktop;
    exports id.web.hikmasoft.aseton.desktop.Model;
}
