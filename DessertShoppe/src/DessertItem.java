/**
 * Abstract superclass for Dessert Item hierarchy
 * @author Stuart Hansen
 * @version September 2018
 */
public abstract class DessertItem {

    /**
     * The name of the dessert item
     */
    protected String name;

    /**
     * Default constructor for DessertItem class
     */
    public DessertItem() {
        this("");
    }

    /**
     * Initializes DessertItem
     * @param name the name of the item
     */
    public DessertItem(String name) {
        this.name = name;
    }

    /**
     * Returns name of DessertItem
     * @return name of DessertItem
     */
    public final String getName() { return name; }

    /**
     * Returns cost of DessertItem
     * Note that costs are calculated as ints
     * @return cost of DessertItem
     */
    public abstract int getCost();



}
