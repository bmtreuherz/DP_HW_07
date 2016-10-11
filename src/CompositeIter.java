import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * Created by Bradley on 10/10/2016.
 */
public class CompositeIter implements Iter<Component> {
    Component component;
    int index;

    public CompositeIter(Component component){
        this.component = component;
        this.index = 0;
    }
    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public boolean isDone() {
        return index >= component.getSize();
    }

    @Override
    public Component currentItem() {
        return component.getChild(index);
    }
}
