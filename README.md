# AI-assisted-Assignment
# Blackjack Game Simulator

The Blackjack Game Simulator is a Java program that simulates a Blackjack game, allowing you to input player card values and receive the best decision based on card counting and strategy.

## Table of Contents
- [Overview](#overview)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Overview

This program simulates a simplified version of the Blackjack game, also known as 21. It allows you to input player card values and calculates the best decision based on basic strategy and card counting techniques. The program uses a decision-making strategy that considers the true count, player's hand value, and remaining cards' probabilities.

## Getting Started

To run the program, you need to have Java installed on your system. Follow these steps:

1. Clone or download this repository to your local machine.
2. Open a terminal or command prompt.
3. Navigate to the directory where you've saved the program files.
4. Compile the Java files by running: `javac *.java`
5. Run the program: `java ImprovedBlackjackGame`

## Usage

1. Run the program as instructed in the Getting Started section.
2. Follow the prompts to enter card values for the player's hand. You can input numeric values (2-10) or use "J", "Q", "K", "A" for face cards and aces.
3. The program will display the current true count and the best decision (Hit or Stand) based on the provided cards and card counting.

## Features

- User-friendly input for card values, including numeric values and card names ("J", "Q", "K", "A").
- Card counting simulation using the Hi-Lo strategy.
- Decision-making based on basic strategy and true count.
- Modular design that separates different aspects of the game into classes.
- Easily extendable for adding new strategies or rule variations.

## License

This program is open-source and available under the [MIT License](LICENSE).

---

**Disclaimer:** This program is meant for educational and entertainment purposes only. It does not guarantee accurate results or simulate the complexities of real-world Blackjack games found in casinos. Always play responsibly and be aware of the laws and regulations in your jurisdiction.
