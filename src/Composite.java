/**
 * Created by bradl on 10/5/2016.
 */
// This class will be dealing with Components that have children. As such, I would like to localize the  maintenance
// the parent-child invarient here.
public abstract class Composite extends Component{

    @Override
    public boolean add(Component child){
        child.setParent(this);
        return true;
    }

    @Override
    public boolean remove(Component child){
        child.setParent(null);
        return true;
    }
}
