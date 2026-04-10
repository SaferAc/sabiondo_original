package com.saferapps.sabiondo.model;

import com.saferapps.sabiondo.adapter.DBHelper;

import java.util.Collections;
import java.util.List;

public class QuizTimeLevel {
    private int schoolGrade;
    private int noOfQuestion;
    private List<Quizplay> question;
    DBHelper questionsDao;

    public QuizTimeLevel(int schoolGrade,int noOfQuestion ,DBHelper questionsDao) {
        super();
        this.schoolGrade= schoolGrade;
        this.noOfQuestion= noOfQuestion;
        this.questionsDao = questionsDao;
    }


    public int getSchoolGrade() {return schoolGrade; }


    public int getNoOfQuestion() {
        return noOfQuestion;
    }

    public List<Quizplay> getQuestion() {
        return question;
    }

    public void setTimeQuestions() {
        question = questionsDao.getQuestions(getNoOfQuestion(), null, getSchoolGrade());
    }
}
