Chapter   7 :  GUI  CS 111 : Programming Language II

TOPICS on GUI  ▪   •   Introduction to GUI and JavaFX  ▪   •   Event - Driven Programming  ▪   •   JavaFX Structure (Stage, Scene, Nodes)  ▪   •   Layouts ( VBox ,   GridPane )  ▪   •   UI Controls  ▪   •   Building Forms  ▪   •   Event Handling  ▪   •   Styling (CSS basics)  2

What   is   a GUI?  ➢   Graphical User Interface (GUI)   is a type of user interface that allows  users to interact with an application using graphical elements rather  than text commands.  ➢ GUI makes programs easier for users compared to command - line  interfaces. Instead of typing commands, users click buttons and enter  data using forms.  ➢   A GUI provides a visual environment where users can interact with the  program through components called   controls   or   widgets   such as:  ▪   Buttons  ▪   Text fields  ▪   Menus  ▪   Icons  ▪   Windows  ➢ A GUI component is an object with which the user   interacts   usually via  the mouse, the keyboard, nowadays often via touch screen   3

Why   GUI?  4  ➢ Consistent   interfaces   help   users   learn   software   quickly  ➢ When   applications   use   similar   interface   designs,   users   feel   familiar   with  the   system .  ➢ For   example,   many   applications   such   as :  ▪   Microsoft Word  ▪   PowerPoint  ▪   Excel  ➢ use a   similar menu bar structure   including:  ▪   File   –   Home   –   Insert   –   Design   –   Layout  ➢ Because of this consistency, users can easily switch between  applications.  ➢ This concept is called:   Look and Feel

GUI Programming Concepts  5  Sequential   programming  ➢ Traditional   programs   usually   follow   sequential   programming,  where   statements   are   executed   in   a   fixed   order   determined   by  the   programmer .  ➢   In   this   type   of  programming,   the  program   controls   the  flow   of   execution .  ➢   The   program   runs   step  by   step   from   start   to  end   without   user  interaction .

GUI Programming Concepts  6  ➢ However,   GUI   applications   work   differently .  ➢ GUI   programs   use   Event - Driven   Programming ,   where   the   flow   of  the   program   is   controlled   by   user   actions   such   as :  ▪   Clicking   a   button  ▪   Selecting   a   menu   item  ▪   Typing   text   in   a   field  ▪   Moving   the   mouse  ➢ The   program   waits   for   events   and   responds   when   they   occur .  ➢ The   user   interacts   with   the   program,   and   the   program   responds .

What is Event - Driven Programming  ➢ A   programming   paradigm   where   the   program's   overall   flow  of   execution   is   determined   by   events .  ➢ Instead   of   executing   instructions   in   a   fixed   sequence,   the  program   waits   for   user   actions   and   responds   when   an   event  occurs .  ➢ Examples   of   events   include :  ▪   Mouse   click  ▪   Kep   press  ▪   Window   resize  7

Key Difference: Sequential vs Event - Driven  Sequential   Programming :  ▪   Program   controls   the   flow   of   execution  ▪   Executes   step   by   step   (fixed   order)  ▪   Runs   from   start   to   end  Event - Driven   Programming :  ➢   User   controls   the   flow   of   execution  ➢   No   fixed   order   (depends   on   user   actions)  ➢   Waits   for   events   (click,   input,   etc . )  8

Event - Driven Programming  9  Key   Concepts   of   Event - Driven   Programming  1 .   Event  ➢ An   event   occurs   when   the   user   interacts   with   a   graphical  component   in   the   interface .  ➢ Examples   of   events   include :  ▪   Clicking   a   button  ▪   Selecting   an   item   from   a   menu  ▪   Typing   text   in   a   text   field  ▪   Moving   the   mouse  ➢ When   an   event   occurs,   the   system   sends   a   message   to   the  application   indicating   that   the   event   happened .

Event - Driven Programming  10  Key   Concepts   of   Event - Driven   Programming  2 .   Event   Listener   and   Event   Handler  ➢ An   event   listener   is   an   object   that   waits   for   an   event   to   occur .  ➢   When   the   event   happens,   the   listener   detects   it   and   triggers   the   code   that  handles   the   event .  ➢   The   code   that   executes   in   response   to   the   event   is   called   the   event   handler .  ➢ Simple Idea : Event   →   Listener detects   →   Handler runs code  ➢ For   example :  ▪   When   the   user   clicks   a   button   →   display   a   message  ▪   When   the   user   enters   text   →   process   the   input  ▪   When   the   user   selects   a   menu   item   →   execute   a  command

