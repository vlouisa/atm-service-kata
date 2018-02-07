package nl.louisa.service;

public enum Money {

    TWENTY_EURO(20), TEN_EURO (10), FIFTY_EURO(50);

    private int value;

    Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
