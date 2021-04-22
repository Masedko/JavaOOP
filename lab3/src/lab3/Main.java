package lab3;
import java.util.*;

public class Main {
    private static String capitalize(String text){
        text = text.substring(0, 1).toUpperCase() + text.substring(1);
        return text;
    }

    private static String SentenceSwap(String sentence, Set<String> SetOfCapitalWords){
        // first and last word
        String FirstWord = sentence.split("[\\s.,:]+", 2)[0];
        String LastWord = sentence.substring(sentence.lastIndexOf(" " ) + 1);
        // Converting array to set to reference to elements.
        sentence = sentence.replaceFirst(FirstWord, capitalize(LastWord));
        if (SetOfCapitalWords.contains(FirstWord)){
            sentence = sentence.replaceAll(" \\S*$", ' ' + FirstWord);
        }
        else{
            sentence = sentence.replaceAll(" \\S*$", ' ' + FirstWord.toLowerCase());
        }
        return sentence;
    }

    private static StringBuilder SwapFirstAndLastWord(StringBuilder SampleText, Set<String> SampleCapitalWords){
        String[] sentences = SampleText.toString().split("(?<=[^A-Z])([!.?]\\s*)");
        StringBuilder SampleText2 = new StringBuilder();
        SampleText.append(" ");
        for (String sentence: sentences) {
            sentence = SentenceSwap(sentence, SampleCapitalWords);
            // Adding separator between sentences
            SampleText2.append(sentence);
            SampleText2.append(SampleText.charAt(SampleText2.length()));
            SampleText2.append(SampleText.charAt(SampleText2.length()));
        }
        // Deleting space at the end
        SampleText2.deleteCharAt(SampleText2.length() - 1);
        return SampleText2;
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("Ben, test R. Richard ipsum I think dolor sit amet, consectetur adipiscing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis" +
                " nostrudexercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Australia aute irure dolor" +
                " inreprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. John sint" +
                " occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum?");
        Set<String> CapitalWords = Set.of(
              "Ben", "John", "Sunny", "Australia", "Ukraine"
        );
        System.out.println(SwapFirstAndLastWord(text, CapitalWords));
    }
}
