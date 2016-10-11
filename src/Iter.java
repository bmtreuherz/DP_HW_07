/**
 * Created by Bradley on 10/10/2016.
 */
public interface Iter<T>{
    void first();
    void next();
    boolean isDone();
    T currentItem();
}
