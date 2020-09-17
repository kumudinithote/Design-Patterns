
Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:
Go to folder where ant is locally downloaded

- cd /Documents/apache-ant-1.10.7/bin

Run following commnd (changed folder path and file names accordingly.

./ant -buildfile /Documents/workspace/wordPlay/build.xml run -Darg0=“<input file name>“ -Darg1="<output file name>“  -Darg2=“<matric file name>”


Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
Developed a program to reverse the word in sentence from file and calculated the metrix AVG_NUM_WORDS_PER_SENTENCE, AVG_NUM_CHARS_PER_SENTENCE,MAX_FREQ_WORD and LONGEST_WORD. The output and metrix file have been created to display the required results.

Used an Array, StringBuilder, HashMap Data Structure for this project

Time completexity : O(n)
Space complexity : Worse case is O(n) :- where their is no new line character are reading from a complete file and spliting it by '.'

Worte test cases for following senarios:
1.Is file invalid or not
2.Is File empty or not
3.If word contains any special characters
