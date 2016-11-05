/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Polygraph;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author rowPC
 */
public interface PolygraphService {
    public String getFileUploadPath();
    public List<Polygraph> getAllPolygraph();
    public XWPFDocument create(Polygraph polygraph, HttpSession session);
}
