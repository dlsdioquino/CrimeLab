/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.repository;

import com.crimelab.domain.Civilian;
import java.util.List;

/**
 *
 * @author rowPC
 */
public interface CivilianDAO {
    public List<Civilian> getAllCivilian();
    public void civilianInfo(Civilian civilian);
}
