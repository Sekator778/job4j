/**
 *
 */

public class InternString {
    public static void main(String[] args) {
        String s1 = "Rachel";
        String s2 = "Rachel";
        String s3 = new String("Rachel");
        String s4 = new String("Rachel").intern();
        String s5 = "Sekator".intern();
        String s6 = "Sekator".intern();
        String s7 = s5.intern();

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // true
        System.out.println(s7 == s5); // true
        System.out.println("s5 " + s5);
        System.out.println("s5.hashCode()" + s5.hashCode());
        System.out.println("s7 " + s7);
        System.out.println("s7.hashCode()" + s7.hashCode());

        s5 = null;
        System.out.println("s5 " + s5);
//        System.out.println("s5.hashCode()" + s5.hashCode());
        System.out.println("s7 " + s7);
        System.out.println("s7.hashCode()" + s7.hashCode());



    }
}
