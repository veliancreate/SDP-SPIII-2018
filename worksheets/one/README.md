# Worksheet One - The Basics

Some *simple* questions just to get you used to using Kotlin and the development environment.

1. Implement the `accumulate` operation, which, given a collection and an
operation to perform on each element of the collection, returns a new
collection containing the result of applying that operation to each element of
the input collection.

 Given the collection of numbers:
```
1, 2, 3, 4, 5
```
 And the operation:
```
square a number (`x => x * x`)
```
 Your code should be able to produce the collection of squares:
```
1, 4, 9, 16, 25
```
Check the test suite to see the expected function signature.

 Do not use the collect/map/fmap/whatchamacallit functionality provided by the 
 standard library! Solve this one yourself using the basic tools instead.

2. Given a phrase, count the occurrences of each word in that phrase.

 For example for the input `"olly olly in come free"`

 ```text
olly: 2
in: 1
come: 1
free: 1
```

3. Given a number, find the sum of all the unique multiples of particular numbers up to
but not including that number.

 If we list all the natural numbers below 20 that are multiples of 3 or 5,
we get 3, 5, 6, 9, 10, 12, 15, and 18.

 The sum of these multiples is 78.

4. Given a word and a list of possible anagrams, select the correct sublist.

 Given `"listen"` and a list of candidates like `"enlists" "google"
"inlets" "banana"` the program should return a list containing
`"inlets"`.

5. Convert a hexadecimal number, represented as a string (e.g. "10af8c"), to its decimal equivalent using first principles (i.e. no, you may not use built-in or external libraries to accomplish the conversion).

 On the web we use hexadecimal to represent colours, e.g. green: 008000,
teal: 008080, navy: 000080).

 The program should handle invalid hexadecimal strings.
 
6. Compute the prime factors of a given natural number.

 A prime number is only evenly divisible by itself and 1.

 Note that 1 is not a prime number.


 What are the prime factors of 60?
	- Our first divisor is 2. 2 goes into 60, leaving 30.
	- 2 goes into 30, leaving 15.
  		- 2 doesn't go cleanly into 15. So let's move on to our next divisor, 3.
	- 3 goes cleanly into 15, leaving 5.
  		- 3 does not go cleanly into 5. The next possible factor is 4.
  		- 4 does not go cleanly into 5. The next possible factor is 5.
	- 5 does go cleanly into 5.
	- We're left only with 1, so now, we're done.

 Our successful divisors in that computation represent the list of prime
factors of 60: 2, 2, 3, and 5.

 You can check this yourself:
	- 2 * 2 * 3 * 5
	- = 4 * 15
	- = 60
	- Success!
	
7. Compute Pascal's triangle up to a given number of rows.

 In Pascal's Triangle each number is computed by adding the numbers to the right and left of the current position in the previous row.

 ```text
        1
       1 1
      1 2 1
     1 3 3 1
 1 4 6 4 1
 # ... etc
 ```
 
8. Implement a doubly linked list.

 Like an array, a linked list is a simple linear data structure. Several
common data types can be implemented using linked lists, like queues,
stacks, and associative arrays.

 A linked list is a collection of data elements called *nodes*. In a
*singly linked list* each node holds a value and a link to the next node.
In a *doubly linked list* each node also holds a link to the previous
node.

 You will write an implementation of a doubly linked list. Implement a
`Node` to hold a value and pointers to the next and previous nodes. Then
implement a `List` which holds references to the first and last node and
offers an array-like interface for adding and removing items:
 * `push` (*insert value at back*);
 * `pop` (*remove value at back*);
 * `shift` (*remove value at front*).
 * `unshift` (*insert value at front*);

 To keep your implementation simple, the tests will not cover error conditions. 
 Specifically: `pop` or `shift` will never be called on an empty list.
 