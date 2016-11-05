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
public class MacroEtching {
    private String dateCreated;
    private String chassisNo;
    private String engineNo;
    private String rclo;
    private String make;
    private String color;
    private String plateNo;
    private String owner;
    private String address;
    private String appName;
    private String appRank;
    private String appPosition;
    private String examinerName;
    private String examinerRank;
    private String examinerPosition;
    private int resultID;

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
    
    public String getDateCreated(){
        return dateCreated;
    }
    
    public void setDateCreated(String dateCreated){
        this.dateCreated = dateCreated;
    }
    
    public String getChassisNo(){
        return chassisNo;
    }
    
    public void setChassisNo(String chassisNo){
        this.chassisNo = chassisNo;
    }
    
    public String getEngineNo(){
        return engineNo;
    }
    
    public void setEngineNo(String engineNo){
        this.engineNo = engineNo;
    }
    
    public String getRclo(){
        return rclo;
    }
    
    public void setRclo(String rclo){
        this.rclo = rclo;
    }
    
    public String getMake(){
        return make;
    }
    
    public void setMake(String make){
        this.make = make;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getPlateNo(){
        return plateNo;
    }
    
    public void setPlateNo(String plateNo){
        this.plateNo = plateNo;
    }
    
    public String getOwner(){
        return owner;
    }
    
    public void setOwner(String owner){
        this.owner = owner;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
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
