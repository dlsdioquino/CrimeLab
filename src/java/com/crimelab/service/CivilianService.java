/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Civilian;
import java.util.List;

/**
 *
 * @author rowPC
 */
public interface CivilianService {
    public List<Civilian> getAllCivilian();
    public void create(Civilian civilian);
}
