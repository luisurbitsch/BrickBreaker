package Tools;

public class RandomNumber {

    public static int get(final int max, final int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
