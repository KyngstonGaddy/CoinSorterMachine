public abstract class Coin {
    public abstract double getValue();
    public abstract String getName();
    public String getPluralName() {
        if (getName().equals("penny")) {
            return "pennies";
        } else {
            return getName() + "s";
        }
    }

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
