package com.crimelab.controller;

import com.crimelab.domain.MedicoLegal;
import com.crimelab.service.AssignmentService;
import com.crimelab.service.MedicoLegalService;
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
public class MedicoLegalController {
    
    private final MedicoLegalService medicoLegalService;
    private final AssignmentService assignmentService;
    
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    
    @Autowired
    public MedicoLegalController(MedicoLegalService medicoLegalService, AssignmentService assignmentService) {
        this.medicoLegalService = medicoLegalService;
        this.assignmentService = assignmentService;
    }
    
    @RequestMapping("/MedicoLegal/report")
    public String medicolegalreport(Model model) {
        return "medicolegalreport";
    }
    
    @RequestMapping(value = "/MedicoLegal/saveMedicoLegalReport", method = RequestMethod.GET)
    public String insertMedicoLegalReport(Model model,
            @RequestParam(value = "division", required = false) String division,
            @RequestParam(value = "reportNo", required = false) String reportNo,
            @RequestParam(value = "caseNo", required = false) String caseNo,
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
            @RequestParam(value = "resultID") String resultID,
            HttpServletResponse response, HttpSession session) throws IOException {
        MedicoLegal inputMedicoLegal = new MedicoLegal();
        inputMedicoLegal.setDivision(division);
        inputMedicoLegal.setReportNo(reportNo);
        inputMedicoLegal.setCaseNo(caseNo);
        inputMedicoLegal.setCaseType(caseType);
        inputMedicoLegal.setSuspect(suspect);
        inputMedicoLegal.setVictim(victim);
        inputMedicoLegal.setTimeDateReceived(timeDateReceived);
        inputMedicoLegal.setRequestingParty(requestingParty);
        inputMedicoLegal.setSpecimenSubmitted(specimenSubmitted);
        inputMedicoLegal.setPurposeOfLabExam(purposeOfLabExam);
        inputMedicoLegal.setFindings(findings);
        inputMedicoLegal.setConclusion(conclusion);
        inputMedicoLegal.setRemarks(remarks);
        inputMedicoLegal.setTimeDateCompleted(timeDateCompleted);
        inputMedicoLegal.setExaminerName(examinerName);
        inputMedicoLegal.setExaminerRank(examinerRank);
        inputMedicoLegal.setExaminerPosition(examinerPosition);
        inputMedicoLegal.setNotedName(notedName);
        inputMedicoLegal.setNotedRank(notedRank);
        inputMedicoLegal.setNotedPosition(notedPosition);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=Medico-Legal Technical Report " + dateFormat.format(date) + ".xls");
        assignmentService.updateResults(Integer.parseInt(resultID));
        Workbook wb = medicoLegalService.create(inputMedicoLegal, session);
        wb.write(response.getOutputStream());
        wb.close();
        return "index";
    }
    
    @RequestMapping(value = "/MedicoLegal/saveMedicoMonthly", method = RequestMethod.GET)
    public String createMedicoMonthly(Model model,
            @RequestParam(value="month") String month,
            HttpServletResponse response,
            HttpSession session) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        String[] numberMonth = month.split("-");
        response.setHeader("Content-Disposition", "attachment; filename=Medico-Legal Monthly Report " + dateFormat.format(date) + ".xls");
        Workbook wb = medicoLegalService.createMedicoMonthly(session, month);
        wb.write(response.getOutputStream());
        wb.close();
        return "index";
    } 
    
}
