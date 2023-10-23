import java.util.HashMap;
import java.util.HashSet;

public class StringCompression {


    // assume lenght of s is n
    // time = O (n)
    // space = O (n)
    public static String stringCompression(String s)
    {
        int count = 1;
        char pre = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(pre);
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i) == pre)
            {
                count++;
            }
            else{
                sb.append(count);
                count = 1;
                pre = s.charAt(i);
                sb.append(pre);
            }
        }
        sb.append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringCompression("aabcccccaaa"));
    }
    
}
