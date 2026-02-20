package byteridge;

import java.awt.datatransfer.StringSelection;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "I love java";
        System.out.println(reverseWord(s));
        System.out.println(reverseString(s));
        String string = "fuuuurkaaaaanali";
        System.out.println(longestSubString(string));
        String string1[]={"Anam","Gadag","malayalam","naman"};
        List<List<String>> res1=groupAnagram(string1);
        System.out.println(res1);
        System.out.println(longestPalindromicSubString(string));
        System.out.println(stringCompression(string));
    }
//    STRINGS
//1 Reverse Words in a Sentence
    public static String reverseWord(String str){
        StringBuilder stringBuilder=new StringBuilder();
        String[] words=str.split(" ");
        for(int i=words.length-1;i>=0;i--){
            stringBuilder.append(words[i]);
            if(i!=0)stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
//    Reverse the words of a given string without using extra space.
    public static  String reverseString(String str){
        char ch[]=str.toCharArray();
        int i=0;
        int j=str.length()-1;
        while(i<j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
        return new String(ch);
    }
//2 Longest Substring Without Repeating Characters
//    Return the length of the longest substring without duplicate characters.
    public  static  int longestSubString(String str){
        Set<Character>set = new HashSet<>();
        int i=0;
        int maxLen=0;
        for(int j=0;j<str.length();j++){
            while (set.contains(str.charAt(j))){
                set.remove(str.charAt(i));
                i++;
            }
            set.add(str.charAt(j));
            maxLen=Math.max(maxLen,j-i+1);
        }
        return maxLen;
    }
//            3 Group Anagrams
//    Given an array of strings, group anagrams together.
        public static List<List<String>> groupAnagram(String[]strings){
            Map<String,List<String>>map = new HashMap<>();
            for(String string:strings){
                char[] chars = string.toCharArray();
                Arrays.sort(chars);
                String key=new String(chars);
                map.computeIfAbsent(key,k->new ArrayList<>()).add(string);
            }
            return new ArrayList<>(map.values());
        }
//4 Minimum Window Substring
//    Given strings s and t, find the smallest substring of s containing all characters of t.

//5 String Compression
//    Implement in-place string compression similar to LeetCode 443.
    public static  String stringCompression(String str){
        int count=1;
        String res="";
        for (int i=1;i<str.length();i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                res += str.charAt(i - 1) + String.valueOf(count);
                count = 1;
            }
        }

            res+=str.charAt(str.length()-1)+String.valueOf(count);
        return res;
    }
//            6 Longest Palindromic Substring
//    Return the longest palindromic substring.
        public static String longestPalindromicSubString(String string) {
            String longest = "";
            for (int i = 0; i < string.length(); i++) {
                for (int j = i; j < string.length(); j++) {
                    String subString=string.substring(i,j+1);
                    if (isPalindrome(subString)&& subString.length()>longest.length()){
                        longest=subString;
                    }
                }
            }
            return longest;
        }
        public  static boolean isPalindrome(String string){
        char ch[]=string.toCharArray();
        int i=0;
        int j=string.length()-1;
        while (i<j){
            if(string.charAt(i)!=string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        }
//7 Decode String
//    Input: "3[a2[c]]"
//
//    Output: "accaccacc"
//
//            8 Rabin–Karp / Pattern Matching
//    Implement substring search using rolling hash.
//

}
