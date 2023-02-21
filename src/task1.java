import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
        System.out.println("Hello, " + args[0]);

        System.out.println("x  =");
        double x = scanner.nextDouble();
        System.out.println("y = ");
        double y =  scanner.nextDouble();
        double z = ((3*Math.pow(Math.cos(x - Math.PI/6),2.0))/0.5 + Math.sin(y)*Math.sin(y));
        System.out.println("z = " + z);
    }
}
