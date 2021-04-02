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

    private BigDecimal left = BigDecimal.ZERO; // saved when pressing a operator
    private BigDecimal right = BigDecimal.ZERO;//saved after pressing equal
    private BigDecimal answer = BigDecimal.ZERO; // final result
    private String buttonOperator = ""; // will be set to the operator that i press on
    @FXML private TextField textField; //Where text goes in calculator

    @FXML
    public void initialize() {

    }

    @FXML
    private void buttonInitializer (ActionEvent event) {
        Button button = (Button)event.getSource(); //grabs buttons from the test.fxml file
        final String buttonText = button.getText(); //grabs text from the buttons
        if(buttonText.matches("[0-9]")) { //as long as its a number, append the text on textfield
            textField.appendText(buttonText);
        }
        if (buttonText.matches("[.]")) {//add a period. Need to think of a way to only allow 1.
            textField.appendText(buttonText);
        }
        if(buttonText.matches("[a|s|m|d]")) { // select operator
            left = new BigDecimal(textField.getText()); // sets whatever is in textfield, to left
            buttonOperator = buttonText;// grabs the button text and sets the buttonoperator to it
            textField.clear();// clear text field
        }
        if(buttonText.equals("=")) { // this is when the calculation will happen
            right = new BigDecimal(textField.getText());// sets whatever is in the textfield to right
            answer=calculate(buttonOperator,left,right);// answer to the arthimetric done
            textField.setText(answer.toString());// puts up the answer onto the textfield
        }
        if (buttonText.equals("c")) {
            textField.clear();// just clears the text field
        }
        if(buttonText.equals("ce")) {
            clearCalculator(); // sets right and left to 1 and clears textfield
        }
    }

    private static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right) {
        switch(operator) {
            case ("a"): // adding
                return left.add(right);
            case("s"): // subtracting
                return left.subtract(right);
            case("m"): // multiplying
                return left.multiply(right);
            case("d"): // division
                return left.divide(right);
        }
        return right;
    }

    private void clearCalculator() { // clearing the textfield and the two variables
        left = BigDecimal.ZERO;
        right = BigDecimal.ZERO;
        textField.clear();
    }



}
