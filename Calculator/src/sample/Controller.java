package sample;

import java.math.BigDecimal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    private BigDecimal left = BigDecimal.ZERO;
    private BigDecimal right = BigDecimal.ZERO;
    private BigDecimal answer = BigDecimal.ZERO;
    private String buttonOperator = "";

    public Controller() {

    }

    @FXML private TextField textField;
    private Map<Button, String> buttonMap = new HashMap<>();

    @FXML
    public void initialize() {

    }

    @FXML
    private void buttonInitializer (ActionEvent event) {
        Button button = (Button)event.getSource();
        final String buttonText = button.getText();
        if(buttonText.matches("[0-9]")) {
            textField.appendText(buttonText);
        }
        if(buttonText.matches("[a|s|m|d]")) {
            left = new BigDecimal(textField.getText());
            buttonOperator = buttonText;
            textField.clear();
        }
        if(buttonText.equals("=")) {
            right = new BigDecimal(textField.getText());
            answer=calculate(buttonOperator,left,right);
            textField.setText(answer.toString());
        }
    }

    static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right) {
        switch(operator) {
            case ("a"):
                return left.add(right);
            case("s"):
                return left.subtract(right);
            case("m"):
                return left.multiply(right);
            case("d"):
                return left.divide(right);
            default:
        }
        return right;
    }




}
