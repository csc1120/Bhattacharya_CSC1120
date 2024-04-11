package Week11;

import java.util.Objects;

// This is a Character2 class. It's an object oriented representation of a simple character,
// having just one attribute namely Name. It provides methods to change and retrieve the character name.
// This class overrides equals and hashCode methods from Object class to provide meaningful equality check
// and hash code for instances of Character2.
public class Character2 {
    private String Name;

    // This is a constructor method that is called when an object of Character2 class is instantiated.
    // It takes a character name as an input and sets it as the name of the newly created character.
    public Character2(String name) {
        Name = name;
    }

    // This method retrieves the name of the character.
    public String getName() {
        return Name;
    }

    // This method allows you to modify the name of the character.
    public void setName(String name) {
        Name = name;
    }

   // this method defines how to check if an object equals to this instance
    @Override
    public boolean equals(Object o) {
        // if object is compared with the instance itself, return true
        if (this == o) return true;
        // if object is not of type Character2, return false
        if (!(o instanceof Character2)) return false;

        // type casting of the object argument to Character2
        Character2 character = (Character2) o;

        // returns true if both character names are null or if character names are equal
      //  return getName() != null ? getName().equals(character.getName()) : character.getName() == null;
        // without ternary operator
        if (getName() != null) {
            return getName().equals(character.getName());
        } else {
            return character.getName() == null;
        }
    }

    // this method returns a hash code value for the object.
    // Two equal objects according to equals(Object obj) method should return same hash code
    @Override
    public int hashCode() {
        //return getName() != null ? getName().hashCode() : 0;
        // withouth ternary operator
       if (getName() != null) {
          return getName().hashCode();
        } else {
           return 0;
        }
    }
}