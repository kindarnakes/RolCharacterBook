package com.example.RolCharacterBook.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
//Clase usada unicamente para no volver a cargar los datos de ejemplo una vez insertados
public class Example extends RealmObject {
    @PrimaryKey
    public int id = 1;
}
