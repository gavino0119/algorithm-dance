package javademo.stringCase;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2022/3/5 9:35
 */
public class StringCase {
    public static void main(String[] args) {


        String s7 = "1" + "2";
        String s8 = "12";
        // s7==s8 true

        String s9 = new String("1") + new String("2");
        s9.intern();
        String s10 = "12";
        // s9==s10 false

        String s91 = new String("345") + new String("678");
        s91 = s9.intern();
        String s101 = "345678";
        // s91==s101 true
        System.out.println(s91==s101);

        String s11 = new String("135") + new String("246");
        String s12 = "135246";
        s11.intern();
        // s11==s12 false

        String s111 = new String("456") + new String("789");
        String s121 = "456789";
        s111.intern();
        // s111==s121 true
        System.out.println(s111==s121);
    }
}
