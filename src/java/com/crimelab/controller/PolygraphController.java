package com.crimelab.controller;

import com.crimelab.domain.GalleryResults;
import com.crimelab.domain.Polygraph;
import com.crimelab.service.PolygraphService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dan
 */
@Controller
public class PolygraphController {

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();

    @Autowired
    private PolygraphService polygraphService;

    @RequestMapping("/Polygraph/report")
    public String showPolygraphReport() {
        return "polygraphreport";
    }

    @RequestMapping(value = "/Polygraph/savePolygraphReport", method = RequestMethod.POST)
    public String insertPolygraphReport(Model model,
            @RequestParam(value = "subjectNo") String subjectNo,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "img") CommonsMultipartFile photo,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "age") String age,
            @RequestParam(value = "birthdate") String birthdate,
            @RequestParam(value = "civilStatus") String civilStatus,
            @RequestParam(value = "idPresented") String idPresented,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "caseNo") String caseNo,
            @RequestParam(value = "requestingParty") String requestingParty,
            @RequestParam(value = "timeDateReceived") String timeDateReceived,
            @RequestParam(value = "natureOfCase") String natureOfCase,
            @RequestParam(value = "examLocation") String examLocation,
            @RequestParam(value = "examDate") String examDate,
            @RequestParam(value = "purpose") String purpose,
            @RequestParam(value = "preTest") String preTest,
            @RequestParam(value = "inTest") String inTest,
            @RequestParam(value = "result") String result,
            @RequestParam(value = "postTest") String postTest,
            @RequestParam(value = "remarks") String remarks,
            @RequestParam(value = "timeDateCompleted") String timeDateCompleted,
            @RequestParam(value = "examinerName") String examinerName,
            @RequestParam(value = "examinerRank") String examinerRank,
            @RequestParam(value = "examinerPosition") String examinerPosition,
            @RequestParam(value = "notedName") String notedName,
            @RequestParam(value = "notedRank") String notedRank,
            @RequestParam(value = "notedPosition") String notedPosition,
            @RequestParam(value = "approvedName") String approvedName,
            @RequestParam(value = "approvedRank") String approvedRank,
            @RequestParam(value = "approvedPosition") String approvedPosition,
            HttpServletResponse response, HttpSession session) throws IOException {
        File filePath = new File(polygraphService.getFileUploadPath() + "\\Files\\");
        
        if (!filePath.exists()) {
            filePath.mkdir();
        }
        String status = "success";
        try {
            photo.transferTo(new File(filePath + "\\" + photo.getOriginalFilename()));
        } catch (IllegalStateException e) {
            status = "failure";
        } catch (IOException e) {
            status = "iofailure";
        }

        Polygraph inputPolygraph = new Polygraph();
        inputPolygraph.setSubjectNo(subjectNo);
        inputPolygraph.setName(name);
        inputPolygraph.setPhotoLocation(filePath.toString() + "\\" + photo.getOriginalFilename());
        inputPolygraph.setPhotoName(photo.getOriginalFilename());
        inputPolygraph.setGender(gender);
        inputPolygraph.setAge(age);
        inputPolygraph.setBirthdate(birthdate);
        inputPolygraph.setCivilStatus(civilStatus);
        inputPolygraph.setIdPresented(idPresented);
        inputPolygraph.setAddress(address);
        inputPolygraph.setCaseNo(caseNo);
        inputPolygraph.setRequestingParty(requestingParty);
        inputPolygraph.setTimeDateReceived(timeDateReceived);
        inputPolygraph.setNatureOfCase(natureOfCase);
        inputPolygraph.setExamLocation(examLocation);
        inputPolygraph.setExamDate(examDate);
        inputPolygraph.setPurpose(purpose);
        inputPolygraph.setPreTest(preTest);
        inputPolygraph.setInTest(inTest);
        inputPolygraph.setResult(result);
        inputPolygraph.setPostTest(postTest);
        inputPolygraph.setRemarks(remarks);
        inputPolygraph.setTimeDateCompleted(timeDateCompleted);
        inputPolygraph.setExaminerName(examinerName);
        inputPolygraph.setExaminerRank(examinerRank);
        inputPolygraph.setExaminerPosition(examinerPosition);
        inputPolygraph.setNotedName(notedName);
        inputPolygraph.setNotedRank(notedRank);
        inputPolygraph.setNotedPosition(notedPosition);
        inputPolygraph.setApprovedName(approvedName);
        inputPolygraph.setApprovedPosition(approvedPosition);
        inputPolygraph.setApprovedRank(approvedRank);
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        response.setHeader("Content-Disposition", "attachment; filename=Polygraph Technical Report " + dateFormat.format(date) + ".docx");
        XWPFDocument wb = polygraphService.create(inputPolygraph, session);
        wb.write(response.getOutputStream());
        response.getOutputStream().close();
        return "index";
    }
}
