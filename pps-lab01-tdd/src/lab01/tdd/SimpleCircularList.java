package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SimpleCircularList implements CircularList {

    private List<Integer> circularList;
    private int indexOfIteratedElement;

    public SimpleCircularList() {
        this.circularList = new ArrayList<>();
        this.indexOfIteratedElement = 0;
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (this.circularList.isEmpty()) {
            this.indexOfIteratedElement = 0;
            return Optional.empty();
        } else {
            int currentIteratedElement = this.indexOfIteratedElement;
            this.indexOfIteratedElement = ( this.indexOfIteratedElement == this.circularList.size() -1 ? 0 : this.indexOfIteratedElement + 1 );
            return Optional.of(this.circularList.get(currentIteratedElement));
        }
    }

    @Override
    public Optional<Integer> previous() {
        if (this.circularList.isEmpty()) {
            this.indexOfIteratedElement = 0;
            return Optional.empty();
        } else {
            this.indexOfIteratedElement = ( this.indexOfIteratedElement == 0 ? this.circularList.size() -1 : this.indexOfIteratedElement - 1 );
            return Optional.of(this.circularList.get(this.indexOfIteratedElement));
        }
    }

    @Override
    public void reset() {
        this.indexOfIteratedElement = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        Optional<Integer> result = Optional.empty();
        for (Integer i : this.circularList){
            if (strategy.apply(this.next().get())) {
                result = this.previous();
            }
        }
        return result;
    }
}
