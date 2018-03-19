package pl.core;

import java.util.HashMap;
import java.util.Map;

/**
 * A model is an assignment of the truth values to the propositional symbols
 * An implementation of Model interface
 */
public class ModelClass implements Model {
	
	HashMap<Symbol, Boolean> model;
	
	public ModelClass() {
		this.model = new HashMap<>();
	}
	
	public ModelClass(HashMap<Symbol, Boolean> model) {
		this.model = model;
	}
	
	// set a value to a symbol in this model
	public ModelClass set(Symbol sym, boolean value) {
		model.put(sym, value);
		return this;
	}

	// get boolean value associated with the given proposition symbol in this model
	public boolean get(Symbol sym) {
		return model.get(sym);
	}
	
	// return true if this model satisfies the given knowledge base
	public boolean satisfies(KB kb) {
		boolean value = true;
		for (Sentence s : kb.sentences) {
			value = value && s.isSatisfiedBy(this);
		}
		return value;
	}

	// return true if this model satisfies the given sentence
	public boolean satisfies(Sentence sentence) {
		return sentence.isSatisfiedBy(this);
	}
	
	// print all values in this model
	public void dump() {
		for (Map.Entry<Symbol, Boolean> i : model.entrySet()) {
			System.out.println(i.getKey().toString() + " : " + i.getValue());
		}
	}
	
}
