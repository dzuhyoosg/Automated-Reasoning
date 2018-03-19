package pl.examples;

import pl.core.*;
import pl.prover.ProverEnumeration;
import pl.prover.ProverResolution;

public class HornClausesKB extends KB {

	public HornClausesKB() {
		super();
		Symbol mythical = intern("Mythical");
		Symbol immortal = intern("Immortal");
		Symbol mammal = intern("Mammal");
		Symbol horned = intern("Horned");
		Symbol magical = intern("Magical");
		
		add(new Implication(mythical, immortal));
		add(new Implication(new Negation(mythical), new Conjunction(new Negation(immortal), mammal)));
		add(new Implication(new Disjunction(immortal, mammal), horned));
		add(new Implication(horned, magical));
	}
	
	// truth-table enumeration method
	public void solveByEnumeration() {
		ProverEnumeration pe = new ProverEnumeration();
		System.out.println("------Prove By Enumeration------");
		
		Symbol mythical = this.intern("Mythical");
		Sentence smy = mythical;
		boolean valMyth = pe.entails(this, smy);
		System.out.println("Can we prove that the unicorn is mythical? "); // should be false
		System.out.println("Mythical: " + valMyth);
		
		Symbol magical = this.intern("Magical");
		Sentence sma = magical;
		boolean valMagi = pe.entails(this, sma);
		System.out.println("Can we prove that the unicorn is magical? "); // should be true
		System.out.println("Magical: " + valMagi);
		
		Symbol horned = this.intern("Horned");
		Sentence sh = horned;
		boolean valHorned = pe.entails(this, sh);
		System.out.println("Can we prove that the unicorn is horned? "); // should be true
		System.out.println("Horned: " + valHorned);
	}
	
	// a resolution-based theorem prover
	public void solveByResolution() {
		ProverResolution pr = new ProverResolution();
		System.out.println("------Prove By Resolution------");
		
		Symbol mythical = this.intern("Mythical");
		Sentence smy = mythical;
		boolean valMyth = pr.entails(this, smy);
		System.out.println("Can we prove that the unicorn is mythical? "); // should be false
		System.out.println("Mythical: " + valMyth);
		
		Symbol magical = this.intern("Magical");
		Sentence sma = magical;
		boolean valMagi = pr.entails(this, sma);
		System.out.println("Can we prove that the unicorn is magical? "); // should be true
		System.out.println("Magical: " + valMagi);
		
		Symbol horned = this.intern("Horned");
		Sentence sh = horned;
		boolean valHorned = pr.entails(this, sh);
		System.out.println("Can we prove that the unicorn is horned? "); // should be true
		System.out.println("Horned: " + valHorned);
	}
	
	public static void main(String[] args) {
		new HornClausesKB().dump();
		HornClausesKB kb = new HornClausesKB();
		
		System.out.println("\n" + "******Horn Clauses******");
		kb.solveByEnumeration();
		kb.solveByResolution();
	}

}
