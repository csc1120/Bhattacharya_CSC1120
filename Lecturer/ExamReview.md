
# Exam Review


1. Describe how the Model-View-Controller pattern works and mention at least 2 advantages of
using it.

Model View Controller (MVC) is a software design pattern that separates the representation of information from the user's interaction with it. The model consists of application data and business rules, and the controller mediates input, converting it to commands for the model or view. The view presents the model to the user. The MVC pattern is used in computer graphics, web development, and applications that require a user interface. The MVC pattern has several advantages, including the ability to support multiple views, the ability to support asynchronous updates, and the ability to support multiple developers working on the same project.

Advantages of using MVC:
- Multiple views: The MVC pattern allows for multiple views of the same model. This means that the same data can be presented in different ways, depending on the needs of the user.
- Asynchronous updates: The MVC pattern allows for asynchronous updates, which means that the model can be updated without requiring the user to refresh the page. This can improve the user experience and make the application feel more responsive.
- Separation of concerns: The MVC pattern separates the concerns of the application, which makes it easier to maintain and extend the application. This is because changes to one part of the application are less likely to affect other parts of the application.
- Reusability: The MVC pattern makes it easier to reuse code, because the model, view, and controller can be used in different applications. This can save time and effort when developing new applications.
- Flexibility: The MVC pattern makes it easier to change the application, because the model, view, and controller can be changed independently of each other. This makes it easier to add new features to the application, or to change existing features.

2. order in which the methods in a JavaFX application  are called?

The order in which the methods in a JavaFX application are called is as follows:
- The **main** method is called first, which creates an instance of the application class and calls the launch method.
- The **launch** method initializes the JavaFX toolkit and calls the init method.
- The **init** method is called next, which initializes the application and sets up the user interface.
- The **start** method is called next, which creates the user interface and sets up event handlers.
- The **user** interacts with the application, which triggers event handlers and updates the user interface.

3. Describe the similarities and differences for JavaFX between imperative coding and declarative
   programming with FXML.

JavaFX is a framework for building user interfaces in Java. It provides two ways to create user interfaces: imperative coding and declarative programming with FXML.

4. Explain the purpose of the of a controller class in relation to an FXML file.

The purpose of a controller class in relation to an FXML file is to provide the logic for the user interface. The controller class is responsible for handling user input, updating the user interface, and interacting with the model. It is used to connect the FXML file to the application logic, and to provide a way to access the user interface from the application code.



5. Explain the purpose of the @FXML annotation in relation to an FXML file.

The purpose of the @FXML annotation in relation to an FXML file is to inject the user interface elements defined in the FXML file into the controller class. This allows the controller class to access the user interface elements and interact with them. The @FXML annotation is used to mark fields and methods in the controller class that correspond to user interface elements in the FXML file.

The private fields in the controller class are annotated with @FXML to indicate that they are associated with elements in the FXML file. The FXML loader uses reflection to inject the elements from the FXML file into the controller class, based on the @FXML annotations.



8. Explain the purpose of the initialize method in relation to an FXML file.

The purpose of the initialize method in relation to an FXML file is to initialize the controller class after the user interface elements have been injected. The initialize method is called by the FXML loader after the user interface elements have been injected, but before the user interface is displayed. This allows the controller class to perform any necessary initialization, such as setting up event handlers or loading data from the model.

8. Alert class in JavaFX and how to use it.

The Alert class in JavaFX is used to display a dialog box with a message and optional buttons. It is used to provide feedback to the user, such as notifying them of an error or asking for confirmation. The Alert class provides several static methods for creating different types of alerts, such as information alerts, warning alerts, error alerts, and confirmation alerts. The Alert class also provides methods for setting the title, header text, content text, and buttons of the alert.

An example of how to use the Alert class is as follows:

```java
Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation Dialog");
alert.setHeaderText("Look, a Confirmation Dialog");
alert.setContentText("Are you ok with this?");
Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    // ... user chose OK
} else {
    // ... user chose CANCEL or closed the dialog
}
```

9. Which input stream takes in primitive types?

The Scanner is mostly used to receive user input and parse them into primitive data types such as int, double or default String.

10. Select all of the following that can a onAction attribute/property:
    (a) TextField
    (b) Button
    (c) Label
    (d) HBox

    (a) TextField
    (b) Button


11. What is the Order of magnitude of a set of functions notated as in terms of algorithm efficiency?

The order of magnitude of a set of functions notated as O(n) in terms of algorithm efficiency is linear. This means that the time it takes to run the algorithm is proportional to the size of the input. For example, if the input size is doubled, the time it takes to run the algorithm will also double.

12. What is the Order of magnitude of a set of functions notated as in terms of algorithm efficiency?

The order of magnitude of a set of functions notated as O(n^2) in terms of algorithm efficiency is quadratic. This means that the time it takes to run the algorithm is proportional to the square of the size of the input. For example, if the input size is doubled, the time it takes to run the algorithm will be four times as long.


13. Discuss the principles and benefits of functional programming. 

Functional programming or declarative programing is a programming paradigm that treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data. It is a declarative programming paradigm, which means that the program logic is expressed without explicitly describing the flow of control. Functional programming has several principles and benefits, including the following:
1. Immutability: Functional programming encourages the use of immutable data, which means that once a value is assigned, it cannot be changed. This makes it easier to reason about the behavior of the program, because the values of variables do not change over time.
2. Higher-order functions: Functional programming treats functions as first-class citizens, which means that functions can be passed as arguments to other functions, returned as values from other functions, and assigned to variables. This makes it easier to write modular and reusable code, because functions can be composed and combined in different ways.
3. Pure functions: Functional programming encourages the use of pure functions, which are functions that have no side effects and always return the same output for the same input. This makes it easier to reason about the behavior of the program, because the behavior of a pure function is determined only by its input.
4. Lazy evaluation: Functional programming encourages the use of lazy evaluation, which is a technique for delaying the evaluation of an expression until its value is actually needed. This makes it easier to write code that is more efficient, because it avoids unnecessary computation.

Imperative programming is a programming paradigm that uses statements to change a program's state. It is a style of programming that is based on the concept of the program as a sequence of commands. Imperative programming has several principles and benefits, including the following:
1. Mutability: Imperative programming allows the use of mutable data, which means that the values of variables can change over time. This makes it easier to write code that is more efficient, because it avoids unnecessary copying of data.
2. Control flow: Imperative programming uses control structures such as loops and conditionals to specify the flow of control in a program. This makes it easier to write code that is more flexible, because it can adapt to different situations.
3. Side effects: Imperative programming allows the use of side effects, which are changes to the state of the program that are not reflected in the return value of a function. This makes it easier to write code that interacts with the outside world, because it can perform actions such as reading from and writing to files, or interacting with a user interface.



