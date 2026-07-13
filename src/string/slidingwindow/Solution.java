package string.slidingwindow;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
    String string="furkanali";
    String res1=subStringWithoutRepeatingCharacter(string);
        System.out.println(res1);

    int k=2;
        System.out.println(longestSubStringWithK(string,k));

//        System.out.println(minimumWindowSubString(string));
        String str[]={"fly", "flower", "flight"};
        System.out.println(longestCommonPrefix(str));
    }
//  1.  Longest substring without repeating characters
    public  static  String subStringWithoutRepeatingCharacter(String string){
        Set<Character>set = new HashSet<>();
        int left=0;
        int longest=0;
        int startIndex=0;
        for(int right=0;right<string.length();right++){
            while(set.contains(string.charAt(right))) {
                set.remove(string.charAt(left));
                left++;
            }
                set.add(string.charAt(right));
                if(right-left+1>longest){
                    longest=right-left+1;
                    startIndex=left;
                }
        }
        return string.substring(startIndex,startIndex+longest);
    }
//  2.  Longest substring with at most K distinct characters
    public static String longestSubStringWithK(String string,int k){
        int left=0;
        int maxLen=0;
        int startIndex=0;
        Map<Character,Integer>freqMap=new HashMap<>();
        for(int right=0;right<string.length();right++){
            char ch=string.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
            while (freqMap.size()>k){
                char leftChar=string.charAt(left);
                freqMap.put(leftChar,freqMap.get(leftChar)-1);

                if(freqMap.get(leftChar)==0){
                    freqMap.remove(leftChar);
                }
                left++;
            }
            if(right-left+1>maxLen){
               maxLen=right-left+1;
               startIndex=left;
            }
        }
        return string.substring(startIndex,startIndex+maxLen);
    }
//  3.  Minimum window substring
//    public static String minimumWindowSubString(String s){
//        int left=0;
//        int min=0;
//        int startIndex=0;
//        for(int right=0;right<s.length();right++){
//
//        }
//    }
//  4.  Find all anagrams in a string
//    public static  String allAnagram(String str){
//
//    }

//   5. Longest repeating character replacement
//
//
//   6. Smallest substring containing all characters of another string
//
//
//   7. Count substrings with exactly K distinct chars
//
//
//   8. Longest palindromic substring
//
//
//   9. Count palindromic substrings
//
//
//   10. Check if permutation of string exists in another

//   11. Given an array of strings (for example: ["fly", "flower", "flight"]),
//    write an algorithm to find the longest common prefix among all the strings.
    public static  String longestCommonPrefix(String[]str){
        Arrays.sort(str);
        String first=str[0];
        String last=str[str.length-1];
        int i=0;
        while(i<first.length()&& i<last.length() &&
        first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }
}
