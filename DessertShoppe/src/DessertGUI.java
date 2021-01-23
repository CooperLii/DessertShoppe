/**
 * @author MingFang Li (lim)
 * Course: CSCI 242 - Computer Science II
 * Date: 10/11/2018
 * Assignment: 2B
 *
 * Project/Class Description:
 *                     This project let users enter the items information
 *                     and then show the users the receipt of the items
 *                     with items information that were entered with tax and total cost in a neat format
 * Known bugs: none
 */

//import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// class DessertGUI for GUI form
public class DessertGUI {

    // create text fields for name,price,weight,price per pounds,price per dozen
    // number,topping types,and topping cost.
    private JTextField textName;
    private JTextField textPrice;
    private JTextField textWeight;
    private JTextField textplb;
    private JTextField textpDz;
    private JTextField textNumber;
    private JTextField textTopping;
    private JTextField textTopCost;

    //create buttons for total, enter, and categories like cookie,
    // sundae, candy, ice cream
    private JButton totalButton;
    private JButton enterButton;
    private JButton cookiesButton;
    private JButton sundaeButton;
    private JButton candyButton;
    private JButton iceCreamButton;

    // create a dessert panel
    private JPanel DessertPanel;

    // set a checker to see which category users choose
    String checker = "";

    // create a new checkout object called checkout
    public static Checkout checkout;

    public DessertGUI()
    {
            // before users choose categories, disable all text fields
            textName.setEditable(false);
            textPrice.setEditable(false);
            textWeight.setEditable(false);
            textplb.setEditable(false);
            textpDz.setEditable(false);
            textNumber.setEditable(false);
            textTopping.setEditable(false);
            textTopCost.setEditable(false);

            /**
             *add a mouse listener for ice cream button
             *tell the program what to do after mouse clicked candy button
             */
        iceCreamButton.addMouseListener(new MouseAdapter()
        {
            @Override
            /**
             * let text fields that are related to ice cream be editable when
             * mouse is clicked on ice cream button
             */
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                textName.setEditable(true);
                textPrice.setEditable(true);
                textWeight.setEditable(false);
                textplb.setEditable(false);
                textpDz.setEditable(false);
                textNumber.setEditable(false);
                textTopping.setEditable(false);
                textTopCost.setEditable(false);

                // set the checker to ice cream
                checker = "iceCream";

                // enter button is only enable after user chose a category
                enterButton.setEnabled(true);

            }
        });

