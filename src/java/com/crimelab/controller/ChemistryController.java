package com.crimelab.controller;

import com.crimelab.domain.Chemistry;
import com.crimelab.domain.DrugTest;
import com.crimelab.service.AssignmentService;
import com.crimelab.service.ChemistryService;
import com.crimelab.service.DrugTestService;
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
public class ChemistryController {
    
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    
    private final ChemistryService chemistryService;
    private final DrugTestService drugTestService;
    private final AssignmentService assignmentService;
    
    @Autowired
    public ChemistryController(ChemistryService chemistryService, DrugTestService drugTestService,AssignmentService assignmentService) {
        this.chemistryService = chemistryService;
        this.drugTestService = drugTestService;
        this.assignmentService = assignmentService;
    }
    
    @RequestMapping("/Chemistry/report")
    public String chemReport(Model model) {
        model.addAttribute("reports", chemistryService.getChemistryReport());
        return "chemreport";
    }
    
    @RequestMapping("/Chemistry/filemanagement")
    public String filemanagement(Model model) {

        return "filemanagement";
    }
    
    @RequestMapping("/Chemistry/subfolder")
    public String subfolder(Model model) {

        return "subfolder";
    }
    
    @RequestMapping(value = {"/Chemistry/saveChemistryReport"}, method = RequestMethod.POST)
    public String insertChemistryReport(Model model,
            @RequestParam(value = "examType") String examType,
            @RequestParam(value = "reportNo") String reportNo,
            @RequestParam(value = "caseType") String caseType,
            @RequestParam(value = "suspects") String suspects,
            @RequestParam(value = "victims") String victims,
            @RequestParam(value = "typeOfOperation") String typeOfOperation,
            @RequestParam(value = "placeOfOperation") String placeOfOperation,
            @RequestParam(value = "timeDateReceived") String timeDateReceived,
            @RequestParam(value = "reqPartyUnit") String requestingParty,
            @RequestParam(value = "custody") String custody,
            @RequestParam(value = "specimenSubmitted") String specimenSubmitted,
            @RequestParam(value = "descriptionOfEvidence") String descriptionOfEvidence,
            @RequestParam(value = "others_descriptionOfEvidence", required = false) String others_descriptionOfEvidence,
            @RequestParam(value = "specimenWeight") float specimenWeight,
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
            @RequestParam(value = "subscribed") String subscribed,
            @RequestParam(value = "subscribedName") String subscribedName,
            @RequestParam(value = "subscribedRank") String subscribedRank,
            @RequestParam(value = "subscribedPosition") String subscribedPosition,
            @RequestParam(value = "resultID") String resultID,
            HttpServletResponse response,
            HttpSession session) throws IOException{
        Chemistry inputChem = new Chemistry();
        inputChem.setResultID(Integer.parseInt(resultID));
        inputChem.setExamType(examType);
        inputChem.setReportNo(reportNo);
        inputChem.setCaseType(caseType);
        inputChem.setSuspects(suspects);
        inputChem.setVictims(victims);
        inputChem.setTypeOfOperation(typeOfOperation);
        inputChem.setPlaceOfOperation(placeOfOperation);
        inputChem.setTimeDateReceived(timeDateReceived);
        inputChem.setRequestingParty(requestingParty);
        inputChem.setCustody(custody);
        inputChem.setSpecimenSubmitted(specimenSubmitted);
        inputChem.setDescriptionOfEvidence(descriptionOfEvidence);
        inputChem.setOthers_descriptionOfEvidence(others_descriptionOfEvidence);
        inputChem.setSpecimenWeight(specimenWeight);
        inputChem.setPurposeOfLabExam(purposeOfLabExam);
        inputChem.setFindings(findings);
        inputChem.setConclusions(conclusions);
        inputChem.setRemarks(remarks);
        inputChem.setTimeDateCompleted(timeDateCompleted);
        inputChem.setExaminerName(examinerName);
        inputChem.setExaminerRank(examinerRank);
        inputChem.setExaminerPosition(examinerPosition);
        inputChem.setAppName(appName);
        inputChem.setAppRank(appRank);
        inputChem.setAppPosition(appPosition);
        inputChem.setNotedName(notedName);
        inputChem.setNotedRank(notedRank);
        inputChem.setNotedPosition(notedPosition);
        inputChem.setSubscribed(subscribed);
        inputChem.setSubscribedName(subscribedName);
        inputChem.setSubscribedRank(subscribedRank);
        inputChem.setSubscribedPosition(subscribedPosition);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=Chemistry Technical Report " + dateFormat.format(date) + ".xls");
        Workbook wb = chemistryService.create(inputChem, session);
        assignmentService.updateResults(Integer.parseInt(resultID));
        wb.write(response.getOutputStream());
        wb.close();
        model.addAttribute("othersList", chemistryService.getOthersChemistry());
        return "index";
    }
    
    @RequestMapping(value = "/Chemistry/saveDrugTestReport", method = RequestMethod.POST)
    public String insertDrugTestReport(Model model,
            @RequestParam(value = "fadtNo") String fadtNo,
            @RequestParam(value = "sbrNo") String sbrNo,
            @RequestParam(value = "timeDate") String timeDate,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "age") int age,
            @RequestParam(value = "sex") String sex,
            @RequestParam(value = "purpose") String purpose,
            @RequestParam(value = "specimenSubmitted") String specimenSubmitted,
            @RequestParam(value = "purposeOfExamination") String purposeOfExamination,
            @RequestParam(value = "methamphetamine") String methamphetamine,
            @RequestParam(value = "thc") String thc,
            @RequestParam(value = "remarks") String remarks,
            @RequestParam(value = "examinerName") String examinerName,
            @RequestParam(value = "examinerRank") String examinerRank,
            @RequestParam(value = "examinerPosition") String examinerPosition,
            @RequestParam(value = "appName") String appName,
            @RequestParam(value = "appRank") String appRank,
            @RequestParam(value = "appPosition") String appPosition,
            HttpServletResponse response,
            HttpSession session) throws IOException {
                DrugTest input = new DrugTest();
                input.setFadtNo(fadtNo);
                input.setSbrNo(sbrNo);
                input.setTimeDate(timeDate);
                input.setName(name);
                input.setAddress(address);
                input.setAge(age);
                input.setSex(sex);
                input.setPurpose(purpose);
                input.setSpecimenSubmitted(specimenSubmitted);
                input.setPurposeOfExamination(purposeOfExamination);
                input.setMethamphetamine(methamphetamine);
                input.setThc(thc);
                input.setRemarks(remarks);
                input.setExaminerName(examinerName);
                input.setExaminerRank(examinerRank);
                input.setExaminerPosition(examinerPosition);
                input.setAppName(appName);
                input.setAppRank(appRank);
                input.setAppPosition(appPosition);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=DrugTest " + dateFormat.format(date) + ".xls");
                Workbook wb = drugTestService.create(input,session);
                wb.write(response.getOutputStream());
                wb.close();
                return "index";
    }
    @RequestMapping(value = "/Chemistry/drugMonthlyReport", method = RequestMethod.POST)
    public String createDrugMonthly(Model model,
            @RequestParam(value="month") String month,
            HttpServletResponse response,
            HttpSession session) throws IOException{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=Drugs Monthly Report " + dateFormat.format(date) + ".xls");
        Workbook wb = chemistryService.createMonthlyReport(session, month);
        wb.write(response.getOutputStream());
        wb.close();
        return "index";
    }
}
