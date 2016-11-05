/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.service;

import com.crimelab.domain.DrugTest;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author TeeDee
 */
public interface DrugTestService {
    public List<DrugTest> getAllDrugTests();
    public Workbook create(DrugTest drugTest,HttpSession session);   
}
