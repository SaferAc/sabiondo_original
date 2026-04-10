package com.saferapps.sabiondo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Quiz implements Serializable {
    private String id;
    private String title;
    private String school_level;
    private int grade;
    private int trimester;
    private int time;
    private List<Question> question_list;
    private int votes;
    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Quiz(){ }

    public Quiz(String title, String school_level, int grade, int trimester, int time, List<Question> question_list, int votes,String userid) {
        this.title = title;
        this.school_level = school_level;
        this.grade = grade;
        this.trimester = trimester;
        this.time = time;
        this.question_list = question_list;
        this.votes = votes;
        this.userid= userid;
    }
    public Quiz(String title, String school_level, int grade,int time, List<Question> question_list, int votes,String userid) {
        this.title = title;
        this.school_level = school_level;
        this.grade = grade;
        this.time = time;
        this.question_list = question_list;
        this.votes = votes;
        this.userid= userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchool_level() {
        return school_level;
    }

    public void setSchool_level(String school_level) {
        this.school_level = school_level;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getTrimester() {
        return trimester;
    }

    public void setTrimester(int trimester) {
        this.trimester = trimester;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Question> getQuestion_list() {
        return question_list;
    }

    public void setQuestion_list(List<Question> question_list) {
        this.question_list = question_list;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}