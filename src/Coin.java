/**
 * Gives the value of each coin along with the proper name
 * @author Kyngston Gaddy
 * @version 4.4.2024
 */
public abstract class Coin {

    /**
     * returns values based on implementing class object's values
     * @return values based on implementing class object's values
     */
    public abstract double getValue();

    /**
     * returns the name of the designated coin i.e "penny" or "nickel"
     * @return the name of the designated coin i.e "penny" or "nickel"
     */
    public abstract String getName();

    /**
     * define in the class: "pennies", "nickels", "dimes", etc
     * @return the plural name of the coin
     */
    public String getPluralName() {
        if (getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }

    /**
     * sees if the coin is an instance of one specific type of coin
     * @param other, the coin that will be compared to the other coins
     * @return true if the coin is the same as other, false if they are not the same
     */
    public boolean equals(Object other) {
        if(other != null && other instanceof Coin) {
            Coin temp = (Coin) other;
            Double v1 = this.getValue();
            Double v2 = temp.getValue();
            return v1.compareTo(v2)==0;
        }
        return false;
    }
}
