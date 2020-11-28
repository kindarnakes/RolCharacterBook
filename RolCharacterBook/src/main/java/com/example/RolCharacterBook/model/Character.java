package com.example.RolCharacterBook.model;

import android.media.Image;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Character {

    private String name;
    private String email;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private Boolean isPlayer;
    private LocalDate playDate;
    private Image portrait;

    public Character() {
    }

    public Character(String name, String email, Integer strength, Integer dexterity, Integer constitution,
                     Integer intelligence, Integer wisdom, Integer charisma, Boolean isPlayer, LocalDate playDate, Image portrait) {
        this.name = name;
        this.email = email;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.isPlayer = isPlayer;
        this.playDate = playDate;
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    /*
    error -1 -> Obligatory field
    error -2 -> Incorrect Value
    error -3 -> Must a numeric value
    */
    public int setName(String name) {
        int error = 0;
        if(name != null && !name.matches("")){
        this.name = name;
        }else{
            error = -1;
        }
        return error;
    }

    public String getEmail() {
        return email;
    }

    public int setEmail(String email) {
        int error = 0;
        if(email != null && !email.matches("")){
            if(email.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")){
                this.email = email;
            }else{
                error = -2;
            }
        }else{
            error = -1;
        }
        return error;
    }

    public Integer getStrength() {
        return strength;
    }

    public int setStrength(String strength) {
        int error = 0;
        if(strength != null && !strength.matches("")){
            try {
                this.strength = Integer.parseInt(strength);
            }catch (NumberFormatException ex){
                error = -3;
            }
        }else {
            error = -1;
        }
        return error;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public int setDexterity(String dexterity) {
        int error = 0;
        if(dexterity != null && !dexterity.matches("")){
            try {
                this.dexterity = Integer.parseInt(dexterity);
            }catch (NumberFormatException ex){
                error = -3;
            }
        }else {
            error = -1;
        }
        return error;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public int setConstitution(String constitution) {
        int error = 0;
        if(constitution != null && !constitution.matches("")){
            try {
                this.constitution = Integer.parseInt(constitution);
            }catch (NumberFormatException ex){
                error = -3;
            }
        }else {
            error = -1;
        }
        return error;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public int setIntelligence(String intelligence) {
        int error = 0;
        if(intelligence != null && !intelligence.matches("")){
            try {
                this.intelligence = Integer.parseInt(intelligence);
            }catch (NumberFormatException ex){
                error = -3;
            }
        }else {
            error = -1;
        }
        return error;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public int setWisdom(String wisdom) {
        int error = 0;
        if(wisdom != null && !wisdom.matches("")){
            try {
                this.wisdom = Integer.parseInt(wisdom);
            }catch (NumberFormatException ex){
                error = -3;
            }
        }else {
            error = -1;
        }
        return error;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public int setCharisma(String charisma) {
        int error = 0;
        if(charisma != null && !charisma.matches("")){
            try {
                this.charisma = Integer.parseInt(charisma);
            }catch (NumberFormatException ex){
                error = -3;
            }
        }else {
            error = -1;
        }
        return error;
    }

    public Boolean getPlayer() {
        return isPlayer;
    }

    public void setPlayer(Boolean player) {
        isPlayer = player;
    }

    public LocalDate getPlayDate() {
        return playDate;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int setPlayDate(String playDate) {
        int error = 0;
        if(playDate != null && !playDate.matches("")){
            try {
                this.playDate = LocalDate.parse(playDate);
            }catch (DateTimeParseException ex){
                error = -2;
            }
        }else {
            error = -1;
        }
        return error;
    }

    public Image getPortrait() {
        return portrait;
    }

    public void setPortrait(Image portrait) {
        this.portrait = portrait;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;

        Character character = (Character) o;

        if (!name.equals(character.name)) return false;
        if (!strength.equals(character.strength)) return false;
        if (!dexterity.equals(character.dexterity)) return false;
        if (!constitution.equals(character.constitution)) return false;
        if (!intelligence.equals(character.intelligence)) return false;
        if (!wisdom.equals(character.wisdom)) return false;
        return charisma.equals(character.charisma);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + strength.hashCode();
        result = 31 * result + dexterity.hashCode();
        result = 31 * result + constitution.hashCode();
        result = 31 * result + intelligence.hashCode();
        result = 31 * result + wisdom.hashCode();
        result = 31 * result + charisma.hashCode();
        return result;
    }
}
