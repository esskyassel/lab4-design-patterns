interface MyIterator<T> {
    boolean hasNext();
    T next();
}

class ArrayIterator<T> implements MyIterator<T> {
    private T[] items;
    private int position = 0;

    public ArrayIterator(T[] items) {
        this.items = items;
    }

    public boolean hasNext() {
        return position < items.length;
    }

    public T next() {
        return items[position++];
    }
}

public class IteratorExample {
    public static void main(String[] args) {
        String[] data = {"A", "B", "C"};

        MyIterator<String> iterator = new ArrayIterator<>(data);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
