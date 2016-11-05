/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.domain;

/**
 *
 * @author TeeDee
 */
public class PiReport {
    private String examType;
    private String reportNo;
    private String caseType;
    private String suspects;
    private String victims;
    private String timeDateReceived;
    private String requestingParty;
    private String specimenSubmitted;
    private String purposeOfLabExam;
    private String findings;
    private String conclusions;
    private String remarks;
    private String timeDateCompleted;
    private String examinerName;
    private String examinerRank;
    private String examinerPosition;
    private String appName;
    private String appRank;
    private String appPosition;
    private String notedName;
    private String notedRank;
    private String notedPosition;
    private int resultID;

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getSpecimenSubmitted() {
        return specimenSubmitted;
    }

    public void setSpecimenSubmitted(String specimenSubmitted) {
        this.specimenSubmitted = specimenSubmitted;
    }

    public String getPurposeOfLabExam() {
        return purposeOfLabExam;
    }

    public void setPurposeOfLabExam(String purposeOfLabExam) {
        this.purposeOfLabExam = purposeOfLabExam;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public String getConclusions() {
        return conclusions;
    }

    public void setConclusions(String conclusions) {
        this.conclusions = conclusions;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTimeDateCompleted() {
        return timeDateCompleted;
    }

    public void setTimeDateCompleted(String timeDateCompleted) {
        this.timeDateCompleted = timeDateCompleted;
    }

    public String getExaminerName() {
        return examinerName;
    }

    public void setExaminerName(String examinerName) {
        this.examinerName = examinerName;
    }

    public String getExaminerRank() {
        return examinerRank;
    }

    public void setExaminerRank(String examinerRank) {
        this.examinerRank = examinerRank;
    }

    public String getExaminerPosition() {
        return examinerPosition;
    }

    public void setExaminerPosition(String examinerPosition) {
        this.examinerPosition = examinerPosition;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppRank() {
        return appRank;
    }

    public void setAppRank(String appRank) {
        this.appRank = appRank;
    }

    public String getAppPosition() {
        return appPosition;
    }

    public void setAppPosition(String appPosition) {
        this.appPosition = appPosition;
    }

    public String getNotedName() {
        return notedName;
    }

    public void setNotedName(String notedName) {
        this.notedName = notedName;
    }

    public String getNotedRank() {
        return notedRank;
    }

    public void setNotedRank(String notedRank) {
        this.notedRank = notedRank;
    }

    public String getNotedPosition() {
        return notedPosition;
    }

    public void setNotedPosition(String notedPosition) {
        this.notedPosition = notedPosition;
    }
    
  
    
    public String getReportNo(){
        return reportNo;
    }
    
    public void setReportNo(String reportNo){
        this.reportNo = reportNo;
    }
    
    public String getCaseType(){
        return caseType;
    }
    
    public void setCaseType(String caseType){
        this.caseType = caseType;
    }
    
    public String getSuspects(){
        return suspects;
    }
    
    public void setSuspects(String suspects){
        this.suspects = suspects;
    }
    
    public String getVictims(){
        return victims;
    }
    
    public void setVictims(String victims){
        this.victims = victims;
    }
    
    public String getTimeDateReceived(){
        return timeDateReceived;
    }
    
    public void setTimeDateReceived(String timeDateReceived){
        this.timeDateReceived = timeDateReceived;
    }
    
    public String getRequestingParty(){
        return requestingParty;
    }
    
    public void setRequestingParty(String requestingParty){
        this.requestingParty = requestingParty;
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
