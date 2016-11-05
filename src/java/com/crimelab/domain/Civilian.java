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
public class Civilian {
    private String stationTaken;
    private String dateTaken;
    private String region;
    private String civilStatus;
    private String voterNo;
    private String spouseName;
    private String race;
    private String spouseAddress;
    private String height;
    private String weight;
    private String hair;
    private String eyes;
    private String complexion;
    private String dialectSpoken;
    private String provincialAddress;
    private String purpose;
    private String nameOfPerson;
    private String educationalAttainment;
    private String nameOfOfficial;
    private String parentsName;
    private String relativeAddress;
    private String reportNo;
    private String parentsAddress;
    private int resultID;
    
    public Civilian(){}
    
    public Civilian(String stationTaken, String dateTaken, String region, String civilStatus, String voterNo, String spouseName,
            String race, String spouseAddress, String height, String weight, String hair, String eyes, String complexion,
            String dialectSpoken, String provincialAddress, String purpose, String nameOfPerson, String educationalAttainment,
            String nameOfOfficial, String parentsName, String relativeAddress, String reportNo, String parentsAddress) {
        this.stationTaken = stationTaken;
        this.dateTaken = dateTaken;
        this.region = region;
        this.civilStatus = civilStatus;
        this.voterNo = voterNo;
        this.spouseName = spouseName;
        this.race = race;
        this.spouseAddress = spouseAddress;
        this.height = height;
        this.weight = weight;
        this.hair = hair;
        this.eyes = eyes;
        this.complexion = complexion;
        this.dialectSpoken = dialectSpoken;
        this.provincialAddress = provincialAddress;
        this.purpose = purpose;
        this.nameOfPerson = nameOfPerson;
        this.educationalAttainment = educationalAttainment;
        this.nameOfOfficial = nameOfOfficial;
        this.parentsName = parentsName;
        this.relativeAddress = relativeAddress;
        this.reportNo = reportNo;
        this.parentsAddress = parentsAddress;
    }
    
    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }    

    /**
     * @return the stationTaken
     */
    public String getStationTaken() {
        return stationTaken;
    }

    /**
     * @param stationTaken the stationTaken to set
     */
    public void setStationTaken(String stationTaken) {
        this.stationTaken = stationTaken;
    }

    /**
     * @return the dateTaken
     */
    public String getDateTaken() {
        return dateTaken;
    }

    /**
     * @param dateTaken the dateTaken to set
     */
    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
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
     * @return the voterNo
     */
    public String getVoterNo() {
        return voterNo;
    }

    /**
     * @param voterNo the voterNo to set
     */
    public void setVoterNo(String voterNo) {
        this.voterNo = voterNo;
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
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace(String race) {
        this.race = race;
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
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the hair
     */
    public String getHair() {
        return hair;
    }

    /**
     * @param hair the hair to set
     */
    public void setHair(String hair) {
        this.hair = hair;
    }

    /**
     * @return the eyes
     */
    public String getEyes() {
        return eyes;
    }

    /**
     * @param eyes the eyes to set
     */
    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    /**
     * @return the complexion
     */
    public String getComplexion() {
        return complexion;
    }

    /**
     * @param complexion the complexion to set
     */
    public void setComplexion(String complexion) {
        this.complexion = complexion;
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
     * @return the nameOfPerson
     */
    public String getNameOfPerson() {
        return nameOfPerson;
    }

    /**
     * @param nameOfPerson the nameOfPerson to set
     */
    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
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
     * @return the nameOfOfficial
     */
    public String getNameOfOfficial() {
        return nameOfOfficial;
    }

    /**
     * @param nameOfOfficial the nameOfOfficial to set
     */
    public void setNameOfOfficial(String nameOfOfficial) {
        this.nameOfOfficial = nameOfOfficial;
    }

    /**
     * @return the parentsName
     */
    public String getParentsName() {
        return parentsName;
    }

    /**
     * @param parentsName the parentsName to set
     */
    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
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
     * @return the parentsAddress
     */
    public String getParentsAddress() {
        return parentsAddress;
    }

    /**
     * @param parentsAddress the parentsAddress to set
     */
    public void setParentsAddress(String parentsAddress) {
        this.parentsAddress = parentsAddress;
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
}
