import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, " + args[0]);
        System.out.println("x  =");
        double x = scanner.nextDouble();
        System.out.println("y = ");
        double y =  scanner.nextDouble();
        double z = ((3*Math.pow(Math.cos(x - Math.PI/6),2.0))/0.5 + Math.sin(y)*Math.sin(y));
        System.out.println("z = " + z);

//        1 var
        System.out.println("Hello, " + args[0]);
        System.out.println("Номер вашего варианта " + args[1]);
        double a = Double.parseDouble(args[2]);
        double n = Double.parseDouble(args[3]);
        x = Double.parseDouble(args[4]);
        double b = Double.parseDouble(args[5]);
        double c = Double.parseDouble(args[6]);
        z = ((5 * Math.pow(a, n * x)) / (b + c)) - (Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3)))));
        System.out.println(z);

//        2 var
        System.out.println("Hello, " + args[7]);
        System.out.println("Номер вашего варианта " + args[8]);
        x = Double.parseDouble(args[9]);
        y = Double.parseDouble(args[10]);
        a = Double.parseDouble(args[11]);
        double f = Double.parseDouble(args[12]);
        z = ((Math.abs( x - y) / Math.pow((1 + 2 * x), a)) - Math.pow(Math.E, Math.sqrt(1 + f)));
        System.out.println(z);

//        3 var
        System.out.println("Hello, " + args[13]);
        System.out.println("Номер вашего варианта " + args[14]);
        double a0 = Double.parseDouble(args[15]);
        double a1 = Double.parseDouble(args[16]);
        x = Double.parseDouble(args[17]);
        double a2 = Double.parseDouble(args[18]);
        z =  (Math.sqrt(a0 + a1 * x + a2 * Math.pow((Math.abs(Math.sin(x))), 1/3)));
        System.out.println(z);

//        4 var
        System.out.println("Hello, " + args[19]);
        System.out.println("Номер вашего варианта " + args[20]);
        a = Double.parseDouble(args[21]);
        x = Double.parseDouble(args[22]);
        z =  Math.log10(Math.pow(a,7)) + (1 / Math.tan(x*x)) + Math.PI / Math.sqrt(Math.abs(a + x));
        System.out.println(z);

//        5 var
        System.out.println("Hello, " + args[23]);
        System.out.println("Номер вашего варианта " + args[24]);
        a = Double.parseDouble(args[25]);
        b = Double.parseDouble(args[26]);
        c = Double.parseDouble(args[27]);
        double d = Double.parseDouble(args[28]);
        x = Double.parseDouble(args[29]);
        z = Math.pow(( Math.pow((a+b),2)/(c+d)) + (Math.pow(Math.E,Math.sqrt(x+1))),(1/5));
        System.out.println(z);

//        6 var
        System.out.println("Hello, " + args[30]);
        System.out.println("Номер вашего варианта " + args[31]);
        x = Double.parseDouble(args[32]);
        z = Math.pow(Math.E, ((2*Math.sin(4*x + Math.cos(x*x) * Math.cos(x*x)))/(3*x)));
        System.out.println(z);

//        7 var
        System.out.println("Hello, " + args[33]);
        System.out.println("Номер вашего варианта " + args[34]);
        x = Double.parseDouble(args[35]);
        z =  ((1/4) * (((1+Math.pow(x,2))/(1-x)) + ((1/2)*(Math.sin(x)/Math.cos(x)))));
        System.out.println(z);
    }
}
