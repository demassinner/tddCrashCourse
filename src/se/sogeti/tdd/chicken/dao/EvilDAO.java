package se.sogeti.tdd.chicken.dao;

public final class EvilDAO {

    public static final int sendToMars(final String string) {
        throw new IllegalStateException("Jag beh�ver att hela min server �r uppe, och mars server ox�");
    }

}
