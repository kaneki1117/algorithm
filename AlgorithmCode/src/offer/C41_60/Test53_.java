package offer.C41_60;
//学会正则
public class Test53_ {
    public static void main(String[] args) {

    }
    public boolean isNumeric(char[] str) {
        String pattern = "[\\+-]?[0-9]*(\\.)?(\\d)*([eE][\\+-]?\\d+)?";
        return String.valueOf(str).matches(pattern);
    }
}
