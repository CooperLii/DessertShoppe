/**
 *
 * Project/Class Description:
 * The cookie class is derived from DessertItems class.
 * This class has item's name, number and price per dozen in the
 * constructor and in constructor's parameter.
 * This class has getCost method to return the cost depending on
 * the item's amount, the cost is rounded to the nearest cent.
 * This class also has a toString method to represent the item name,
 * item amount, item price, and cost.
 *
 * Known bugs: none
 */
// class Cookie is derived from DessertItem class
public class Cookie extends DessertItem{

    // declare variable for the amount of the item
    int number;

    // declare variable for the price of the item
    int pricePerDozen;

    /**
     * The constructor has item name,item amount, price in it
     * and as its parameter.
     * @param name The name of the item.
     * @param number The amount of the item.
     * @param pricePerDozen The price of the item(per dozen).
     */
    public Cookie(String name,int number,int pricePerDozen)
    {
        super(name);
        this.number =number;
        this.pricePerDozen=pricePerDozen;
    }

    /**
     * The getCost method returns the cost of the item
     * and round the cost to the nearest cent.
     * @return Rounded item cost
     */
    public int getCost()
    {
        return   (int)Math.round(number/12.0*pricePerDozen);
    }

    /**
     * This toString method represent the item name,
     * item amount, item price, and how much it cost.
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
            String first20 = this.getName().substring(0,20);
            return String.format("%s%8d%s%.2f%s%8s%.2f",first20,number,
                    " at $ ", pricePerDozen/100.00,
                    "/doz."," $ ",getCost()/100.00);
        }
        else {
            return String.format("%-20s%8d%s%.2f%s%8s%.2f",getName(),number,
                    " at $ ",pricePerDozen/100.00,
                    "/doz."," $ ", getCost()/100.00);
        }
    }
}
