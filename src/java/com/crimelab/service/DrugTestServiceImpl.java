/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.DrugTest;
import com.crimelab.repository.DrugTestDAO;
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
public class DrugTestServiceImpl implements DrugTestService {

    private final DrugTestDAO drugTestDAO;

    @Autowired
    public DrugTestServiceImpl(DrugTestDAO drugTestDAO) {
        this.drugTestDAO = drugTestDAO;
    }

    @Override
    public List<DrugTest> getAllDrugTests() {
        return drugTestDAO.getAllDrugTests();
    }

    @Override
    public Workbook create(DrugTest drugTest,HttpSession session) {
        Workbook wb = null;
        
        try {       
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/DrugTest.xls");
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            
            //iterate over keywords  
            Cell fadtNo = findCell(sheet, "$fadtNo");
            Cell sbrNo = findCell(sheet, "$sbrNo");
            Cell timeDate = findCell(sheet, "$timeDate");
            Cell name = findCell(sheet, "$name");
            Cell address = findCell(sheet, "$address");
            Cell age = findCell(sheet, "$age");
            Cell sex = findCell(sheet, "$sex");
            Cell purposeFL = findCell(sheet, "$purposeFL");
            Cell purposePTCFOR = findCell(sheet, "$purposePTCFOR");
            Cell specimenSubmitted = findCell(sheet, "$specimenSubmitted");
            Cell purposeOfExamination = findCell(sheet, "$purposeOfExamination");
            Cell methamphetamine = findCell(sheet, "$methamphetamine");
            Cell thc = findCell(sheet, "$thc");
            Cell remarks = findCell(sheet, "$remarks");
            Cell examinerName = findCell(sheet, "$examinerName");
            Cell examinerRank = findCell(sheet, "$examinerRank");
            Cell examinerPosition = findCell(sheet, "$examinerPosition");
            Cell appName = findCell(sheet, "$appName");
            Cell appRank = findCell(sheet, "$appRank");
            Cell appPosition = findCell(sheet, "$appPosition");

            //Modify the cellContents here
            // Write the output to a file
            //get from param
            fadtNo.setCellValue(drugTest.getFadtNo());
            sbrNo.setCellValue(drugTest.getSbrNo());
            timeDate.setCellValue(drugTest.getTimeDate());
            name.setCellValue(drugTest.getName());
            address.setCellValue(drugTest.getAddress());
            age.setCellValue(drugTest.getAge());
            sex.setCellValue(drugTest.getSex());

            switch (drugTest.getPurpose().trim()) {
                case "Firearm License":
                    purposeFL.setCellValue("   ✓");
                    purposePTCFOR.setCellValue("");
                    break;
                    
                case "Permit to Carry Firearms Outside Residence (PTCFOR)":
                    purposeFL.setCellValue("");
                    purposePTCFOR.setCellValue("   ✓");
                    break;
               
                default:
                    purposeFL.setCellValue("   ✓");
                    purposePTCFOR.setCellValue("   ✓");
                    break;
            }

            specimenSubmitted.setCellValue(drugTest.getSpecimenSubmitted());
            purposeOfExamination.setCellValue(drugTest.getPurposeOfExamination());
            methamphetamine.setCellValue(drugTest.getMethamphetamine());
            thc.setCellValue(drugTest.getThc());
            remarks.setCellValue(drugTest.getRemarks());
            examinerName.setCellValue(drugTest.getExaminerName());
            examinerRank.setCellValue(drugTest.getExaminerRank());
            examinerPosition.setCellValue(drugTest.getExaminerPosition());
            appName.setCellValue(drugTest.getAppName());
            appRank.setCellValue(drugTest.getAppRank());
            appPosition.setCellValue(drugTest.getAppPosition());

            drugTestDAO.drugTestInfo(drugTest);
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
}
