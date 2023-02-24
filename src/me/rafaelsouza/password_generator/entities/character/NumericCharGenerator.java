package me.rafaelsouza.password_generator.entities.character;

public class NumericCharGenerator extends CharGenerator{

	private static final int minCodeANCII = 48, maxCodeANCII = 57;
	
	public NumericCharGenerator() {
		super(minCodeANCII, maxCodeANCII);
	}
	
}
