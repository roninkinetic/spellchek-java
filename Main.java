public class Main {
    
    private static String[] words = new String[10];    

    public static void checkIt(String word) {
        // setup the words array
        // super ineffecient code that builds a new dictionary on the fly
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        SpellChek spellChek = new SpellChek(words);        
        if (spellChek.check(word)) {
            System.out.println(word + " is spelled correctly");
        } else {
            System.out.println(word + " is spelled incorrectly");
            System.out.println("Did you mean: ");
            for (String s : spellChek.spellChek(word)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        // spellCheck returns a list of words that are one character away from the word passed in
        // if the list is empty then the word is correct
        
        String testWord = "one";
        checkIt(testWord);
        testWord = "on";
        checkIt(testWord);
        testWord = "onr";
        checkIt(testWord);
        testWord = "onre";
        checkIt(testWord);
    }   
}
