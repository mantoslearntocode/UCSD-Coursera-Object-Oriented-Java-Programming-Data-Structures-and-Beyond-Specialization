package textgen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	private HashMap<String, Integer> wordIndexMap;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
		wordIndexMap = new HashMap<>();
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		if (sourceText == null || sourceText.equals(""))
		{
			//System.out.println("null");
			// throw new NullPointerException();
			return;
		}
		String[] words = sourceText.split("[ ]+");
		/* === for test only === */
//		for (int i = 0; i < words.length; i++)
//		{
//			System.out.println(words[i]);
//		}
		/* === end of test === */
		starter = words[0];
		
		for (int i = 0; i < words.length; i++)
		{
			String curWord = words[i];
			String nextWord = starter;
			if (i < (words.length - 1))
			{
				nextWord = words[i+1];
			}
			if (wordIndexMap.containsKey(curWord))
			{
				int curWordIndex = wordIndexMap.get(curWord);
				ListNode curListNode = wordList.get(curWordIndex);
				curListNode.addNextWord(nextWord);
			}
			else
			{
				int newIndex = wordList.size();
				ListNode newNode = new ListNode(curWord);
				newNode.addNextWord(nextWord);
				wordList.add(newNode);
				wordIndexMap.put(curWord, newIndex);
			}
		}
	}
	
//	private boolean hasWord(String thisWord)
//	{
//		ListNode curNode = new ListNode<>
//		
//		return false;
//	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords)
	{
	    // TODO: Implement this method
		if (numWords < 0 || starter == null || starter.equals(""))
		{
			//throw new NullPointerException();
			return "Invalid Input: Please give a Valid Training Text first.";
		}
		
		String newGen = starter + " ";
		String curWord = starter;
		
		for (int i = 1; i < numWords; i++)
		{
			int curWordIndex = wordIndexMap.get(curWord);
			ListNode curListNode = wordList.get(curWordIndex);
			String nextWord = curListNode.getRandomNextWord(rnGenerator);
			newGen += nextWord + " ";
			curWord = nextWord;
		}
		
		return newGen.trim();
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
		starter = "";
		wordList.clear();
		wordIndexMap.clear();
		this.train(sourceText);
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
//		String textString = "hi there hi Leo";
//		System.out.println(textString);
//		gen.train(textString);
//		System.out.println(gen);
//		System.out.println(gen.generateText(20));
//		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
//		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
//		System.out.println(textString);
//		gen.train(textString);
//		System.out.println(gen);
//		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println("Original:\n" + textString2);
		gen.train(textString2);
		System.out.println("=== ===\nTrain: \n" + gen.generateText(20));
		gen.retrain(textString2);
		//System.out.println(gen);
		System.out.println("=== ===\nReTrain: \n" + gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		int nextIndex = generator.nextInt(nextWords.size());
		
	    return nextWords.get(nextIndex);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


