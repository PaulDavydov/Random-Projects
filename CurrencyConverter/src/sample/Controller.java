package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller {
    // List of currencies used
    ObservableList<String> currencyList = FXCollections.observableArrayList("USD", "CAD", "EUR","GBP","YEN","CHF");

    // Values I will be using to store certain values
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal converted = BigDecimal.ZERO;

    // Components from my converter.fxml file. Grabs them by id designated for them
    @FXML
    private ChoiceBox choiceFROM;
    @FXML
    private ChoiceBox choiceTO;
    @FXML
    private TextField enterAmount;
    @FXML
    private TextField convertedAmount;
    @FXML
    private Button convertButton;

    // Grabs the currencyList and puts the values into the two Choiceboxes, choiceFROM and choiceTO
    @FXML
    private void loadData() {
        choiceFROM.setItems(currencyList);
        choiceTO.setItems(currencyList);
    }

    // initiates the load data method and defines what happens when the convertButton is pressed
    @FXML
    private void initialize() {
        loadData();
        convertButton.setOnAction(event -> {
            final String choiceFROMText = choiceFROM.getValue().toString(); // Grabs currency from choicebox
            final String choiceTOText = choiceTO.getValue().toString(); // Same as above
            amount = new BigDecimal(enterAmount.getText()); // Amount entered on TextField
            converted = conversion(amount,choiceFROMText,choiceTOText);
            converted = converted.setScale(2, RoundingMode.CEILING); // Sets converted amount to two Decimal places
            convertedAmount.setText(converted.toString()); // Displays converted text on second textfield

        });

    }
    // HashMap that contains info to convert from X currency to USD. Returns amount in USD
    private static BigDecimal toUSD (String currency) {
        BigDecimal eurUSD = new BigDecimal(1.18);
        BigDecimal cadUSD = new BigDecimal(0.80);
        BigDecimal gbpUSD = new BigDecimal(1.38);
        BigDecimal yenUSD = new BigDecimal(0.0090);
        BigDecimal chfUSD = new BigDecimal(1.06);
        BigDecimal usdUSD = new BigDecimal(1.00);

        HashMap<String, BigDecimal> map_To_USD = new HashMap<>();
        map_To_USD.put("EUR",eurUSD);
        map_To_USD.put("CAD",cadUSD);
        map_To_USD.put("GBP",gbpUSD);
        map_To_USD.put("YEN",yenUSD);
        map_To_USD.put("CHF",chfUSD);
        map_To_USD.put("USD",usdUSD);

        return map_To_USD.get(currency);
    }
    // HashMap that contains info to convert from USD to X currency. Returns amount in specified currency
    private static BigDecimal fromUSD (String currency) {
        BigDecimal eurUSD = new BigDecimal(0.85);
        BigDecimal cadUSD = new BigDecimal(1.26);
        BigDecimal gbpUSD = new BigDecimal(0.72);
        BigDecimal yenUSD = new BigDecimal(110.71);
        BigDecimal chfUSD = new BigDecimal(0.94);
        BigDecimal usdUSD = new BigDecimal(1.00);

        HashMap<String, BigDecimal> map_From_USD = new HashMap<>();
        map_From_USD.put("EUR", eurUSD);
        map_From_USD.put("CAD", cadUSD);
        map_From_USD.put("GBP", gbpUSD);
        map_From_USD.put("YEN", yenUSD);
        map_From_USD.put("CHF", chfUSD);
        map_From_USD.put("USD", usdUSD);

        return map_From_USD.get(currency);
    }
    // Does the conversion calculation
    private static BigDecimal conversion (BigDecimal amount,String fromCurrency, String toCurrency) {
        BigDecimal usd = amount.multiply(toUSD(fromCurrency));

        return usd.multiply(fromUSD(toCurrency));

    }

}
