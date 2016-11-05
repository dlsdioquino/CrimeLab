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
public class Fingerprint {
    
    private String division;
    private String reportNo;
    private String caseType;
    private String suspect;
    private String victim;
    private String timeDateReceived;
    private String requestingParty;
    private String specimenSubmitted;
    private String purposeOfLabExam;
    private String findings;
    private String conclusion;
    private String remarks;
    private String timeDateCompleted;
    private String examinerName;
    private String examinerRank;
    private String examinerPosition;
    private String notedName;
    private String notedRank;
    private String notedPosition;
    private int resultID;
    
    public Fingerprint(){}
    
    public Fingerprint(String division, String reportNo, String caseType, String suspect, String victim, 
            String timeDateReceived, String requestingParty, String specimenSubmitted, String purposeOfLabExam, 
            String findings, String conclusion, String remarks, String timeDateCompleted, String examinerName,
            String examinerRank, String examinerPosition, String notedName, String notedRank, String notedPosition) {
        this.division = division;
        this.reportNo = reportNo;
        this.caseType = caseType;
        this.suspect = suspect;
        this.victim = victim;
        this.timeDateReceived = timeDateReceived;
        this.requestingParty = requestingParty;
        this.specimenSubmitted = specimenSubmitted;
        this.purposeOfLabExam = purposeOfLabExam;
        this.findings = findings;
        this.conclusion = conclusion;
        this.remarks = remarks;
        this.timeDateCompleted = timeDateCompleted;
        this.examinerName = examinerName;
        this.examinerRank = examinerRank;
        this.examinerPosition = examinerPosition;
        this.notedName = notedName;
        this.notedRank = notedRank;
        this.notedPosition = notedPosition;
    }

    /**
     * @return the division
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @return the reportNo
     */
    public String getReportNo() {
        return reportNo;
    }

    /**
     * @param reportNo the reportNo to set
     */
    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    /**
     * @return the caseType
     */
    public String getCaseType() {
        return caseType;
    }

    /**
     * @param caseType the caseType to set
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    /**
     * @return the suspect
     */
    public String getSuspect() {
        return suspect;
    }

    /**
     * @param suspect the suspect to set
     */
    public void setSuspect(String suspect) {
        this.suspect = suspect;
    }

    /**
     * @return the victim
     */
    public String getVictim() {
        return victim;
    }

    /**
     * @param victim the victim to set
     */
    public void setVictim(String victim) {
        this.victim = victim;
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
     * @return the specimenSubmitted
     */
    public String getSpecimenSubmitted() {
        return specimenSubmitted;
    }

    /**
     * @param specimenSubmitted the specimenSubmitted to set
     */
    public void setSpecimenSubmitted(String specimenSubmitted) {
        this.specimenSubmitted = specimenSubmitted;
    }

    /**
     * @return the purposeOfLabExam
     */
    public String getPurposeOfLabExam() {
        return purposeOfLabExam;
    }

    /**
     * @param purposeOfLabExam the purposeOfLabExam to set
     */
    public void setPurposeOfLabExam(String purposeOfLabExam) {
        this.purposeOfLabExam = purposeOfLabExam;
    }

    /**
     * @return the findings
     */
    public String getFindings() {
        return findings;
    }

    /**
     * @param findings the findings to set
     */
    public void setFindings(String findings) {
        this.findings = findings;
    }

    /**
     * @return the conclusion
     */
    public String getConclusion() {
        return conclusion;
    }

    /**
     * @param conclusion the conclusion to set
     */
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
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
