package codingpractice;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterFrequencyCounter {
    public static void main(String[] args) {
        String str = "My name is Krishna";
        Map<Character, Integer> charCountMap = countCharacterOccurrences(str);

        // Print character frequencies
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }

    public static Map<Character, Integer> countCharacterOccurrences(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        // Convert to lowercase to make it case-insensitive
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (ch != ' ') { // Ignore spaces
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }
        return charCountMap;
    }
}
