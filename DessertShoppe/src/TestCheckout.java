/**
 * A class to test the Dessert Shoppe Application
 */
public class TestCheckout {

    public static void main(String[] args) {

        Checkout checkout = new Checkout();    // a check out object to handle a sale

        // Sell a customer a bunch of desserts
        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream",105));
        checkout.enterItem(new Sundae("Choc. Chip Ice Cream",145, "Hot Fudge", 50));
        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));

        checkout.processReceipt();

        System.out.println("\n\n\n\n");

        // Sell another customer some desserts
        checkout.enterItem(new IceCream("Strawberry Ice Cream",145));
        checkout.enterItem(new Sundae("Vanilla Ice Cream",105, "Caramel", 50));
        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
        checkout.enterItem(new Candy("Candy Corn",3.0, 109));

        // Print a receipt
        checkout.processReceipt();
    }
}
