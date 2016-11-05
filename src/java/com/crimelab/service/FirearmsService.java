/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Firearms;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author rowPC
 */
public interface FirearmsService {
    public Workbook create(Firearms firearms, HttpSession session);
    public Workbook createFirearmsCases(HttpSession session, String month);
}
