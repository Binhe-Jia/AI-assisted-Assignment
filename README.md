# Blackjack Game Simulator

This is a simple Java program that simulates a Blackjack game, allowing a player to input their hand and receiving the best decision based on card counting and basic strategy.

## Table of Contents
- [Requirements](#requirements)
- [Usage](#usage)
- [Version of Java](#version-of-java)
- [Testing Framework](#testing-framework)
- [Code Smells and SOLID](#code-smells-and-solid)

## Requirements

To run this program, you need to have Java installed on your system.

## Usage

1. Clone this repository to your local machine.
2. Open a terminal or command prompt and navigate to the cloned directory.
3. Compile the Java source files by running the following command: javac ImprovedBlackjackGame.java
4. Run the compiled program using the following command:java ImprovedBlackjackGame

5. Follow the prompts to input your cards and receive the best decision.

## Version of Java

This program was developed using Java SE 8 (Java 1.8).

## Testing Framework

This program includes unit tests using the JUnit testing framework. The tests cover important methods within the `BlackjackGame` and `CardUtils` classes. To run the tests, ensure you have JUnit set up in your development environment and run the test classes.

## Code Smells and SOLID

While efforts have been made to address code smells and adhere to SOLID principles, some areas may still require improvement. Notable code smells that were addressed include:

- **Duplication**: Code duplication has been reduced by modularizing methods and promoting reusability.
- **Long Methods**: Methods have been broken down into smaller, focused methods to improve readability and maintainability.
- **Tight Coupling**: Steps have been taken to reduce coupling between classes and promote separation of concerns.
- **Limited Strategy Support**: The strategy pattern is employed to make the decision-making process more flexible and extensible.

However, further enhancements can still be made:

- **Code Organization**: The code organization can be improved by grouping related classes into packages.
- **Complex Strategies**: As more complex decision strategies are added, the decision-making logic may become more intricate. A more advanced strategy pattern or factory pattern could be considered.
- **Multiplayer Support**: The program is currently tailored for single-player scenarios. Extending it to support multiplayer games may introduce complexity and architectural changes.

Overall, while the program has been designed to be clean and maintainable, continuous refactoring and adherence to design principles will contribute to its ongoing improvement.



