package com.saferapps.sabiondo.model;




import com.saferapps.sabiondo.adapter.DBHelper;

import java.util.Collections;
import java.util.List;

public class QuizLevel {
    private int schoolGrade;
    private int levelNo;
    private int noOfQuestion;
    private List<Quizplay> question;
    DBHelper questionsDao;

    public QuizLevel(int levelNo, int schoolGrade, int noOfQuestion, DBHelper questionsDao) {
        super();
        this.levelNo = levelNo;
        this.schoolGrade= schoolGrade;
        this.noOfQuestion = noOfQuestion;
        this.questionsDao = questionsDao;
    }
    public QuizLevel(int schoolGrade, int noOfQuestion, DBHelper questionsDao) {
        super();
        this.schoolGrade= schoolGrade;
        this.noOfQuestion = noOfQuestion;
        this.questionsDao = questionsDao;
    }


    public int getLevelNo() {
        return levelNo;
    }

    public int getSchoolGrade() {return schoolGrade; }


    public int getNoOfQuestion() {
        return noOfQuestion;
    }

    public List<Quizplay> getQuestion() {
        return question;
    }

    public void setQuestionGuj() {
        question = questionsDao.getQuestions(getNoOfQuestion(), getLevelNo(), getSchoolGrade());
    }

    public void setQuestionRandom() {
        question = questionsDao.getQuestions(getNoOfQuestion(), null, getSchoolGrade());
    }

    }
