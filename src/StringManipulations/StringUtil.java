package StringManipulations;

import java.util.*;

public class StringUtil {
    public static int countVowels(String word) {
        char[] charArr = word.toLowerCase().toCharArray();
        String vowels = "aeiou";
        int count = 0;
        for (char c : charArr) {
            if (vowels.contains(Character.toString(c))) { // OR (vowels.indexOf(ch) != -1)
                count++;
            }
        }
        return count;
    }

    public static String reverseString(String word) {
        return new StringBuilder(word.trim()).reverse().toString();

//        char[] charArr = word.toCharArray();
//        int p1 = 0;
//        int p2 = charArr.length - 1;
//        while (p1 <= p2) {
//            char temp = charArr[p1];
//            charArr[p1] = charArr[p2];
//            charArr[p2] = temp;
//            p1++;
//            p2--;
//        }
//        return new String(charArr);
    }

    public static String reverseWordOrder(String sent) {
        String[] strings = sent.trim().split(" ");
        Collections.reverse(Arrays.asList(strings));
        return String.join(" ", strings);
//        int p1 = 0;
//        int p2 = strings.length - 1;
//        while (p1 <= p2) {
//            String temp = strings[p1];
//            strings[p1] = strings[p2];
//            strings[p2] = temp;
//            p1++;
//            p2--;
//        }
//        return String.join(" ", strings);
    }

    public static boolean isRotatedStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] wordArr1 = word1.toCharArray();
        char[] wordArr2 = word2.toCharArray();

        int index1 = word1.indexOf(wordArr2[0]);
        for (int i = 0; i < wordArr2.length; i++) {
            if (wordArr2[i] != wordArr1[index1 % wordArr1.length]) {
                return false;
            }
            index1++;
        }
        return true;
    }

    public static String removeDuplicates(String word) {
        Set<Character> seen = new HashSet<>();
        char[] charArray = word.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            if (!seen.contains(c)) {
                result.append(c);
                seen.add(c);
            }
        }
        return result.toString();
    }

    public static char getMostRepeated(String word) {
        // Solution without the HashMap
        int[] alphabets = new int[26]; // If want to include all ASCII , use 256
        char[] arr = word.toLowerCase().toCharArray();
        for (char c :  arr) {
            alphabets[c - 'a']++; // if use ASCII, alphabets[c]
        }

        int max = Integer.MIN_VALUE;
        char result = ' ';
        for (char c : arr) {
            if (alphabets[c - 'a'] > max) {
                max = alphabets[c - 'a'];
                result = c;
            }
        }
        return result;
//        Map<Character, Integer> map = new HashMap<>();
//        char[] arr = word.toCharArray();
//        for (char c : arr) {
//            map.put(c, map.getOrDefault(c,0)+1);
//        }
//        int max = Integer.MIN_VALUE;
//        char result = ' ';
//        for (Map.Entry<Character, Integer> e : map.entrySet()) {
//            if (e.getValue() > max) {
//                max = e.getValue();
//                result = e.getKey();
//            }
//        }
//        return result;
    }

    public static String fixSentence(String sent) {
        String[] arr = sent.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : arr) {
            if (!word.isEmpty()) {
                builder.append(word.replace(word.substring(0,1), word.substring(0,1).toUpperCase())).append(" ");
            }
        }
        return builder.toString().trim();
    }

    public static boolean isAnagrams(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> word1map = new HashMap<>();
        Map<Character, Integer> word2map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            word1map.put(c, word1map.getOrDefault(c,0)+1);
        }
        for (char c : word2.toCharArray()) {
            word2map.put(c, word2map.getOrDefault(c,0)+1);
        }
        for (char c : word1.toCharArray()) {
            if (word1map.get(c) == null || word2map.get(c) == null) {
                return false;
            }
            if (!word1map.get(c).equals(word2map.get(c))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String word) {
        char[] arr = word.toCharArray();
        int p1 = 0;
        int p2 = arr.length - 1;

        while (p1 <= p2) {
            if (arr[p1] != arr[p2]) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
