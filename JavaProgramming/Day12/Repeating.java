import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        
        Integer maxLength =0;
        Integer maxFreq = 0;

        Integer left =0;
        Integer right = 0;
        HashMap<Character,Integer> hmap = new HashMap();
        while(right<s.length())
        {
            hmap.put(s.charAt(right),hmap.getOrDefault(s.charAt(right),0)+1);
            maxFreq = Math.max(maxFreq,hmap.get(s.charAt(right)));
            Integer noofreplaceablech = ((right - left)+1) - maxFreq; 
            if(noofreplaceablech>k)
            {
                hmap.put(s.charAt(left),hmap.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
            maxLength = Math.max(maxLength,right - left +1);
            right++;
        }
        return maxLength;
    }
}

public class Repeating{
    public static void main(String[] args) {
        System.out.println("MaxLength :"+new Solution().characterReplacement("ABBC",2));
    }
}