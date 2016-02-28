# Checkers

[![Build Status](https://travis-ci.org/theophilereq/checkers.png?branch=master)](https://travis-ci.org/theophilereq/checkers)
[![Coverage Status](https://coveralls.io/repos/github/theophilereq/checkers/badge.svg?branch=master)](https://coveralls.io/github/theophilereq/checkers?branch=master)

## How to launch

	$ mvn clean install
	$ cd checkers-web
	$ mvn glassfish:run

It launches a Glassfish server on port 9090, so your application can be browsed at :

	http://localhost:9090/checkers-web/

## Rules
- We need to begin with the red player
- You ought to move a piece in diagonal (It's possible to eat a piece if the diagonal cell is occupied by an adverse piece)
- To win, we need to go until the other side of the board

- The reset button permit you to reset a party
- The turn button inform you which player need to play
- A winner button appear when a player has won

- If you do a forbidden deplacement, a GameException is displayed to tell you what the problem is 

## Members
- Théophile Requillart
- Alexandre Mouquet
- Clément Porte
