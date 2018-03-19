/* ZIYU SONG
 * NET ID: zsong10
 * CSC 242
 * Project 2
 */

package pl.prover;

import java.util.*;
import pl.core.*;
import pl.cnf.*;

/**
 * Resolution Algorithm For Propositional Logic
 * Pseudo-code From AIMA Figure 7.12
 */
public class ProverResolution {
	
	public boolean entails(KB k, Sentence alpha) {
		KB kb = k.copyKB();
		kb.add(new Negation(alpha)); // add negation of alpha to knowledge base
		Set<Clause> clauses = CNFConverter.convert(kb); // convert knowledge base to CNF
		Set<Clause> newClauses = new HashSet<>();
		Set<Clause> resolvents;
		
		while (true) {
			for (Clause ci : clauses) {
				for (Clause cj : clauses) { // for each pair of clauses ci, cj
					if (!ci.equals(cj)) {
						resolvents = resolve(ci, cj);
						for (Clause current : resolvents) {
							if (current.isEmpty()) { return true; } // if the resolvents contains the empty clause, return true
						}
						newClauses.addAll(resolvents);
					}
				}
			}
			if (clauses.containsAll(newClauses)) {
				return false;
			}
			// add new clauses to clauses
			clauses.addAll(newClauses);
		}
	}

	/**
	 * Resolves two propositional clauses
	 * Returns the set of possible clauses from resolving the two clauses
	 */
	public static Set<Clause> resolve(Clause c1, Clause c2) {

		Clause ci = c1.copyClause();
		Clause cj = c2.copyClause();
		Set<Clause> resolvents = new HashSet<>();
		
		for (Literal li : c1) {
			for (Literal lj : c2) {
				if (((li.getContent()).equals(lj.getContent())) && (!(li.getPolarity()).equals(lj.getPolarity()))) {
					// if the literals have the same symbol but opposite polarity, remove them from the clauses
					ci.remove(li);
					cj.remove(lj);
					ci.addAll(cj);
					
					resolvents.add(ci);
					return resolvents;
				}
			}
		}
		return resolvents;
	}
}