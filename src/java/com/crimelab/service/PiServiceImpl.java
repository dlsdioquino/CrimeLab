/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.service;

import com.crimelab.domain.PiReport;
import com.crimelab.repository.PiDAO;
import java.io.InputStream;
import java.util.List;
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
 * @author TeeDee
 */
@Service
public class PiServiceImpl implements PiService{
    private final PiDAO piDAO;
    
    @Autowired
    public PiServiceImpl(PiDAO piDAO){
        this.piDAO = piDAO;
    }

    @Override
    public List<PiReport> getAllPiReport() {
        return piDAO.getAllPiReport();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Workbook create(PiReport piReport, HttpSession session) {
        Workbook wb = null;
        try{
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/Default.xls");
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
            
            examType.setCellValue(piReport.getExamType());
            reportNo.setCellValue(piReport.getReportNo());
            caseType.setCellValue(piReport.getCaseType());
            suspects.setCellValue(piReport.getSuspects());
            victims.setCellValue(piReport.getVictims());
            timeDateReceived.setCellValue(piReport.getTimeDateReceived());
            requestingParty.setCellValue(piReport.getRequestingParty());
            specimenSubmitted.setCellValue(piReport.getSpecimenSubmitted());
            purposeOfLabExam.setCellValue(piReport.getPurposeOfLabExam());
            findings.setCellValue(piReport.getFindings());
            conclusions.setCellValue(piReport.getConclusions());
            remarks.setCellValue(piReport.getRemarks());
            timeDateCompleted.setCellValue(piReport.getTimeDateCompleted());
            examinerName.setCellValue(piReport.getExaminerName());
            examinerRank.setCellValue(piReport.getExaminerRank());
            examinerPosition.setCellValue(piReport.getExaminerPosition());
            appName.setCellValue(piReport.getAppName());
            appRank.setCellValue(piReport.getAppRank());
            appPosition.setCellValue(piReport.getAppPosition());
            notedName.setCellValue(piReport.getNotedName());
            notedRank.setCellValue(piReport.getNotedRank());
            notedPosition.setCellValue(piReport.getNotedPosition());
            
            piDAO.piReportInfo(piReport);
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
