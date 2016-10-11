
/**
 * Created by bradl on 10/5/2016.
 */
public abstract class Component {
    private static int instanceIDSeed = 0;

    private Component parent;
    private int instanceID;

    public Component(){
        this.instanceID = instanceIDSeed++;
    }

    public String toString(){
        return (parent == null) ?
                instanceID + " is the root." :
                instanceID + " is the child of " + parent;
    }

    // Returns a boolean indicating if the component was successfully added.
    public boolean add(Component child){

        boolean result = doAdd(child);
        if(result){
            child.setParent(this);
        }
        return result;
    }

    // Returns a boolean indicating if the component was removed.
    public boolean remove(Component child){

        boolean result = doRemove(child);
        if(result){
            child.setParent(null);
        }
        return result;
    }

    // By default, nothing will be added. Composite must override this.
    protected boolean doAdd(Component child){
        return false;
    }

    // By default, nothing will be removed. Composite must override this.
    protected boolean doRemove(Component child){
        return false;
    }

    public Component getParent(){
        return parent;
    }

    public Component getChild(int index) { return null; }

    // Returns the size of the children.
    public int getSize(){
        return 0;
    }

    public void setParent(Component parent){
        this.parent = parent;
    }

    public Iter<Component> makeIter(){
        return new NullIter<>();
    }

    public Iter<Component> makePreorderIterator(){
        return new PreorderIter(this);
    }
}
