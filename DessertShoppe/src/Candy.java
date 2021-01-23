/**
 * @author MingFang Li (lim)
 * Course: CSCI 242 - Computer Science II
 * Assignment: 2
 *
 * Project/Class Description:
 * The candy class is derived from DessertItems class.
 * This class has item's name, weight and price per pound in the
 * constructor and in constructor's parameter.
 * This class has getCost method to return the cost depending on
 * the item's weight, the cost is rounded to the nearest cent.
 * This class also has a toString method to represent the item name,
 * item weight, item price, and cost.
 *
 * Known bugs: none
 */

// class Candy is derived from DessertItem class
public class Candy extends DessertItem
{
    // declare variable for the weight of the item
    double weight;

    // declare variable for the price of the item
    int pricePerPound;

    /**
     * The constructor has item name, weight, price in it
     * and as its parameter.
     * @param name The name of the item.
     * @param weight The weight of the item.
     * @param pricePerPound The price of the item(per pound).
     */
    public Candy(String name,double weight,int pricePerPound)
    {
        super(name);
        this.weight=weight;
        this.pricePerPound=pricePerPound;
    }

    /**
     * The getCost method returns the cost of the item
     * and round the cost to the nearest cent.
     * @return Rounded item cost
     */
    public int getCost()
    {
        return (int)Math.round(weight*pricePerPound);
    }

    /**
     * This toString method represent the item name,
     * item weight, item price, and how much it cost.
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
        return String.format("%s%8.2f%s%.2f%8s%.2f",first20,weight
                ," lbs. at $ ",pricePerPound/100.00
                ," $ ",getCost()/100.00);
        }
        else
            {
            return String.format("%-20s%8.2f%s%.2f%8s%.2f",getName(), weight
                    , " lbs. at $ ", pricePerPound/100.00
                    , " $ ", getCost()/100.00);
        }
    }
}
