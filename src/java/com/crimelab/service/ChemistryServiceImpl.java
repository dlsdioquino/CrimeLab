/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Chemistry;
import com.crimelab.repository.ChemistryDAO;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import static org.apache.poi.ss.usermodel.CellStyle.ALIGN_CENTER;
import static org.apache.poi.ss.usermodel.CellStyle.BORDER_THIN;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TeeDee
 */
@Service
public class ChemistryServiceImpl implements ChemistryService {

    private final ChemistryDAO chemistryDAO;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    Date date;
    String dateformat = "";

    @Autowired
    public ChemistryServiceImpl(ChemistryDAO chemistryDAO) {
        this.chemistryDAO = chemistryDAO;
    }

    @Override
    public Workbook create(Chemistry chemistry, HttpSession session) {
        Workbook wb = null;
        try {
            
//            date = sdf.parse(chemistry.getTimeDateReceived());
//            sdf.applyPattern("M-dd-yyyy hh:mm:ss a");
//            dateformat = sdf.format(date);
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/DefaultDrugs.xls");
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);

            Cell examType = findCell(sheet, "$examType");
            Cell reportNo = findCell(sheet, "$reportNo");
            Cell caseType = findCell(sheet, "$caseType");
            Cell suspects = findCell(sheet, "$suspects");
            Cell victims = findCell(sheet, "$victims");
            Cell timeDateReceived = findCell(sheet, "$timeDateReceived");
            Cell requestingParty = findCell(sheet, "$requestingParty");
            Cell specimenSubmitted = findCell(sheet, "$specimenSubmitted");
            Cell purposeOfLabExam = findCell(sheet, "$purposeOfLabExam");
            Cell findings = findCell(sheet, "$findings");
            Cell conclusions = findCell(sheet, "$conclusions");
            Cell remarks = findCell(sheet, "$remarks");
            Cell timeDateCompleted = findCell(sheet, "$timeDateCompleted");
            Cell examinerName = findCell(sheet, "$examinerName");
            Cell examinerRank = findCell(sheet, "$examinerRank");
            Cell examinerPosition = findCell(sheet, "$examinerPosition");
            Cell appName = findCell(sheet, "$appName");
            Cell appRank = findCell(sheet, "$appRank");
            Cell appPosition = findCell(sheet, "$appPosition");
            Cell notedName = findCell(sheet, "$notedName");
            Cell notedRank = findCell(sheet, "$notedRank");
            Cell notedPosition = findCell(sheet, "$notedPosition");
            Cell subscribed = findCell(sheet, "$subscribed");
            Cell subscribedName = findCell(sheet, "$subscribedName");
            Cell subscribedRank = findCell(sheet, "$subscribedRank");
            Cell subscribedPosition = findCell(sheet, "$subscribedPosition");

            examType.setCellValue(chemistry.getExamType());
            reportNo.setCellValue(chemistry.getReportNo());
            caseType.setCellValue(chemistry.getCaseType());
            suspects.setCellValue(chemistry.getSuspects());
            victims.setCellValue(chemistry.getVictims());
            timeDateReceived.setCellValue(chemistry.getTimeDateReceived());
            requestingParty.setCellValue(chemistry.getRequestingParty());
            specimenSubmitted.setCellValue(chemistry.getSpecimenSubmitted());
            purposeOfLabExam.setCellValue(chemistry.getPurposeOfLabExam());
            findings.setCellValue(chemistry.getFindings());
            conclusions.setCellValue(chemistry.getConclusions());
            remarks.setCellValue(chemistry.getRemarks());
            timeDateCompleted.setCellValue(chemistry.getTimeDateCompleted());
            examinerName.setCellValue(chemistry.getExaminerName());
            examinerRank.setCellValue(chemistry.getExaminerRank());
            examinerPosition.setCellValue(chemistry.getExaminerPosition());
            appName.setCellValue(chemistry.getAppName());
            appRank.setCellValue(chemistry.getAppRank());
            appPosition.setCellValue(chemistry.getAppPosition());
            notedName.setCellValue(chemistry.getNotedName());
            notedRank.setCellValue(chemistry.getNotedRank());
            notedPosition.setCellValue(chemistry.getNotedPosition());
            subscribed.setCellValue(chemistry.getSubscribed());
            subscribedName.setCellValue(chemistry.getSubscribedName());
            subscribedRank.setCellValue(chemistry.getSubscribedRank());
            subscribedPosition.setCellValue(chemistry.getSubscribedPosition());

            chemistryDAO.chemistryInfo(chemistry);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return wb;
    }

