/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.GalleryResults;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Dan
 */
public interface GalleryService {
    public String getFileUploadPath();
    public ArrayList<Map<String, Object>> getFiles();
    public List<GalleryResults> getCompositeDetails(String caseNo);
    public GalleryResults getCompositeSketch(String caseNo);
    public XWPFDocument create(GalleryResults galleryResults, HttpSession session);
}
