module edu.farmingdale.csc311_mod3_assignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.smartcardio;
    requires java.scripting;


    opens edu.farmingdale.csc311_mod3_assignment to javafx.fxml;
    exports edu.farmingdale.csc311_mod3_assignment;
}