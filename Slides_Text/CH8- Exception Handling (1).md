CS 111 : Programming Language II

▪   What Is an Exception?  ▪   What happens when an Exception occurs?  ▪   Exception Categories  ▪   Exception Handling with try/catch Block  ▪   Common Exceptions  ▪   Example  2

▪   When a program runs, unexpected situations may occur, such as dividing by zero or  receiving invalid input from the user. These situations cause runtime errors, which can  terminate the program abruptly.  ▪   In real - world applications, such   behavior   is unacceptable. For example, banking  systems, registration systems, and mobile applications must continue running even if an  error occurs.  ▪   Exception handling allows us to detect these problems and respond to them properly  instead of letting the program crash.  3

4  What happens when...  1. The user enters char by mistake?  2 .   The user enters the value   0   as the denominator?

➢ An   exception   is   an   error   that   occurs   during   the   execution   of   a  program(run - time)   that   interrupts   the   normal   Java   program   flow .  ➢ If   an   exception   is   not   handled,   the   program   will   terminate   abnormally .  ➢ Such   error   can   be   handled   within   the   program   and   you   can   take   necessary  corrective   actions   so   that   the   program   can   continue   with   its   execution   →  exception   hadling .  5

If   an   exception   occurs   while   your   program   is   executing   …  ➢ Execution   of   the   program   is   terminated .  ➢ A   stack   trace,   with   the   details   of   the   exception,   is   printed  in   the   console .  6

The   stack trace   provides   information that includes:  ▪   The exception's name in a descriptive message that  indicates the problem that occurred  ▪   The method - call stack (i.e., the call chain) at the time it  occurred. Represents the path of execution that led to the  exception method by method.  ▪   This information helps you debug the program.  7

▪   Example : Divide by Zero  In Java, the following code throws an exception because we can ’ t  divide an integer by zero:  8  public   class   CH 8 Examples {  public static void main (String   args []) {  int d =   0 ;  int a =   130 /d;  System.out.print (a);  }}  Exception occurs at this statement.  SO This statement will not be  executed  A stack trace, with the details of the exception, is printed in the  console.

When You Don ’ t Handle Exceptions  ▪   When Java encounters an error or condition that prevents execution from  proceeding normally, Java " throws "   an exception .  ▪   If the exception isn't " caught " by the programmer, the program crashes.  ▪   The exception description and current stack trace are printed to the  console.  9

1  0 LinkageError  Error  Throwable  ClassNotFoundException  VirtualMachin eError  IOException  Exception  RuntimeException  Object  ArithmeticException  NullPointerException  IndexOutOfBoundsException  Many more classes  Many more classes  Many more classes  IllegalArgumentException

11 LinkageError  Error  Throwable  ClassNotFoundException  VirtualMachin eError  IOException  Exception  RuntimeException  Object  ArithmeticException  NullPointerException  IndexOutOfBoundsException  Many more classes  Many more classes  Many more classes  IllegalArgumentException  System errors   are thrown  by JVM and represented  in the   Error   class. The  Error   class describes  internal system errors.  Such errors rarely occur.  Liang, Introduction to Java Programming, Eleventh Edition, (c) Pearson All  right reserved

12 LinkageError  Error  Throwable  ClassNotFoundException  VirtualMachin eError  IOException  Exception  RuntimeException  Object  ArithmeticException  NullPointerException  IndexOutOfBoundsException  Many more classes  Many more classes  Many more classes  IllegalArgumentException  Exception   describes errors  caused by your program  and external  circumstances. These  errors can be caught and  handled by your program.  Liang, Introduction to Java Programming, Eleventh Edition, (c) Pearson All  right reserved  Dr. HYA,   2024

13 LinkageError  Error  Throwable  ClassNotFoundException  VirtualMachin eError  IOException  Exception  RuntimeException  Object  ArithmeticException  NullPointerException  IndexOutOfBoundsException  Many more classes  Many more classes  Many more classes  IllegalArgumentException  RuntimeException   is caused  by programming errors, such  as bad casting, accessing an  out - of - bounds array, and  numeric errors.  Liang, Introduction to Java Programming, Eleventh Edition, (c) Pearson All  right reserved  Dr. HYA,   2024

▪   Java exceptions fall into two categories:  ▪   Checked Exceptions:  ▪   are exceptions that are checked   at compile time.  ▪   If the exceptions aren ’ t handled in the program,   it gives a compilation error.  ▪   Examples :   IOException  ▪   Unchecked Exceptions:  ▪   Unchecked exceptions are exceptions that   are not checked at compile time.  ▪   In most cases, unchecked exceptions reflect   programming logic errors that  are not recoverable.  ▪   Examples:  ▪   ArrayIndexOutOfBoundsException ,  ▪   NullPointerExceptio  ▪   Arithmetic Exception  14  Copyright   ©   2015 ,   Oracle and/or its affiliates. All rights   reserved.

