import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Takes an assortment of coins and tells the user how much $$ came from each type of coin (along w/ total amount)
 * @author Kyngston Gaddy
 * @version 4.4.2024
 *  # Andrew helped me with the print statements for the printDepositSummary method
 */
public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    private int[] coinCounts = {0,0,0,0,0,0};
    TreeMap<String, Coin> coinMap = new TreeMap<>();

    /**
     * initializes coins ArrayList, along with the coinMap values
     */
    public CoinSorterMachine() {
        coins = new ArrayList<>();
        coinMap.put("1", new Penny());
        coinMap.put("5", new Nickel());
        coinMap.put("10", new Dime());
        coinMap.put("25", new Quarter());
        coinMap.put("50", new HalfDollar());
        coinMap.put("100", new Dollar());
    }

    /**
     * use one or two Scanner objects, prompting user for the appropriate file
     * name and importing the data from filename – MUST handle diabolic values!
     */
    public void depositCoins() {
        System.out.print("Enter the name of the data file for coin deposit: ");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        try {
            System.out.println("Depositing coins...");
            Scanner openFile = new Scanner(new File(filename));
            while(openFile.hasNext()) {
                String temp = openFile.nextLine();
                if (coinMap.containsKey(temp)) {
                    coins.add(coinMap.get(temp));
                    coinCounts[indexValue(temp)]++; // adding these values to the array that counts the coins
                }
                else
                    System.out.println("Coin value " + temp + " not recognized");
            }
            in.close();
            openFile.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // an extra I added
    private int indexValue(String t) { // similar to the switch example mentioned in class, but I found it easier to use a bunch of if statements
        if (Objects.equals(t, "1"))
            return 0; // index 0 - penny
        if (Objects.equals(t, "5"))
            return 1; // index 1 - nickel
        if (Objects.equals(t, "10"))
            return 2; // index 2 - dime
        if (Objects.equals(t, "25"))
            return 3; // index 3 - quarter
        if (Objects.equals(t, "50"))
            return 4; // index 4 - half dollar
        if (Objects.equals(t, "100"))
            return 5; // index 5 - dollar
        else
            return -1;
    }
    /**
     * Prints deposit summary using a DecimalFormat object (see output section)
     */
    public void printDepositSummary() {
        DecimalFormat df = new DecimalFormat("$0.00");
        System.out.println("Summary of deposit: ");
        System.out.println("\t" + coinCounts[0] + " " + (coinCounts[0] == 1 ? coinMap.get("1").getName() : coinMap.get("1").getPluralName()) + " " + df.format(coinCounts[0] * .01));
        System.out.println("\t" + coinCounts[1] + " " + (coinCounts[1] == 1 ? coinMap.get("5").getName() : coinMap.get("5").getPluralName()) + " " + df.format(coinCounts[1] * .05));
        System.out.println("\t" + coinCounts[2] + " " + (coinCounts[2] == 1 ? coinMap.get("10").getName() : coinMap.get("10").getPluralName()) + " " + df.format(coinCounts[2] * .1));
        System.out.println("\t" + coinCounts[3] + " " + (coinCounts[3] == 1 ? coinMap.get("25").getName() : coinMap.get("25").getPluralName()) + " " + df.format(coinCounts[3] * .25));
        System.out.println("\t" + coinCounts[4] + " " + (coinCounts[4] == 1 ? coinMap.get("50").getName() : coinMap.get("50").getPluralName()) + " " + df.format(coinCounts[4] * .5));
        System.out.println("\t" + coinCounts[5] + " " + (coinCounts[5] == 1 ? coinMap.get("100").getName() : coinMap.get("100").getPluralName()) + " " + df.format(coinCounts[5] * 1));
        System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));
    }

    /**
     * return the total value of all Coin objects stored in coins as a double
     * @return sum, the total value of the coins as a double
     */
    public double getTotalValue() {
        double sum = 0;
        for(Coin c : coins)
            sum += c.getValue();
        return sum;
    }

    /**
     * main method for the class should use these exact three lines of code
     * @param args command line args, if needed
     */
    public static void main(String[] args)  {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}

