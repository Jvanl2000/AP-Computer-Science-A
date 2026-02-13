3.1.13 What does the following code fragment print?
String string1 = "hello";
String string2 = string1;
string1 = "world";
StdOut.println(string1);
StdOut.println(string2);

world
hello



3.1.14 What does the following code fragment print?
String s = "Hello World";
s.toUpperCase();
s.substring(6, 11);
StdOut.println(s);

Answer: "Hello World". String objects are immutable—string methods each re-
turn a new String object with the appropriate value (but they do not change the

value of the object that was used to invoke them). This code ignores the objects
returned and just prints the original string. To print "WORLD", replace the second
and third statements with s = s.toUpperCase() and s = s.substring(6, 11).





S2. Describe what we get if we do a horizontal flip and then a diagonal flip. What is the relation of the final output to the original input. (Don’t say that it’s double-flipped. Make an interesting observation.)

it rotates the image 90 degrees counter-clockwise






S3. Your interesting observation for S2 should make this one easy. How many successive pairs of horizontal flip/diagonal flips would we have to do to get back to the original picture?

4





S4. Which one or more of the following converts all of the strings in the array a to uppercase?

# THIS ONE
for (int i = 0; i < a.length; i++) {
   String s = a[i];
   s = s.toUpperCase();
}

# NOT THIS ONE
for (int i = 0; i < a.length; i++) {
   a[i].toUpperCase();
}


# THIS ONE
for (int i = 0; i < a.length; i++) {
   a[i] = a[i].toUpperCase();
}





