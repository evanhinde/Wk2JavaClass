package org.example;

import java.util.Arrays;
import java.util.List;
public class Card {
    //These are "instance variables". When you create an instance of your class
    //the system will reserve space in memory to store these items
    private String faceName;
    private String suit;

    /**
     * This is a constructor. It is called when we want to instantiate (create and instance) of our object.
     * It looks like a method, but does not have a return type and must have the
     * exact same name as the class
     */

    public Card(String faceName, String suit)
    {
        setFaceName(faceName);
        setSuit(suit);
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This method returns all the valid face names for Card objects
     */

    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");
    }

    public static List<String> getValidSuits()
    {
        return Arrays.asList("hearts","diamonds","clubs","spades");
    }

    /**
     * Validates that the argument (input) is a valid face name
     * @param faceName "2", "3", ..., "10", "jack",...
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();

        if(getValidFaceNames().contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + "must be in the list of" +
            getValidFaceNames());
    }

    public void setSuit(String suit) {
        suit = suit.toLowerCase();

        if (suit.charAt(suit.length()-1) != 's')
            suit = suit+"s";

        if(getValidSuits().contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + "must be in the list of" +
                    getValidSuits());
    }

    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }

    /**
     * This method returns the colour of the card.
     * Red = hearts or diamonds
     * Black = clubs or spades
     */
    public String getColour()
    {
        if(suit.equals("hearts")|| suit.equals("diamonds"))
            return "red";
        else
            return "black";
    }

    /**
     * This method will return the value of the card, assuming ace is highest
     */

    public int getCardValue()
    {
        List<String> faceNames = getValidFaceNames();
        int indexOfCard = faceNames.indexOf(faceName);
        return indexOfCard+2;
    }



}
