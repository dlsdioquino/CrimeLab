package com.crimelab.controller;

import com.crimelab.domain.Civilian;
import com.crimelab.domain.Criminal;
import com.crimelab.service.AssignmentService;
import com.crimelab.service.CivilianService;
import com.crimelab.service.CriminalService;
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
public class FingerprintController {
    
    private final CriminalService criminalService;
    private final CivilianService civilianService;
    private final AssignmentService assignmentService;
    
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    
    @Autowired
    public FingerprintController(CriminalService criminalService, CivilianService civilianService, AssignmentService assignmentService) {
        this.criminalService = criminalService;
        this.civilianService = civilianService;
        this.assignmentService = assignmentService;
    }
    
    @RequestMapping("/Fingerprint/report")
    public String fingerprintreport(Model model) {
        return "fingerprintreport";
    }
    
    
    @RequestMapping(value = "/Fingerprint/saveCriminalReport", method = RequestMethod.GET)
    public String insertCriminalReport(Model model,
            @RequestParam(value = "criminalDate", required = false) String criminalDate,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "middleName", required = false) String middleName,
            @RequestParam(value = "provincialAddress", required = false) String provincialAddress,
            @RequestParam(value = "civicOrganization", required = false) String civicOrganization,
            @RequestParam(value = "spouseName", required = false) String spouseName,
            @RequestParam(value = "spouseAddress", required = false) String spouseAddress,
            @RequestParam(value = "educationalAttainment", required = false) String educationalAttainment,
            @RequestParam(value = "voterId", required = false) String voterId,
            @RequestParam(value = "fatherName", required = false) String fatherName,
            @RequestParam(value = "dialectSpoken", required = false) String dialectSpoken,
            @RequestParam(value = "fatherAddress", required = false) String fatherAddress,
            @RequestParam(value = "motherName", required = false) String motherName,
            @RequestParam(value = "relativeAddress", required = false) String relativeAddress,
            @RequestParam(value = "motherAddress", required = false) String motherAddress,
            @RequestParam(value = "caseNo", required = false) String caseNo,
            @RequestParam(value = "arrestNo", required = false) String arrestNo,
            @RequestParam(value = "placeOfArrest", required = false) String placeOfArrest,
            @RequestParam(value = "timeDateArrest", required = false) String timeDateArrest,
            @RequestParam(value = "offenseCharge", required = false) String offenseCharge,
            @RequestParam(value = "arrestingOfficer", required = false) String arrestingOfficer,
            @RequestParam(value = "civilStatus", required = false) String civilStatus,
            @RequestParam(value = "resultID") String resultID,
            HttpServletResponse response, HttpSession session) throws IOException {
        Criminal inputCriminal = new Criminal();
        inputCriminal.setCriminalDate(criminalDate);
        inputCriminal.setLastName(lastName);
        inputCriminal.setFirstName(firstName);
        inputCriminal.setMiddleName(middleName);
        inputCriminal.setProvincialAddress(provincialAddress);
        inputCriminal.setCivicOrganization(civicOrganization);
        inputCriminal.setCivilStatus(civilStatus);
        inputCriminal.setSpouseName(spouseName);
        inputCriminal.setSpouseAddress(spouseAddress);
        inputCriminal.setEducationalAttainment(educationalAttainment);
        inputCriminal.setVoterId(voterId);
        inputCriminal.setFatherName(fatherName);
        inputCriminal.setDialectSpoken(dialectSpoken);
        inputCriminal.setFatherAddress(fatherAddress);
        inputCriminal.setMotherName(motherName);
        inputCriminal.setRelativeAddress(relativeAddress);
        inputCriminal.setMotherAddress(motherAddress);
        inputCriminal.setCaseNo(caseNo);
        inputCriminal.setArrestNo(arrestNo);
        inputCriminal.setPlaceOfArrest(placeOfArrest);
        inputCriminal.setTimeDateArrest(timeDateArrest);
        inputCriminal.setOffenseCharge(offenseCharge);
        inputCriminal.setArrestingOfficer(arrestingOfficer);
        assignmentService.updateResults(Integer.parseInt(resultID));
        criminalService.create(inputCriminal);
        return "fingerprintReport";
    }

    @RequestMapping(value = "/Fingerprint/saveCivilianReport", method = RequestMethod.GET)
    public String insertCivilianReport(Model model,
            @RequestParam(value = "stationTaken", required = false) String stationTaken,
            @RequestParam(value = "dateTaken", required = false) String dateTaken,
            @RequestParam(value = "region", required = false) String region,
            @RequestParam(value = "civilStatus", required = false) String civilStatus,
            @RequestParam(value = "voterNo", required = false) String voterNo,
            @RequestParam(value = "spouseName", required = false) String spouseName,
            @RequestParam(value = "race", required = false) String race,
            @RequestParam(value = "spouseAddress", required = false) String spouseAddress,
            @RequestParam(value = "height", required = false) String height,
            @RequestParam(value = "weight", required = false) String weight,
            @RequestParam(value = "hair", required = false) String hair,
            @RequestParam(value = "eyes", required = false) String eyes,
            @RequestParam(value = "complexion", required = false) String complexion,
            @RequestParam(value = "dialectSpoken", required = false) String dialectSpoken,
            @RequestParam(value = "provincialAddress", required = false) String provincialAddress,
            @RequestParam(value = "purpose", required = false) String purpose,
            @RequestParam(value = "nameOfPerson", required = false) String nameOfPerson,
            @RequestParam(value = "educationalAttainment", required = false) String educationalAttainment,
            @RequestParam(value = "nameOfOfficial", required = false) String nameOfOfficial,
            @RequestParam(value = "parentsName", required = false) String parentsName,
            @RequestParam(value = "relativeAddress", required = false) String relativeAddress,
            @RequestParam(value = "reportNo", required = false) String reportNo,
            @RequestParam(value = "parentsAddress", required = false) String parentsAddress,
            HttpServletResponse response, HttpSession session) throws IOException {
        Civilian inputCivilian = new Civilian();
        inputCivilian.setStationTaken(stationTaken);
        inputCivilian.setDateTaken(dateTaken);
        inputCivilian.setRegion(region);
        inputCivilian.setCivilStatus(civilStatus);
        inputCivilian.setVoterNo(voterNo);
        inputCivilian.setSpouseName(spouseName);
        inputCivilian.setRace(race);
        inputCivilian.setSpouseAddress(spouseAddress);
        inputCivilian.setHeight(height);
        inputCivilian.setWeight(weight);
        inputCivilian.setHair(hair);
        inputCivilian.setEyes(eyes);
        inputCivilian.setComplexion(complexion);
        inputCivilian.setDialectSpoken(dialectSpoken);
        inputCivilian.setProvincialAddress(provincialAddress);
        inputCivilian.setPurpose(purpose);
        inputCivilian.setNameOfPerson(nameOfPerson);
        inputCivilian.setEducationalAttainment(educationalAttainment);
        inputCivilian.setNameOfOfficial(nameOfOfficial);
        inputCivilian.setParentsName(parentsName);
        inputCivilian.setRelativeAddress(relativeAddress);
        inputCivilian.setReportNo(reportNo);
        inputCivilian.setParentsAddress(parentsAddress);
        civilianService.create(inputCivilian);
        return "fingerprintReport";
    }
    
    @RequestMapping(value = "/Fingerprint/saveTenprintsCards", method = RequestMethod.GET)
    public String createTenprintsCards(Model model,
            @RequestParam(value="month") String month,
            HttpServletResponse response,
            HttpSession session) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        String[] numberMonth = month.split("-");
        response.setHeader("Content-Disposition", "attachment; filename=Submitted Tenprints Cards " + dateFormat.format(date) + ".xls");
        Workbook wb = criminalService.createTenprintsCards(session, month);
        wb.write(response.getOutputStream());
        wb.close();
        return "index";
    }
    
}