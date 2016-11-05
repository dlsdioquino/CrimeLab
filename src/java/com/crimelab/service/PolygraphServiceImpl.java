/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Polygraph;
import com.crimelab.repository.PolygraphDAO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpSession;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/**
 *
 * @author rowPC
 */
@Service
public class PolygraphServiceImpl implements PolygraphService {

    private final PolygraphDAO polygraphDAO;

    @Override
    public String getFileUploadPath() {
        return polygraphDAO.getFileUploadPath();
    }

    @Autowired
    public PolygraphServiceImpl(PolygraphDAO polygraphDAO) {
        this.polygraphDAO = polygraphDAO;
    }

    @Override
    public List<Polygraph> getAllPolygraph() {
        return polygraphDAO.getAllPolygraph();
    }

    @Override
    public XWPFDocument create(Polygraph polygraph, HttpSession session) {
        XWPFDocument document = null;

        //Insert into dbase
//        polygraphDAO.polygraphInfo(polygraph);
        try {
            //Blank Document
            InputStream inpDocx = session.getServletContext().getResourceAsStream("/WEB-INF/templates/Polygraph.docx");
            document = new XWPFDocument(inpDocx);

            //create Paragraph
            XWPFParagraph subjectNo = document.createParagraph();
            XWPFRun r1 = subjectNo.createRun();
            r1.setText("POLYGRAPH SUBJECT NO: " + polygraph.getSubjectNo());
            subjectNo.setAlignment(ParagraphAlignment.CENTER);
            r1.setBold(true);;

            //create table
            XWPFTable table = document.createTable();
            //width 
            CTTbl tableFix = table.getCTTbl();
            CTTblPr pr = tableFix.getTblPr();
            CTTblWidth tblW = pr.getTblW();
            tblW.setW(BigInteger.valueOf(4800));
            tblW.setType(STTblWidth.PCT);
            pr.setTblW(tblW);
            tableFix.setTblPr(pr);

            //create first row
            XWPFTableRow tableRowOne = table.getRow(0);
            XWPFTableCell headerCell = tableRowOne.getCell(0);
            XWPFParagraph headerParagraph = headerCell.getParagraphs().get(0);
            XWPFRun hRun = headerParagraph.createRun();
            headerCell.setColor("CDCDB4");
            hRun.setText("PERSONAL INFORMATION");
            tableRowOne.addNewTableCell().setText(null);

            headerParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFTableCell photoHeaderCell = tableRowOne.getCell(1);
            XWPFParagraph photoHeaderParagraph = photoHeaderCell.getParagraphs().get(0);
            XWPFRun pRun = photoHeaderParagraph.createRun();
            photoHeaderCell.setColor("CDCDB4");
            pRun.setText("PHOTO");
            photoHeaderParagraph.setAlignment(ParagraphAlignment.CENTER);

            XWPFTableRow tableRowTwo = table.createRow();
            XWPFTableCell cell = tableRowTwo.getCell(0);
            XWPFParagraph personalInfo = cell.getParagraphs().get(0);
            XWPFRun r2 = personalInfo.createRun();
            r2.setText("Name");
            r2.addTab();
            r2.addTab();
            r2.setText(": " + polygraph.getName());
            r2.addBreak();
            r2.setText("Gender");
            r2.addTab();
            r2.addTab();
            r2.setText(": " + polygraph.getGender());
            r2.addBreak();
            r2.setText("Age");
            r2.addTab();
            r2.addTab();
            r2.setText(": " + polygraph.getAge());
            r2.addBreak();
            r2.setText("Date of Birth");
            r2.addTab();
            r2.setText(": " + polygraph.getBirthdate());
            r2.addBreak();
            r2.setText("Civil Status");
            r2.addTab();
            r2.setText(": " + polygraph.getCivilStatus());
            r2.addBreak();
            r2.setText("ID Presented");
            r2.addTab();
            r2.setText(": " + polygraph.getIdPresented());
            r2.addBreak();
            r2.setText("Address");
            r2.addTab();
            r2.setText(": " + polygraph.getAddress());

            //Adding the picture
            XWPFTableCell pictureCell = tableRowTwo.getCell(1);
            XWPFParagraph pictureHolder = pictureCell.getParagraphs().get(0);
            XWPFRun pictureRun = pictureHolder.createRun();
            FileInputStream getPhoto = new FileInputStream(polygraph.getPhotoLocation());
            FileInputStream getImage = new FileInputStream(polygraph.getPhotoLocation());
            ImageInputStream imageInput = ImageIO.createImageInputStream(getPhoto);
            BufferedImage bi = ImageIO.read(imageInput);
            pictureHolder.setAlignment(ParagraphAlignment.RIGHT);
            pictureRun.addPicture(getImage, XWPFDocument.PICTURE_TYPE_JPEG, null, Units.toEMU(120), Units.toEMU(120));

            XWPFParagraph spacing = document.createParagraph();
            XWPFRun spacingRun = spacing.createRun();

            //create table
            XWPFTable otherTable = document.createTable();
            //width 
            CTTbl tableFixTwo = otherTable.getCTTbl();
            CTTblPr prTwo = tableFixTwo.getTblPr();
            CTTblWidth tblWTwo = prTwo.getTblW();
            tblWTwo.setW(BigInteger.valueOf(4800));
            tblWTwo.setType(STTblWidth.PCT);
            prTwo.setTblW(tblWTwo);
            tableFixTwo.setTblPr(prTwo);

            XWPFTableRow examInfoHeader = otherTable.createRow();
            XWPFTableCell cellInfo = examInfoHeader.getCell(0);
            XWPFParagraph examInfo = cellInfo.getParagraphs().get(0);
            XWPFRun r3 = examInfo.createRun();
            cellInfo.setColor("CDCDB4");
            r3.setText("EXAM INFORMATION");
            examInfo.setAlignment(ParagraphAlignment.CENTER);

            XWPFTableRow examInfoRow = otherTable.createRow();
            XWPFTableCell cellRowInfo = examInfoRow.getCell(0);
            XWPFParagraph examInfoRowP = cellRowInfo.getParagraphs().get(0);
            XWPFRun examRun = examInfoRowP.createRun();
            examRun.setText("Case Number");
            examRun.addTab();
            examRun.addTab();
            examRun.setText(": " + polygraph.getCaseNo());
            examRun.addBreak();
            examRun.setText("Requesting Party");
            examRun.addTab();
            examRun.setText(": " + polygraph.getRequestingParty());
            examRun.addBreak();
            examRun.setText("Time/Date Received");
            examRun.addTab();
            examRun.setText(": " + polygraph.getTimeDateReceived());
            examRun.addBreak();
            examRun.setText("Nature of Case");
            examRun.addTab();
            examRun.addTab();
            examRun.setText(": " + polygraph.getNatureOfCase());
            examRun.addBreak();
            examRun.setText("Exam Location");
            examRun.addTab();
            examRun.addTab();
            examRun.setText(": " + polygraph.getExamLocation());
            examRun.addBreak();
            examRun.setText("Exam Date");
            examRun.addTab();
            examRun.addTab();
            examRun.setText(": " + polygraph.getExamDate());

            otherTable.removeRow(0);
            
            XWPFParagraph purposeOfExamination = document.createParagraph();
            XWPFRun r4 = purposeOfExamination.createRun();
            r4.setUnderline(UnderlinePatterns.SINGLE);
            r4.addBreak();
            r4.setText("SECTION 1: PURPOSE OF EXAMINATION");
            r4.addTab();
            r4.addTab();
            r4.addTab();
            r4.addTab();
            r4.addTab();
            r4.addTab();
            r4.addTab();
            r4.addTab();
            r4.addTab();
            
            XWPFParagraph purposeOfExaminationContents = document.createParagraph();
            XWPFRun r4Contents = purposeOfExaminationContents.createRun();
            r4Contents.setText(polygraph.getPurpose());

            XWPFParagraph preTestInterview = document.createParagraph();
            XWPFRun r5 = preTestInterview.createRun();
            r5.setUnderline(UnderlinePatterns.SINGLE);
            r5.setText("SECTION 2: PRE-TEST INTERVIEW");
            r5.addTab();
            r5.addTab();
            r5.addTab();
            r5.addTab();
            r5.addTab();
            r5.addTab();
            r5.addTab();
            r5.addTab();
            r5.addTab();
            
            XWPFParagraph preTestInterviewContents = document.createParagraph();
            XWPFRun r5Contents = preTestInterviewContents.createRun();
            r5Contents.setText(polygraph.getPreTest());

            XWPFParagraph inTestPhase = document.createParagraph();
            XWPFRun r6 = inTestPhase.createRun();
            r6.setUnderline(UnderlinePatterns.SINGLE);
            r6.setText("SECTION 3: IN-TEST PHASE");
            r6.addTab();
            r6.addTab();
            r6.addTab();
            r6.addTab();
            r6.addTab();
            r6.addTab();
            r6.addTab();
            r6.addTab();
            r6.addTab();
            r6.addTab();
            
            XWPFParagraph inTestPhaseContents = document.createParagraph();
            XWPFRun r6Contents = inTestPhaseContents.createRun();
            r6Contents.setText(polygraph.getInTest());

            XWPFParagraph result = document.createParagraph();
            XWPFRun r7 = result.createRun();
            r7.setUnderline(UnderlinePatterns.SINGLE);
            r7.setText("SECTION 4: RESULT");
            r7.addTab();
            r7.addTab();
            r7.addTab();
            r7.addTab();
            r7.addTab();
            r7.addTab();
            r7.addTab();
            r7.addTab();
            r7.addTab();
            r7.addTab();
            r7.addTab();
            
            XWPFParagraph resultContents = document.createParagraph();
            XWPFRun r7Contents = resultContents.createRun();
            r7Contents.setText(polygraph.getResult());

            XWPFParagraph postTestInterview = document.createParagraph();
            XWPFRun r8 = postTestInterview.createRun();
            r8.setUnderline(UnderlinePatterns.SINGLE);
            r8.setText("SECTION 5: POST-TEST INTERVIEW");
            r8.addTab();
            r8.addTab();
            r8.addTab();
            r8.addTab();
            r8.addTab();
            r8.addTab();
            r8.addTab();
            r8.addTab();
            r8.addTab();
            
            
            XWPFParagraph postTestInterviewContents = document.createParagraph();
            XWPFRun r8Contents = postTestInterviewContents.createRun();
            r8Contents.setText(polygraph.getPostTest());

            XWPFParagraph remarks = document.createParagraph();
            XWPFRun r9 = remarks.createRun();
            r9.setUnderline(UnderlinePatterns.SINGLE);
            r9.setText("REMARKS:");
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            r9.addTab();
            
            XWPFParagraph remarksContents = document.createParagraph();
            XWPFRun r9Contents = remarksContents.createRun();
            r9Contents.setText(polygraph.getRemarks());
            
            
            XWPFParagraph timeDateCompleted = document.createParagraph();
            XWPFRun r10 = timeDateCompleted.createRun();
            r10.setUnderline(UnderlinePatterns.SINGLE);
            r10.setText("TIME AND DATE COMPLETED:");
            r10.addTab();
            r10.addTab();
            r10.addTab();
            r10.addTab();
            r10.addTab();
            r10.addTab();
            r10.addTab();
            r10.addTab();
            r10.addTab();
            r10.addTab();
            
            XWPFParagraph timeDateCompletedContents = document.createParagraph();
            XWPFRun r10Contents = timeDateCompletedContents.createRun();
            r10Contents.setText(polygraph.getTimeDateCompleted());
            
            XWPFParagraph examinedBy = document.createParagraph();
            XWPFRun r11 = examinedBy.createRun();
            r11.setUnderline(UnderlinePatterns.SINGLE);
            r11.setText("EXAMINED BY:");
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            r11.addTab();
            
            XWPFParagraph examinedByContents = document.createParagraph();
            XWPFRun r11Contents = examinedByContents.createRun();
            r11Contents.setText(polygraph.getExaminerName());
            r11Contents.addBreak();
            r11Contents.setText(polygraph.getExaminerRank());
            r11Contents.addBreak();
            r11Contents.setText(polygraph.getExaminerPosition());
            
            XWPFParagraph approvedBy = document.createParagraph();
            XWPFRun r12 = approvedBy.createRun();
            r12.setUnderline(UnderlinePatterns.SINGLE);
            r12.setText("APPROVED BY:");
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            r12.addTab();
            
            XWPFParagraph approvedByContents = document.createParagraph();
            XWPFRun r12Contents = approvedByContents.createRun();
//            r12Contents.setText(polygraph.getApprovedName());
//            r12Contents.addBreak();
//            r12Contents.setText(polygraph.getApprovedRank());
//            r12Contents.addBreak();
//            r12Contents.setText(polygraph.getApprovedPosition());
//            r12Contents.addBreak();
            
            
            XWPFParagraph notedBy = document.createParagraph();
            XWPFRun r13 = notedBy.createRun();
            r13.setUnderline(UnderlinePatterns.SINGLE);
            r13.setText("NOTED BY:");
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            r13.addTab();
            
            XWPFParagraph notedByContents = document.createParagraph();
            XWPFRun r13Contents = notedByContents.createRun();
            r13Contents.setText(polygraph.getNotedName());
            r13Contents.addBreak();
            r13Contents.setText(polygraph.getNotedRank());
            r13Contents.addBreak();
            r13Contents.setText(polygraph.getNotedPosition());
            r13Contents.addBreak();
            table.setInsideVBorder(XWPFTable.XWPFBorderType.NIL, 0, 0, "white");

            document.getXWPFDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

}
