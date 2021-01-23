/**
 * @author MingFang Li (lim)
 * Course: CSCI 242 - Computer Science II
 * Assignment: 2
 *
 * Project/Class Description:
 *  The Sundae class is derived from iceCream class.
 *  This class has a constructor that has types of toppings
 *  and price of toppings in it.
 *  And the parameter of the constructor contains
 *  ice cream's name, and ice cream's price , topping types,
 *  and topping price.
 *  This class has getCost method to return the cost of the ice cream plus
 *  the cost of toppings.
 *  This class also has a toString method to represent the ice cream name,
 *  ice cream cost, topping name, topping cost, and total cost.
 *
 * Known bugs: none
 */

//  The Sundae class is derived from iceCream class.
public class Sundae extends IceCream
{
    // declare variable for the topping types
    String toppingType;

    // declare variable for the topping cost
    int toppingCost;

    /**
     *  A constructor that has types of toppings
     *  and price of toppings in it.
     *  And the parameter of the constructor contains
     *  ice cream's name, and ice cream's price , topping types,
     *  and topping price.
     * @param iceCreamName the name of ice cream
     * @param iceCreamPrice the price of ice cream
     * @param toppingType the topping types
     * @param toppingCost the topping cost
     */
    public Sundae(String iceCreamName, int iceCreamPrice,  String toppingType, int toppingCost)
    {
        super(iceCreamName, iceCreamPrice);
        this.toppingType = toppingType;
        this.toppingCost = toppingCost;
    }

    /**
     * The getCost method returns the cost of the ice cream plus the cost of topping.
     * @return the cost of the ice cream plus the cost of topping
     */
    public int getCost()
    {
        return iceCreamCost +toppingCost;
    }

    /**
     * This toString method represent the ice cream name
     * and ice cream cost, topping type, and topping cost.
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
            return String.format("%s\n\t%-28s%s%.2f\n\t%-28s%s%.2f%8s%.2f"
                    ,"Sundae",first20," $ "
                    ,this.iceCreamCost/100.00,toppingType," $ ",toppingCost/100.00
                    ," $ ",getCost()/100.00);
        }
        else
        {
            return  String.format("%-20s\n\t%-28s%s%.2f\n\t%-28s%s%.2f%8s%.2f"
                    ,"Sundae",getName()," $ "
                    ,this.iceCreamCost/100.00,toppingType," $ ",toppingCost/100.00
                    ," $ ",getCost()/100.00);
        }
    }
}
