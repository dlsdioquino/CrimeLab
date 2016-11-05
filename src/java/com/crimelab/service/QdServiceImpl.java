/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Qd;
import com.crimelab.repository.QdDAO;
import java.io.InputStream;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
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
public class QdServiceImpl implements QdService {
    
    private final QdDAO qdDAO;
    
    @Autowired
    public QdServiceImpl(QdDAO qdDAO){
        this.qdDAO = qdDAO;
    }

    @Override
    public Workbook create(Qd qd, HttpSession session) {
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
            
            division.setCellValue(qd.getDivision());
            reportNo.setCellValue(qd.getReportNo());
            caseType.setCellValue(qd.getCaseType());
            suspect.setCellValue(qd.getSuspect());
            victim.setCellValue(qd.getVictim());
            timeDateReceived.setCellValue(qd.getTimeDateReceived());
            requestingParty.setCellValue(qd.getRequestingParty());
            specimenSubmitted.setCellValue(qd.getSpecimenSubmitted());
            purposeOfLabExam.setCellValue(qd.getPurposeOfLabExam());
            findings.setCellValue(qd.getFindings());
            conclusion.setCellValue(qd.getConclusion());
            remarks.setCellValue(qd.getRemarks());
            timeDateCompleted.setCellValue(qd.getTimeDateCompleted());
            examinerName.setCellValue(qd.getExaminerName());
            examinerRank.setCellValue(qd.getExaminerRank());
            examinerPosition.setCellValue(qd.getExaminerPosition());
            notedName.setCellValue(qd.getNotedName());
            notedRank.setCellValue(qd.getNotedRank());
            notedPosition.setCellValue(qd.getNotedPosition());
     
            qdDAO.qdInfo(qd);  
        }catch(Exception e){
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
}

