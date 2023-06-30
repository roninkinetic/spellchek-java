import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

// haha, chek
// dad jokes
public class SpellChek {
    
    // hashtable of words
    private static Hashtable<String, String> W = new Hashtable<String, String>();

    // constructor, excepts an array of dictionary words
    public SpellChek(String[] words) {
        for (String word : words) {
            add(word);
        }
    }

    // add word all lowercase
    public void add(String word) {
        W.put(word.toLowerCase(), word.toLowerCase());
    }

    // check if word is in hashtable
    public boolean check(String word) {
        return W.containsKey(word);
    }

    // get word from hashtable
    public String get(String word) {
        return W.get(word);
    }

    // check if one character away
    private boolean isOneCharacterAway(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (Math.abs(len1 - len2) > 1)
            return false;

        // i & k are function interators
        int i = 0, k = 0;
        // d is the number of differences
        int d = 0;

        // while i is less than the length of word1 and k is less than the length of word2
        while (i < len1 && k < len2) {
            // if the character at i in word1 is not equal to the character at k in word2
            if (word1.charAt(i) != word2.charAt(k)) {
                // increment d
                if (d == 1)
                    return false;
                d++;
                // increment i or k depending on which word is longer
                if (len1 > len2) {
                    i++;                    
                } else if (len1 < len2) {
                    k++;
                } else {
                    i++;
                    k++;
                }
            } else {
                // increment both i & k
                i++;
                k++;
            }
        }
        d += len1 - i + len2 - k;
        // if d is equal to 1, return true
        return d == 1;
    }

    public List<String> spellChek(String word) {
        List<String> suggestions = new ArrayList<>();

        if (check(word))
            return suggestions;

        

        // Check for words with one character added, removed, or replaced
        for (String dictionaryWord : W.keySet()) {
            if (isOneCharacterAway(word, dictionaryWord)) {
                suggestions.add(dictionaryWord);
            }
        }
        return suggestions;
    }

}