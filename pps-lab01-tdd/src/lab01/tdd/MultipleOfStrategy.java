package lab01.tdd;

public class MultipleOfStrategy implements SelectStrategy {

    private int number;

    public MultipleOfStrategy(int givenNumber) {
        this.number = givenNumber;
    }
    @Override
    public boolean apply(int element) {
        return element % number == 0;
    }
}
