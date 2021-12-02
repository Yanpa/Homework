public class Main {
    public static void main(String[] args) {
        boolean x = true;
        int a = 0, b = 0;

        if (x | (a++ == 1)) {
            b = 20;
        } else {
            b = 10;
        }

        System.out.println(a);
        System.out.println(b);
        
    }
}
