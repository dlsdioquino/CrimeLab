package com.crimelab.controller;

import com.crimelab.domain.GalleryResults;
import com.crimelab.service.GalleryService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
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

/**
 *
 * @author Dan
 */
@Controller
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @RequestMapping(value = "/Gallery", method = RequestMethod.GET)
    public String view(Model model) {
        return "gallery";
    }
    
    @RequestMapping(value = "/getGallery", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAssignments() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(galleryService.getFiles());
    }
    
    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("caseNo") String caseNo, HttpServletResponse response, HttpServletRequest request) throws IOException {
        GalleryResults gr = galleryService.getCompositeSketch(caseNo);

        FileInputStream fileInputStream = new FileInputStream(gr.getPhotoLocation());
        byte[] bytes = IOUtils.toByteArray(fileInputStream);

        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

        response.getOutputStream().write(bytes);
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/GalleryResults", method = RequestMethod.GET)
    public String showGalleryForm(Model model) {
        return "galleryResults";
    }

    @RequestMapping(value = "/saveGalleryResults", method = RequestMethod.POST)
    public String insert(Model model,
            @RequestParam(value = "photo", required = false) CommonsMultipartFile photo,
            @RequestParam(value = "caseNo", required = false) String caseNo,
            @RequestParam(value = "caseDate", required = false) String date,
            @RequestParam(value = "offenseIncident", required = false) String offenseIncident,
            @RequestParam(value = "nameAKA", required = false) String nameAKA,
            @RequestParam(value = "sex", required = false) String sex,
            @RequestParam(value = "height", required = false) String height,
            @RequestParam(value = "built", required = false) String built,
            @RequestParam(value = "otherInfo", required = false) String otherInfo,
            @RequestParam(value = "describedBy", required = false) String describedBy,
            @RequestParam(value = "requestingParty", required = false) String requestingParty,
            @RequestParam(value = "investOnCase", required = false) String investOnCase,
            @RequestParam(value = "interviewer", required = false) String interviewer,
            @RequestParam(value = "age", required = false) String age,
            @RequestParam(value = "weight", required = false) String weight,
            @RequestParam(value = "complexion", required = false) String complexion,
            @RequestParam(value = "rating", required = false) String rating,
            HttpServletResponse response, HttpSession session) throws IOException {
        File filePath = new File(galleryService.getFileUploadPath() + "\\Files\\");
        
        JOptionPane.showMessageDialog(null, date);

        GalleryResults input = new GalleryResults();

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

        input.setCaseNo(caseNo);
        input.setDate(date);
        input.setOffenseIncident(offenseIncident);
        input.setNameAKA(nameAKA);
        input.setSex(sex);
        input.setHeight(height);
        input.setBuilt(built);
        input.setOtherInfo(otherInfo);
        input.setDescribedBy(describedBy);
        input.setRequestingParty(requestingParty);
        input.setInvestOnCase(investOnCase);
        input.setInterviewer(interviewer);
        input.setAge(age);
        input.setWeight(weight);
        input.setComplexion(complexion);
        input.setRating(rating);
        input.setPhotoName(photo.getOriginalFilename());
        input.setPhotoLocation(filePath.toString() + "\\" + photo.getOriginalFilename());
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        response.setHeader("Content-Disposition", "attachment; filename=Composite Sketch (" + caseNo + ").docx");
        XWPFDocument wb = galleryService.create(input, session);
        wb.write(response.getOutputStream());
        return "index";
    }

    @RequestMapping(value = "/CompositeDetails", method = RequestMethod.GET)
    public String showCompositeDetails(Model model, @RequestParam("caseNo") String caseNo) {
        model.addAttribute("compositeDetails", galleryService.getCompositeDetails(caseNo));
        return "CompositeDetails";
    }
}
