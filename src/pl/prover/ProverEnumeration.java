/* ZIYU SONG
 * NET ID: zsong10
 * CSC 242
 * Project 2
 */

package pl.prover;

import java.util.Collection;
import pl.core.*;

/**
 * Truth-Table Enumeration Algorithm
 * Pseudo-code From AIMA Figure 7.10
 */
public class ProverEnumeration implements Prover {

	public boolean entails(KB kb, Sentence alpha) {
		ModelClass m = new ModelClass();
		Collection<Symbol> symbols = kb.symbols();
		return checkAll(kb, alpha, symbols, m, 0);
	}
	
	public static boolean checkAll(KB kb, Sentence alpha, Collection<Symbol> symbols, Model model, int count) {
		if (count == symbols.size()) { // if empty
			if (model.satisfies(kb)) { // if the model satisfies the given knowledge base
				return model.satisfies(alpha); // return true if sentence holds within a model
			} else {
				return true;
			}
		} else {
			Symbol p = null;
			int i = 0;
			for (Symbol s : symbols) { // iterate symbols collection and set p(first) to s
				p = s;
				if (i == count) {
					break; // exit loop when iterated through collection
				}
				i++;
			}
			return (checkAll(kb, alpha, symbols, model.set(p, Boolean.TRUE), count+1) && 
					checkAll(kb, alpha, symbols, model.set(p, Boolean.FALSE), count+1));
		}		
	}

}
