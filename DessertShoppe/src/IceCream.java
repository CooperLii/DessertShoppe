/**
 * @author MingFang Li (lim)
 * Course: CSCI 242 - Computer Science II
 * Assignment: 2
 *
 * Project/Class Description:
 * The iceCream class is derived from DessertItems class.
 * This class has item's name,and price in the
 * constructor and in constructor's parameter.
 * This class has getCost method to return the cost of the ice cream
 * This class also has a toString method to represent the item name,
 * and cost.
 *
 * Known bugs: none
 */

// The iceCream class is derived from DessertItems class.
public class IceCream extends DessertItem{

    // declare variable for the price of the item
    int iceCreamCost;

    /**
     * The constructor has item name,and price in it
     * and as its parameter.
     * @param iceCreamName the name of item
     * @param iceCreamCost the price of item
     */
    public IceCream(String iceCreamName,int iceCreamCost)
    {
        super(iceCreamName);
      this.iceCreamCost = iceCreamCost;
    }

    /**
     * The getCost method returns the cost of the item.
     * @return the cost of the item.
     */
    public int getCost()
    {
        return iceCreamCost;
    }

    /**
     * This toString method represent the item name
     * and how much it cost.
     * (the maximum length of the item name is 20)
     * @return a string with information needed.
     */
    @Override
    public String toString()
    {
        /**
         * check if the item name is more than 20 characters
         * if it is, limit the length to 20
         * if it is not, just return the regular item name
         */
        if(getName().length()>Checkout.MAX_NAMELENGTH)
    {
        String first20 = getName().substring(0,20);
        return String.format("%s%31s%.2f",first20
                ," $ ",getCost()/100.00);
    }
    else
        {
        return  String.format("%-20s%31s%.2f",getName()
                ," $ ",getCost()/100.00);
        }
    }
}