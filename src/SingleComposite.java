/**
 * Created by bradl on 10/5/2016.
 */
public class SingleComposite extends Composite {
    Component child;

    public SingleComposite(Component child){
        this.child = child;
        child.setParent(this);
    }

    @Override
    public boolean add(Component child){
        // Check if the child can be added.
        if(this.child != null){
            return false;
        }

        // Set the child and call the super method.
        this.child = child;
        super.add(child);
        return true;
    }

    @Override
    public boolean remove(Component child){
        // Check if the the reference to child is the same as the child we have.
        if(this.child == child && child!=null){
            this.child = null;
            super.remove(child);
            return true;
        }
        return false;
    }

    @Override
    public String toString(int depth){
        String s = "";
        for(int i=0; i< depth; i++){
            s += "\t";
        }
        s += "SingleComposite containing\n";
        s+=child.toString(depth + 1);

        return s;
    }
}
