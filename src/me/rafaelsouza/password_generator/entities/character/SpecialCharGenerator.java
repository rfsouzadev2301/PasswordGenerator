package me.rafaelsouza.password_generator.entities.character;

public class SpecialCharGenerator extends CharGenerator{
	
	private final int minCodeANCII = 33, maxCodeANCII = 38;
	private final int minCodeSecondANCII = 63, maxCodeSecondANCII = 64;
	
	public SpecialCharGenerator() {
		super();
	}
	
	@Override
	public int randomANCII() {
		
		int[] optionsStack = new int[2];
		optionsStack[0] = (int) (Math.random() * (maxCodeANCII - minCodeANCII + 1)) + minCodeANCII;
		optionsStack[1] = (int) (Math.random() * (maxCodeSecondANCII - minCodeSecondANCII + 1)) + minCodeSecondANCII;
		
		return optionsStack[(int) (Math.random() * 2)];
	}
}