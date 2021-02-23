package com.example.RolCharacterBook.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Character extends RealmObject implements Parcelable {


    @PrimaryKey
    private String UUID;
    private String name;
    private String email;
    private String charClass;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private Boolean isPlayer = false;
    private Date playDate;
    private String portrait;

    public Character() {
        this.UUID = java.util.UUID.randomUUID().toString();
    }


    public Character(String id, String name, String email, String portrait) {
        this.name = name;
        this.email = email;
        this.charClass = "";
        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.intelligence = 0;
        this.wisdom = 0;
        this.charisma = 0;
        this.isPlayer = true;
        this.playDate = new Date();
        this.portrait = portrait;
        if (id != null) {
            this.UUID = id;
        } else {
            this.UUID = java.util.UUID.randomUUID().toString();
        }
    }

    public Character(String name, String email, String charClass, Integer strength, Integer dexterity, Integer constitution,
                     Integer intelligence, Integer wisdom, Integer charisma, Boolean isPlayer, Date playDate, String portrait, String id) {
        this.name = name;
        this.email = email;
        this.charClass = charClass;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.isPlayer = isPlayer;
        this.playDate = playDate;
        this.portrait = portrait;
        if (id != null) {
            this.UUID = id;
        } else {
            this.UUID = java.util.UUID.randomUUID().toString();
        }
    }


    public String getId() {
        return UUID;
    }

    public void setId(String id) {
        this.UUID = id;
    }

    public void generateUUID() {
        if (this.UUID == null) {
            this.UUID = java.util.UUID.randomUUID().toString();
        }
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
        if (name != null && !name.matches("")) {
            this.name = name;
        } else {
            error = -1;
        }
        return error;
    }

    public String getEmail() {
        return email;
    }

    public int setEmail(String email) {
        int error = 0;
        if (email != null && !email.matches("")) {
            if (email.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")) {
                this.email = email;
            } else {
                error = -2;
            }
        } else {
            error = -1;
        }
        return error;
    }

    public Integer getStrength() {
        return strength;
    }

    public int setStrength(String strength) {
        int error = 0;
        if (strength != null && !strength.matches("")) {
            try {
                this.strength = Integer.parseInt(strength);
            } catch (NumberFormatException ex) {
                error = -3;
            }
        } else {
            error = -1;
        }
        return error;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public int setDexterity(String dexterity) {
        int error = 0;
        if (dexterity != null && !dexterity.matches("")) {
            try {
                this.dexterity = Integer.parseInt(dexterity);
            } catch (NumberFormatException ex) {
                error = -3;
            }
        } else {
            error = -1;
        }
        return error;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public int setConstitution(String constitution) {
        int error = 0;
        if (constitution != null && !constitution.matches("")) {
            try {
                this.constitution = Integer.parseInt(constitution);
            } catch (NumberFormatException ex) {
                error = -3;
            }
        } else {
            error = -1;
        }
        return error;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public int setIntelligence(String intelligence) {
        int error = 0;
        if (intelligence != null && !intelligence.matches("")) {
            try {
                this.intelligence = Integer.parseInt(intelligence);
            } catch (NumberFormatException ex) {
                error = -3;
            }
        } else {
            error = -1;
        }
        return error;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public int setWisdom(String wisdom) {
        int error = 0;
        if (wisdom != null && !wisdom.matches("")) {
            try {
                this.wisdom = Integer.parseInt(wisdom);
            } catch (NumberFormatException ex) {
                error = -3;
            }
        } else {
            error = -1;
        }
        return error;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public int setCharisma(String charisma) {
        int error = 0;
        if (charisma != null && !charisma.matches("")) {
            try {
                this.charisma = Integer.parseInt(charisma);
            } catch (NumberFormatException ex) {
                error = -3;
            }
        } else {
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

    public Date getPlayDate() {
        return playDate;
    }

    public String getPlayDateAsString() {
        if (playDate != null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(playDate);
        } else {
            return null;
        }
    }


    public int setPlayDate(String playDate) {
        int error = 0;
        if (playDate != null && !playDate.matches("")) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                try {
                    ZoneId defaultZoneId = ZoneId.systemDefault();
                    this.playDate = Date.from(LocalDate.parse(playDate).atStartOfDay(defaultZoneId).toInstant());
                } catch (DateTimeParseException ex) {
                    error = -2;
                }
            } else {
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(playDate);
                    this.playDate = date;
                } catch (ParseException ex) {
                    error = -2;
                }
            }
        } else {
            error = -1;
        }
        return error;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        return UUID.matches(character.UUID);
    }



    @Override
    public int hashCode() {
        int result = UUID.hashCode();
        return result;
    }

    public Bitmap getPortraitAsBitmap() {
        Bitmap decodedByte = null;
        if (this.portrait != null) {
            byte[] decodedString = Base64.decode(this.portrait, Base64.DEFAULT);
            decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        }
        return decodedByte;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(UUID);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(portrait);

    }


    private Character(Parcel in) {
        UUID = in.readString();
        name = in.readString();
        email = in.readString();
        portrait = in.readString();

    }


    public static final Parcelable.Creator<Character> CREATOR
            = new Parcelable.Creator<Character>() {
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        public Character[] newArray(int size) {
            return new Character[size];
        }
    };
}
