/**
 * Created by bradl on 10/5/2016.
 */
public class ArrayComposite extends Component {
    Component[] components;

    public ArrayComposite(Component... components){
        this.components = new Component[components.length];

        // Set all the components parents
        for(int i=0; i<components.length; i++){
            super.add(components[i]);
        }
    }

    @Override
    protected boolean doAdd(Component child){

        // Try to find an empty space in the array
        for(int i=0; i< components.length; i++){
            if(components[i] == null){
                components[i] = child;
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean doRemove(Component child){

        // Try to find this reference in the array
        for(int i=0; i<components.length; i++){
            if(components[i] == child){
                components[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Component getChild(int index){
        // Traverse through and get the indexth child (note it may not
        // be at the indexth position in the array as there could be holes.
        int pos = 0;
        for(int i=0; i<components.length; i++){
            if(components[i] != null){
                if(pos == index){
                    return components[i];
                }
                pos++;
            }
        }
        return null;
    }

    @Override
    public int getSize(){
        int size = 0;
        for(int i=0; i<components.length; i++){
            if(components[i] != null){
                size++;
            }
        }
        return size;
    }

    @Override
    public Iter<Component> makeIter(){
        return new CompositeIter(this);
    }
}
