package com.crimelab.controller;

import com.crimelab.domain.MacroEtching;
import com.crimelab.domain.PiReport;
import com.crimelab.service.AssignmentService;
import com.crimelab.service.PiService;
import com.crimelab.service.MacroEtchingService;
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
public class PhysicalIdentificationController {
    
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    
    private final PiService piService;
    private final MacroEtchingService macroEtchingService;
    private final AssignmentService assignmentService;
    
    @Autowired
    public PhysicalIdentificationController(PiService piService, MacroEtchingService macroEtchingService, AssignmentService assignmentService) {
        this.piService = piService;
        this.macroEtchingService = macroEtchingService;
        this.assignmentService = assignmentService;
    }
    
    @RequestMapping("/PhysicalIdentification/report")
    public String physicalidentificationReport(Model model) {
        
        return "physicalidentificationreport";
    }
    
    @RequestMapping("/PhysicalIdentification/filemanagement")
    public String filemanagement(Model model) {
        
        return "filemanagement";
    }
    
    @RequestMapping("/PhysicalIdentification/subfolder")
    public String subfolder(Model model) {

        return "subfolder";
    }
    
    @RequestMapping(value = "/PhysicalIdentification/savePiReport", method = RequestMethod.POST)
    public String insertPiReport(Model model,
            @RequestParam(value = "examType", required=false) String examType,
            @RequestParam(value = "reportNo", required = false) String reportNo,
            @RequestParam(value = "caseType", required = false) String caseType,
            @RequestParam(value = "suspects", required = false) String suspects,
            @RequestParam(value = "victims", required = false) String victims,
            @RequestParam(value = "timeDateReceived", required = false) String timeDateReceived,
            @RequestParam(value = "requestingParty", required = false) String requestingParty,
            @RequestParam(value = "specimenSubmitted") String specimenSubmitted,
            @RequestParam(value = "purposeOfLabExam") String purposeOfLabExam,
            @RequestParam(value = "findings") String findings,
            @RequestParam(value = "conclusions") String conclusions,
            @RequestParam(value = "remarks") String remarks,
            @RequestParam(value = "timeDateCompleted") String timeDateCompleted,
            @RequestParam(value = "examinerName") String examinerName,
            @RequestParam(value = "examinerRank") String examinerRank,
            @RequestParam(value = "examinerPosition") String examinerPosition,
            @RequestParam(value = "appName") String appName,
            @RequestParam(value = "appRank") String appRank,
            @RequestParam(value = "appPosition") String appPosition,
            @RequestParam(value = "notedName") String notedName,
            @RequestParam(value = "notedRank") String notedRank,
            @RequestParam(value = "notedPosition") String notedPosition,
            @RequestParam(value = "resultID") String resultID,
            HttpServletResponse response,
            HttpSession session) throws IOException {
        PiReport inputPi = new PiReport();
        inputPi.setExamType(examType);
        inputPi.setReportNo(reportNo);
        inputPi.setCaseType(caseType);
        inputPi.setSuspects(suspects);
        inputPi.setVictims(victims);
        inputPi.setTimeDateReceived(timeDateReceived);
        inputPi.setRequestingParty(requestingParty);
        inputPi.setSpecimenSubmitted(specimenSubmitted);
        inputPi.setPurposeOfLabExam(purposeOfLabExam);
        inputPi.setFindings(findings);
        inputPi.setConclusions(conclusions);
        inputPi.setRemarks(remarks);
        inputPi.setTimeDateCompleted(timeDateCompleted);
        inputPi.setExaminerName(examinerName);
        inputPi.setExaminerRank(examinerRank);
        inputPi.setExaminerPosition(examinerPosition);
        inputPi.setAppName(appName);
        inputPi.setAppRank(appRank);
        inputPi.setAppPosition(appPosition);
        inputPi.setNotedName(notedName);
        inputPi.setNotedRank(notedRank);
        inputPi.setNotedPosition(notedPosition);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=PI Technical Report " + dateFormat.format(date) + ".xls");
        assignmentService.updateResults(Integer.parseInt(resultID));
        Workbook wb = piService.create(inputPi, session);
        wb.write(response.getOutputStream());
        wb.close();
        return "index";
    }
    
    @RequestMapping(value = "/PhysicalIdentification/saveMacroEtchingReport", method = RequestMethod.POST)
    public String insertMacroEtchingReport(Model model,
            @RequestParam(value = "dateCreated") String dateCreated,
            @RequestParam(value = "chassisNo") String chassisNo,
            @RequestParam(value = "engineNo") String engineNo,
            @RequestParam(value = "rclo") String rclo,
            @RequestParam(value = "make") String make,
            @RequestParam(value = "color") String color,
            @RequestParam(value = "plateNo") String plateNo,
            @RequestParam(value = "owner") String owner,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "appName") String appName,
            @RequestParam(value = "appRank") String appRank,
            @RequestParam(value = "appPosition") String appPosition,
            @RequestParam(value = "examinerName") String examinerName,
            @RequestParam(value = "examinerRank") String examinerRank,
            @RequestParam(value = "examinerPosition") String examinerPosition,
            @RequestParam(value = "resultID") String resultID,
            HttpServletResponse response,
            HttpSession session) throws IOException {
        MacroEtching input = new MacroEtching();
        input.setDateCreated(dateCreated);
        input.setChassisNo(chassisNo);
        input.setEngineNo(engineNo);
        input.setRclo(rclo);
        input.setMake(make);
        input.setColor(color);
        input.setPlateNo(plateNo);
        input.setOwner(owner);
        input.setAddress(address);
        input.setAppName(appName);
        input.setAppRank(appRank);
        input.setAppPosition(appPosition);
        input.setExaminerName(examinerName);
        input.setExaminerRank(examinerRank);
        input.setExaminerPosition(examinerPosition);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=Macro Etching Certificate " + dateFormat.format(date) + ".xls");
        assignmentService.updateResults(Integer.parseInt(resultID));
        Workbook wb = macroEtchingService.create(input, session);
        wb.write(response.getOutputStream());
        wb.close();
        //macroEtchingService.create(input, session);
        return "physicalidentificationreport";        
    } 
}

