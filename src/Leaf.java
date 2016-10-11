/**
 * Created by bradl on 10/5/2016.
 */
public class Leaf extends Component {
    private String value;

    public Leaf(String value){
        this.value = value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public String toString(int depth){
        String s = "";
        for(int i=0; i<depth; i++){
            s += "\t";
        }
        return s + "Leaf " + getValue() + "\n";
    }
}
