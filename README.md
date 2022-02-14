# Simple-Search-Engine

## Stage Five Description

Now your program can successfully search for all matching lines, ignoring cases and extra spaces. There is one problem though: you need to check whether each line contains a query string or not.

To optimize your program, you can use a data structure called Inverted Index. It maps each word to all positions/lines/documents in which the word occurs. As a result, when we receive a query, we can immediately find the answer without any comparisons.

At this stage, build an inverted index when the program starts, and then use the index for searching operations. You can implement it using a Map class. It connects an item with a list (or set) of indexes belonging to the lines that contain the item.

Suppose you have the following array or list of lines:

0: Katie Jacobs
1: Erick Harrington harrington@gmail.com
2: Myrtle Medina
3: Erick Burgess
For these lines, the inverted index will look like this:

Katie -> [0]
Jacobs -> [0]
Erick -> [1, 3]
Harrington -> [1]
harrington@gmail.com -> [1]
Myrtle -> [2]
Medina -> [2]
Burgess -> [3]
The order of pairs is not important. If you are searching for Erick, you can immediately get the target fields using this mapping.

Note that the Inverted Index is not intended to search for parts of a word, it is only used to search for full words.

## Stage Six Description

Improve your search engine to support complex queries containing a sequence of words and a strategy that determines how to match data.

Take, for example, these six sample lines:

Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess
Let's consider the searching strategies: ALL, ANY and NONE.

If the strategy is ALL, the program should print lines containing all the words from the query.
Query:

Harrington Erick
Result:

Erick Harrington harrington@gmail.com
If the strategy is ANY, the program should print the lines containing at least one word from the query.
Query:

Erick Dwight webb@gmail.com
Result:

Erick Harrington harrington@gmail.com
Erick Burgess
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
If the strategy is NONE, the program should print lines that do not contain words from the query at all:
Query:

djo@gmail.com ERICK
Result:

Katie Jacobs
Myrtle Medina
Rene Webb webb@gmail.com
All listed operations are implemented in the inverted index. The results should not contain duplicates.
Note, do not forget to use methods to decompose your program.
