/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.repository;

import com.crimelab.domain.Chemistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author TeeDee
 */
public interface ChemistryDAO {
    public List<Chemistry> getAllChemistry(@Param("month") String month);
    public List<Chemistry> getOthersChemistry();
    public void chemistryInfo(Chemistry chemistry);
    public ArrayList<Map<String, Object>> getChemistryReport ();
}
