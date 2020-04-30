package com.szit.eurekacardmanage.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 安全问题实体类
 */
public class Question implements Serializable {
    private Integer id;//--主键（可选值1、2、3、4）
    private String question;//--安全问题

    public Question() {
    }

    public Question(Integer id, String question) {
        this.id = id;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(id, question1.id) &&
                Objects.equals(question, question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }
}
