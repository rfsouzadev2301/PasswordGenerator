package me.rafaelsouza.password_generator.entities.character;

public class SimpleCharGenerator extends CharGenerator{
	
	private static final int minCodeANCII = 97, maxCodeANCII = 122;
	
	public SimpleCharGenerator() {
		super(minCodeANCII, maxCodeANCII);
	}
}
