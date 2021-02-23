package com.example.RolCharacterBook;


import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmConfiguration;


@RunWith(AndroidJUnit4.class)
public class DataTest {

    private Data data;

    public DataTest() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Realm.init(appContext);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .name("TESTRolCharacterBook.realm")
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(config);

        data = Data.getDATA();
    }



    @Test
    public void loadAllTest(){
        Log.d("TEST","load All test");
        Assert.assertEquals(10, data.loadAll().size()); //por defecto tenemos 10 elementos
    }


    @Test
    public void removeTest(){
        Log.d("TEST","remove test");
        Character c = data.loadAll().get(0);
        data.remove(c);
        Assert.assertFalse(data.loadAll().contains(c));
        data.save(c);
        Assert.assertEquals(10, data.loadAll().size());
    }

    @Test
    public void saveTest(){
        Log.d("TEST","save test");
        Character c = new Character();
        data.save(c);
        c = data.getById(c.getId());//realm cambia la clase, necesitamos cargarlo de nuevo o el equals no funcionara
        Assert.assertTrue(data.loadAll().contains(c));
        data.remove(c);
        Assert.assertEquals(10, data.loadAll().size());
    }

    @Test
    public void getByIdTest(){
        Log.d("TEST","save test");
        Character c = data.loadAll().get(0);
        Character b = data.getById(c.getId());

        Assert.assertTrue(c.equals(b));

    }

    @Test
    public void searchTest() throws ParseException {
        Log.d("TEST","search test");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-10");
        Character c = new Character("1", "1", "1", 1, 1,1,1,1,1, true, date, "","44");
        data.save(c);
        Assert.assertTrue(data.search("1", "", "").size() == 1);
        Assert.assertTrue(data.search("1", c.getPlayDateAsString(), "").size() == 1);
        Assert.assertTrue(data.search("", "", "1").size() == 1);
        Assert.assertTrue(data.search("", c.getPlayDateAsString(), "1").size() == 1);
        Assert.assertTrue(data.search("1", "", "1").size() == 1);
        Assert.assertTrue(data.search("1", c.getPlayDateAsString(), "1").size() == 1);
        Assert.assertTrue(data.search("5", "", "15").size() == 0);
        Assert.assertTrue(data.search("", "", "").size() == 11);
        data.remove(data.getById(c.getId()));
        Assert.assertTrue(data.search("", "", "").size() == 10);
    }


}
