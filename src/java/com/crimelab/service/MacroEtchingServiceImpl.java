/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.service;

import com.crimelab.domain.MacroEtching;
import com.crimelab.repository.MacroEtchingDAO;
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
public class MacroEtchingServiceImpl implements MacroEtchingService{
    private final MacroEtchingDAO macroEtchingDAO;
    
    
    @Autowired
    public MacroEtchingServiceImpl(MacroEtchingDAO macroEtchingDAO){
        this.macroEtchingDAO = macroEtchingDAO;
    }
    
    @Override
    public List<MacroEtching> getAllMacroEtching() {
        return macroEtchingDAO.getAllMacroEtching();
    }

    @Override
    public Workbook create(MacroEtching macroEtching, HttpSession session) {
        Workbook wb = null;
        try{
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/meCert.xls");
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            
            Cell dateCreated = findCell(sheet, "$dateCreated");
            Cell rclo = findCell(sheet, "$rclo");
            Cell make = findCell(sheet, "$make");
            Cell color = findCell(sheet, "$color");
            Cell plateNo = findCell(sheet, "$plateNo");
            Cell engineNo = findCell(sheet, "$engineNo");
            Cell chassisNo = findCell(sheet, "$chassisNo");
            Cell eNo = findCell(sheet, "$eNo");
            Cell cNo = findCell(sheet, "$cNo");
            Cell owner = findCell(sheet, "$owner");
            Cell address = findCell(sheet, "$address");
            Cell appName = findCell(sheet, "$appName");
            Cell appRank = findCell(sheet, "$appRank");
            Cell appPosition = findCell(sheet, "$appPosition");
            Cell examinerName = findCell(sheet, "$examinerName");
            Cell examinerRank = findCell(sheet, "$examinerRank");
            Cell examinerPosition = findCell(sheet, "$examinerPosition");
            
            dateCreated.setCellValue(macroEtching.getDateCreated());
            rclo.setCellValue(macroEtching.getRclo());
            make.setCellValue(macroEtching.getMake());
            color.setCellValue(macroEtching.getColor());
            plateNo.setCellValue(macroEtching.getPlateNo());
            engineNo.setCellValue(macroEtching.getEngineNo());
            chassisNo.setCellValue(macroEtching.getChassisNo());
            eNo.setCellValue(macroEtching.getEngineNo());
            cNo.setCellValue(macroEtching.getChassisNo());
            owner.setCellValue(macroEtching.getOwner());
            address.setCellValue(macroEtching.getAddress());
            appName.setCellValue(macroEtching.getAppName());
            appRank.setCellValue(macroEtching.getAppRank());
            appPosition.setCellValue(macroEtching.getAppPosition());
            examinerName.setCellValue(macroEtching.getExaminerName());
            examinerRank.setCellValue(macroEtching.getExaminerRank());
            examinerPosition.setCellValue(macroEtching.getExaminerPosition());
            
            macroEtchingDAO.macroEtchingInfo(macroEtching); 
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
