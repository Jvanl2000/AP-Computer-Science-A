import java.util.ArrayList;

public class WordChecker {
    
    /** Initialized in the constructor and contains no null elements */
    private ArrayList<String> wordList;

    public WordChecker(ArrayList<String> words) {
        wordList = words;
    }

    /**
    * Returns true if each element of wordList (except the first) contains the previous
    * element as a substring and returns false otherwise, as described in part (a)
    * Precondition: wordList contains at least two elements.
    * Postcondition: wordList is unchanged. */
    public boolean isWordChain() { 
        for (int i = 1; i < wordList.size(); i++) {
            if (!wordList.get(i).contains(wordList.get(i - 1))) 
                return false;
        }

        return true;
    }

    /**
    * Returns an ArrayList<String> based on strings from wordList that start
    * with target, as described in part (b). Each element of the returned ArrayList has had
    * the initial occurrence of target removed.
    * Postconditions: wordList is unchanged.
    * Items appear in the returned list in the same order as they appear in wordList. */
    public ArrayList<String> createList(String target) {
        ArrayList<String> returnList = new ArrayList<String>();

        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).startsWith(target))
                returnList.add(wordList.get(i).substring(target.length()));
        }

        return returnList;
    }

    @Override
    public String toString() {
        return wordList.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> someWords = new ArrayList<String>();
        someWords.add("an");
        someWords.add("band");
        someWords.add("band");
        someWords.add("abandon");
        WordChecker wcObject = new WordChecker(someWords);
        System.out.println(wcObject);
        System.out.println(wcObject.isWordChain());

        someWords = new ArrayList<String>();
        someWords.add("to");
        someWords.add("too");
        someWords.add("stool");
        someWords.add("tools");
        wcObject = new WordChecker(someWords);
        System.out.println(wcObject);
        System.out.println(wcObject.isWordChain());

        someWords = new ArrayList<String>();
        someWords.add("catch");
        someWords.add("bobcat");
        someWords.add("catchacat");
        someWords.add("cat");
        someWords.add("at");
        wcObject = new WordChecker(someWords);
        System.out.println(wcObject);
        System.out.println(wcObject.createList("cat"));
        System.out.println(wcObject.createList("catch"));
        System.out.println(wcObject.createList("dog"));
    }
}