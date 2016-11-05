/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.crimelab.repository;

import com.crimelab.domain.MacroEtching;
import java.util.List;
/**
 *
 * @author TeeDee
 */
public interface MacroEtchingDAO {
    public List<MacroEtching> getAllMacroEtching();
    //public void insertUser(@Param(value = "firstName")String firstName, @Param(value = "lastName")String lastName, @Param(value = "title")String title);
    public MacroEtching macroEtchingInfo(MacroEtching macroEtching);
}
