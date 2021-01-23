/**
 * @author MingFang Li (lim)
 * Course: CSCI 242 - Computer Science II
 * Assignment: 2
 *
 * Project/Class Description:
 * The class Checkout.
 * This class has a constructor with item list in it,
 * this class also has a method to clear the receipt,
 * this class also has a method to enter the items,
 * this class also has a method to return the number of items in the current transaction,
 * this class also has a method to first prints the string representation of the transaction then clears the register
 * this class also has a method to make a string representation of the transaction.
 * this class also has a method to return the total cost of all the items as a double without tax.
 * this class also has a method to return the total tax on all the items.
 *
 * Known bugs: none
 */

// import array list
import java.util.ArrayList;

// class Checkout
public class Checkout
{
    //The name of the store
    public static  String storeName
            = "M and M Dessert Shoppe";

    //The maximum length of item names, a reasonable value is 20.
    public static final int MAX_NAMELENGTH=20;

    //The tax rate is 6.5%
    public static final double TAX_RATE = 0.065;

    // make an array list for items
    ArrayList<DessertItem> itemsList;

    // the default constructor
    public Checkout()
    {
        itemsList = new ArrayList();
    }

    // clear the cash register for another transaction
    public void clear()
    {
        itemsList.clear();
    }

    /**
     * Enter an item
     * @param item the dessert item to be entered
     */
    public void enterItem(DessertItem item)
    {
        itemsList.add(item);
    }


    /**
     * The number of items in the current transaction
     * @param itemsList the list of items
     * @return the number of items in the current transaction
     */
    public int numberOfItems(ArrayList itemsList)
    {
        return itemsList.size();
    }


    // First prints the string representation
    // of the transaction then clears the register
    public void processReceipt()
    {
        System.out.println(this.toString());
         this.clear();
    }

    /**
     * A string representation of the transaction.
     * @return the string that represent the receipt
     */
    @Override
    public String toString(){
        String receipt;
        receipt="***  "+storeName+"  ***"+"\n";
        for(int i=0; i<itemsList.size();i++)
        {
             receipt +="\n"+itemsList.get(i).toString();
        }
        receipt+=String.format(
                "%s%s%d%s%38s%5.2f%s%39s%5.2f%s%37s%5.2f",
        "\n-------------------------------------------------------"
        ,"\nNumber of items: ",numberOfItems(itemsList),
                "\nTotal cost: ","$",totalCost()
        ,"\nTotal tax: ","$",totalTax(),"\nGrand Total: ","$"
                ,(totalTax()+totalCost()));

        return receipt;
    }

    /**
     * The total cost of all the items as a double.
     * @return total cost of items without tax
     */
    public double totalCost(){
        double totalItemsCost=0.0;
        for (int i=0;i<itemsList.size();i++)
        {
            totalItemsCost+=itemsList.get(i).getCost()/100.00;
        }
        return totalItemsCost;
    }

    /**
     * The total tax on all the items
     * @return total tax of all items
     */
    public double totalTax()
    {
    double totalTax=Math.round(this.totalCost()*TAX_RATE*100.00)/100.00;
        return totalTax;
    }
}
