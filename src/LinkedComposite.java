/**
 * Created by bradl on 10/5/2016.
 */
public class LinkedComposite extends Component {
    LinkedList<Component> components;

    public LinkedComposite(Component... components){
        this.components = new LinkedList<>();

        for(int i=0; i<components.length; i++){
            super.add(components[i]);
        }
    }

    @Override
    protected boolean doAdd(Component child){

        components.add(child);
        return true;
    }

    @Override
    protected boolean doRemove(Component child){

        // Try to find this reference in the array
        for(int i=0; i<components.size(); i++){
            if(components.get(i) == child){
                components.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Component getChild(int index){
        return components.get(index);
    }

    @Override
    public int getSize(){
        return components.size();
    }

    @Override
    public Iter<Component> makeIter(){
        return new CompositeIter(this);
    }
}
