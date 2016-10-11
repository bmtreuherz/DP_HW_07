import java.util.*;
/**
 * Created by Bradley on 10/10/2016.
 */

public class PreorderIter implements Iter<Component> {
    Component root;
    LinkedList<Component> components;

    public PreorderIter(Component root){
        this.root = root;
        components = new LinkedList<>();
        populate(root);
    }

    @Override
    public void first() {
        components.clear();
        populate(root);
    }

    @Override
    public void next(){
        components.dequeue();

    }

    @Override
    public boolean isDone() {
        return components.isEmpty();
    }

    @Override
    public Component currentItem() {
        return components.get(0);
    }

    private void populate(Component component){
        components.enqueue(component);
        Iter<Component> iter = component.makeIter();
        for(iter.first(); !iter.isDone(); iter.next()){
            populate(iter.currentItem());
        }
    }
}
