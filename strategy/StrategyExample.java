interface SortingStrategy {
    void sort(int[] array);
}

class BubbleSortStrategy implements SortingStrategy {
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
    }
}

class QuickSortStrategy implements SortingStrategy {
    public void sort(int[] array) {
        System.out.println("Sorting using Quick Sort");
    }
}

class Sorter {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        strategy.sort(array);
    }
}

public class StrategyExample {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();

        sorter.setStrategy(new BubbleSortStrategy());
        sorter.sortArray(new int[]{5, 3, 8});

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sortArray(new int[]{5, 3, 8});
    }
}
