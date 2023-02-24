package me.rafaelsouza.password_generator.entities.password;

import java.util.ArrayList;
import java.util.List;

import me.rafaelsouza.password_generator.entities.character.CharGenerator;
import me.rafaelsouza.password_generator.entities.character.NumericCharGenerator;
import me.rafaelsouza.password_generator.entities.character.SimpleCharGenerator;
import me.rafaelsouza.password_generator.entities.character.SpecialCharGenerator;
import me.rafaelsouza.password_generator.entities.character.UppercaseCharGenerator;
import me.rafaelsouza.password_generator.exception.PasswordBuilderException;

public class PasswordBuilder {
	
	private boolean simpleChar, numericChar, specialChar, uppercaseChar;
	Character[] charactersOfPassword = null;
	
	public PasswordBuilder(){
		this.simpleChar = true;
		this.numericChar = false;
		this.specialChar = false;
		this.uppercaseChar = false;
	}
	
	public PasswordBuilder(boolean simpleChar, boolean numericChar, boolean specialChar, boolean uppercaseChar) {
		this.simpleChar = simpleChar;
		this.numericChar = numericChar;
		this.specialChar = specialChar;
		this.uppercaseChar = uppercaseChar;
	}

	public void generateRandomPassaword(int length) throws PasswordBuilderException {
		
		if (length < getSelectedTypes().size()) 
			throw new PasswordBuilderException("Password length is less than the amount of selected character types! Password legth: "
					+ length + " Amount character types: "
					+ getSelectedTypes().size());
		
		charactersOfPassword = new Character[length];
		
		for (CharGenerator charGenerator: getSelectedTypes()) {
			
			boolean hasItCharType = false;
			
			do {
				int randomIndexForInsert = (int) (Math.random() * charactersOfPassword.length);
				
				if(charactersOfPassword[randomIndexForInsert] == null) {
					charactersOfPassword[randomIndexForInsert] = (Character) charGenerator.randomCharacter();
					hasItCharType = true;
				}
			}while(hasItCharType == false);
		}
	
		for (int i = 0 ; i < length; i++) {
			
			int randomIndexOfSelectedTypes = (int) (Math.random() * getSelectedTypes().size());
			char randomChar = getSelectedTypes().get(randomIndexOfSelectedTypes).randomCharacter();
			
			if (charactersOfPassword[i] == null) {
				charactersOfPassword[i] = randomChar;
			}
		}
	}
	
	private List<CharGenerator> getSelectedTypes() {

		List<CharGenerator> charsSelected = new ArrayList<>();
		
		if(simpleChar == false && numericChar == false && specialChar == false && uppercaseChar == false ) {
			charsSelected.add(new SimpleCharGenerator());
			return charsSelected;
		}
		
		if (simpleChar == true) {
			charsSelected.add(new SimpleCharGenerator());
		}
		if (numericChar == true) {
			charsSelected.add(new NumericCharGenerator());
		}
		if (specialChar == true) {
			charsSelected.add(new SpecialCharGenerator());
		}
		if (uppercaseChar == true) {
			charsSelected.add(new UppercaseCharGenerator());
		}
		
		return charsSelected;
	}
	
	public Character[] getCharactersOfPassword() {
		return charactersOfPassword;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
			for (Character character: charactersOfPassword) {
				sb.append(character);
			}
	
		return sb.toString();
	}
}
