/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Criminal;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author rowPC
 */
public interface CriminalService {
    public void create(Criminal criminal);
    public Workbook createTenprintsCards(HttpSession session, String month);
}
