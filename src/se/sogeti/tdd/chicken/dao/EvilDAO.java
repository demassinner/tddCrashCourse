package se.sogeti.tdd.chicken.dao;

public final class EvilDAO {

    public static final int sendToMars(final String string) {
        throw new IllegalStateException("Jag behöver att hela min server är uppe, och mars server oxå");
    }

}
