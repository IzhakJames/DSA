
import StringManipulations.StringUtil;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String word = "Trees are beautiful";
        System.out.println(StringUtil.countVowels(word));
        System.out.println(StringUtil.reverseString(word));
        System.out.println(StringUtil.reverseWordOrder(word));

        String word1 = "ABBA";
        String word2 = "ADCB";
        System.out.println(StringUtil.isRotatedStrings(word1,word2));
        System.out.println(StringUtil.isAnagrams(word1, word2));
        System.out.println(StringUtil.isPalindrome(word1));

        String longWord = "Hellllllllloooo";
        System.out.println(StringUtil.removeDuplicates(longWord));
        System.out.println(StringUtil.getMostRepeated(longWord));

        String badSentence = " trees     are beautiful ";
        System.out.println(StringUtil.fixSentence(badSentence));



    }
}