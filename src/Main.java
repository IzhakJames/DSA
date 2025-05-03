
import Linear.util.CharacterFinder;

public class Main {
    public static void main(String[] args) {
        char result = CharacterFinder.findFirstNonRepeatingCharacter("a green apple");
        char result2 = CharacterFinder.findFirstRepeatingCharacter("a green apple");
        System.out.println(result);
        System.out.println(result2);
    }
}