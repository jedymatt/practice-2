
public class TestCircle {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println(c1.toString());
        System.out.println(c1.getArea());
        System.out.println(c1.getVolume());
        System.out.println("==========");
        Cylinder c2 = new Cylinder(10.0);
        System.out.println(c2.toString());
        System.out.println(c2.getArea());
        System.out.println(c2.getVolume());
        System.out.println("==========");
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println(c3.toString());
        System.out.println(c3.getArea());
        System.out.println(c3.getVolume());
    }
}
