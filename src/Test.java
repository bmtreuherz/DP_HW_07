/**
 * Created by bradl on 10/5/2016.
 */
public class Test {
    public static void main(String[] args){
        simpleExample();
        verifyInvariantOnCreation();
        verifyInsertion();
        verifyRemoval();
    }


    // Shows the output for the simple example provided in the HW instructions.
    private static void simpleExample(){
        System.out.println("\n---------------Simple Example Test---------------");
        Component lc = new LinkedComposite( new Leaf( "A" ), new Leaf( "B" ) );
        Component ac = new ArrayComposite( new Leaf( "C" ), lc, new Leaf( "D" ) );
        ac.toString();
        System.out.println(ac.toString());
    }

    // This test checks to make sure a child knows its parent when a composition is instantiated.
    public static void verifyInvariantOnCreation(){
        System.out.println("\n---------------Verify Invariant on Creation---------------");

        Leaf l1 = new Leaf("A");

        // Verify with single composite
        Component sc = new SingleComposite(l1);
        System.out.println(sc.toString());

        // Verify the Leaf views that component as its parent.
        if(l1.getParent() != sc){
            System.out.println("Test failed. Child should know who its parent is.\n");
        }else{
            System.out.println("Test passed: Parent invariant preserved.\n");
        }

        // Verify with array composite
        Leaf l2 = new Leaf("B");
        Component ac = new ArrayComposite(l2, sc);
        System.out.println(ac.toString());

        // Verify the Leaf views that component as its parent.
        if(l2.getParent() != ac || sc.getParent() != ac){
            System.out.println("Test failed. Child should know who its parent is.\n");
        }else{
            System.out.println("Test passed: Parent invariant preserved.\n");
        }

        // Verify with linked composite
        Leaf l3 = new Leaf("C");
        Component lc = new LinkedComposite(l3, ac);
        System.out.println(lc.toString());

        // Verify the Leaf views that component as its parent.
        if(l3.getParent() != lc || ac.getParent() != lc){
            System.out.println("Test failed. Child should know who its parent is.\n");
        }else{
            System.out.println("Test passed: Parent invariant preserved.\n");
        }
    }


    // Checks that a Leaf, when inserted into a composite, will view that composite as its parent.
    public static void verifyInsertion(){
        System.out.println("\n---------------Verify Insertion---------------");
        // Create a leaf.
        Component l = new Leaf("A");
        if(l.getParent() != null){
            System.out.println("Test failed. Child should initially have null parent.\n");
        }else{
            System.out.println("Check passed: Child's parent is initially null.\n");
        }

        // Create an linked list composite and insert the leaf.
        Component lc = new LinkedComposite( new Leaf( "B" ), new Leaf( "C" ) );
        lc.add(l);

        // Print the composite so we know it contains the new component.
        System.out.println(lc.toString());

        // Verify the Leaf views that component as its parent.
        if(l.getParent() != lc){
            System.out.println("Test failed. Child should know who its parent is.\n");
        }else{
            System.out.println("Test passed: Parent invariant preserved.\n");
        }

        // W will now test this with array composites by inserting the lc into an ac.
        Component l2 = new Leaf("E"); // We need to keep a reference to this component as it will be removed.
        Component ac = new ArrayComposite(new Leaf("D"), l2);

        // Remove the Leaf E so there is room in the array
        ac.remove(l2);
        ac.add(lc);

        // Display the ac
        System.out.println(ac.toString());

        // Verify the child-parent invarient.
        if(lc.getParent() != ac){
            System.out.println("Test failed. Child should know who its parent is.\n");
        }else{
            System.out.println("Test passed: Parent invariant preserved.\n");
        }
    }

    // Same as above but with a composite.
    public static void verifyRemoval(){
        System.out.println("\n---------------Verify Invariant on Removal---------------");
        Leaf l1 = new Leaf("A");
        Leaf l2 = new Leaf("B");
        Component lc = new LinkedComposite(l1, l2);

        System.out.println("LC Before removal");
        System.out.println(lc.toString());

        // The invariant on instantiation has already been verified in other tests. Go straight to removing it.
        lc.remove(l1);
        System.out.println("LC After removal.\n" + lc.toString());

        // Verify the child-parent invarient.
        if(l1.getParent() != null){
            System.out.println("Test failed. Child should not keep a reference once removed.\n");
        }else{
            System.out.println("Test passed: Parent invariant preserved.\n");
        }

        // Verify this again with a composite instead of a leaf.
        Component ac = new ArrayComposite(l1, lc);
        System.out.println("AC Before removal");
        System.out.println(ac.toString());

        ac.remove(lc);
        System.out.println("AC After removal\n" + ac.toString());

        // Verify the child-parent invarient.
        if(ac.getParent() != null){
            System.out.println("Test failed. Child should not keep a reference once removed.\n");
        }else{
            System.out.println("Test passed: Parent invariant preserved.\n");
        }
    }
}
