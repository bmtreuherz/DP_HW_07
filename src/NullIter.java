/**
 * Created by Bradley on 10/10/2016.
 */
// This class is an iterator that iterates over nothing.
public class NullIter<T> implements Iter<T> {

    @Override
    public void first() {}

    @Override
    public void next() {}

    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public T currentItem() {
        return null;
    }
}
