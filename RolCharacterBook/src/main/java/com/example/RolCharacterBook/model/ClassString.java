package com.example.RolCharacterBook.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ClassString extends RealmObject {

    @PrimaryKey
    public String _name;

}
