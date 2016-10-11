/**
 * Created by bradl on 10/5/2016.
 */
public class SingleComposite extends Component {
    Component child;

    public SingleComposite(){}
    public SingleComposite(Component child){
        super.add(child);
    }

    @Override
    protected boolean doAdd(Component child){
        // Check if the child can be added.
        if(this.child != null){
            return false;
        }

        // Set the child and call the super method.
        this.child = child;
        return true;
    }

    @Override
    protected boolean doRemove(Component child){
        // Check if the the reference to child is the same as the child we have.
        if(this.child == child && child!=null){
            this.child = null;
            return true;
        }
        return false;
    }

    @Override
    public Component getChild(int index){
        return (index == 0) ?
                this.child :
                null;
    }

    @Override
    public int getSize(){
        return (child == null) ? 0 : 1;
    }

    @Override
    public Iter<Component> makeIter(){
        return new CompositeIter(this);
    }
}
