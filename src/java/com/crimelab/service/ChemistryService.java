/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.service;

import com.crimelab.domain.Chemistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author TeeDee
 */
public interface ChemistryService {
//    public List<Chemistry> getAllChemistry(String startPeriod, String endPeriod);
    public List<Chemistry> getOthersChemistry();
    public Workbook createMonthlyReport(HttpSession session,String month);
    public Workbook create(Chemistry chemistry, HttpSession session);
    public ArrayList<Map<String, Object>> getChemistryReport();

}
