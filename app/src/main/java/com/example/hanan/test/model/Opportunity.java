package com.example.hanan.test.model;

/**
 * Created by Hanan on 20/09/16.
 */
public class Opportunity {
    private int ID;
    private String name;
    private String SDate;
    private String EDate;
    private String STime;
    private String ETime;
    private String Status;
    private String description;
    private int num_of_v;
    private int current_num_of_v;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSDate() {
        return SDate;
    }

    public void setSDate(String SDate) {
        this.SDate = SDate;
    }

    public String getEDate() {
        return EDate;
    }

    public void setEDate(String EDate) {
        this.EDate = EDate;
    }

    public String getSTime() {
        return STime;
    }

    public void setSTime(String STime) {
        this.STime = STime;
    }

    public String getETime() {
        return ETime;
    }

    public void setETime(String ETime) {
        this.ETime = ETime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNum_of_v() {
        return num_of_v;
    }

    public void setNum_of_v(int num_of_v) {
        this.num_of_v = num_of_v;
    }

    public int getCurrent_num_of_v() {
        return current_num_of_v;
    }

    public void setCurrent_num_of_v(int current_num_of_v) {
        this.current_num_of_v = current_num_of_v;
    }
}