Elements of GUI Programming  11  ➢ A   graphical   user   interface   (GUI)   is   built   from   several   key   elements  that   work   together   to   create   an   interactive   application .  ➢ The   main   elements   of   GUI   programming   include :  1 . Components  ❑ Components are   visual objects   that appear on the screen and  allow the user to interact with the application.  ❑ Examples include:  ▪   Buttons  ▪   Labels  ▪   Text fields  ▪   Checkboxes  ▪   Menus  ❑ These components are also called   controls   or   widgets .

Elements of GUI Programming  12  2 . Layouts  ➢ Layouts control   how components are arranged   inside the window.  ➢ They determine the position and organization of GUI elements.  ➢ For example, a layout may arrange components:  ▪   in rows and columns  ▪   vertically or horizontally  ▪   centered   inside the window

Elements of GUI Programming  13  3 . Events  ➢ An event occurs when the user interacts with a GUI  component.  ➢ Examples:  ▪   clicking a button, typing text, selecting a menu item  ➢ Events trigger actions in the program.  4 . Graphics  ➢ Graphics include the visual appearance of the interface, such  as:  ▪   Colours, shapes, fonts, images  ➢   Graphics make the interface more attractive and user - friendly.

GUI Libraries in Java  14  ➢   Java provides several libraries for building graphical user interfaces.  ➢   These libraries provide ready - made components such as:  ▪   Buttons  ▪   Text fields  ▪   Labels  ▪   Menus  ▪   Windows  ➢   Developers can use these components to build interactive  applications without creating the interface from scratch.  ➢   Some common GUI libraries in Java include:  ▪   AWT (Abstract Window Toolkit)  ▪   Swing  ▪   JavaFX  ➢   Among these libraries,   JavaFX   is the most modern and widely used  for building Java GUI applications.

What is the JavaFX  15  ➢   JavaFX is a Java library used to build graphical user interfaces  (GUI).  ➢   It allows developers to create applications with windows,  buttons, and interactive elements.  ➢   JavaFX applications can run on different platforms such as  desktop systems.  ➢   It provides ready - made components such as:  Button, Label,   TextField  ➢   It also provides tools to:  design layouts and handle user events

Why JavaFX?  16  ➢   JavaFX is a modern framework used to build graphical user  interfaces in Java.  ➢   It provides:  ▪   Rich UI components  ▪   Modern design capabilities  ▪   Built - in support for multimedia  ▪   CSS styling for interface design  ➢   It helps developers to create   interactive and visually  appealing applications.  ➢   JavaFX is used to build modern desktop applications.

Basic Structure of a JavaFX Application  17 1️⃣  Stage  Represents the main window of the application.  ▪   It is the top - level container  ▪   It holds the scene 2️⃣  Scene  Represents the container inside the window that holds all GUI components.  ▪   A scene is placed inside the stage  ▪   It contains all visual elements  A JavaFX program typically contains three main parts:  Stage   →   contains   Scene   →   contains   Root   →   contains   Nodes 3️⃣  Nodes  ▪   Nodes are the visual components inside the scene  (buttons, labels, text fields, etc.)  ▪   The root node is the main container of the scene  ▪   It is usually a layout ( VBox ,   GridPane )  ▪   All UI components are added inside the root node

Basic Structure of a JavaFX Application  18  JavaFX app window parts

JavaFX API (Packages)  19  JavaFX provides different packages (libraries) to build GUI applications.  The main packages are:  ➢   javafx.application :   Controls the application lifecycle ( init , start, stop)  ➢   javafx.stage :   Represents the main window ( Stage )  ➢   javafx.scene :   Holds all UI components ( Scene & Nodes )  ➢   javafx.scene.control :   Provides UI components (Button, Label,  TextField )  ➢   javafx.scene.layout :   Organizes components inside the window  (Layouts)  ➢   javafx.event :   Handles user events (clicks, actions)

First JavaFX Example  20  Let's build a program that:  • Displays a window (Stage)  •   Shows a button inside the window  •   When the button is clicked   →   prints "Hello World"  Hello World  Main Parts of the Program  •   Stage   →   the window  •   Scene   →   the content inside the window  •   Button   →   a UI component  •   Event   →   user clicks the button  •   Handler/Action   →   print message

