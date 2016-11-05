package com.crimelab.repository;

import com.crimelab.domain.GalleryResults;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Dan
 */
public interface GalleryDAO {

    public String getFileUploadPath();

    public ArrayList<Map<String,Object>> getFiles();

    public GalleryResults getCompositeSketch(@Param("caseNo") String caseNo);

    public void insertResults(GalleryResults galleryResults);

    public List<GalleryResults> getCompositeDetails(@Param("caseNo") String caseNo);
}
