package lab01.tdd;

public class EqualsStrategy implements SelectStrategy{

    private int number;

    public EqualsStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean apply(int element) {
        return this.number == element;
    }
}
