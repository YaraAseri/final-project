CS111: Programming Language II

   Abstract classes     Abstract methods     Case study  2

 In   object - oriented   programming,   we   often   define   general   classes   that   represent   a  common   concept .   For   example :     Circle     Rectangle     Triangle   All of these shapes share common properties such as:     color     area     perimeter   Instead of repeating the same code in each class, we can create a   general  superclass   that defines the common structure.   However, sometimes this superclass should   not be instantiated directly .   This   is   where   abstract   classes   become   useful . .   3

   An   abstract class   is a class that   cannot be instantiated .     This means we cannot create objects directly from it.     Instead, it is used as a   base class   for other classes.     Abstract classes are typically used when we want to define:  • common fields  • common methods  • method declarations that must be implemented by subclasses     Syntax:  4

   An abstract class cannot be instantiated using the new operator.     However, it can still define constructors.     These constructors are invoked when subclasses are created.  5

   An abstract method is like a   placeholder   for a method that will be fully defined in  a descendent class     An   abstract method   is a method that is declared but   does not have an  implementation .     It only specifies the method   signature , and the implementation is provided in  subclasses.     It has   no method body,   and ends with a semicolon in place of its body     It cannot be private  6

Important rules:     If a class contains at least   one abstract method , the class   must be  declared abstract     Otherwise, the program will produce a   compile - time error .     An abstract method must be declared inside an abstract class.     If a derived class of an abstract class   does not define all abstract  methods , then it is also abstract and must include the abstract  modifier.  7

Important rules:     A class that contains abstract methods must be declared abstract.     However, it is possible to define an abstract class with no abstract  methods.     In this case:     You cannot create objects from the class.     The class is used only as a base class for subclasses.  8

Concrete Class     A   concrete class   is a normal class that can be  instantiated.   Objects can be created from a concrete class  9  Abstract Class     An   abstract class   cannot be instantiated and  may contain   abstract methods .     You cannot create an object from an  abstract class

10

   If a class contains at least   one abstract method , the class   must be  declared abstract,   even if that class contains some concrete methods.     Otherwise, the program will produce a   compile - time error .  11

12

13  Only the   abstract methods   from the UML are shown here for simplicity.

14     You cannot create an  instance from an  abstract class using  new.     However, an abstract  class can be used as a  data type.

   We want to design a payroll system for different types of employees.     Different employees calculate their earnings differently:  15  Can we create   one class called Employee   that calculates earnings for all  employees?

Why We Need an Abstract Class   All employees share common  information:     firstName     lastName     socialSecurityNumber   But the earnings calculation is  different for each type of employee   Therefore:     The class Employee cannot implement  earnings()     Each subclass must define its own  calculation.   16  earnings()   →   abstract method  Employee   →   abstract class  Subclasses   →   implement earnings()

In the Abstract Class (Employee), we  define:     Common attributes shared by all  employees  o   firstName  o   lastName  o   socialSecurityNumber     General methods that apply to all  employees  o   toString ()  o   getters and setters     An   abstract method   that must be  implemented by subclasses  o   public abstract double earnings();  17

In the Concrete Subclasses, we must:     Define additional attributes specific to each employee type     Provide the implementation of the method  18

19  SalariedEmployee

20  HourlyEmployee

21  CommissionEmployee

22  BasePlusCommissionEmployee

23  In the main method:  1. Create objects from each employee subclass.  2. Store them in an array of type Employee.  3. Use a loop to process the employees polymorphically:     Print each employee information.     Call the earnings() method     Check if an object is an instance of   BasePlusCommissionEmployee , Increase the  base salary by 10%  4. Display the class name of each object using   getClass (). getName ().

In the main method:     Create objects from each employee subclass.     Store them in an array of type Employee.     Use a loop to process the employees  polymorphically:     Print each employee information.     Check if an object is an instance of  BasePlusCommissionEmployee , Increase the  base salary by   10 %     Call the earnings() method     Display the class name of each object using  getClass (). getName ().   24

Dr. MFH, 2022   27  Students are required to refer to  Introduction to Java Programming, Comprehensive Version by Y.  Daniel Liang,  Chapter 13: Abstract classes and interfaces,  for studying and solving exercises.