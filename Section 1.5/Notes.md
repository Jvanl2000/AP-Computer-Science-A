# 1.5 — Input & Output

## 1.5.9 — StdIn Dragon
### Question
- Suppose that the file input.txt contains the two strings F and F. What does
the following command do (see Exercise 1.2.35)?
### Result
```
$ java Dragon < input.txt
FLF FRF

$ java Dragon < input.txt | java Dragon
FLFLFRF FLFRFRF

$ java Dragon < input.txt | java Dragon | java Dragon
FLFLFRFLFLFRFRF FLFLFRFRFLFRFRF

$ java Dragon < input.txt | java Dragon | java Dragon | java Dragon
FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRF FLFLFRFLFLFRFRFRFLFLFRFRFLFRFRF
```
### Explanation
- This "loops" the `Dragon` method and uses the output of the previous one for the inputs of the next

## 1.5.14 — 
### Print the maximum and minimum numbers.
- No Array Needed
### Print the sum of the squares of the n numbers.
- No Array Needed
### Print the average of the n numbers.
- No Array Needed
### Print the median of the n numbers.
- Array Needed
### Print the percentage of numbers greater than the average.
- No Array Needed
### Print the n numbers in increasing order.
- Array Needed
### Print the n numbers in random order.
- Array Needed