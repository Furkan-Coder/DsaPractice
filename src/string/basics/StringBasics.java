package string.basics;

import java.util.*;

public class StringBasics {
    public static void main(String[] args) {
        String string = "Furkanu";
        String s2="kan";
        System.out.println(reverseString(string));
        System.out.println(firstNonRepeatingChar("First non repeating char = "+string));
        Map<Character,Integer>freq=freqCount(string);
        System.out.println(freq);
        System.out.println(removeDuplicate(string));
        System.out.println(containsdigit(string));
        System.out.println(stringRotation(string,s2));
    }
//        🔹 Basic String Processing
//        Reverse a string
    public static String reverseString(String s) {
    char ch[]=s.toCharArray();
    int i=0;
    int j=ch.length-1;
    StringBuilder stringBuilder = new StringBuilder();
    while (i<j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        i++;
        j--;
    }
    return new String(ch);
    }
//        Check palindrome
//
//
//        Check if two strings are anagrams
//
//
//        Find first non-repeating character
    public static  Character firstNonRepeatingChar(String s){
        char ch[]=s.toCharArray();
        for(int i=0;i<s.length();i++){
            int count=0;
            for (int j=0;j<s.length();j++){
                if(ch[j]==ch[i]){
                    count++;
                }
            }
            if(count==1){
                return (s.charAt(i));
            }
        }
        return '\0';
    }
//        Count frequency of characters
    public static Map<Character, Integer> freqCount(String string){
        Map<Character,Integer>map = new HashMap<>();
        char ch[]=string.toCharArray();
        for(int i=0;i<string.length();i++){
            map.put(ch[i], map.getOrDefault(ch[i],0)+1);
        }
       return map;
    }
//        Remove duplicates from string
    public static String removeDuplicate(String string){
        Set<Character>set = new HashSet<>();
    char ch[]=string.toCharArray();
    StringBuilder stringBuilder=new StringBuilder();
    for(int i=0;i<string.length();i++){
        if(!set.contains(ch[i])) {
            set.add(ch[i]);
            stringBuilder.append(ch[i]);
        }
    }
    return stringBuilder.toString();
}
//

//        Check if string contains only digits
            public  static String containsdigit(String string){
        char ch[]=string.toCharArray();
       for(int i=0;i<string.length();i++){
           if(ch[i]>'0'&& ch[i]<'9'){
               return "String is containing digits only";
           }
       }
       return "String is not containing digits";
            }
//        Check if string is rotation of another
        public static String stringRotation(String string, String s){
        String s2=string+string;
        if(s2.contains(s)){
            return "String is rotation of another";
        }
        return "String is not rotation of another";
        }
//        Convert string to integer (atoi)
//
//
//                Check if string is valid number

//
//


}
