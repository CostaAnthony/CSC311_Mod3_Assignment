package edu.farmingdale.csc311_mod3_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;

public class GameController {
    @FXML
    protected void onSolutionButtonClick(ActionEvent event) {
        SolutionText.setText("New Solution");
    }

    @FXML
    private Label SolutionText;

    @FXML
    protected void onRefreshButtonClick(ActionEvent event) {
    }

    @FXML
    private ImageView card1, card2, card3, card4;

    @FXML
    private Label ExpressionText;
    @FXML
    private TextField ExpressionInput;
    @FXML
    private Label ResultText;

    @FXML
    protected void onVerifyButtonClick() {
        String expression = ExpressionInput.getText().trim();  // Trim any leading/trailing spaces

        // Check if the expression is not empty and doesn't contain the placeholder text
        if (expression.isEmpty() || expression.equals("Enter an expression:")) {
            ResultText.setText("Please enter a valid expression.");
            return;
        }

        // Pass the expression to the ExpressionEvaluator to compute the result
        String resultMessage = ExpressionEvaluator.evaluate(expression);

        // Set ResultText based on the evaluation result
        ResultText.setText(resultMessage);
    }

    private DeckOfCards deck = new DeckOfCards();
    @FXML
    public void printCards() {
        deck.shuffleDeck(); // Shuffle deck each time the method is called
        List<CardGen> selectedCards = deck.getFourCards(); // Get 4 cards

        ImageView[] cardImages = {card1, card2, card3, card4};

        for (int i = 0; i < 4; i++) {
            CardGen card = selectedCards.get(i);
            String imagePath = "/edu/farmingdale/csc311_mod3_assignment/images/" + card.getFace().name().toLowerCase() + "_of_" + card.getSuit().name().toLowerCase() + ".png";
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            cardImages[i].setImage(image);
        }
    }
}