/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.repository;

import com.crimelab.domain.Criminal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author rowPC
 */
public interface CriminalDAO {
    public List<Criminal> getAllCriminal(@Param("month") String month);
    public void criminalInfo(Criminal criminal);
}
