package com.saferapps.sabiondo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Question implements Serializable {
    String question_text;
    String option_a;
    String option_b;
    String option_c;
    String option_d;
    String right_ans;
    String subject;
    String feedback;
    String uri;
    Boolean is_multiple_option;
    Boolean has_image;
    String img_url;
    Boolean is_boolean;
    String true_option;
    String false_option;
    Boolean is_text_response;
    String txt_response;

    public Question(){
    }

    public Question(String question_text, String option_a, String option_b, String option_c, String option_d, String right_ans, String subject, String feedback, String uri) {
        this.question_text = question_text;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
        this.right_ans = right_ans;
        this.subject = subject;
        this.feedback = feedback;
        this.uri = uri;
    }



    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getOption_a() {
        return option_a;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public String getOption_d() {
        return option_d;
    }

    public void setOption_d(String option_d) {
        this.option_d = option_d;
    }

    public String getRight_ans() {
        return right_ans;
    }

    public void setRight_ans(String right_ans) {
        this.right_ans = right_ans;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Boolean getIs_multiple_option() {
        return is_multiple_option;
    }

    public void setIs_multiple_option(Boolean is_multiple_option) {
        this.is_multiple_option = is_multiple_option;
    }

    public Boolean getHas_image() {
        return has_image;
    }

    public void setHas_image(Boolean has_image) {
        this.has_image = has_image;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Boolean getIs_boolean() {
        return is_boolean;
    }

    public void setIs_boolean(Boolean is_boolean) {
        this.is_boolean = is_boolean;
    }

    public String getTrue_option() {
        return true_option;
    }

    public void setTrue_option(String true_option) {
        this.true_option = true_option;
    }

    public String getFalse_option() {
        return false_option;
    }

    public void setFalse_option(String false_option) {
        this.false_option = false_option;
    }

    public Boolean getIs_text_response() {
        return is_text_response;
    }

    public void setIs_text_response(Boolean is_text_response) {
        this.is_text_response = is_text_response;
    }

    public String getTxt_response() {
        return txt_response;
    }

    public void setTxt_response(String txt_response) {
        this.txt_response = txt_response;
    }
}
