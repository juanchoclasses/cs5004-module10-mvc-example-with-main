# Simple MVC Example

This project is a simple example of the Model-View-Controller (MVC) design pattern implemented in Java. It consists of a GUI application that allows users to interact with text in various ways.

## Project Structure

The project is divided into three main parts:

1. **Model**: The `Model` interface and its implementation `ModelImpl` represent the data and the rules of the application. It contains methods for setting and getting a string, and for flipping the string.

2. **View**: The `FrameView` class represents the user interface of the application. It contains various components such as buttons and text fields, and it defines how user actions on these components should be handled.

3. **Controller**: The `Features` interface represents the controller of the application. It defines the actions that can be performed by the user, such as echoing the input, toggling the color of the display, making the text uppercase, restoring the original text, flipping the text, and exiting the program.

## Running the Tests

Unit tests for the `Model` are provided in the `ModelTest` class. You can run these tests to verify the correctness of the `Model` implementation.

## Built With

- Java
