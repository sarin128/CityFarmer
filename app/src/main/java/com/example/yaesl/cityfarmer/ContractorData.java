package com.example.yaesl.cityfarmer;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractorData implements Serializable {

    private int id;
    private String name;
    private Date TimeLimit;
    public String nowTime;

    public ContractorData() {
    }
    public ContractorData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ContractorData(String name) {
        this.name = name;
        setTimeLimit(new Date(System.currentTimeMillis()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        nowTime = sdf.format(TimeLimit);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimeLimit() {
        return TimeLimit;
    }

    public void setTimeLimit(Date timeLimit) {
        TimeLimit = timeLimit;
    }

    public String getTime(){return nowTime;}

    public String toString()
    {
        return id + ": " + name;
    }
}



