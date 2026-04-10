package com.saferapps.sabiondo.model;


import java.util.ArrayList;

public class Quizplay{
	public void setQuestion(String question) {
		this.question = question;
	}

	private String question, feedback;
	private ArrayList<String> options = new ArrayList<>();
	private String trueAns;

	public Quizplay(String question) {
		super();
		this.question = question;
	}
	public String getQuestion() {
		return question;
	}
	public boolean addOption(String option) {
		return this.options.add(option);
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public String getTrueAns() {
		return trueAns;
	}
	public void setTrueAns(String trueAns) {
		this.trueAns = trueAns;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Question: " + question + " Options: " + options;
	}

}
