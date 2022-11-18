import java.util.*;
import java.io.*;
public class WordCounterEE{
//have an arraylist that holds everyword in the script
//go through each line and then each word within the lines
//use scanners
//then w each word, add to existing arraylist if not already there
    //if AL.indexOf(i) = -1
//have a parallel array that has the counts of each word (same length as noDuplicates array)


//need AL with all words in entire script (w/ duplicates)
//need AL with all words (w/out duplicates)
//AL parallel to noDuplicates AL with count of how many times each word was said
//return index of largest value in count; overall return word at that index

    public static void main(String[] args) throws FileNotFoundException{
        //String filename args[0];
        //countWords(filename);
        ArrayList<String> allWords = parseList("/Users/etrauber/Desktop/CSSeminar/Unit2/twilight.txt");
        ArrayList<String> noDuplicates = noDuplicates(allWords);
        ArrayList<Integer> count = counts(allWords);
        
        System.out.println("the most used word in Twilight is: " + getWord(count, noDuplicates));
    }

    public static ArrayList<String> parseList(String pathname) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(pathname));
        ArrayList<String> words = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] arrLine = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            ArrayList<String> alOfLine = new ArrayList<>(Arrays.asList(arrLine));
            Scanner scn = new Scanner(line);
            while(scn.hasNext()){
                words.add(scn.next());
            }
        }
        sc.close();
        return words;
    }

    public static ArrayList<String> noDuplicates(ArrayList<String> allWords){
        ArrayList<String> noDuplicates = new ArrayList<>();

        //goes through the original ArrayList and takes out any instance of repetition
        for(int i = 0; i < allWords.size(); i++){
            //if item is not already in the noDuplicates ArrayList...
            if(noDuplicates.indexOf(allWords.get(i)) == -1){
                //...add that value to the noDuplicates ArrayList
                noDuplicates.add(allWords.get(i));
            }
        }
        return noDuplicates;
    }

    public static ArrayList<Integer> counts(ArrayList<String> allWords){
        ArrayList<String> noDuplicates = new ArrayList<>(); //to make parallel to and for if/else expression

        //could call getRidOfDuplicates method but for sake of clarity and debugging going to keep same code here
        for(int i = 0; i < allWords.size(); i++){
            if(noDuplicates.indexOf(allWords.get(i)) == -1){
                noDuplicates.add(allWords.get(i));
            }
        }
        //ArrayList<Integer> counts = new ArrayList<>(Arrays.asList(new Integer[noDuplicates.size()]));
        //commented code above works for making counts AL parallel to noDuplicates, however, values are null (bc Integer is object type, not primitive)

        //for loop so AL are the same size, however values aren't null
        ArrayList<Integer> counts = new ArrayList<>();
        for(int i = 0; i<noDuplicates.size(); i++){
            counts.add(0);
        }

        for(int i = 0; i<allWords.size(); i++){
        //finding index of the item in the noDuplicates AL
            int index = noDuplicates.indexOf(allWords.get(i));
            //getting value (num times that item has been said in allWords AL) in counts at that same index (bc parallel arrays)
            Integer value = counts.get(index);
            //incrementing that value by 1
            value = value + 1;
            //setting that value at that same index
            counts.set(index, value);
        }
        return counts;
    }

    //method to go through values in counts AL, get the index, and return the value at that index in noDuplicates AL (the most common word)
    public static String getWord(ArrayList<Integer> counts, ArrayList<String> noDuplicates){
        //comparison variable
        int largestNum = 0;
        //index that will be used to get returned word
        int index = 0;
        for(int i = 0; i<counts.size(); i++){
            //compares value in counts to the current largest value
            if(counts.get(i) > largestNum){
                largestNum = counts.get(i);
                index = i;
            }
        }
<<<<<<< HEAD
=======
        //word to be returned
>>>>>>> fc297a0b6c0e29f2552503b614d7e77253e06d85
        String word = noDuplicates.get(index);
        return word;
    }
}