/* ZIYU SONG
 * NET ID: zsong10
 * CSC 242
 * Project 2
 */

package pl.examples;

import pl.core.*;
import pl.prover.ProverEnumeration;
import pl.prover.ProverResolution;

public class ModusPonensKB extends KB {
	
	public ModusPonensKB() {
		super();
		Symbol p = intern("P");
		Symbol q = intern("Q");
		add(p);
		add(new Implication(p, q));
	}
	
	// truth-table enumeration method
	public void solveByEnumeration() {
		ProverEnumeration pe = new ProverEnumeration();
		Symbol q = this.intern("Q");
		Sentence s = q;
		boolean value = pe.entails(this, s); // check entailment of KB with interned sentence
		System.out.println("Solve By Enumeration: " + value);
	}
	
	// a resolution-based theorem prover
	public void solveByResolution() {
		ProverResolution pr = new ProverResolution();
		Symbol q = this.intern("Q");
		Sentence s = q;
		boolean value = pr.entails(this, s);
		System.out.println("Solve By Resolution: " + value);
	}
	
	public static void main(String[] argv) {
		new ModusPonensKB().dump();
		ModusPonensKB kb = new ModusPonensKB();
		
		System.out.println("\n" + "******Modus Ponens******");
		kb.solveByEnumeration();
		kb.solveByResolution();
	}

}
