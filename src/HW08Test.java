/**
 * Created by Bradley on 10/10/2016.
 */
public class HW08Test {

    public static void main(String[] args){
//        testToString();
//        testIterOnLeaf();
//        testIterOnLC();
//        testIterOnAC();
//        testIterOnSC();
//        testWithNestedComposites();
        testPreOrder();
    }



    private static void testToString(){
        System.out.println("\n---------------Test To String---------------");
        Leaf a = new Leaf("A"); // ID: 0
        Leaf b = new Leaf("B"); // ID: 1
        Leaf c = new Leaf("C"); // ID: 2
        Leaf d = new Leaf("D"); // ID: 3
        Component lc = new LinkedComposite(a, b); // ID: 4
        Component ac = new ArrayComposite( c, lc, d ); // ID: 5
        System.out.println(ac.toString()); // 5 is the root.
        System.out.println(lc.toString()); // 4 is the child of 5 is the root.
        System.out.println(a.toString()); // 0 is the child of 4 is the child of 5.
    }

    private static void testIterOnLeaf(){
        System.out.println("\n---------------Test Iter on Leaf---------------");
        Leaf a = new Leaf("A");
        Iter<Component> iterA = a.makeIter();
        System.out.println(iterA.currentItem()); // NULL;
        System.out.println(iterA.isDone()); // TRUE;
        iterA.next();
        System.out.println(iterA.currentItem()); // NULL;
        System.out.println(iterA.isDone()); // TRUE;
        iterA.first();
        System.out.println(iterA.currentItem()); // NULL;
        System.out.println(iterA.isDone()); // TRUE;
    }

    private static void testIterOnSC(){
        System.out.println("\n---------------Test Iter on LC---------------");
        Leaf a = new Leaf("A"); // ID: 0
        Component sc = new SingleComposite();
        Iter<Component> iter = sc.makeIter();

        // Should not enter here.
        while(!iter.isDone()){
            System.out.println(iter.currentItem());
            iter.next();
        }
        System.out.println("Inserting child");
        sc.add(a);
        iter.first();
        // Should print a single child of depth 1
        while(!iter.isDone()){
            System.out.println(iter.currentItem());
            iter.next();
        }
    }

    private static void testIterOnLC(){
        System.out.println("\n---------------Test Iter on LC---------------");
        Leaf a = new Leaf("A"); // ID: 0
        Leaf b = new Leaf("B"); // ID: 1
        Leaf c = new Leaf("C"); // ID: 2
        Leaf d = new Leaf("D"); // ID: 3
        Component lc = new LinkedComposite(a, b, c, d); // ID: 4
        Iter<Component> iter = lc.makeIter();

        // Should print 4 children of depth 1.
        while(!iter.isDone()){
            System.out.println(iter.currentItem());
            iter.next();
        }
        System.out.println("Removing ID: 1");
        lc.remove(b);
        iter.first();

        // Should print 3 children of depth 1.
        while(!iter.isDone()){
            System.out.println(iter.currentItem());
            iter.next();
        }
    }

    private static void testIterOnAC(){
        System.out.println("\n---------------Test Iter on AC---------------");
        Leaf a = new Leaf("A"); // ID: 0
        Leaf b = new Leaf("B"); // ID: 1
        Leaf c = new Leaf("C"); // ID: 2
        Leaf d = new Leaf("D"); // ID: 3
        Component ac = new ArrayComposite(a, b, c, d); // ID: 4
        Iter<Component> iter = ac.makeIter();

        // Should print 4 children of depth 1.
        while(!iter.isDone()){
            System.out.println(iter.currentItem());
            iter.next();
        }
        System.out.println("Removing ID: 1");
        ac.remove(b);
        iter.first();

        // Should print 3 children of depth 1/
        while(!iter.isDone()){
            System.out.println(iter.currentItem());
            iter.next();
        }
    }

    private static void testWithNestedComposites(){
        System.out.println("\n---------------Test With Nested Composites---------------");
        Leaf a = new Leaf("A"); // ID: 0
        Leaf b = new Leaf("B"); // ID: 1
        Leaf c = new Leaf("C"); // ID: 2
        Leaf d = new Leaf("D"); // ID: 3
        Component lc = new LinkedComposite(a, b); // ID: 4
        Component ac = new ArrayComposite( c, lc, d ); // ID: 5

        Iter<Component> iter = ac.makeIter();
        // Should print 3 children of depth 1.
        while(!iter.isDone()){
            System.out.println(iter.currentItem());
            iter.next();
        }

        Iter<Component> iter2 = lc.makeIter();
        // Should print 2 children of depth 2.
        while(!iter2.isDone()){
            System.out.println(iter2.currentItem());
            iter2.next();
        }
    }

    private static void testPreOrder(){
        System.out.println("\n---------------Test To String---------------");
        Leaf a = new Leaf("A"); // ID: 0
        Leaf b = new Leaf("B"); // ID: 1
        Leaf c = new Leaf("C"); // ID: 2
        Leaf d = new Leaf("D"); // ID: 3
        Component lc = new LinkedComposite(a, b); // ID: 4
        Component ac = new ArrayComposite( c, lc, d ); // ID: 5

        Iter<Component> iter = ac.makePreorderIterator();
        while(!iter.isDone()){
            System.out.println(iter.currentItem());
            iter.next();
        }
    }
}
