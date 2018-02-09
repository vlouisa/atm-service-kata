package nl.louisa.service;

public enum Denomination {

    FIFTY_EURO(50), TWENTY_EURO(20), TEN_EURO (10);

    private int value;

    Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