21  First JavaFX Example  Main Parts of the Program  •   Stage   →   the window  •   Scene   →   the content inside the  window  •   Button   →   a UI component  •   Event   →   user clicks the button  •   Handler/Action   →   print message

22  First JavaFX Example  •   Every JavaFX program must extend the  Application class  •   This allows the program to use JavaFX  features  •   Application is a base class provided by  JavaFX  •   start()   is an abstract method in the  Application class  •   We must override it to create our GUI  •   This method is called automatically by  JavaFX  •   It receives a Stage object (the main  window)  •   start() = where we build the GUI

23  First JavaFX Example  •   Creates a button component  •   The text "Click Me" appears on the  button  •   Users interact with this component  •   An event occurs when the user clicks the  button  •   setOnAction () defines what happens  when the event occurs  •   This is called event handling  •   This code runs after the button is clicked  •   It prints "Hello World" in the console

24  First JavaFX Example  •   Scene represents the content inside the  window  •   It contains all UI components  •   Here, the button is placed inside the  scene  •   Stage represents the main window  •   We set the scene inside the stage  •   show() displays the window  •   main() starts the program  •   launch() starts JavaFX  •   launch() automatically calls start()  •   launch() is defined in the Application class  •   We inherit it using "extends Application"  •   main()   →   launch()   →   start()   →   GUI  appears

25  LIFECYCLE OF A JAVAFX  APPLICATION  ➢   The   Application class   in the  package   javafx.application  contains the following methods:  launch(),   init (), start(), and  stop() .  ➢   These methods represent the  lifecycle of any JavaFX  application, and they are called  automatically as shown in the  diagram:

26  LIFECYCLE OF A JAVAFX APPLICATION  1 . launch()  ➢   Starts the JavaFX application.  ➢   Called inside the main() method.  ➢   Initializes the JavaFX runtime.  2 .   init ()  ➢   Used for initialization tasks.  ➢   Runs   before the GUI is created .  3 . start(Stage stage)  ➢   The   entry point method of the JavaFX  application   where the GUI is created.  ➢   All UI code is written here.  ➢   Stage represents the window.  4 . stop()  ➢   Called when the application is closed.  ➢   Used to release resources or stop  processes.

27  From One Component to Many  •   In our example   →   one button only   →   we put the button on the scene directly  •   Real applications   →   multiple components   →   cannot place them directly  We need a way to organize them, how?  What if you want to build this form:

28  What is a Layout?  ➢   A layout organizes components inside the window  ➢   It controls where components appear  ➢   It helps build structured interfaces  ➢   JavaFX provides many types of layout panes for organizing nodes in  a container.  ➢   Each layout pane is represented by a class in the JavaFX API.  ➢   These classes exist in the package   javafx.scene.layout

29  Common Layouts in JavaFX  •   VBox   →   arranges components vertically  •   HBox   →   arranges components horizontally  •   GridPane   →   arranges components in rows and columns

30  Example 2 :  Creating a Form  in JavaFX

31  Example 2 : Creating a Form in JavaFX  ➢   Java is organized into packages  ➢   Each package contains related  classes  ➢   import is used to access  JavaFX classes  ➢   It allows us to use:  ▪   Application  ▪   Scene  ▪   Button   -   Label  ▪   Layouts ( GridPane ,   VBox )  ➢   Without import, we cannot  use these classes

32  Example 2 :  Creating a Form in JavaFX  •   Creates a label to display text  •   Used as the title of the window  •   Label   →   describes the input field  •   TextField   →   allows the user to enter  text  •   PasswordField   →   hides the entered  text  •   Used for secure input  •   Creates a button  •   The user clicks it to perform an action  •   Displays feedback to the user  •   Initially empty  •   setOnAction ()   →   defines what  happens when the button is clicked  •   Updates the message text  •   Changes the text   color   to red  •   setStyle () is used to change the  appearance

