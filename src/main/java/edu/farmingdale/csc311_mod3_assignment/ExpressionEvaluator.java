package edu.farmingdale.csc311_mod3_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {
    // Method to evaluate the expression
    public static String evaluate(String expression) {
        try {
            // Tokenize the expression
            List<String> tokens = tokenize(expression);

            // Convert to postfix notation using Shunting Yard algorithm
            List<String> postfix = infixToPostfix(tokens);

            // Evaluate the postfix expression
            double result = evaluatePostfix(postfix);

            // Check if the result is 24
            if (result == 24) {
                return result + " - Good Job!";
            } else {
                return result + " - Wrong, Try Again.";
            }

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // Tokenizes the expression into a list of strings
    private static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                number.append(c);
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else if (Character.isWhitespace(c)) {
                continue;
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }
        if (number.length() > 0) {
            tokens.add(number.toString());
        }

        return tokens;
    }

    // Converts the infix expression to postfix notation
    private static List<String> infixToPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                output.add(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop(); // Pop the '('
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            }
        }

        // Pop all remaining operators
        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    // Evaluates the postfix expression
    private static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    // Helper methods
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    private static double applyOperator(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}