package me.rafaelsouza.password_generator.entities.character;

public class UppercaseCharGenerator extends CharGenerator{

	private static final int minCodeANCII = 65, maxCodeANCII = 90;

	public UppercaseCharGenerator() {
		super(minCodeANCII, maxCodeANCII);
	}

}
