/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Qd;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author rowPC
 */
public interface QdService {
    public Workbook create(Qd qd, HttpSession session);
}
