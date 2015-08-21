package Reflect;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    public Toy() {
        // TODO Auto-generated constructor stub
    }
    
    public Toy(int i) {
        
    }
}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
        // TODO Auto-generated constructor stub
    }
}

public class ToyTest {
    @SuppressWarnings("rawtypes")
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("Reflect.FancyToy");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
    }
}
