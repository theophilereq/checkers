# Checkers

[![Build Status](https://travis-ci.org/theophilereq/checkers.png?branch=master)](https://travis-ci.org/theophilereq/checkers)
[![Coverage Status](https://coveralls.io/repos/github/theophilereq/checkers/badge.svg?branch=master)](https://coveralls.io/github/theophilereq/checkers?branch=master)

This is a simple JEE7 checkers game made to illustrate various aspects of JEE:

 * TDD thru with Junit and AssertJ
 * Servlet, JSP
 * CDI
 * JPA
 * JAX-RS
 
![Image of Checkers](http://img4.hostingpics.net/pics/446627checkers.png)
 
**Contributors:**
 
 * Alexandre Mouquet ([@alexmouquet](https://github.com/alexmouquet))
 * Clément Porte ([@porrto]https://github.com/porrto)
 * Théophile Requillart ([@theophilereq](https://github.com/theophilereq))

## How to launch

To launch this project, you must have Firefox 44, 43, 38 or 31, according to the compatibility of the Selenium version, specified in parent `pom.xml`.

	$ mvn clean install
	$ cd checkers-web
	$ mvn glassfish:run

It launches a Glassfish server on port 9090, so your application can be browsed at:

	http://localhost:9090/checkers-web/
	
Or copy the `checkers-web/target/checkers.war` in your application server's webapp directory.

## Rules

- The red player begins the game.
- You must move a piece in diagonal (you can eat an enemy piece and go over if the diagonal cell is occupied by this enemy piece).
- To win: you need to go until the other side of the board.
- The `Reset` button allows you to reset a party.
- The `Turn` button informs you which player must play.
- A `Winner` button appears when a player has won.
- If you do a forbidden movement, a `GameException` will be displayed to tell you what the problem is.
