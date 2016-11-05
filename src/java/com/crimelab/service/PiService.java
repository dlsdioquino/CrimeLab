/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.service;

import com.crimelab.domain.PiReport;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author TeeDee
 */
public interface PiService {
    public List<PiReport> getAllPiReport();
    public Workbook create(PiReport piReport, HttpSession session);
}