15  RuntimeException ,   Error   and their   subclasses   are known as unchecked   exceptions .  All other exceptions are known as  checked exceptions.  Liang, Introduction to Java Programming, Eleventh Edition, (c) Pearson All  right reserved

▪   The general structure of a try - catch block in Java:  try   {  // Statements that may throw exceptions  }  catch   (Exception type e) {  // The code to handle the exception  }  finally   {  // The finally clause is always executed regardless whether an  exception occurred or not.  }  16

▪   Exception Handling Flow Diagram  Dr. MFH,   2023   17  https://www.onlinetutorialspoint.com/wp -  content/uploads/ 2015 / 04 /Exception -  Flow.png

▪   For code that ’ s likely to cause an exception, you can write the code  inside a special "   try   " block.  ▪   You associate exception handlers with a try block by providing one or  more catch blocks after the try block.  ▪   Each catch block handles the type of exception indicated by its  argument.  ▪   The   ExceptionType   argument type declares the type of exception.  ▪   If you want some code to be executed regardless of  whether an exception occurs or is caught, you can  use finally clause.  18

▪   The   try   statement is to define a block of code to be tested for  errors while it is being executed.  ▪   The   catch   statement is to define a block of code to be  executed, if an error occurs in the try block.  ▪   and if there is a code that we want to execute regardless of  having or no caught an exception, we use:   finally   statement  ▪   The   try   and   catch   keywords come in pairs.   as follows:  try  { // Block of code to try   }  catch (Exception   e)  {   // Block of code to handle errors   }  19

20

•   Attempt to access a nonexistent array index  java.lang.ArrayIndexOutOfBoundsException \  •   Attempt to use an object reference that wasn ’ t instantiated  java.lang.NullPointerException  •   Failed or interrupted I/O operations  java.io.IOException  21

▪   Try to   be as specific   as possible with the type of error you're trying to  catch.  ▪   This allows the program to provide you with   specific feedback on what  went wrong.  ▪   Catch a generic exception is often too imprecise to be useful but can be  done as a last resort.  catch   (Exception e)  {   System. out .println (e);   }  Dr. MFH,   2023   22  Copyright   ©   2015 ,   Oracle and/or its affiliates. All rights   reserved.

23

L.MMSH,   2025   24  Output:

25  ▪   “ So far, we learned different parts of exception handling … try -  catch, types of exceptions, and how errors occur. ”  ▪   “ But all of these are just pieces … Now let ’ s see how everything  works together in one complete flow. ”

26  ▪   In Java, exception handling is not just about catching errors … it actually  has   three main steps:  ▪   Declaring the exception using   throws  ▪   Throwing the exception using   throw  ▪   Catching the exception using   try - catch

27  ▪   An exception does not get handled immediately where it occurs. Instead, it may be  passed from one method to another until a suitable handler is found.  ▪   This means that different methods in the program can have   different responsibilities:  ▪   A method can declare that it may cause an exception using the   throws   keyword.  ▪   Another method may actually detect a problem and throw the exception using the  throw   statement.  ▪   Finally, a calling method may handle the exception using a   try - catch   block.

28  ▪   Suppose the   main   method invokes   method 1 ,  method 1   invokes   method 2 ,   method 2   invokes  method 3 , and   method 3   throws   an exception.  Consider the following scenarios:  Scenario   1 : Caught in method 2  •   If the exception is handled in   method 2 ,  the remaining statements in   method 2   are  skipped, and the program continues there.  Scenario   2 : Caught in method 1  •   If the exception is If the exception is not handled  in method 2 , it is passed to method 1 , where it is  handled.  ▪   In this case, the remaining statements in  method 2   and part of method 1   are skipped.  Scenario   3 : Caught in main  ▪   If the exception is not handled in method 2   or  method 1 , it is passed to the main method and handled  there.  Scenario   4 : Not Caught  ▪   If the exception is not handled in any method,  the program terminates.

29  ▪   In this example, the exception handling process is  divided into   three main parts .  ▪   First , the exception is declared in the header of   method 2  using the   throws   keyword. This means that the method  may produce an exception   during execution.  ▪   Second , the exception is thrown inside   method 2   when  the input value is invalid. The throw new statement  creates an exception object and stops the normal  execution of the method.  ▪   Third , the exception is caught and handled in method 1  using a try - catch block.   When the exception occurs, Java  transfers control to the catch block, where the problem is  handled .  ▪   Because   the exception is handled properly, the program  continues executing normally instead of terminating.

30  ▪   throws   is used in the method header to declare that a method may  produce an exception.  ▪   throw   is used inside the method body to actually create and throw  an exception.  ▪   catch   is used to handle the exception when it occurs.