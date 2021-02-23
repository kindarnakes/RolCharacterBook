package com.example.RolCharacterBook;

import android.os.Build;

import com.example.RolCharacterBook.model.Character;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ModelTest {
    @Test
    public void emailValidator() {
        Character c = new Character();

        //Test set Email empty err_code = -1
        System.out.println("Check empty email");
        Assert.assertEquals(-1, c.setEmail("")); //=> true
        //Test set Email incorrect err_code = -2
        System.out.println("Check incorrect email");
        Assert.assertEquals(-2, c.setEmail("a")); //=> true
        Assert.assertEquals(-2, c.setEmail("a@a")); //=> true
        Assert.assertEquals(-2, c.setEmail("a@a.")); //=> true
        Assert.assertEquals(-2, c.setEmail("a@a.a")); //=> true
        Assert.assertEquals(-2, c.setEmail("a@a.a1")); //=> true
        Assert.assertEquals(-2, c.setEmail("a@a.aaaaaaa")); //=> true
        //Test set and get Email correct err_code=0
        System.out.println("Check correct email");
        Assert.assertEquals(0, c.setEmail("a@a.aa")); //=> true
        Assert.assertTrue(c.getEmail().matches("^a@a.aa$")); //=> true
        Assert.assertEquals(0, c.setEmail("example@example.com")); //=> true
        Assert.assertTrue(c.getEmail().matches("^example@example.com$")); //=> true

    }

    @Test
    public void nameValidator() {
        Character c = new Character();

        //Test set name empty err_code = -1
        System.out.println("Check empty name");
        Assert.assertEquals(-1, c.setName("")); //=> true
        //Test set Email correct err_code=0
        System.out.println("Check correct name");
        Assert.assertEquals(0, c.setName("NameValid")); //=> true

        //Test get Name
        Assert.assertTrue(c.getName().matches("^NameValid$")); //=> true

    }

    @Test
    public void strengthValidator() {
        Character c = new Character();

        //Test set Strength empty err_code = -1
        System.out.println("Check empty Strength");
        Assert.assertEquals(-1, c.setStrength("")); //=> true
        //Test set Strength incorrect err_code = -3
        System.out.println("Check incorrect Strength, not natural number");
        Assert.assertEquals(-3, c.setStrength("a")); //=> true
        Assert.assertEquals(-3, c.setStrength("20.0")); //=> true
        Assert.assertEquals(-3, c.setStrength("one")); //=> true
        //Test set Strength correct err_code=0
        System.out.println("Check correct Strength");
        Assert.assertEquals(0, c.setStrength("5")); //=> true
        Assert.assertEquals(0, c.setStrength("100")); //=> true

        //Test get Strength
        Assert.assertEquals(java.util.Optional.of(100), java.util.Optional.of(c.getStrength())); //=> true
        c.setStrength("4");
        Assert.assertEquals(java.util.Optional.of(4), java.util.Optional.of(c.getStrength())); //=> true

    }


    @Test
    public void dexterityValidator() {
        Character c = new Character();

        //Test set Dexterity empty err_code = -1
        System.out.println("Check empty Dexterity");
        Assert.assertEquals(-1, c.setDexterity("")); //=> true
        //Test set Dexterity incorrect err_code = -3
        System.out.println("Check incorrect Dexterity, not natural number");
        Assert.assertEquals(-3, c.setDexterity("a")); //=> true
        Assert.assertEquals(-3, c.setDexterity("20.0")); //=> true
        Assert.assertEquals(-3, c.setDexterity("one")); //=> true
        //Test set Dexterity correct err_code=0
        System.out.println("Check correct Dexterity");
        Assert.assertEquals(0, c.setDexterity("5")); //=> true
        Assert.assertEquals(0, c.setDexterity("100")); //=> true

        //Test get Dexterity
        Assert.assertEquals(java.util.Optional.of(100), java.util.Optional.of(c.getDexterity())); //=> true
        c.setDexterity("4");
        Assert.assertEquals(java.util.Optional.of(4), java.util.Optional.of(c.getDexterity())); //=> true

    }


    @Test
    public void constitutionValidator() {
        Character c = new Character();

        //Test set Constitution empty err_code = -1
        System.out.println("Check empty Constitution");
        Assert.assertEquals(-1, c.setConstitution("")); //=> true
        //Test set Constitution incorrect err_code = -3
        System.out.println("Check incorrect Constitution, not natural number");
        Assert.assertEquals(-3, c.setConstitution("a")); //=> true
        Assert.assertEquals(-3, c.setConstitution("20.0")); //=> true
        Assert.assertEquals(-3, c.setConstitution("one")); //=> true
        //Test set Constitution correct err_code=0
        System.out.println("Check correct Constitution");
        Assert.assertEquals(0, c.setConstitution("5")); //=> true
        Assert.assertEquals(0, c.setConstitution("100")); //=> true

        //Test get Constitution
        Assert.assertEquals(java.util.Optional.of(100), java.util.Optional.of(c.getConstitution())); //=> true
        c.setConstitution("4");
        Assert.assertEquals(java.util.Optional.of(4), java.util.Optional.of(c.getConstitution())); //=> true

    }

    @Test
    public void intelligenceValidator() {
        Character c = new Character();

        //Test set Intelligence empty err_code = -1
        System.out.println("Check empty Intelligence");
        Assert.assertEquals(-1, c.setIntelligence("")); //=> true
        //Test set Intelligence incorrect err_code = -3
        System.out.println("Check incorrect Intelligence, not natural number");
        Assert.assertEquals(-3, c.setIntelligence("a")); //=> true
        Assert.assertEquals(-3, c.setIntelligence("20.0")); //=> true
        Assert.assertEquals(-3, c.setIntelligence("one")); //=> true
        //Test set Intelligence correct err_code=0
        System.out.println("Check correct Intelligence");
        Assert.assertEquals(0, c.setIntelligence("5")); //=> true
        Assert.assertEquals(0, c.setIntelligence("100")); //=> true

        //Test get Intelligence
        Assert.assertEquals(java.util.Optional.of(100), java.util.Optional.of(c.getIntelligence())); //=> true
        c.setIntelligence("4");
        Assert.assertEquals(java.util.Optional.of(4), java.util.Optional.of(c.getIntelligence())); //=> true

    }

    @Test
    public void wisdomValidator() {
        Character c = new Character();

        //Test set Wisdom empty err_code = -1
        System.out.println("Check empty Wisdom");
        Assert.assertEquals(-1, c.setWisdom("")); //=> true
        //Test set Wisdom incorrect err_code = -3
        System.out.println("Check incorrect Wisdom, not natural number");
        Assert.assertEquals(-3, c.setWisdom("a")); //=> true
        Assert.assertEquals(-3, c.setWisdom("20.0")); //=> true
        Assert.assertEquals(-3, c.setWisdom("one")); //=> true
        //Test set Wisdom correct err_code=0
        System.out.println("Check correct Wisdom");
        Assert.assertEquals(0, c.setWisdom("5")); //=> true
        Assert.assertEquals(0, c.setWisdom("100")); //=> true

        //Test get Wisdom
        Assert.assertEquals(java.util.Optional.of(100), java.util.Optional.of(c.getWisdom())); //=> true
        c.setWisdom("4");
        Assert.assertEquals(java.util.Optional.of(4), java.util.Optional.of(c.getWisdom())); //=> true

    }

    @Test
    public void charismaValidator() {
        Character c = new Character();

        //Test set Charisma empty err_code = -1
        System.out.println("Check empty Charisma");
        Assert.assertEquals(-1, c.setCharisma("")); //=> true
        //Test set Charisma incorrect err_code = -3
        System.out.println("Check incorrect Charisma, not natural number");
        Assert.assertEquals(-3, c.setCharisma("a")); //=> true
        Assert.assertEquals(-3, c.setCharisma("20.0")); //=> true
        Assert.assertEquals(-3, c.setCharisma("one")); //=> true
        //Test set Charisma correct err_code=0
        System.out.println("Check correct Charisma");
        Assert.assertEquals(0, c.setCharisma("5")); //=> true
        Assert.assertEquals(0, c.setCharisma("100")); //=> true

        //Test get Charisma
        Assert.assertEquals(java.util.Optional.of(100), java.util.Optional.of(c.getCharisma())); //=> true
        c.setCharisma("4");
        Assert.assertEquals(java.util.Optional.of(4), java.util.Optional.of(c.getCharisma())); //=> true

    }


    @Test
    public void playerValidator(){
        Character c = new Character();

        //Test set get Player
        System.out.println("Check player");
        c.setPlayer(true);
        Assert.assertTrue(c.getPlayer());
        c.setPlayer(false);
        Assert.assertFalse(c.getPlayer());
    }


    @Test
    public void playDateValidator() throws ParseException {
        Character c = new Character();

        //Test empty Date err_code=1
        System.out.println("Check empty PlayDate");
        Assert.assertEquals(-1, c.setPlayDate(""));
        //Test incorrect Date err_code=-2
        System.out.println("Check incorrect PlayDate");
        Assert.assertEquals(-2, c.setPlayDate("55"));
        Assert.assertEquals(-2, c.setPlayDate("aa/aa/aaaa"));
        Assert.assertEquals(-2, c.setPlayDate("aa-aa-aaaa"));
        Assert.assertEquals(-2, c.setPlayDate("1000/05/20"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //Only in newer versions, incorrect date value
            System.out.println("Check correct PlayDate based on LocalDate not Date class");
            Assert.assertEquals(-2, c.setPlayDate("1998-02-55"));
            Assert.assertEquals(-2, c.setPlayDate("1998-20-10"));
        }

        //Test get set Date correct
        System.out.println("Check correct PlayDate");
        Assert.assertEquals(0, c.setPlayDate("2000-02-10"));
        Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-10"), c.getPlayDate());
        Assert.assertTrue(c.getPlayDateAsString().matches("^2000-02-10$"));
        Assert.assertEquals(0, c.setPlayDate("2020-02-10"));
        Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-10"), c.getPlayDate());
        Assert.assertTrue(c.getPlayDateAsString().matches("^2020-02-10$"));

    }


    @Test
    public void charClassValidator() {
        Character c = new Character();

        System.out.println("Check correct charClass");
        //Test set get charClass
        c.setCharClass("charClass");
        Assert.assertTrue(c.getCharClass().matches("^charClass$")); //=> true

    }

    @Test
    public void portraitValidator() {
        Character c = new Character();

        System.out.println("Check correct portrait");
        //Test set get Portrait
        c.setPortrait("Portrait");
        Assert.assertTrue(c.getPortrait().matches("^Portrait$")); //=> true

    }



}