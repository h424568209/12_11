import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCode {
    /**
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
     * @param s  字符串
     * @return 不同回文字符串的数
     */
    public int countSubstrings(String s) {
        int num = 0;
        for(int i = 0 ; i < s.length() ; i++){
            //计算奇数长度的回文
            num+= counts(s,i,i);
            //计算偶数长度的回文
            num+= counts(s,i,i+1);
        }
        return num;
    }

    private int counts(String s, int start, int end) {
        int num = 0;
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            num++;
            start--;
            end++;
        }
        return num;
    }

    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成
     * 将字符串拷贝一份，掐头去尾，如果还含有这个字符串则就是由一个字符串重复多次构成
     * @param s 字符串
     * @return 是否可以由他的一个子串重复多次构成
     */
    public boolean repeatedSubstringPattern(String s) {
        String res = s+s;
        return res.substring(1,res.length()-1).contains(s);
    }
    /*
    public String shortestPalindrome(String s) {
        int len = s.length();
        String tmp = s+s;
        int x = tmp.length();
        StringBuffer res = new StringBuffer(s);
        res.reverse();
        String t = "";
        for(int i = 0 ; i <res.length()-1 ; i++ ){
            t+=res.charAt(i);
        }
        s = t+s;
        int lens = s.length();
        String res1 = "";
        for(int i =lens -  len ; i >= 0 ; i--){
            if(isHuiwen(s.substring(i,lens))) {
                res1 = s.substring(i, lens).toString();
                break;
            }
        }
        String res2 = "";
        for(int i = len; i >= 0 ; i--){
            if(isHuiwen(tmp.substring(i,x))) {
                res2 = tmp.substring(i, x);
                break;
            }
        }
        if(res2.length() >res1.length())
            return res1;
        else{
            return res2;
        }
    }
*/
    private boolean isHuiwen(String s) {
      int start = 0 ;
      int end = s.length()-1;
      while(start < end){
          if(s.charAt(start) != s.charAt(end)){
              return false;
          }
          start++;
          end --;
      }
      return true;
    }

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 输入的字符可以在前面后者后面包含多余的字符，但是反转后的字符不能包括
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
     * String.trim() 方法是将字符串的前候空格去掉
     * @param s 字符串
     * @return 反转后的字符串
     */
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        //去掉s的首尾空格 然后将字符串拆分
        String[] s1 = s.trim().split(" ");
        for(int i = s1.length - 1; i >= 0; i--){
            //空格后面的空格会变成空字符串
            //刚刚开始写的是!s1[i].equals(" ")，然后返现字符串中间的多余的空格没办法解决
            //最后发现应该写成 ""
            //空格不是空
            if(!s1[i].equals("")) ans.append(s1[i] + " ");
        }
        //去掉最后添加上的空格
        ans = new StringBuilder(ans.toString().trim());
        return ans.toString();
    }



    public static void main(String[] args) {
        System.out.println(LeeCode.reverseWords("in my eyes i wan"));
        LeeCode l = new LeeCode();
     //   System.out.println(l.shortestPalindrome("abcd"));
        System.out.println(l.repeatedSubstringPattern("abcabc"));
        System.out.println(l.countSubstrings("abbbbba"));
    }
}
