import java.util.HashMap;

/**
 * ArrayString
 */
public class ArrayString {

    public static boolean oneAway(String s1, String s2)
    {
        if(s1.length() == s2.length())
        {
            // need to replace
            return oneAwayReplace(s1, s2);
        }
        else if(s1.length() == s2.length()+1)
        {
            // need to insert
            return oneAwayInsert(s1, s2);
        }
        else if(s1.length() == s2.length()-1)
        {
            // need to remove
            return oneAwayRemove(s1, s2);
        }
        else{
            // cant perform the operation
            return false;
        }
    }
    public static boolean oneAwayReplace(String s1, String s2)
    {
        HashMap<Character, Integer> s1Map = new HashMap<>();

        for(char c:s1.toCharArray())
        {
            s1Map.put(c, s1Map.getOrDefault(c, 1));
        }

        for(char c:s2.toCharArray())
        {
            if(s1Map.containsKey(c))
            {
                s1Map.put(c, s1Map.get(c)-1);
            }
        }

        int count = 0;
        for(char c:s1Map.keySet())
        {
            if(s1Map.get(c)>0)
            {
                count++;
            }
        }

        return count == 1;
    }
    public static boolean oneAwayInsert(String s1, String s2)
    {
        HashMap<Character, Integer> s1Map = new HashMap<>();

        for(char c:s1.toCharArray())
        {
            s1Map.put(c, s1Map.getOrDefault(c, 1));
        }

        for(char c:s2.toCharArray())
        {
            if(s1Map.containsKey(c))
            {
                s1Map.put(c, s1Map.get(c)-1);
            }
        }

        for(char c:s1Map.keySet())
        {
            if(s1Map.get(c)>0)
            {
                return true;
            }
        }

        return false;
    }
    public static boolean oneAwayRemove(String s1, String s2)
    {
        HashMap<Character, Integer> s1Map = new HashMap<>();

        for(char c:s1.toCharArray())
        {
            s1Map.put(c, s1Map.getOrDefault(c, 0)+1);
        }

        for(char c:s2.toCharArray())
        {
            if(s1Map.containsKey(c))
            {
                s1Map.put(c, s1Map.get(c)-1);
            }
        }

        for(char c:s1Map.keySet())
        {
            if(s1Map.get(c)>0)
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // System.out.println(oneAway("pale", "ale")); // insertion works
        // System.out.println(oneAway("pale", "paled")); removal works
        // System.out.println(oneAway("pale","pala")); replace works
    }
}