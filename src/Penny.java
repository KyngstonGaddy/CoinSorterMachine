/**
 * Data for the penny object
 * @author Kyngston Gaddy
 * @version 4.4.2024
 */
public class Penny extends Coin {
    public double getValue() {
        return .01;
    }

    /**
     * name of the coin
     * @return the name
     */
    public String getName() {
        return "penny";
    }
}
