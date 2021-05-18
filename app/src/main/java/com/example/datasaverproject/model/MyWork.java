package com.example.datasaverproject.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class MyWork implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int workId;

    private String emailPhn;
    private String pass;
    private String server;
    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }
    public String getEmailPhn() {
        return emailPhn;
    }

    public void setEmailPhn(String emailPhn) {
        this.emailPhn = emailPhn;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Ignore
    public MyWork(int workId, String emailPhn, String pass, String server) {
        this.workId = workId;
        this.emailPhn = emailPhn;
        this.pass = pass;
        this.server = server;
    }

    public MyWork(String emailPhn, String pass, String server) {
        this.emailPhn = emailPhn;
        this.pass = pass;
        this.server = server;
    }


}
