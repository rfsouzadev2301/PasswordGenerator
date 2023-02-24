package me.rafaelsouza.password_generator.entities.character;

public abstract class CharGenerator {
	
	public int minCodeANCII, maxCodeANCII;
	
	public CharGenerator() {
	}
	
	public CharGenerator(int minCodeANCII, int maxCodeANCII) {
		this.minCodeANCII = minCodeANCII;
		this.maxCodeANCII = maxCodeANCII;
	}

	public char randomCharacter() {
		return (char) randomANCII();
	}
		
	public int randomANCII() {
		return (int) (Math.random() * (maxCodeANCII - minCodeANCII + 1)) + minCodeANCII;
	}
}