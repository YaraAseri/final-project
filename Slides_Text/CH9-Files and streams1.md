CS 111 :   Programming   Language   II

•   Introduction  •   Some definitions  •   Files and streams in Java  •   Examples  O UTLINE  1

I NTRODUCTION : Why do we need files  ▪   Data stored in variables and arrays is temporary.  ▪   It is lost when the program ends or the variable goes out of  scope.  ▪   For long - term data storage, computers use files.  ▪   Files are stored on secondary storage devices such as hard  disks, flash drives, and DVDs.  ▪   Data stored in files is called persistent data because it exists  after the program ends.  2

➢ Java   applications   read   data   and   write   data .  ➢ Input   means   receiving   data   (e . g . ,   from   keyboard   or   file) .  ➢ Output   means   sending   data   (e . g . ,   to   screen   or   file) .  ➢ Input   and   output   are   the   basic   operations   used   when   working   with  files .  3

▪   Stream :   A stream is a flow of data between a program and  a file or device.  ▪   It acts as a connection between the data source and the  destination.  4 Program  Input object  created from an  input class  Output object  created from an  output class  Input stream  Output stream  File  File 01011…1001  11001…1011

▪   Input stream:   used to receive data into the program.  ▪   Example : System.in → keyboard input  ▪   Output   stream :   used to send data from the program  ▪  Example :   System.out   → screen output  ▪   A stream connects a program to an I/O device.  5

There are two types of files:  Text files:  ➢   Store data as readable characters (ASCII)  ➢   Can be opened using a text editor  ➢   Cannot be processed directly as numbers  ➢   Text   →   for humans  Binary files:  ➢   Store data in raw binary format  ➢   Not readable by humans  ➢   Can be processed directly by the program  ➢   Binary   →   for computers  6

Files and Streams  ➢   Java views a file as a stream of bytes.  ➢   Data is read sequentially (one part at a time).  ➢   The program reads data until it reaches the end of the  file.  9

Files and Streams (cont.)  ➢   When a Java program starts, it creates three  standard streams:  ▪   System.in → input (keyboard)  ▪   System.out   → output (screen)  ▪   System.err   → error messages  ➢   Java uses classes to read and write files.  Scanner :  ▪   Used to read data (input)  ▪   Can read from keyboard or file  Formatter :  ▪   Used to write formatted data to a file   10

When working with files, errors may occur:  ▪   File not found   →   File does not exist  ▪   No permission   →   No access to read/write the file  ▪   Disk problems   →   Issue with storage device  ▪   These errors are called   IOExceptions .  ▪   IOExceptions   are checked exceptions,   →   T he program must  handle them  ▪   Handling using:   try - catch   or   throws  12

14  Example:  Writing to a File  Now, let ’ s see a simple  example of writing data to a  file.  In this example, we:  ▪   Open a file  ▪   Write data to the file  ▪   Close the file  ▪   Handle any possible errors  using try - catch

Now, let’s read data from a file and  display it on the screen.  In this example, we:  ▪   Open the file  ▪   Read data from the file  ▪   Display it on the screen  ▪   Handle errors using try - catch  14  Example:  Reading from a File

Write a Java program that:  1 . Reads student data from a file called "students.txt"  2 . Each line contains: id, name, and grade  3 . Stores the data in an   ArrayList   of Student objects  4 . Writes the data to another file called "output.txt"  Hint:  -   Use Scanner to read from the file  -   Use Formatter to write to the file  -   Use try - catch to handle errors   14  Example: Reading and Writing Files

Example  input file   (  students.txt   ):  101   Ali   85  102   Sara   90  103   Omar   78  Output File:  output.txt  101   Ali   85.0  102   Sara   90.0  103   Omar   78.0  14  Example: Reading and Writing Files

Student Class  14  Example: Reading and Writing Files

Reading from File  14  Example:  Reading and  Writing Files

Writing to File  14  Example: Reading and Writing Files

Text   Book :  Chapter   17  T HAT ’ S   ALL   FOR   THIS  SEMESTER !