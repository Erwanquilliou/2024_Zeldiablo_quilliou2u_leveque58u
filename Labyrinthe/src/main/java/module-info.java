module org.example.labyrinthe {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.labyrinthe to javafx.fxml;
    exports org.example.labyrinthe;
}