package com.kenmeidearu.searchablespinnerlibrary;

import java.io.Serializable;

/**
 * Created by kenjin on 11/11/2016.
 */
public class  mListString implements Serializable {
    private  int _id;
    private String nilai1;
    private String nilai2;
    private String nilai3;
    private String nilai4;

    public mListString() {
    }

    public mListString(int id,String nilai1) {
        this._id=id;
        this.nilai1 = nilai1;
    }
    public mListString(int id,String nilai1, String nilai2) {
        this._id=id;
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
    }
    public mListString(int id,String nilai1, String nilai2, String nilai3) {
        this._id=id;
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
        this.nilai3 = nilai3;
    }
    public mListString(int id,String nilai1, String nilai2, String nilai3, String nilai4) {
        this._id=id;
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
        this.nilai3 = nilai3;
        this.nilai4 = nilai4;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNilai1() {
        return nilai1;
    }

    public void setNilai1(String nilai1) {
        this.nilai1 = nilai1;
    }

    public String getNilai2() {
        return nilai2;
    }

    public void setNilai2(String nilai2) {
        this.nilai2 = nilai2;
    }

    public String getNilai3() {
        return nilai3;
    }

    public void setNilai3(String nilai3) {
        this.nilai3 = nilai3;
    }

    public String getNilai4() {
        return nilai4;
    }

    public void setNilai4(String nilai4) {
        this.nilai4 = nilai4;
    }
}