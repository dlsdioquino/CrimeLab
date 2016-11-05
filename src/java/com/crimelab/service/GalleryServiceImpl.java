/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.GalleryResults;
import com.crimelab.repository.GalleryDAO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpSession;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dan
 */
@Service
public class GalleryServiceImpl implements GalleryService {

    private final GalleryDAO galleryDAO;

    @Autowired
    public GalleryServiceImpl(GalleryDAO galleryDAO) {
        this.galleryDAO = galleryDAO;
    }

    @Override
    public ArrayList<Map<String, Object>> getFiles() {
        return galleryDAO.getFiles();
    }

    @Override
    public List<GalleryResults> getCompositeDetails(String caseNo) {
        return galleryDAO.getCompositeDetails(caseNo);
    }

    @Override
    public String getFileUploadPath() {
        return galleryDAO.getFileUploadPath();
    }

    @Override
    public GalleryResults getCompositeSketch(String caseNo) {
        return galleryDAO.getCompositeSketch(caseNo);
    }

    @Override
    public XWPFDocument create(GalleryResults galleryResults, HttpSession session) {
        XWPFDocument document = null;

        //Insert into database
        galleryDAO.insertResults(galleryResults);

        try {
            //Retrieving Template
            InputStream inpDocx = session.getServletContext().getResourceAsStream("/WEB-INF/templates/CompositeSketch.docx");
            document = new XWPFDocument(inpDocx);

            //Adding the picture
            XWPFParagraph pictureHolder = document.createParagraph();
            XWPFRun pictureRun = pictureHolder.createRun();
            
            FileInputStream getPhoto = new FileInputStream(galleryResults.getPhotoLocation());
            FileInputStream getImage = new FileInputStream(galleryResults.getPhotoLocation());
            ImageInputStream imageInput = ImageIO.createImageInputStream(getPhoto);
            BufferedImage bi = ImageIO.read(imageInput);
            int width = bi.getWidth() - 100;
            int height = bi.getHeight() - 100;

            pictureRun.addBreak();
            pictureRun.addPicture(getImage, XWPFDocument.PICTURE_TYPE_PNG, null, Units.toEMU(width), Units.toEMU(height));
         
            pictureHolder.setBorderBottom(Borders.BASIC_BLACK_DASHES);
            pictureHolder.setBorderTop(Borders.BASIC_BLACK_DASHES);
            pictureHolder.setBorderLeft(Borders.BASIC_BLACK_DASHES);
            pictureHolder.setBorderRight(Borders.BASIC_BLACK_DASHES);
            pictureHolder.setAlignment(ParagraphAlignment.CENTER);
//            pictureRowHolder.getCell(0).setText("IMAGE PLACER");

            //Case number and Date            
            XWPFParagraph info = document.createParagraph();
            XWPFRun caseNoAndDate = info.createRun();
            caseNoAndDate.setText("Case Number: " + galleryResults.getCaseNo());
            caseNoAndDate.addTab();
            caseNoAndDate.addTab();
            caseNoAndDate.addTab();
            caseNoAndDate.addTab();
            caseNoAndDate.setText(galleryResults.getDate());
            caseNoAndDate.setFontSize(16);

            //Sketch Details
            XWPFParagraph caseDetails = document.createParagraph();
            XWPFRun detailsParagraph = caseDetails.createRun();
            detailsParagraph.setText("Offense/Incident: " + galleryResults.getOffenseIncident());
            detailsParagraph.addBreak();
            detailsParagraph.setText("Name/AKA: " + galleryResults.getNameAKA());
            detailsParagraph.addBreak();
            detailsParagraph.setText("Sex: " + galleryResults.getSex());
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.setText("Age: " + galleryResults.getAge());
            detailsParagraph.addBreak();
            detailsParagraph.setText("Height: " + galleryResults.getHeight());
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.setText("Weight: " + galleryResults.getWeight());
            detailsParagraph.addBreak();
            detailsParagraph.setText("Built: " + galleryResults.getBuilt());
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.addTab();
            detailsParagraph.setText("Complexion: " + galleryResults.getComplexion());
            detailsParagraph.addBreak();
            detailsParagraph.setText("Other Information: " + galleryResults.getOtherInfo());
            detailsParagraph.addBreak();
            detailsParagraph.setText("Described by: " + galleryResults.getDescribedBy());
            detailsParagraph.addBreak();
            detailsParagraph.setText("Requesting party: " + galleryResults.getRequestingParty());

            //Details Borders
            caseDetails.setBorderBottom(Borders.BASIC_BLACK_DASHES);
            caseDetails.setBorderTop(Borders.BASIC_BLACK_DASHES);
            caseDetails.setBorderLeft(Borders.BASIC_BLACK_DASHES);
            caseDetails.setBorderRight(Borders.BASIC_BLACK_DASHES);
            caseDetails.setAlignment(ParagraphAlignment.LEFT);

            //Reference Paragraph
            XWPFParagraph outsideDetails = document.createParagraph();
            XWPFRun outsideDetailsRun = outsideDetails.createRun();
            outsideDetailsRun.addBreak();
            outsideDetailsRun.setText("Note: For reference");
            outsideDetailsRun.addBreak();
            outsideDetailsRun.setText("The witness indicates that this image is: " + galleryResults.getRating());
            getPhoto.close();
            getImage.close();
            imageInput.close();
            document.getXWPFDocument();
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return document;
    }

}
