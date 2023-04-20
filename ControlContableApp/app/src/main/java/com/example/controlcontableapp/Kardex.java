package com.example.controlcontableapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Kardex {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String asdsa;

}
