/**
 * Created by bradl on 10/5/2016.
 */
public abstract class Component {
    private Component parent;

    public String toString(){
        return toString(0);
    }

    public abstract String toString(int depth);

    // Returns a boolean indicating if the component was successfully added. By default, nothing will be added.
    public boolean add(Component child){
        return false;
    }

    // Returns a boolean indicating if the component was removed. By default, nothing will be removed.
    public boolean remove(Component child){
        return false;
    }

    public Component getParent(){
        return parent;
    }

    public void setParent(Component parent){
        this.parent = parent;
    }
}
