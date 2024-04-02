import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TreeMap;

public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    private int[] coinCounts = {0,0,0,0,0,0};
    private int sum;

    // initializes coins ArrayList
    public CoinSorterMachine() {
        coins = new ArrayList<>();
    }

    // use one or two Scanner objects, prompting user for the appropriate file
    // name and importing the data from filename – MUST handle diabolic values!
    public void depositCoins() {
        TreeMap<String, Coin> coinMap = new TreeMap<>();
        coinMap.put("1", new Penny());
        coinMap.put("1", new Nickel());
        coinMap.put("1", new Dime());
        coinMap.put("1", new Quarter());
        coinMap.put("1", new HalfDollar());
        coinMap.put("1", new Dollar());
        ArrayList<String> coinVals = new ArrayList<>();
        ArrayList<Coin> coinTypes = new ArrayList<>();
    }

    // Prints deposit summary using a DecimalFormat object (see output section)
    public void printDepositSummary() {
        DecimalFormat df = new DecimalFormat("$0.00");
        System.out.println("Summary of deposit: ");
        System.out.println("\t" + coinCounts[0] + " pennies " + df.format(coinCounts[0]*.01)); // what if the output is 0 pennies or 1 penny?
        System.out.println("\t" + coinCounts[0] + "pennies");
        }

    // return the total value of all Coin objects stored in coins as a double
    public double getTotalValue() {
        for(Coin c : coins)
            sum += c.getValue();
        return sum;
    }

    // main method for the class should use these exact three lines of code
    public static void main(String[] args)  {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}

