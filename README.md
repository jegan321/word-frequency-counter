# Word Frequency Counter

## Description
Accepts a piece of text as a CLI argument and outputs each word and the number of times it occurred. The words
are printed in order of frequency, highest to lowest. The order of words with the same frequency is not guaranteed.

## Usage
For Java 11 and above:
```bash
java WordFrequencyCounter "the cat is in the bag"
```
Below Java 11:
```bash
javac WordFrequencyCounter.java
java -cp . WordFrequencyCounter "the cat is in the bag"
```
