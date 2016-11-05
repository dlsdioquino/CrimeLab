/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Criminal;
import com.crimelab.repository.CriminalDAO;
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
public class CriminalServiceImpl implements CriminalService {

    private final CriminalDAO criminalDAO;

    @Autowired
    public CriminalServiceImpl(CriminalDAO criminalDAO) {
        this.criminalDAO = criminalDAO;
    }

    @Override
    public void create(Criminal criminal) {
        criminalDAO.criminalInfo(criminal);
    }

    @Override
    public Workbook createTenprintsCards(HttpSession session, String month) {
        Workbook wb = null;

        try {
            InputStream inp = session.getServletContext().getResourceAsStream("/WEB-INF/templates/TenprintsCards.xls");
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
            in1.setCellValue("Submitted Tenprints Cards from " + month.split("-")[0]);
            in1.setCellStyle(cs1);
            in1.setCellStyle(cs2);

            int ctr = 11; //initial
            Row row = sheet.createRow(ctr);
            month = month.split("-")[1];

            //JOptionPane.showMessageDialog(null, criminalDAO.getAllCriminal(month));
            for (Criminal criminal : criminalDAO.getAllCriminal(month)) {
                //JOptionPane.showMessageDialog(null, criminal.getReportNo());

                Cell cell2 = row.createCell(2);//.setCellValue(criminal.getRequestingParty());
                cell2.setCellValue(criminal.getLastName());
                cell2.setCellStyle(bt);
                cell2.setCellStyle(bb);
                cell2.setCellStyle(bl);
                cell2.setCellStyle(br);

                Cell cell3 = row.createCell(3);//.setCellValue(criminal.getDescriptionOfEvidence());
                cell3.setCellValue(criminal.getFirstName());
                cell2.setCellStyle(bt);
                cell2.setCellStyle(bb);
                cell3.setCellStyle(bl);
                cell3.setCellStyle(br);

                Cell cell4 = row.createCell(4);//.setCellValue(criminal.getSpecimenWeight());
                cell4.setCellValue(criminal.getMiddleName());
                cell4.setCellStyle(bt);
                cell4.setCellStyle(bb);
                cell4.setCellStyle(bl);
                cell4.setCellStyle(br);

                Cell cell5 = row.createCell(5);//.setCellValue(criminal.getCustody());
                cell5.setCellValue(criminal.getTimeDateArrest());
                cell5.setCellStyle(bt);
                cell5.setCellStyle(bb);
                cell5.setCellStyle(bl);
                cell5.setCellStyle(br);

                Cell cell6 = row.createCell(6);//.setCellValue(criminal.getSuspects());
                cell6.setCellValue(criminal.getOffenseCharge());
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

