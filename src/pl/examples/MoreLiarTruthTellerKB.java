/* ZIYU SONG
 * NET ID: zsong10
 * CSC 242
 * Project 2
 */

package pl.examples;

import pl.core.*;
import pl.prover.ProverEnumeration;
import pl.prover.ProverResolution;

public class MoreLiarTruthTellerKB extends KB {
	
	public MoreLiarTruthTellerKB() {
		super();
		Symbol a = intern("Amy");
		Symbol b = intern("Bob");
		Symbol c = intern("Cal");
		Symbol d = intern("Dee");
		Symbol e = intern("Eli");
		Symbol f = intern("Fay");
		Symbol g = intern("Gil");
		Symbol h = intern("Hal");
		Symbol i = intern("Ida");
		Symbol j = intern("Jay");
		Symbol k = intern("Kay");
		Symbol l = intern("Lee");
		
		add(new Biconditional(a, new Conjunction(h, i)));
		add(new Biconditional(b, new Conjunction(a, l)));
		add(new Biconditional(c, new Conjunction(b, g)));
		add(new Biconditional(d, new Conjunction(e, l)));
		add(new Biconditional(e, new Conjunction(c, h)));
		add(new Biconditional(f, new Conjunction(d, i)));
		add(new Biconditional(g, new Conjunction(new Negation(e), new Negation(j))));
		add(new Biconditional(h, new Conjunction(new Negation(f), new Negation(k))));
		add(new Biconditional(i, new Conjunction(new Negation(g), new Negation(k))));
		add(new Biconditional(j, new Conjunction(new Negation(a), new Negation(c))));
		add(new Biconditional(k, new Conjunction(new Negation(d), new Negation(f))));
		add(new Biconditional(l, new Conjunction(new Negation(b), new Negation(j))));
	}
	
	// truth-table enumeration method
	public void solveByEnumeration() {
		ProverEnumeration pe = new ProverEnumeration();
		System.out.println("------Prove By Enumeration------");
		System.out.println("Amy tells the truth: " + pe.entails(this, new Symbol("Amy")));
		System.out.println("Bob tells the truth: " + pe.entails(this, new Symbol("Bob")));
		System.out.println("Cal tells the truth: " + pe.entails(this, new Symbol("Cal")));
		System.out.println("Dee tells the truth: " + pe.entails(this, new Symbol("Dee")));
		System.out.println("Eli tells the truth: " + pe.entails(this, new Symbol("Eli")));
		System.out.println("Fay tells the truth: " + pe.entails(this, new Symbol("Fay")));
		System.out.println("Gil tells the truth: " + pe.entails(this, new Symbol("Gil")));
		System.out.println("Hal tells the truth: " + pe.entails(this, new Symbol("Hal")));
		System.out.println("Ida tells the truth: " + pe.entails(this, new Symbol("Ida")));
		System.out.println("Jay tells the truth: " + pe.entails(this, new Symbol("Jay")));
		System.out.println("Kay tells the truth: " + pe.entails(this, new Symbol("Kay")));
		System.out.println("Lee tells the truth: " + pe.entails(this, new Symbol("Lee")));
	}
	
	// a resolution-based theorem prover
	public void solveByResolution() {
		ProverResolution pr = new ProverResolution();
		System.out.println("------Prove By Resolution------");
		System.out.println("Amy tells the truth: " + pr.entails(this, new Symbol("Amy")));
		System.out.println("Bob tells the truth: " + pr.entails(this, new Symbol("Bob")));
		System.out.println("Cal tells the truth: " + pr.entails(this, new Symbol("Cal")));
		System.out.println("Dee tells the truth: " + pr.entails(this, new Symbol("Dee")));
		System.out.println("Eli tells the truth: " + pr.entails(this, new Symbol("Eli")));
		System.out.println("Fay tells the truth: " + pr.entails(this, new Symbol("Fay")));
		System.out.println("Gil tells the truth: " + pr.entails(this, new Symbol("Gil")));
		System.out.println("Hal tells the truth: " + pr.entails(this, new Symbol("Hal")));
		System.out.println("Ida tells the truth: " + pr.entails(this, new Symbol("Ida")));
		System.out.println("Jay tells the truth: " + pr.entails(this, new Symbol("Jay")));
		System.out.println("Kay tells the truth: " + pr.entails(this, new Symbol("Kay")));
		System.out.println("Lee tells the truth: " + pr.entails(this, new Symbol("Lee")));
	}
	
	public static void main(String[] args) {
		MoreLiarTruthTellerKB kb = new MoreLiarTruthTellerKB();
		kb.solveByEnumeration();
		System.out.println();
		kb.solveByResolution();
	}

}
