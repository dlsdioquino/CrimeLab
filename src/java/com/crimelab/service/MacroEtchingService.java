/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.service;

import com.crimelab.domain.MacroEtching;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author TeeDee
 */
public interface MacroEtchingService {
    public List<MacroEtching> getAllMacroEtching();
    public Workbook create(MacroEtching macroEtching, HttpSession session);
}
