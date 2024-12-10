# TicTacToeImplementation

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Contact](#contact)

## Introduction
Welcome to the Tic-Tac-Toe (also known as Noughts and Crosses) project! This project implements a classic two-player game where players take turns marking spaces in a 3x3 grid.

## Features
- **Two Player Mode**: Two players can compete against each other, one using 'X' and the other using 'O'.
- **Interactive Gameplay**: Players take turns to place their tokens in an empty cell of the 3x3 grid.
- **Win Detection**: The game detects and announces the winner when three tokens are aligned horizontally, vertically, or diagonally.
- **Grid Display**: The current state of the game board is displayed after each turn.

## Prerequisites
- Java 22 or higher.

## Installation
1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/TicTacToeImplementation.git
    cd TicTacToeImplementation
    ```

2. **Compile the project:**
    ```sh
    javac src/main/java/com/example/*.java
    ```

## Usage
- **Run the Game:**
    ```java
    public class Main {
        public static void main(String[] args) {
            GamePlayer player1 = new GamePlayer('X', "Player 1");
            GamePlayer player2 = new GamePlayer('O', "Player 2");
            GameLogic game = new GameLogic(new GamePlayer[]{player1, player2});
            game.playGame();
        }
    }
    ```


## Contact
If you have any questions or feedback, feel free to reach out to me at ouambocanis@gmail.com.
