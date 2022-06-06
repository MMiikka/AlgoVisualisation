module fi.mmiikka.algovisualisation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens fi.mmiikka.algovisualisation to javafx.fxml;
    exports fi.mmiikka.algovisualisation;
}