        /**
         * add a mouse listener for candy button
         * tell the program what to do after mouse clicked candy button
         */
        candyButton.addMouseListener(new MouseAdapter()
        {
            @Override
            /**
             * let text fields that are related to candy be editable when
             * mouse is clicked on candy button
             */
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                textName.setEditable(true);
                textPrice.setEditable(false);
                textWeight.setEditable(true);
                textplb.setEditable(true);
                textpDz.setEditable(false);
                textNumber.setEditable(false);
                textTopping.setEditable(false);
                textTopCost.setEditable(false);

                // set the checker to candy
                checker = "Candy";

                // enter button is only enable after user chose a category
                enterButton.setEnabled(true);
            }
        });

        /**
         * add a mouse listener for cookies button
         * tell the program what to do after mouse clicked cookies button
         */
        cookiesButton.addMouseListener(new MouseAdapter()
        {
            @Override
            /**
             * let text fields that are related to cookies be editable when
             * mouse is clicked on cookies button
             */
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                textName.setEditable(true);
                textPrice.setEditable(false);
                textWeight.setEditable(false);
                textplb.setEditable(false);
                textpDz.setEditable(true);
                textNumber.setEditable(true);
                textTopping.setEditable(false);
                textTopCost.setEditable(false);

                //set the checker to cookie
                checker = "Cookie";

                // enter button is only enable after user chose a category
                enterButton.setEnabled(true);
            }
        });

        /**
         * add a mouse listener for sundae button
         * tell the program what to do after mouse clicked sundae button
         */
        sundaeButton.addMouseListener(new MouseAdapter()
        {
            @Override
            /**
             * let text fields that are related to sundae be editable when
             * mouse is clicked on sundae button
             */
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                textName.setEditable(true);
                textPrice.setEditable(true);
                textWeight.setEditable(false);
                textplb.setEditable(false);
                textpDz.setEditable(false);
                textNumber.setEditable(false);
                textTopping.setEditable(true);
                textTopCost.setEditable(true);

                // set the checker to sundae
                checker = "Sundae";

                // enter button is only enable after user chose a category
                enterButton.setEnabled(true);
            }
        });

        // disable the enter button before users choose a category
        // to prevent users from not choosing a category
        enterButton.setEnabled(false);

        /**
         * add a mouse listener for enter button
         * tell the program what to do after mouse clicked enter button
         */
        enterButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                // after users click enter button disable all the text fields
                // until users choose another category
                textName.setEditable(false);
                textPrice.setEditable(false);
                textWeight.setEditable(false);
                textplb.setEditable(false);
                textpDz.setEditable(false);
                textNumber.setEditable(false);
                textTopping.setEditable(false);
                textTopCost.setEditable(false);
                super.mouseClicked(e);

                /** if users clicked the category ice cream,
                 *  gather the information that users entered for ice cream
                 *  then enter the item to the object checkout
                 *  then set the text fields back to empty
                 *  then disable the enter button until users choose another category
                 *  if the text fields are empty and users press enter, print out the exception
                 */
                    if (checker == "iceCream") {
                        try
                        {
                        enterButton.setEnabled(true);
                        checkout.enterItem(new IceCream(textName.getText(), Integer.parseInt(textPrice.getText())));
                        textName.setText("");
                        textPrice.setText("");
                        enterButton.setEnabled(false);

                            // if the user enter the wrong format in text fields
                            // print out the exception
                            try {
                                int a = Integer.parseInt(textName.getText());
                                int b = Integer.parseInt(textPrice.getText());
                                System.out.println(a);
                                System.out.println(b);

                            } catch (NumberFormatException e2) {
                                System.out.println("Please enter right information");
                            }
                    }
                    catch (NumberFormatException e1){
                        System.out.println(e1.getMessage());
                    }
                }


                /** if users clicked the category candy,
                 *  gather the information that users entered for candy
                 *  then enter the item to the object checkout
                 *  then set the text fields back to empty
                 *  then disable the enter button until users choose another category
                 *  if the text fields are empty and users press enter, print out the exception
                 */
                else if (checker == "Candy") {
                        try {
                            enterButton.setEnabled(true);
                            checkout.enterItem(new Candy(textName.getText(), Double.parseDouble(textWeight.getText()),
                                    Integer.parseInt(textplb.getText())));
                            textName.setText("");
                            textWeight.setText("");
                            textplb.setText("");
                            enterButton.setEnabled(false);

                            // if the user enter the wrong format in text fields
                            // print out the exception
                            try {
                                int a = Integer.parseInt(textName.getText());
                                int b = Integer.parseInt(textPrice.getText());
                                System.out.println(a);
                                System.out.println(b);

                            } catch (NumberFormatException e2) {
                                System.out.println("Please enter right information");
                            }
                        } catch (NumberFormatException e1) {
                            System.out.println(e1.getMessage());
                        }
                    }
                /** if users clicked the category cookie,
                 *  gather the information that users entered for cookie
                 *  then enter the item to the object checkout
                 *  then set the text fields back to empty
                 *  then disable the enter button until users choose another category
                 *  if the text fields are empty and users press enter, print out the exception
                 */
                else if (checker == "Cookie")
                {
                    try
                    {
                        enterButton.setEnabled(true);
                        checkout.enterItem(new Cookie(textName.getText(),
                                Integer.parseInt(textNumber.getText()),Integer.parseInt(textpDz.getText())));
                        textName.setText("");
                        textpDz.setText("");
                        textNumber.setText("");
                        enterButton.setEnabled(false);

                        // if the user enter the wrong format in text fields
                        // print out the exception
                        try {
                            int a = Integer.parseInt(textName.getText());
                            int b = Integer.parseInt(textPrice.getText());
                            System.out.println(a);
                            System.out.println(b);

                        } catch (NumberFormatException e2) {
                            System.out.println("Please enter right information");
                        }
                    }
                    catch (NumberFormatException e1)
                    {
                        System.out.println(e1.getMessage());
                    }
                }


                /** if users clicked the category sundae,
                 *  gather the information that users entered for sundae
                 *  then enter the item to the object checkout
                 *  then set the text fields back to empty
                 *  then disable the enter button until users choose another category
                 *  if the text fields are empty and users press enter, print out the exception
                 */
                else
                    {
                        try
                        {
                            enterButton.setEnabled(true);
                            checkout.enterItem(new Sundae(textName.getText(), Integer.parseInt(textPrice.getText()),
                            textTopping.getText(), Integer.parseInt(textTopCost.getText())));
                        textName.setText("");
                        textPrice.setText("");
                        textTopping.setText("");
                        textTopCost.setText("");
                        enterButton.setEnabled(false);

                        // if the user enter the wrong format in text fields
                        // print out the exception
                        try {
                            int a = Integer.parseInt(textName.getText());
                            int b = Integer.parseInt(textPrice.getText());
                            System.out.println(a);
                            System.out.println(b);

                        } catch (NumberFormatException e2) {
                            System.out.println("Please enter right information");
                        }
                    }
                    catch (NumberFormatException e1)
                {
                    System.out.println(e1.getMessage());
                }
            }}
        });

        /**
         * add a mouse listener for total button
         * tell the program what to do after mouse clicked total button
         */
        totalButton.addMouseListener(new MouseAdapter()
        {
            @Override
            /**
             * after mouse clicked total button
             * check if the users chose a category and if the item list is empty
             * if so, show up another frame and place an error message in the middle of the frame
             * if not, show up the receipt frame with the items information users entered with the tax and total price
             */
            public void mouseClicked(MouseEvent e)
            {
          if(checker==""||checkout.itemsList.isEmpty())
          {
              JFrame error = new JFrame("ErrorMessage");
              error.setSize(400, 400);
              JTextField errorMessage = new JTextField();
              errorMessage.setText("Make sure you entered (correct) information!");
              errorMessage.setHorizontalAlignment(JTextField.CENTER);
              error.add(errorMessage);
              error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              error.setVisible(true);
          }
          else
              {
                  super.mouseClicked(e);
                JFrame frameReceipt = new JFrame("Receipt");
                frameReceipt.setSize(400, 700);
                JTextArea printReceipt = new JTextArea();

                // set the font to MONOSPACED in order to match the format of sample output
                Font font = new Font(Font.MONOSPACED, Font.PLAIN, 10);
                printReceipt.setFont(font);

                printReceipt.setText( checkout.toString());
                frameReceipt.add(printReceipt);
                frameReceipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameReceipt.setVisible(true);
              }
            }
        });
    }

    // the main set the first pop up window with buttons and
    // text fields and labels that are needed for users to enter information of items they want to purchase
    public static void main(String[] args)
    {
        checkout = new Checkout();
        DessertGUI dessertGUI = new DessertGUI();
        JFrame frame = new JFrame("M and M Dessert Shoppe");
        frame.setSize(400, 400);
        frame.setContentPane(dessertGUI.DessertPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}