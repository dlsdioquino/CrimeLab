/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.controller;

import com.crimelab.domain.Files;
import com.crimelab.service.FileUploadService;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel
 */
@Controller
public class UploadController extends HttpServlet {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/FileUpload", method = RequestMethod.GET)
    public String showUploadForm(Model model) {
        return "fileUpload";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ModelAndView showCompositeDetails(Model model, @RequestParam(value = "file") CommonsMultipartFile uploadedFile,
            @RequestParam(value = "description", required = false) String fileDescription,
            @RequestParam(value = "sococase", required = false) String soco_case) throws IOException {
        Calendar currentTimeDate = Calendar.getInstance();
        File filePath = new File(fileUploadService.getFileUploadPath() + "\\Files\\");
        ModelAndView mv = new ModelAndView("redirect:FileUpload");

        if (!filePath.exists()) {
            filePath.mkdir();
        }
        String status = "success";
        try {
            uploadedFile.transferTo(new File(filePath + "\\" + uploadedFile.getOriginalFilename()));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            status = "failure";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            status = "iofailure";
        }

        int file_type;

        String fileType = uploadedFile.getContentType();
        String getFile = uploadedFile.getOriginalFilename();
        String[] fileExtension = getFile.split("\\.", 2);

        if (fileExtension[1].contains("doc") || fileExtension[1].contains("pdf") || fileExtension[1].contains("xls")) {
            file_type = 0;
        } else {
            file_type = 1;
        }

        Files input = new Files();

        input.setFile_type(file_type);
        input.setOrig_file_name(uploadedFile.getOriginalFilename());
        input.setFile_name(uploadedFile.getOriginalFilename());
        input.setFile_extension(fileExtension[1]);
        input.setFile_path(filePath.toString() + "\\" + uploadedFile.getOriginalFilename());
        input.setDate(currentTimeDate.getTime());
        input.setDescription(fileDescription);
        input.setSoco_case(soco_case);
        input.setFolder_id(1); // Related field
        fileUploadService.uploadFile(input);
        //site settings for fileLocation, to edit
        mv.addObject("status", status);
        return mv;
    }

}
