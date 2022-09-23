package binarySearch;

public class MakePalindrome {

    public int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int low = 0;
        int high = 1;
        int c = 0;
        while (low < high) {
            if (arr[low] == arr[high]) {
                low++;
                high--;

            } else {
                int l = low, h = high;
                int cl = 0, ch = 0;
                while (arr[l++] != arr[high] && l < arr.length) {
                    cl++;
                }
                while (arr[h--] != arr[low] ) {
                    ch++;
                }
                if (cl < ch) {
                    for (int i = l - 1; i >= low; i--) {
                        swap(arr, i, i + 1);
                    }
                    c += cl;
                } else {
                    for (int i = h + 1; h <= high; i++) {
                        swap(arr, i - 1, i);
                    }
                    c += ch;
                }
            }
        }
        return c;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    public static void main(String[] args){
        MakePalindrome obj = new MakePalindrome();
        System.out.println(obj.minMovesToMakePalindrome("abab"));
    }

}
