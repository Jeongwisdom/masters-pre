package Mission1;

public class CharArray {
    public static void main(String[] args) {
        char [] arr = new char [26];
        char a = 'A';

        for(int i = 0; i < arr.length; i++) {
            arr[i] = a;
            a++;
        }
        System.out.println(arr);
    }
}
