/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Firearms;
import com.crimelab.repository.FirearmsDAO;
import java.io.InputStream;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
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
 * @author rowPC
 */
@Service
public class FirearmsServiceImpl implements FirearmsService {

    private final FirearmsDAO firearmsDAO;

    @Autowired
    public FirearmsServiceImpl(FirearmsDAO firearmsDAO) {
        this.firearmsDAO = firearmsDAO;
    }

    @Override
    public Workbook create(Firearms firearms, HttpSession session) {
        Workbook wb = null;

        try {
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/Default.xls");
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);

            Cell division = findCell(sheet, "$division");
            Cell reportNo = findCell(sheet, "$reportNo");
            Cell caseType = findCell(sheet, "$caseType");
            Cell suspect = findCell(sheet, "$suspect");
            Cell victim = findCell(sheet, "$victim");
            Cell timeDateReceived = findCell(sheet, "$timeDateReceived");
            Cell requestingParty = findCell(sheet, "$requestingParty");
            Cell specimenSubmitted = findCell(sheet, "$specimenSubmitted");
            Cell purposeOfLabExam = findCell(sheet, "$purposeOfLabExam");
            Cell findings = findCell(sheet, "$findings");
            Cell conclusion = findCell(sheet, "$conclusion");
            Cell remarks = findCell(sheet, "$remarks");
            Cell timeDateCompleted = findCell(sheet, "$timeDateCompleted");
            Cell examinerName = findCell(sheet, "$examinerName");
            Cell examinerRank = findCell(sheet, "$examinerRank");
            Cell examinerPosition = findCell(sheet, "$examinerPosition");
            Cell notedName = findCell(sheet, "$notedName");
            Cell notedRank = findCell(sheet, "$notedRank");
            Cell notedPosition = findCell(sheet, "$notedPosition");
            
            
            division.setCellValue(firearms.getDivision());
            reportNo.setCellValue(firearms.getReportNo());
            caseType.setCellValue(firearms.getCaseType());
            suspect.setCellValue(firearms.getSuspect());
            victim.setCellValue(firearms.getVictim());
            timeDateReceived.setCellValue(firearms.getTimeDateReceived());
            requestingParty.setCellValue(firearms.getRequestingParty());
            specimenSubmitted.setCellValue(firearms.getSpecimenSubmitted());
            purposeOfLabExam.setCellValue(firearms.getPurposeOfLabExam());
            findings.setCellValue(firearms.getFindings());
            conclusion.setCellValue(firearms.getConclusion());
            remarks.setCellValue(firearms.getRemarks());
            timeDateCompleted.setCellValue(firearms.getTimeDateCompleted());
            examinerName.setCellValue(firearms.getExaminerName());
            examinerRank.setCellValue(firearms.getExaminerRank());
            examinerPosition.setCellValue(firearms.getExaminerPosition());
            notedName.setCellValue(firearms.getNotedName());
            notedRank.setCellValue(firearms.getNotedRank());
            notedPosition.setCellValue(firearms.getNotedPosition());            
            firearmsDAO.firearmsInfo(firearms);
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
    public Workbook createFirearmsCases(HttpSession session, String month) {
        Workbook wb = null;

        try {
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/FirearmsCases.xls");
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            CellStyle cs1 = wb.createCellStyle();
            CellStyle cs2 = wb.createCellStyle();
            CellStyle bl = wb.createCellStyle();
            CellStyle br = wb.createCellStyle();
            CellStyle bt = wb.createCellStyle();
            CellStyle bb = wb.createCellStyle();
            cs1.setWrapText(true);
            cs2.setAlignment(ALIGN_CENTER);
            bt.setBorderTop(BORDER_THIN);
            bb.setBorderBottom(BORDER_THIN);
            bl.setBorderLeft(BORDER_THIN);
            br.setBorderRight(BORDER_THIN);

            Row intro1 = sheet.createRow(9);
            Cell in1 = intro1.createCell(0);
            in1.setCellValue("Period Covered:");
            in1.setCellStyle(cs1);
            in1.setCellStyle(cs2);
            
            Row intro2 = sheet.createRow(10);
            Cell in2 = intro2.createCell(0);
            in1.setCellValue(month.split("-")[0]);
            in1.setCellStyle(cs1);
            in1.setCellStyle(cs2);
            
            
            int ctr = 12; //initial
            Row row = sheet.createRow(ctr);
            month = month.split("-")[1];

            //JOptionPane.showMessageDialog(null, firearmsDAO.getAllFirearms(month));
            for (Firearms firearms : firearmsDAO.getAllFirearms(month)) {
                //JOptionPane.showMessageDialog(null, firearms.getReportNo());
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(firearms.getReportNo());
                cell0.setCellStyle(bt);
                cell0.setCellStyle(bb);
                cell0.setCellStyle(bl);
                cell0.setCellStyle(br);

                Cell cell1 = row.createCell(1);//.setCellValue(firearms.getReportNo());
                cell1.setCellValue(firearms.getExaminerName());
                cell1.setCellStyle(bt);
                cell1.setCellStyle(bb);
                cell1.setCellStyle(bl);
                cell1.setCellStyle(br);

                Cell cell2 = row.createCell(2);//.setCellValue(firearms.getRequestingParty());
                cell2.setCellValue(firearms.getCaseType());
                cell2.setCellStyle(bt);
                cell2.setCellStyle(bb);
                cell2.setCellStyle(bl);
                cell2.setCellStyle(br);

                Cell cell3 = row.createCell(3);//.setCellValue(firearms.getDescriptionOfEvidence());
                cell3.setCellValue(firearms.getVictim());
                cell2.setCellStyle(bt);
                cell2.setCellStyle(bb);
                cell3.setCellStyle(bl);
                cell3.setCellStyle(br);

                Cell cell4 = row.createCell(4);//.setCellValue(firearms.getSpecimenWeight());
                cell4.setCellValue(firearms.getSuspect());
                cell4.setCellStyle(bt);
                cell4.setCellStyle(bb);
                cell4.setCellStyle(bl);
                cell4.setCellStyle(br);

                Cell cell5 = row.createCell(5);//.setCellValue(firearms.getCustody());
                cell5.setCellValue(firearms.getTimeDateIncident());
                cell5.setCellStyle(bt);
                cell5.setCellStyle(bb);
                cell5.setCellStyle(bl);
                cell5.setCellStyle(br);

                Cell cell6 = row.createCell(6);//.setCellValue(firearms.getSuspects());
                cell6.setCellValue(firearms.getPlaceOfIncident());
                cell6.setCellStyle(bt);
                cell6.setCellStyle(bb);
                cell6.setCellStyle(bl);
                cell6.setCellStyle(br);

                Cell cell7 = row.createCell(7);//.setCellValue(firearms.getTypeOfOperation());
                cell7.setCellValue(firearms.getRequestingParty());
                cell7.setCellStyle(bt);
                cell7.setCellStyle(bb);
                cell7.setCellStyle(bl);
                cell7.setCellStyle(br);

                Cell cell8 = row.createCell(8);//.setCellValue(firearms.getPlaceOfOperation());
                cell8.setCellValue(firearms.getInvestigator());
                cell8.setCellStyle(bt);
                cell8.setCellStyle(bb);
                cell8.setCellStyle(bl);
                cell8.setCellStyle(br);

                Cell cell9 = row.createCell(9);//.setCellValue(firearms.getPlaceOfOperation());
                cell9.setCellValue(firearms.getCaseStatus());
                cell9.setCellStyle(bt);
                cell9.setCellStyle(bb);
                cell9.setCellStyle(bl);
                cell9.setCellStyle(br);

                row = sheet.createRow(ctr += 1);

                return wb;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }
}

