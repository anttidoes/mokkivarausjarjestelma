package src.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private void handleCottages(ActionEvent event) throws IOException {
        App.setRoot("CottageView");
    }

    @FXML
    private void handleBilling(ActionEvent event) throws IOException {
        App.setRoot("BillingView");
    }

    @FXML
    private void handleCustomers(ActionEvent event) throws IOException {
        App.setRoot("CustomerView");
    }

    @FXML
    private void handleServices(ActionEvent event) throws IOException {
        App.setRoot("ServiceView");
    }

    @FXML
    private void handleReservations(ActionEvent event) throws IOException {
        App.setRoot("ReservationView");
    }

    @FXML
    private void handleRegions(ActionEvent event) throws IOException {
        App.setRoot("RegionView");
    }
}
