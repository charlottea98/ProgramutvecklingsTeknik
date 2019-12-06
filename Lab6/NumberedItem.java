package Lab6;

public class NumberedItem<T> implements Comparable<NumberedItem<T>> {

    int heltal;
    T generic;

    NumberedItem(int heltal, T generic) {
        if (heltal < 0) {
            this.heltal = 0;
        } else {
            this.heltal = heltal;
        }

    }

    @Override
    public int compareTo(NumberedItem<T> o) {
        return this.heltal - o.heltal;
    }

    @Override
    public String toString() {
        return "Index: " + this.heltal + " Value: " + this.generic;
    }

    public boolean equals(NumberedItem<T> o) {
        if (this == null || o == null) {
            return false;
        } else if (this.heltal == o.heltal) {
            return true;
        } else {
            return false;
        }
    }
}