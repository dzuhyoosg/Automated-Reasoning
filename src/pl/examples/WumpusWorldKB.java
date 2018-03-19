/* ZIYU SONG
 * NET ID: zsong10
 * CSC 242
 * Project 2
 */

package pl.examples;

import pl.core.Biconditional;
import pl.core.Disjunction;
import pl.core.KB;
import pl.core.Negation;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.prover.ProverEnumeration;
import pl.prover.ProverResolution;

public class WumpusWorldKB extends KB {
	
	public WumpusWorldKB() {
		super();
		Symbol p11 = intern("P1,1");
		Symbol p12 = intern("P1,2");
		Symbol p21 = intern("P2,1");
		Symbol p22 = intern("P2,2");
		Symbol p31 = intern("P3,1");
		Symbol b11 = intern("B1,1");
		Symbol b21 = intern("B2,1");

		add(new Negation(p11));
		add(new Biconditional(b11, new Disjunction(p12, p21)));
		add(new Biconditional(b21, new Disjunction(p12, new Disjunction(p22, p31))));
		add(new Negation(b11));
		add(b21);
	}
	
	// truth-table enumeration method
	public void solveByEnumeration() {
		ProverEnumeration pe = new ProverEnumeration();
		Symbol p12 = this.intern("P1,2");
		Sentence s = p12;
		boolean value = pe.entails(this, s);
		System.out.println("Solve By Enumeration: " + value);
	}
	
	// a resolution-based theorem prover
	public void solveByResolution() {
		ProverResolution pr = new ProverResolution();
		Symbol p12 = this.intern("P1,2");
		Sentence s = p12;
		boolean value = pr.entails(this, s);
		System.out.println("Solve By Resolution: " + value);
	}

	public static void main(String[] argv) {
		new WumpusWorldKB().dump();
		WumpusWorldKB kb = new WumpusWorldKB();
		
		System.out.println("\n" + "******Wumpus World******");
		kb.solveByEnumeration();
		kb.solveByResolution();
	}

}
