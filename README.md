# Sorting-Tool

#1 Sorting tool based on a command line arguments input. Added 3 functions:
-finding biggest integer in integer based set of data,
-finding the lingest word in String data,
-finding the longest line.

#trojka Added cmd argument -sortIntegers, used to access sorted data. Using ArrayList.

#czworka Uploaded final version. 

Program parses arguments from command line. Usable arguments are:
-dataType - long(numbers), line(Sting lines) or word(string).
-sortingType - natural(from smallest value to biggest) and byCount(sorting by number of repetitions).
Uses maps, lists, streams.

Default dataType is long, sortingType is natural.


Example:
java czworka -dataType long -sortingType bycount

input> 1 3 333 2 42
input> 11 1
input> 1           1

output:
Total numbers: 9.
2: 1 time(s), 11%
3: 1 time(s), 11%
11: 1 time(s), 11%
42: 1 time(s), 11%
333: 1 time(s), 11%
1: 4 time(s), 44%
