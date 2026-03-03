package string.logicalprgramming;

public class LogicalProgramming {
    public static void main(String[] args) {
        String string="a1b2c3d4e5f";
        System.out.println(reverseLetterOnly(string));

    }
    public static String reverseLetterOnly(String string){
        int left=0;
        int right=string.length()-1;
        char ch[]=string.toCharArray();
        while (left<right){
            if(!Character.isLetter(ch[left])||!Character.isLetter(ch[right])){
                left++;
                right++;
                continue;
            }
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        return new String(ch);
    }
}