33  •   GridPane   organizes components in  rows and columns  •   Hgap   →   space between columns  •   Vgap   →   space between rows  •   Each component is placed using  (column, row)  •   ( 0,0 )   →   first column, first row  •   ( 1,0 )   →   second column, first row  •   VBox   arranges components vertically  •   15   →   spacing between elements  •   Aligns everything to the   center  •   VBox   is the main layout (container) of  the window  •   getChildren () returns the list of  components inside it  •   addAll (...) adds multiple components  to be displayed  •   Components are added in order:  title   →   top grid   →   middle message   →  bottom

34  •   Scene contains all UI components  •   Sets the window size  •   Stage represents the window  •   setScene ()   →   places the content  inside the window  •   show()   →   displays the window  •   Starts JavaFX  •   Automatically calls start()  Summary:  •   Components   →   to build the UI  •   Layouts   →   to organize them  •   Events   →   to handle user interaction  •   We can use more than one layout in  the same   program,   in this example we  used:  •   VBox   →   arranges main sections  vertically  •   GridPane   →   organizes form elements  in rows and columns  •   Layouts can be nested (layout inside  another layout)

35

36  JAVAFX UI CONTROLS  ➢   In previous examples we used many of JavaFX UI controls,  such as :  ➢   Label  ➢   TextField  ➢   PasswordField  ➢   Button  ➢   Are these all the components available?  →   Let ’ s explore more UI controls

37  JAVAFX UI CONTROLS  ➢   JavaFX UI controls are the visual elements that form the  building blocks of a JavaFX application ’ s user interface.  ➢   These controls are pre - built components that developers  can use to construct the interactive parts of a GUI.

38  JAVAFX UI CONTROLS  Control   Description  Label   Displays text on the screen  Button   Performs an action when clicked  RadioButton   Allows selecting one option from a  group  CheckBox   Allows selecting multiple options  TextField   Used to enter single - line text  TextArea   Used to enter multiple lines of text  ComboBox   Allows selecting one item from a  dropdown list  ListView   Displays a list for single or multiple  selection  Slider   Used to select a value from a range

39  Example (Self Study)  •   This example focuses on  the UI design only  •   No functionality  (events) has been added

40  Example (Self Study)

•   What is the main layout used in this  program?  •   Which layout is used to organize the  form fields?  •   Where are the UI controls added to  the layout?  •   Which control is used to enter text?  •   How are the   RadioButtons   grouped  together?  •   Which line sets the default selected  option?  •   What does   setPromptText () do?  •   How can you change the layout to  place fields side by side?  •   How can you make the button appear  at the bottom right?   41

42  Event Handling  What is an Event?  ➢   An event is a user action  ➢   Examples:   -   Clicking a button   -   Typing text  Handling Events  ➢   We handle events using methods like   setOnAction ()  ➢   Events can happen on different controls:  ▪   Button (click)  ▪   TextField   (enter text)  ▪   CheckBox   (select)  ➢   Example:  btn.setOnAction (e   - > {   System.out.println ("Clicked");});  •   e   represents the event (user action)  •   This code runs when the button is clicked  Event Flow:  ➢   User Action   →   Event   →   Code Runs

43  Event Handling example  ➢   In the previous example, add an  action to the   Primary   button.  ➢   When the user clicks the button:  →   Display a message   "Form Submitted “  ➢   Hint:  •   Create a Label to display the  message  •   Add it to the layout

44  Styling in JavaFX  ➢   Styling means changing the appearance of UI components  ➢   We can change:  ➢   →   Colors  ➢   →   Font size  ➢   →   Background

45  Styling in JavaFX  ➢   JavaFX uses a CSS - like syntax  What is CSS?  ➢   CSS stands for Cascading Style Sheets  ➢   It is used to style UI elements  ➢   In JavaFX, we use a simple CSS - like syntax  ➢   CSS Syntax (Simple):  ➢   property : value  ➢   Example:  - fx - text - fill: red;  ➢   •   property   →   what to change •   value   →   how to change it

46  Styling in JavaFX: Using   setStyle ()  ➢   setStyle ()   is used to apply styling  ➢   Example:  button.setStyle (" - fx - background - color : green;");  ➢   Common Styling Properties  ▪   - fx - background - color   →   background   color  ▪   - fx - text - fill   →   text   color  ▪   - fx - font - size   →   text size

47  Styling in JavaFX: Using   setStyle ()  ➢   Before Styling  ➢   Default appearance  ➢   No styling applied  After Styling  ➢   Button is now green with white text  ➢   Message is red and larger

Self Reading  Dr. MFH,   2023  48