public class InfiniteString {
    public static void main(String args[]) {
        String s = "abc";
        System.out.println(repeatedString(s, 10));
    }
    static long repeatedString(String s, long n) {

        long res = 0;
        long len = 0;
        String tmp = s;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'A') {
                len++;
            }
        }
        if ((n / len) > 1) {
            res = (n / s.length()) * len;
        }
        if (n % s.length() > 0) {
            long index = n % s.length();
            for (int i = 0; i < index; i++) {
                if (s.charAt((int)i) == 'a' || s.charAt((int)i) == 'A') {
                    res++;
                }
            }
        }

        return res;
    }
}
