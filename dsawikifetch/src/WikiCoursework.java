package dsa.cw2324;

import java.io.IOException;
import dsa.cw2324.WikiFetcher;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WikiCoursework
{

  public static void main(String[] args) throws IOException
  {
    // Creating a map of maps called outerMap
    Map<String, Map<String, Integer>> outerMap = new TreeMap<>();

    // Iterating 10 times to count the frequency of word occurrences
    for (int i = 0; i < 10; i++)
    {
      WikiFetcher wf = new WikiFetcher();
      String url = wf.getUrl();
      String[] words = wf.getWords();

      // Creating an innermap which will store the occurances of the words
      Map<String, Integer> innerMap = new TreeMap<>();

      // This will check to see the frequency of each word in the string of words
      for (String word : words)
      {
        // Check to see if the innermap contains that word
        if (innerMap.containsKey(word))
        {

          // If the innermap contains that word then it will add it to the innermap increment the value by 1
          innerMap.put(word, innerMap.get(word) + 1);
        }
        else
        {
          // Otherwise it will store the word in the innermap with a occurance of 1
          innerMap.put(word, 1);
        }
      }
      // Creating a treemap for a list of words
      Map<String, Integer> frequency_of_words = new TreeMap<>();

      // Retrieving words with a frequency greater than or equal to 10
      for (Map.Entry<String, Integer> x : innerMap.entrySet())
      {
        // If the value is greater than or equal 10, it will be added to the frequency_of_words map
        if (x.getValue() >= 10)
        {
          frequency_of_words.put(x.getKey(), x.getValue());
        }
      }
      // Adding the URls to the corresponding frequency_of_words map to the outer map
      outerMap.put(url, frequency_of_words);

    }
    WikiFetcher.deepPrint(outerMap); // outputs the outer map, which basically contains all the URLs and their particular word frequency maps

  }

}