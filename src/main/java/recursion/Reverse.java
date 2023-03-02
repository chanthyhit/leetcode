package recursion;

public class Reverse {
    public static void main(String[] args) {
        String str = "Hello World!";
        String rev = reverse(str);
        //System.out.printf(rev);
        int x = rev(1534236469);
        System.out.println(x);
        System.out.println(Integer.MAX_VALUE);
    }

    static String reverse(String str){
        if(str.length()<=1) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }



    static int rev(int x){
        String str = String.valueOf(x);
        boolean neg = str.contains("-");
        String revStr = new StringBuilder(str.replace("-","")).reverse().toString();
        long revInt = neg ? Long.parseLong(revStr) * -1 : Long.parseLong(revStr);
        return (int) revInt;
    }
}