    public Cell findCell(Sheet sheet, String cellContent) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                        return cell;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Workbook createMonthlyReport(HttpSession session, String month) {
        Workbook wb = null;

        try {
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/DrugMonthlyReport.xls");
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            CellStyle cs1 = wb.createCellStyle();
            CellStyle cs2 = wb.createCellStyle();
            CellStyle bl = wb.createCellStyle();
            CellStyle br = wb.createCellStyle();
            CellStyle bt = wb.createCellStyle();
            CellStyle bb = wb.createCellStyle();
            CellStyle stf = wb.createCellStyle();
            cs1.setWrapText(true);
            cs2.setAlignment(ALIGN_CENTER);
            bt.setBorderTop(BORDER_THIN);
            bb.setBorderBottom(BORDER_THIN);
            bl.setBorderLeft(BORDER_THIN);
            br.setBorderRight(BORDER_THIN);
            stf.setShrinkToFit(true);

            Row intro1 = sheet.createRow(7);
            Cell in1 = intro1.createCell(0);//.setCellValue("DRUG INVETORY COVERED PERIOD JANUARY-DECEMBER CY-" +month.split("-")[0]);
            in1.setCellValue("DRUG INVENTORY COVERED PERIOD JANUARY-DECEMBER CY-" + month.split("-")[0]);
            in1.setCellStyle(cs1);
            in1.setCellStyle(cs2);

            Row intro2 = sheet.createRow(9);
            Cell in2 = intro2.createCell(0);//.setCellValue("SUMMARY OF SEIZED/SURRENDERED/RECOVERED OF DRUG EVIDENCES FROM NEGATION OPERATIONS FROM LAW ENFORCEMENTS, PHARMACEUTICAL COMPANIES AND SIMILAR ESTABLISHMENTS FOR THE MONTH OF "+month);
            in2.setCellValue("SUMMARY OF SEIZED/SURRENDERED/RECOVERED OF DRUG EVIDENCES FROM NEGATION OPERATIONS FROM LAW ENFORCEMENTS, PHARMACEUTICAL COMPANIES AND SIMILAR ESTABLISHMENTS FOR THE MONTH OF " + month);
            in2.setCellStyle(cs1);
            in2.setCellStyle(cs2);
            in2.setCellStyle(stf);

            int ctr = 12; //initial
            Row row = sheet.createRow(ctr);
            month = month.split("-")[1];

            //System.out.println("GAC " + chemistryDAO.getAllChemistry(month).isEmpty());
            for (Chemistry chemistry : chemistryDAO.getAllChemistry(month)) {
                //System.out.println("Test " + chemistry.getTimeDateReceived());
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(chemistry.getTimeDateReceived());
                cell0.setCellStyle(bt);
                cell0.setCellStyle(bb);
                cell0.setCellStyle(bl);
                cell0.setCellStyle(br);

                Cell cell1 = row.createCell(1);//.setCellValue(chemistry.getReportNo());
                cell1.setCellValue(chemistry.getReportNo());
                cell1.setCellStyle(bt);
                cell1.setCellStyle(bb);
                cell1.setCellStyle(bl);
                cell1.setCellStyle(br);

                Cell cell2 = row.createCell(2);//.setCellValue(chemistry.getRequestingParty());
                cell2.setCellValue(chemistry.getRequestingParty());
                cell2.setCellStyle(bt);
                cell2.setCellStyle(bb);
                cell2.setCellStyle(bl);
                cell2.setCellStyle(br);

                Cell cell3 = row.createCell(3);//.setCellValue(chemistry.getDescriptionOfEvidence());
                cell3.setCellValue(chemistry.getDescriptionOfEvidence());
                cell3.setCellStyle(bt);
                cell3.setCellStyle(bb);
                cell3.setCellStyle(bl);
                cell3.setCellStyle(br);

                Cell cell4 = row.createCell(4);//.setCellValue(chemistry.getSpecimenWeight());
                cell4.setCellValue(chemistry.getSpecimenWeight());
                cell4.setCellStyle(bt);
                cell4.setCellStyle(bb);
                cell4.setCellStyle(bl);
                cell4.setCellStyle(br);

                Cell cell5 = row.createCell(5);//.setCellValue(chemistry.getCustody());
                cell5.setCellValue(chemistry.getCustody());
                cell5.setCellStyle(bt);
                cell5.setCellStyle(bb);
                cell5.setCellStyle(bl);
                cell5.setCellStyle(br);

                Cell cell6 = row.createCell(6);//.setCellValue(chemistry.getSuspects());
                cell6.setCellValue(chemistry.getSuspects());
                cell6.setCellStyle(bt);
                cell6.setCellStyle(bb);
                cell6.setCellStyle(bl);
                cell6.setCellStyle(br);

                Cell cell7 = row.createCell(7);//.setCellValue(chemistry.getTypeOfOperation());
                cell7.setCellValue(chemistry.getTypeOfOperation());
                cell7.setCellStyle(bt);
                cell7.setCellStyle(bb);
                cell7.setCellStyle(bl);
                cell7.setCellStyle(br);

                Cell cell8 = row.createCell(8);//.setCellValue(chemistry.getPlaceOfOperation());
                cell8.setCellValue(chemistry.getPlaceOfOperation());
                cell8.setCellStyle(bt);
                cell8.setCellStyle(bb);
                cell8.setCellStyle(bl);
                cell8.setCellStyle(br);

                row = sheet.createRow(ctr += 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return wb;
    }

    @Override
    public List<Chemistry> getOthersChemistry() {
        return chemistryDAO.getOthersChemistry();
    }
    
    public static int countWords(String s){
        int wordCount = 0;
        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

    @Override
    public ArrayList<Map<String, Object>> getChemistryReport() {
        return chemistryDAO.getChemistryReport();
    }
    
}
