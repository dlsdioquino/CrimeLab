package com.crimelab.controller;

import com.crimelab.domain.Firearms;
import com.crimelab.service.AssignmentService;
import com.crimelab.service.FirearmsService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirearmsController {
    
    private final FirearmsService firearmsService;
    private final AssignmentService assignmentService;
    
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    
    @Autowired
    public FirearmsController(FirearmsService firearmsService, AssignmentService assignmentService){
        this.firearmsService = firearmsService;
        this.assignmentService = assignmentService;
    }
    
    @RequestMapping("/Firearms/report")
    public String firearmsreport(Model model) {
        return "firearmsreport";
    }
    
    @RequestMapping("/Firearms/accountSettings")
    public String firearmsaccount(Model model) {
        return "editAccount";
    }    
    
    @RequestMapping(value = "/Firearms/saveFirearmsReport", method = RequestMethod.GET)
    public String insertFirearmsReport(Model model,
            @RequestParam(value = "division", required = false) String division,
            @RequestParam(value = "reportNo", required = false) String reportNo,
            @RequestParam(value = "caseType", required = false) String caseType,
            @RequestParam(value = "suspect", required = false) String suspect,
            @RequestParam(value = "victim", required = false) String victim,
            @RequestParam(value = "timeDateReceived", required = false) String timeDateReceived,
            @RequestParam(value = "requestingParty", required = false) String requestingParty,
            @RequestParam(value = "specimenSubmitted", required = false) String specimenSubmitted,
            @RequestParam(value = "purposeOfLabExam", required = false) String purposeOfLabExam,
            @RequestParam(value = "findings", required = false) String findings,
            @RequestParam(value = "conclusion", required = false) String conclusion,
            @RequestParam(value = "remarks", required = false) String remarks,
            @RequestParam(value = "timeDateCompleted", required = false) String timeDateCompleted,
            @RequestParam(value = "examinerName", required = false) String examinerName,
            @RequestParam(value = "examinerRank", required = false) String examinerRank,
            @RequestParam(value = "examinerPosition", required = false) String examinerPosition,
            @RequestParam(value = "notedName", required = false) String notedName,
            @RequestParam(value = "notedRank", required = false) String notedRank,
            @RequestParam(value = "notedPosition", required = false) String notedPosition,
            @RequestParam(value = "timeDateIncident", required = false) String timeDateIncident,
            @RequestParam(value = "placeOfIncident", required = false) String placeOfIncident,
            @RequestParam(value = "investigator", required = false) String investigator,
            @RequestParam(value = "caseStatus", required = false) String caseStatus,
            @RequestParam(value = "resultID") String resultID,
            HttpServletResponse response, HttpSession session) throws IOException {
        Firearms inputFirearms = new Firearms();
        inputFirearms.setDivision(division);
        inputFirearms.setReportNo(reportNo);
        inputFirearms.setCaseType(caseType);
        inputFirearms.setSuspect(suspect);
        inputFirearms.setVictim(victim);
        inputFirearms.setTimeDateReceived(timeDateReceived);
        inputFirearms.setRequestingParty(requestingParty);
        inputFirearms.setSpecimenSubmitted(specimenSubmitted);
        inputFirearms.setPurposeOfLabExam(purposeOfLabExam);
        inputFirearms.setFindings(findings);
        inputFirearms.setConclusion(conclusion);
        inputFirearms.setRemarks(remarks);
        inputFirearms.setTimeDateCompleted(timeDateCompleted);
        inputFirearms.setExaminerName(examinerName);
        inputFirearms.setExaminerRank(examinerRank);
        inputFirearms.setExaminerPosition(examinerPosition);
        inputFirearms.setNotedName(notedName);
        inputFirearms.setNotedRank(notedRank);
        inputFirearms.setNotedPosition(notedPosition);
        inputFirearms.setTimeDateIncident(timeDateIncident);
        inputFirearms.setPlaceOfIncident(placeOfIncident);
        inputFirearms.setInvestigator(investigator);
        inputFirearms.setCaseStatus(caseStatus);
        assignmentService.updateResults(Integer.parseInt(resultID));
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=Firearms Technical Report " + dateFormat.format(date) + ".xls");
        Workbook wb = firearmsService.create(inputFirearms, session);
        wb.write(response.getOutputStream());
        wb.close();
        return "index";
    }
    
    @RequestMapping(value = "/Firearms/saveFirearmsCases", method = RequestMethod.GET)
    public String createFirearmsCases(Model model,
            @RequestParam(value="month") String month,
            HttpServletResponse response,
            HttpSession session) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        String[] numberMonth = month.split("-");
        response.setHeader("Content-Disposition", "attachment; filename=Firearms Identification Cases " + dateFormat.format(date) + ".xls");
        Workbook wb = firearmsService.createFirearmsCases(session, month);
        wb.write(response.getOutputStream());
        wb.close();
        return "index";
    } 
    
}
