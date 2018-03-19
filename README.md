# Automated-Reasoning
This project is mainly about implementing two inference methods for Propositional Logic and demonstrate them on 5 examples: Modus Ponens, Simple Wumpus World, Horn Clauses, Liars and Truth-teller, and More Liars and Truth-tellers.

1. The program is built on the code provided by Professor George Ferguson. Starts with pretty much all files in pl.cnf, pl.core, pl.util packages.

Files created (or edited a lot by me):
	All files in pl.examples package
	pl.prover package:
		ProverEnumeration.java
		ProverResolution.java

There is no collaborator of this project.

2. This program is written in Java. Each sample problem need to be check/run separately. 

Make sure the build files (.class) are also in the same directory as the terminal.
If there's no build file, try this command: javac 

Change directory to the src folder in terminal and enter following commands: 

3. How to Run:
cd src
find pl -name "*.java" -exec javac '{}' +
java pl.examples.ModusPonensKB
java pl.examples.WumpusWorldKB
java pl.examples.HornClausesKB
java pl.examples.LiarTruthTellerKB
java pl.examples.MoreLiarTruthTellerKB
