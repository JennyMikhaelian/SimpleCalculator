import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    // Plan
    // Step 1) Adding the frame, the panel, the buttons, the text-field and all the necessary data fields
    // Step 2) Creating the frame, assigning each button with a function or a number
    //         Adding the buttons into the panel
    // Step 3) Working in the actionPerformed method to obtain results on the text-field

    JFrame frame;
    JTextField textField;
    JButton [] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel; //to hold the separate buttons

    Font myFont = new Font ("Ink Free", Font.BOLD,30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator(){

        // Creating the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        // Creating the text-field
        textField = new JTextField();
        textField.setBounds(50,25,300,50); //since there is no layout
        textField.setFont(myFont);
        textField.setEditable(false);

        // Creating the buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        // Adding the buttons inside the array we created
        functionButtons[0]= addButton;
        functionButtons[1]= subButton;
        functionButtons[2]= mulButton;
        functionButtons[3]= divButton;
        functionButtons[4]= decButton;
        functionButtons[5]= equButton;
        functionButtons[6]= delButton;
        functionButtons[7]= clrButton;
        functionButtons[8]= negButton;

        for(int i=0;i<functionButtons.length;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Adding the numbers in the array
        for(int i=0;i<numberButtons.length;i++){
            numberButtons[i]= new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // setting the size of del, clr and division
        delButton.setBounds(100,430,100,50);
        clrButton.setBounds(200,430,100,50);

        //Creating a panel
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        // Adding the buttons inside the panel
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[4]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(negButton);
        panel.add(equButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Making the numbers appear when clicking on the buttons
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Decimal button appearance on the text-field
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));

        }

        // Addition button
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText(""); // Clearing the text-field for the user to enter the next nbr
        }

        // Subtraction button
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        // Multiplication button
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        // Division button
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        // Equation button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result; // In case the user wants to use the resulting number
        }

        // Clear button
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        // Delete button
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        // Negative button
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
