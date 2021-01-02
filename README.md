# UCSD-Coursera-Object-Oriented-Java-Programming-Data-Structures-and-Beyond-Specialization

Week2:
Main goal: calculate number of sentences/words/Syllables in a given text.
What I did:
The main practice is around String.Split method. How to get the correct substrings to calculate the sentences/words and Syllables. The first two were relatively easy. The last one has a few more requirements including checking if a lone e is at the end. I implemented some helper functions e.g. checkLoneEIfEnd, startWithCheck(to check if a word start with a vowel) and ifVowel(to check if a letter is vowel), the basic syllable split regular experissions I use is: word.toLowerCase().split("[^aeiouy]"), what this line doing is generate a string array of strings splitted by the vowels. The only problem of this implemention is that if the original word not start with vowel, it will generate one more syllable which is an empty first string. Pay attention to this. Then the other thing is to check if the ending lone e matters.

The 2nd goal of this week is to implement the flesche score. which is very easy because the hard work of calculating numbers of sentences/words/Syllables has been done already. For this task, we just need to put these numbers into Flesche fomular. The only thing I need to notice is that if I want to get a double value by integer/another integer, just simply add integer * 1.0 /another integer then the answer would be double.


week 3:
Mainly 2 things:
	first one is implementing the "EffiecientDocument", the difference from the BasicDocument I implemented above is this time, read the numSentences/numWords/numSentences at the same time by calling getText(), not a big deal.
	Second thing is to write a benchmarking processing time analysis for efficient and basic Document. The built-in java method System.nanoTime is called by both before and after one series of operations. 
One thing to note: estTime = (endTime - startTime) / 100000000.0;

week 4:
Implementing my linkedList.
C2 w4 programming for myLinkedList and the JUnit Test(SO FRUSTRATING taking so much time on that. Hopefully I can learn more form this session), also, the mylinkedList function are full of pitfalls, be careful next time to implement it.
LLNode<E>
MyLinkedList<E> extends AbstractList<E>
{
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	public MyLinkedList()
	{
	// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		head.next = tail;
		tail.prev = head;
	}
	Pay attention to those nodes' next and prev whenever you are trying to add or remove an element, you have to change their next/prev and probably their next' pre and pre's next
}

2nd part of this week's project is implementing Markov text processor which I have experience at Duke's Java Course, so this is not a big deal, what we do is for a given paragraph, for each word, we map this word to its following words. Then when we are generating Markov Text, Just randomly picking up words from its followers.

Week 5
1st part is C2 w5 Programming part 1 Spell Checking. which I have to implementing the Dictionary balanced binary tree and dictionary Linked List. Which is just using Java built-in data structures of TreeSet() and LinkedList along with their methods.

2nd part of this week is implementing DictionaryTrie, which is a little difficult than the 1st part, but the most difficult part has been implemented already: The TrieNode class define. So technically speaking, what I do for DictionaryTrie is based on what we already have. Pay attention to the TrieNode Implementation and its methods, maybe I can use it in the future.


Week 6
1st part of C2 w6 is implementing the spelling suggestion module. It is relatively easy by just doing distanceOne remove/substitution/delete one character from the given string, if not enough string found, then doing a second DistanceOne on all the words derived from the original string. 

2nd part of C2 w6 is implementing the Word Path Game, The core of this assignment is the creation of the findPath method. findPath will function very similarly to the suggestions method you authored in the prior NearbyWords assignment. The fundamental difference between these two methods is that suggestions simply searched for nearby words, whereas findPath must find, and return, the path to a specific word. To be able to return the path, we need to have a way of reconstructing how we got to the target word - and we'll do this by creating a tree as we search.
