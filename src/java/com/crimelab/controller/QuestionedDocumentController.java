package com.crimelab.controller;

import com.crimelab.domain.Qd;
import com.crimelab.service.AssignmentService;
import com.crimelab.service.QdService;
import java.io.IOException;
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
public class QuestionedDocumentController {
    
    private final QdService qdService;
    private final AssignmentService assignmentService;
    
    @Autowired
    public QuestionedDocumentController(QdService qdService, AssignmentService assignmentService) {
        this.qdService = qdService;
        this.assignmentService = assignmentService;
    }
    
    @RequestMapping("/QuestionedDocument/report")
    public String physicalidentificationReport(Model model) {
        
        return "qdreport";
    }
    
    @RequestMapping("/QuestionnedDocument/filemanagement")
    public String filemanagement(Model model) {
        
        return "filemanagement";
    }
    
    @RequestMapping("/QuestionnedDocument/subfolder")
    public String subfolder(Model model) {

        return "subfolder";
    }
    
    @RequestMapping(value = "/QuestionedDocument/saveQdReport", method = RequestMethod.GET)
    public String insertQdReport(Model model,
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
            @RequestParam(value = "resultID") String resultID,
            HttpServletResponse response, HttpSession session) throws IOException {
        Qd inputQd = new Qd();
        inputQd.setDivision(division);
        inputQd.setReportNo(reportNo);
        inputQd.setCaseType(caseType);
        inputQd.setSuspect(suspect);
        inputQd.setVictim(victim);
        inputQd.setTimeDateReceived(timeDateReceived);
        inputQd.setRequestingParty(requestingParty);
        inputQd.setSpecimenSubmitted(specimenSubmitted);
        inputQd.setPurposeOfLabExam(purposeOfLabExam);
        inputQd.setFindings(findings);
        inputQd.setConclusion(conclusion);
        inputQd.setRemarks(remarks);
        inputQd.setTimeDateCompleted(timeDateCompleted);
        inputQd.setExaminerName(examinerName);
        inputQd.setExaminerRank(examinerRank);
        inputQd.setExaminerPosition(examinerPosition);
        inputQd.setNotedName(notedName);
        inputQd.setNotedRank(notedRank);
        inputQd.setNotedPosition(notedPosition);
        response.setContentType("application/vnd.ms-excel");
        //response.setHeader("Content-Disposition", "attachment; filename=Qd Technical Report " + dateFormat.format(date) + ".xls");
        assignmentService.updateResults(Integer.parseInt(resultID));
        Workbook wb = qdService.create(inputQd, session);
        wb.write(response.getOutputStream());
        wb.close();
        return "index";
    }    
}

