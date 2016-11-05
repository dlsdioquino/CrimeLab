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
public class Criminal {
    private String criminalDate;
    private String lastName;
    private String firstName;
    private String middleName;
    private String provincialAddress;
    private String civilStatus;
    private String spouseName;
    private String spouseAddress;
    private String educationalAttainment;
    private String voterId;
    private String fatherName;
    private String dialectSpoken;
    private String fatherAddress;
    private String civicOrganization;
    private String motherName;
    private String relativeAddress;
    private String motherAddress;
    private String caseNo;
    private String arrestNo;
    private String placeOfArrest;
    private String timeDateArrest;
    private String offenseCharge;
    private String arrestingOfficer;
    private int resultID;

    public Criminal() {
    }

    public Criminal(String criminalDate, String lastName, String firstName, String middleName, String provincialAddress, String civilStatus, String spouseName,
            String spouseAddress, String educationalAttainment, String voterId, String fatherName, String dialectSpoken,
            String fatherAddress, String civicOrganization, String motherName, String relativeAddress, String motherAddress,
            String caseNo, String arrestNo, String placeOfArrest, String timeDateArrest, String offenseCharge, String arrestingOfficer) {
        this.criminalDate = criminalDate;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.provincialAddress = provincialAddress;
        this.civilStatus = civilStatus;
        this.spouseName = spouseName;
        this.spouseAddress = spouseAddress;
        this.educationalAttainment = educationalAttainment;
        this.voterId = voterId;
        this.fatherName = fatherName;
        this.dialectSpoken = dialectSpoken;
        this.fatherAddress = fatherAddress;
        this.civicOrganization = civicOrganization;
        this.motherName = motherName;
        this.relativeAddress = relativeAddress;
        this.motherAddress = motherAddress;
        this.caseNo = caseNo;
        this.arrestNo = arrestNo;
        this.placeOfArrest = placeOfArrest;
        this.timeDateArrest = timeDateArrest;
        this.offenseCharge = offenseCharge;
        this.arrestingOfficer = arrestingOfficer;
    }
    
    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    /**
     * @return the criminalDate
     */
    public String getCriminalDate() {
        return criminalDate;
    }

    /**
     * @param criminalDate the criminalDate to set
     */
    public void setCriminalDate(String criminalDate) {
        this.criminalDate = criminalDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the provincialAddress
     */
    public String getProvincialAddress() {
        return provincialAddress;
    }

    /**
     * @param provincialAddress the provincialAddress to set
     */
    public void setProvincialAddress(String provincialAddress) {
        this.provincialAddress = provincialAddress;
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
     * @return the spouseName
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * @param spouseName the spouseName to set
     */
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    /**
     * @return the spouseAddress
     */
    public String getSpouseAddress() {
        return spouseAddress;
    }

    /**
     * @param spouseAddress the spouseAddress to set
     */
    public void setSpouseAddress(String spouseAddress) {
        this.spouseAddress = spouseAddress;
    }

    /**
     * @return the educationalAttainment
     */
    public String getEducationalAttainment() {
        return educationalAttainment;
    }

    /**
     * @param educationalAttainment the educationalAttainment to set
     */
    public void setEducationalAttainment(String educationalAttainment) {
        this.educationalAttainment = educationalAttainment;
    }

    /**
     * @return the voterId
     */
    public String getVoterId() {
        return voterId;
    }

    /**
     * @param voterId the voterId to set
     */
    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    /**
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return the dialectSpoken
     */
    public String getDialectSpoken() {
        return dialectSpoken;
    }

    /**
     * @param dialectSpoken the dialectSpoken to set
     */
    public void setDialectSpoken(String dialectSpoken) {
        this.dialectSpoken = dialectSpoken;
    }

    /**
     * @return the fatherAddress
     */
    public String getFatherAddress() {
        return fatherAddress;
    }

    /**
     * @param fatherAddress the fatherAddress to set
     */
    public void setFatherAddress(String fatherAddress) {
        this.fatherAddress = fatherAddress;
    }

    /**
     * @return the civicOrganization
     */
    public String getCivicOrganization() {
        return civicOrganization;
    }

    /**
     * @param civicOrganization the civicOrganization to set
     */
    public void setCivicOrganization(String civicOrganization) {
        this.civicOrganization = civicOrganization;
    }

    /**
     * @return the motherName
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName the motherName to set
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    /**
     * @return the relativeAddress
     */
    public String getRelativeAddress() {
        return relativeAddress;
    }

    /**
     * @param relativeAddress the relativeAddress to set
     */
    public void setRelativeAddress(String relativeAddress) {
        this.relativeAddress = relativeAddress;
    }

    /**
     * @return the motherAddress
     */
    public String getMotherAddress() {
        return motherAddress;
    }

    /**
     * @param motherAddress the motherAddress to set
     */
    public void setMotherAddress(String motherAddress) {
        this.motherAddress = motherAddress;
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
     * @return the arrestNo
     */
    public String getArrestNo() {
        return arrestNo;
    }

    /**
     * @param arrestNo the arrestNo to set
     */
    public void setArrestNo(String arrestNo) {
        this.arrestNo = arrestNo;
    }

    /**
     * @return the placeOfArrest
     */
    public String getPlaceOfArrest() {
        return placeOfArrest;
    }

    /**
     * @param placeOfArrest the placeOfArrest to set
     */
    public void setPlaceOfArrest(String placeOfArrest) {
        this.placeOfArrest = placeOfArrest;
    }

    /**
     * @return the arrestingOfficer
     */
    public String getArrestingOfficer() {
        return arrestingOfficer;
    }

    /**
     * @param arrestingOfficer the arrestingOfficer to set
     */
    public void setArrestingOfficer(String arrestingOfficer) {
        this.arrestingOfficer = arrestingOfficer;
    }

    /**
     * @return the offenseCharge
     */
    public String getOffenseCharge() {
        return offenseCharge;
    }

    /**
     * @param offenseCharge the offenseCharge to set
     */
    public void setOffenseCharge(String offenseCharge) {
        this.offenseCharge = offenseCharge;
    }

    /**
     * @return the timeDateArrest
     */
    public String getTimeDateArrest() {
        return timeDateArrest;
    }

    /**
     * @param timeDateArrest the timeDateArrest to set
     */
    public void setTimeDateArrest(String timeDateArrest) {
        this.timeDateArrest = timeDateArrest;
    }
}
