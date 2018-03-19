package pl.examples;

import pl.core.*;
import pl.prover.ProverEnumeration;
import pl.prover.ProverResolution;

public class LiarTruthTellerKB extends KB {
	
	public LiarTruthTellerKB() {
		super();
	}
	
	// truth-table enumeration method
	public void solveByEnumeration() {
		ProverEnumeration pe = new ProverEnumeration();
		System.out.println("------Prove By Enumeration------");
		
		Symbol amy = this.intern("Amy");
		Sentence sa = amy;
		boolean valA = pe.entails(this, sa);
		System.out.println("Amy tells the truth: " + valA);
		
		Symbol bob = this.intern("Bob");
		Sentence sb = bob;
		boolean valB = pe.entails(this, sb);
		System.out.println("Bob tells the truth: " + valB);
		
		Symbol cal = this.intern("Cal");
		Sentence sc = cal;
		boolean valC = pe.entails(this, sc);
		System.out.println("Cal tells the truth: " + valC);
	}
	
	// a resolution-based theorem prover
	public void solveByResolution() {
		ProverResolution pr = new ProverResolution();
		System.out.println("------Prove By Resolution------");
		
		Symbol amy = this.intern("Amy");
		Sentence sa = amy;
		boolean valA = pr.entails(this, sa);
		System.out.println("Amy tells the truth: " + valA);
		
		Symbol bob = this.intern("Bob");
		Sentence sb = bob;
		boolean valB = pr.entails(this, sb);
		System.out.println("Bob tells the truth: " + valB);
		
		Symbol cal = this.intern("Cal");
		Sentence sc = cal;
		boolean valC = pr.entails(this, sc);
		System.out.println("Cal tells the truth: " + valC);
	}

	public static void main(String[] args) {
		LiarTruthTellerKB kb = new LiarTruthTellerKB(); // new knowledge base
		
		System.out.println("\n" + "******Liars and Truth-Tellers (Part A)******"); // part A of the sample problem
		Symbol amy = kb.intern("Amy");
		Symbol bob = kb.intern("Bob");
		Symbol cal = kb.intern("Cal");
		
		kb.add(new Biconditional(amy, new Conjunction(amy, cal)));
		kb.add(new Biconditional(bob, new Negation(cal)));
		kb.add(new Biconditional(cal, new Disjunction(bob, new Negation(amy))));
		
		kb.solveByEnumeration();
		kb.solveByResolution();
		
		System.out.println("\n" + "******Liars and Truth-Tellers (Part B)******"); // part B of the sample problem
		LiarTruthTellerKB kb2 = new LiarTruthTellerKB();
		amy = kb2.intern("Amy");
		bob = kb2.intern("Bob");
		cal = kb2.intern("Cal");
		
		kb2.add(new Biconditional(amy, new Negation(cal)));
		kb2.add(new Biconditional(bob, new Conjunction(amy, cal)));
		kb2.add(new Biconditional(cal, bob));
        
        kb2.solveByEnumeration();
		kb2.solveByResolution();
	}

}
