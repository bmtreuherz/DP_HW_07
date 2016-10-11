/**
 * Created by bradl on 10/5/2016.
 */
public class LinkedComposite extends Composite {
    LinkedList<Component> components;

    public LinkedComposite(Component... components){
        this.components = new LinkedList<>();

        for(int i=0; i<components.length; i++){
            this.components.add(components[i]);
            components[i].setParent(this);
        }
    }

    @Override
    public boolean add(Component child){

        components.add(child);
        super.add(child);
        return true;
    }

    @Override
    public boolean remove(Component child){

        // Try to find this reference in the array
        for(int i=0; i<components.size(); i++){
            if(components.get(i) == child){
                components.remove(i);
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
        s += "LinkedComposite containing\n";
        for(int i=0; i<components.size(); i++){
            s += components.get(i).toString(depth + 1);
        }
        return s;
    }
}
