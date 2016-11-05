/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.crimelab.domain.Civilian;
import com.crimelab.repository.CivilianDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rowPC
 */
@Service
public class CivilianServiceImpl implements CivilianService {
  private final CivilianDAO civilianDAO;
    
    @Autowired
    public CivilianServiceImpl(CivilianDAO civilianDAO){
        this.civilianDAO = civilianDAO;
    }
    
    @Override
    public List<Civilian> getAllCivilian() {
        return civilianDAO.getAllCivilian();
    }

    @Override
    public void create(Civilian civilian) {
        civilianDAO.civilianInfo(civilian);
    }
}

