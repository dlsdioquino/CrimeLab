/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.domain;

import java.io.Serializable;

/**
 *
 * @author Daniel
 */
public class GalleryResults implements Serializable {

    private String caseNo;
    private String date;
    private String offenseIncident;
    private String nameAKA;
    private String sex;
    private String height;
    private String built;
    private String otherInfo;
    private String describedBy;
    private String requestingParty;
    private String investOnCase;
    private String interviewer;
    private String age;
    private String weight;
    private String complexion;
    private String rating;
    private String photoName;
    private String photoLocation;

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOffenseIncident() {
        return offenseIncident;
    }

    public void setOffenseIncident(String offenseIncident) {
        this.offenseIncident = offenseIncident;
    }

    public String getNameAKA() {
        return nameAKA;
    }

    public void setNameAKA(String nameAKA) {
        this.nameAKA = nameAKA;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBuilt() {
        return built;
    }

    public void setBuilt(String built) {
        this.built = built;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getDescribedBy() {
        return describedBy;
    }

    public void setDescribedBy(String describedBy) {
        this.describedBy = describedBy;
    }

    public String getRequestingParty() {
        return requestingParty;
    }

    public void setRequestingParty(String requestingParty) {
        this.requestingParty = requestingParty;
    }

    public String getInvestOnCase() {
        return investOnCase;
    }

    public void setInvestOnCase(String investOnCase) {
        this.investOnCase = investOnCase;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

}
