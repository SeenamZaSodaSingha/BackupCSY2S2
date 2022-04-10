import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Scanner;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class WordCount {
    private HashMap<String, Integer> wordcount;

    public WordCount(String fileName) {
        wordcount = new HashMap<>();
        Path inFile = Paths.get(".", fileName);
        Charset charset = Charset.forName("UTF-8");
        String line;
        int cnt;
        try (BufferedReader br = Files.newBufferedReader(inFile, charset)) {
            while ((line = br.readLine()) != null) { //still have next line
                if (isVailidLine(line)) { //valid line
                    String[] words = line.split(" ");
                    for (String word : words) {
                        word = word.replaceAll("[^a-zA-Z0-9-]", ""); //replace special characters
                        wordcount.putIfAbsent(word, 0); //if word not in map, put 0
                        cnt = wordcount.get(word);
                        wordcount.put(word, ++cnt); //increase count
                    }

                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static boolean isVailidLine(String line) {
        if (line.equals(" ")) {
            return false;
        }
        if (line.startsWith("Page |")) {
            return false;
        } else if (line.equals("/")) {
            return false;
        }
        return true;
    }

    private Set<String> getKeySet() {
        return wordcount.keySet();
    }

    public Set<String> getSetDifferent(WordCount o) {
        Set<String> x = wordcount.keySet();
        x.removeAll(o.getKeySet());
        return x;
    }

    public int getNumberofWord() {
        return wordcount.size();
    }

    // function to sort hashmap by values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    private void getTopFive(){
        System.out.println("Top 5 words: ");
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordcount.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }.reversed());
        for(int i = entryList.size() - 2; i >= entryList.size() - 6; i--) {
            System.out.println(entryList.get(i).getKey() + " " + entryList.get(i).getValue());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bookName = sc.nextLine();
        WordCount wc3 = new WordCount(bookName + ".txt");
        System.out.println("book 3 word count: " + wc3.getNumberofWord());
        wc3.getTopFive();
        System.out.println("----------------------------------");
        bookName = sc.nextLine();
        WordCount wc4 = new WordCount(bookName + ".txt");
        System.out.println("book 4 word count: " + wc4.getNumberofWord());
        wc4.getTopFive();
        System.out.println("--------- W O R D D I F F ------------");
        System.out.println("Different words book 3/book 4: ");
        Set<String> diff = wc3.getSetDifferent(wc4);
        System.out.println(diff);
        System.out.println("----------------------------------");
        System.out.println("Different words book 4/book 3: ");
        diff = wc4.getSetDifferent(wc3);
        System.out.println(diff);
        sc.close();
    }
}