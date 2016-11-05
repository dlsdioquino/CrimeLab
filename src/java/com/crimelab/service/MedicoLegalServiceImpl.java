/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.MedicoLegal;
import com.crimelab.repository.MedicoLegalDAO;
import java.io.InputStream;
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
 * @author rowPC
 */
@Service
public class MedicoLegalServiceImpl implements MedicoLegalService {
    
  private final MedicoLegalDAO medicoLegalDAO;
    
    @Autowired
    public MedicoLegalServiceImpl(MedicoLegalDAO medicoLegalDAO){
        this.medicoLegalDAO = medicoLegalDAO;
    }

    @Override
    public Workbook create(MedicoLegal medicoLegal, HttpSession session) {
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

            division.setCellValue(medicoLegal.getDivision());
            reportNo.setCellValue(medicoLegal.getReportNo());
            caseType.setCellValue(medicoLegal.getCaseType());
            suspect.setCellValue(medicoLegal.getSuspect());
            victim.setCellValue(medicoLegal.getVictim());
            timeDateReceived.setCellValue(medicoLegal.getTimeDateReceived());
            requestingParty.setCellValue(medicoLegal.getRequestingParty());
            specimenSubmitted.setCellValue(medicoLegal.getSpecimenSubmitted());
            purposeOfLabExam.setCellValue(medicoLegal.getPurposeOfLabExam());
            findings.setCellValue(medicoLegal.getFindings());
            conclusion.setCellValue(medicoLegal.getConclusion());
            remarks.setCellValue(medicoLegal.getRemarks());
            timeDateCompleted.setCellValue(medicoLegal.getTimeDateCompleted());
            examinerName.setCellValue(medicoLegal.getExaminerName());
            examinerRank.setCellValue(medicoLegal.getExaminerRank());
            examinerPosition.setCellValue(medicoLegal.getExaminerPosition());
            notedName.setCellValue(medicoLegal.getNotedName());
            notedRank.setCellValue(medicoLegal.getNotedRank());
            notedPosition.setCellValue(medicoLegal.getNotedPosition());

            medicoLegalDAO.medicoLegalInfo(medicoLegal);
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
    public Workbook createMedicoMonthly(HttpSession session, String month) {
        Workbook wb = null;

        try {
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/MedicoMonthly.xls");
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

            //JOptionPane.showMessageDialog(null, medicoLegalDAO.getAllMedicoLegal(month));
            for (MedicoLegal medicoLegal : medicoLegalDAO.getAllMedicoLegal(month)) {
                //JOptionPane.showMessageDialog(null, medicoLegal.getReportNo());
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(medicoLegal.getCaseNo());
                cell0.setCellStyle(bt);
                cell0.setCellStyle(bb);
                cell0.setCellStyle(bl);
                cell0.setCellStyle(br);

                Cell cell1 = row.createCell(1);//.setCellValue(medicoLegal.getReportNo());
                cell1.setCellValue(medicoLegal.getExaminerName());
                cell1.setCellStyle(bt);
                cell1.setCellStyle(bb);
                cell1.setCellStyle(bl);
                cell1.setCellStyle(br);

                Cell cell2 = row.createCell(2);//.setCellValue(medicoLegal.getRequestingParty());
                cell2.setCellValue(medicoLegal.getCaseType());
                cell2.setCellStyle(bt);
                cell2.setCellStyle(bb);
                cell2.setCellStyle(bl);
                cell2.setCellStyle(br);

                Cell cell3 = row.createCell(3);//.setCellValue(medicoLegal.getDescriptionOfEvidence());
                cell3.setCellValue(medicoLegal.getVictim());
                cell2.setCellStyle(bt);
                cell2.setCellStyle(bb);
                cell3.setCellStyle(bl);
                cell3.setCellStyle(br);

                Cell cell4 = row.createCell(4);//.setCellValue(medicoLegal.getSpecimenWeight());
                cell4.setCellValue(medicoLegal.getSuspect());
                cell4.setCellStyle(bt);
                cell4.setCellStyle(bb);
                cell4.setCellStyle(bl);
                cell4.setCellStyle(br);

                Cell cell5 = row.createCell(5);//.setCellValue(medicoLegal.getCustody());
                cell5.setCellValue(medicoLegal.getTimeDateReceived());
                cell5.setCellStyle(bt);
                cell5.setCellStyle(bb);
                cell5.setCellStyle(bl);
                cell5.setCellStyle(br);

                Cell cell6 = row.createCell(6);//.setCellValue(medicoLegal.getSuspects());
                cell6.setCellValue(medicoLegal.getFindings());
                cell6.setCellStyle(bt);
                cell6.setCellStyle(bb);
                cell6.setCellStyle(bl);
                cell6.setCellStyle(br);

                row = sheet.createRow(ctr += 1);

                return wb;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }
}

