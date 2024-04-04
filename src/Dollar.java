/**
 * Data for the Dollar object
 * @author Kyngston Gaddy
 * @version 4.4.2024
 */
public class Dollar extends Coin {
    public double getValue() {
        return 1;
    }

    /**
     * name of the coin
     * @return the name
     */
    public String getName() {
        return "dollar";
    }
}
