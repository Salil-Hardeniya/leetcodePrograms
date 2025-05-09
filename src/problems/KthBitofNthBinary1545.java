package problems;

public class KthBitofNthBinary1545 {
    public static void main(String[] args) {
        KthBitofNthBinary1545 kthBitofNthBinary = new KthBitofNthBinary1545();
        char ch = kthBitofNthBinary.findKthBit(4,11);
        System.out.println(ch);
    }

    public char findKthBit(int n, int k) {
        String str = findNthString(n);
        return str.charAt(k-1);
    }

    private String findNthString(int n) {
        if (n == 1)
            return "0";
        String n_1 = findNthString(n-1);
        return n_1 + "1" + reverseAndInvert(n_1);
    }

    public String reverseAndInvert(String binaryString) {
        int length = binaryString.length();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (binaryString.charAt(length - 1 - i) == '0') ? '1' : '0';
        }
        return new String(result);
    }
}
