/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.domain;

/**
 *
 * @author rowPC
 */
public class Polygraph {

    private String subjectNo;
    private String name;
    private String gender;
    private String age;
    private String birthdate;
    private String civilStatus;
    private String idPresented;
    private String address;
    private String caseNo;
    private String requestingParty;
    private String timeDateReceived;
    private String natureOfCase;
    private String examLocation;
    private String examDate;
    private String purpose;
    private String preTest;
    private String inTest;
    private String result;
    private String postTest;
    private String remarks;
    private String timeDateCompleted;
    private String examinerName;
    private String examinerRank;
    private String examinerPosition;
    private String notedName;
    private String notedRank;
    private String approvedName;
    private String approvedRank;
    private String approvedPosition;
    private String notedPosition;
    private String photoLocation;
    private String photoName;
    private int resultID;

    public Polygraph() {
    }

    public Polygraph(String subjectNo, String name, String gender, String age,
            String birthdate, String civilStatus, String idPresented, String address,
            String caseNo, String requestingParty, String timeDateReceived, String natureOfCase,
            String examLocation, String examDate, String purpose, String preTest, String inTest, String result,
            String postTest, String remarks, String timeDateCompleted, String examinerName, String examinerRank,
            String examinerPosition, String notedName, String notedRank, String notedPosition, String photoLocation, String photoName) {
        this.subjectNo = subjectNo;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthdate = birthdate;
        this.civilStatus = civilStatus;
        this.idPresented = idPresented;
        this.address = address;
        this.caseNo = caseNo;
        this.requestingParty = requestingParty;
        this.timeDateReceived = timeDateReceived;
        this.natureOfCase = natureOfCase;
        this.examLocation = examLocation;
        this.examDate = examDate;
        this.purpose = purpose;
        this.preTest = preTest;
        this.inTest = inTest;
        this.result = result;
        this.postTest = postTest;
        this.remarks = remarks;
        this.timeDateCompleted = timeDateCompleted;
        this.examinerName = examinerName;
        this.examinerRank = examinerRank;
        this.examinerPosition = examinerPosition;
        this.notedName = notedName;
        this.notedRank = notedRank;
        this.notedPosition = notedPosition;
        this.photoLocation = photoLocation;
        this.photoName = photoName;
    }

    /**
     * @return the subjectNo
     */
    public String getSubjectNo() {
        return subjectNo;
    }

    /**
     * @param subjectNo the subjectNo to set
     */
    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    /**
     * @return the civilStatus
     */
    public String getCivilStatus() {
        return civilStatus;
    }

    /**
     * @param civilStatus the civilStatus to set
     */
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    /**
     * @return the idPresented
     */
    public String getIdPresented() {
        return idPresented;
    }

    /**
     * @param idPresented the idPresented to set
     */
    public void setIdPresented(String idPresented) {
        this.idPresented = idPresented;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the caseNo
     */
    public String getCaseNo() {
        return caseNo;
    }

    /**
     * @param caseNo the caseNo to set
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    /**
     * @return the requestingParty
     */
    public String getRequestingParty() {
        return requestingParty;
    }

    /**
     * @param requestingParty the requestingParty to set
     */
    public void setRequestingParty(String requestingParty) {
        this.requestingParty = requestingParty;
    }

    /**
     * @return the timeDateReceived
     */
    public String getTimeDateReceived() {
        return timeDateReceived;
    }

    /**
     * @param timeDateReceived the timeDateReceived to set
     */
    public void setTimeDateReceived(String timeDateReceived) {
        this.timeDateReceived = timeDateReceived;
    }

    /**
     * @return the natureOfCase
     */
    public String getNatureOfCase() {
        return natureOfCase;
    }

    /**
     * @param natureOfCase the natureOfCase to set
     */
    public void setNatureOfCase(String natureOfCase) {
        this.natureOfCase = natureOfCase;
    }

    /**
     * @return the examLocation
     */
    public String getExamLocation() {
        return examLocation;
    }

    /**
     * @param examLocation the examLocation to set
     */
    public void setExamLocation(String examLocation) {
        this.examLocation = examLocation;
    }

    /**
     * @return the examDate
     */
    public String getExamDate() {
        return examDate;
    }

    /**
     * @param examDate the examDate to set
     */
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the timeDateCompleted
     */
    public String getTimeDateCompleted() {
        return timeDateCompleted;
    }

    /**
     * @param timeDateCompleted the timeDateCompleted to set
     */
    public void setTimeDateCompleted(String timeDateCompleted) {
        this.timeDateCompleted = timeDateCompleted;
    }

    /**
     * @return the examinerName
     */
    public String getExaminerName() {
        return examinerName;
    }

    /**
     * @param examinerName the examinerName to set
     */
    public void setExaminerName(String examinerName) {
        this.examinerName = examinerName;
    }

    /**
     * @return the examinerRank
     */
    public String getExaminerRank() {
        return examinerRank;
    }

    /**
     * @param examinerRank the examinerRank to set
     */
    public void setExaminerRank(String examinerRank) {
        this.examinerRank = examinerRank;
    }

    /**
     * @return the examinerPosition
     */
    public String getExaminerPosition() {
        return examinerPosition;
    }

    /**
     * @param examinerPosition the examinerPosition to set
     */
    public void setExaminerPosition(String examinerPosition) {
        this.examinerPosition = examinerPosition;
    }

    /**
     * @return the notedName
     */
    public String getNotedName() {
        return notedName;
    }

    /**
     * @param notedName the notedName to set
     */
    public void setNotedName(String notedName) {
        this.notedName = notedName;
    }

    /**
     * @return the notedRank
     */
    public String getNotedRank() {
        return notedRank;
    }

    /**
     * @param notedRank the notedRank to set
     */
    public void setNotedRank(String notedRank) {
        this.notedRank = notedRank;
    }

    /**
     * @return the notedPosition
     */
    public String getNotedPosition() {
        return notedPosition;
    }

    /**
     * @param notedPosition the notedPosition to set
     */
    public void setNotedPosition(String notedPosition) {
        this.notedPosition = notedPosition;
    }

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    /**
     * @return the purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose the purpose to set
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * @return the preTest
     */
    public String getPreTest() {
        return preTest;
    }

    /**
     * @param preTest the preTest to set
     */
    public void setPreTest(String preTest) {
        this.preTest = preTest;
    }

    /**
     * @return the inTest
     */
    public String getInTest() {
        return inTest;
    }

    /**
     * @param inTest the inTest to set
     */
    public void setInTest(String inTest) {
        this.inTest = inTest;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the postTest
     */
    public String getPostTest() {
        return postTest;
    }

    /**
     * @param postTest the postTest to set
     */
    public void setPostTest(String postTest) {
        this.postTest = postTest;
    }

    public String getApprovedName() {
        return approvedName;
    }

    public void setApprovedName(String approvedName) {
        this.approvedName = approvedName;
    }

    public String getApprovedRank() {
        return approvedRank;
    }

    public void setApprovedRank(String approvedRank) {
        this.approvedRank = approvedRank;
    }

    public String getApprovedPosition() {
        return approvedPosition;
    }

    public void setApprovedPosition(String approvedPosition) {
        this.approvedPosition = approvedPosition;
    }
    

    /**
     * @return the resultID
     */
    public int getResultID() {
        return resultID;
    }

    /**
     * @param resultID the resultID to set
     */
    public void setResultID(int resultID) {
        this.resultID = resultID;
    }
    
}
