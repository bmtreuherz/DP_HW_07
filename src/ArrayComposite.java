/**
 * Created by bradl on 10/5/2016.
 */
public class ArrayComposite extends Composite {
    Component[] components;

    public ArrayComposite(Component... components){
        this.components = components;

        // Set all the components parents
        for(int i=0; i<components.length; i++){
            components[i].setParent(this);
        }
    }

    @Override
    public boolean add(Component child){

        // Try to find an empty space in the array
        for(int i=0; i< components.length; i++){
            if(components[i] == null){
                components[i] = child;
                super.add(child);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean remove(Component child){

        // Try to find this reference in the array
        for(int i=0; i<components.length; i++){
            if(components[i] == child){
                components[i] = null;
                super.remove(child);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(int depth){
        String s = "";
        for(int i=0; i< depth; i++){
            s += "\t";
        }
        s += "ArrayComposite containing\n";
        for(int i=0; i<components.length; i++){
            if(components[i] != null){
                s += components[i].toString(depth + 1);
            }
        }
        return s;
    }
}
