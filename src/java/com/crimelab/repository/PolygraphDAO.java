/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.repository;

import com.crimelab.domain.Polygraph;
import java.util.List;

/**
 *
 * @author rowPC
 */
public interface PolygraphDAO {

    public String getFileUploadPath();

    public List<Polygraph> getAllPolygraph();

    //public void insertUser(@Param(value = "firstName")String firstName, @Param(value = "lastName")String lastName, @Param(value = "title")String title);

    public void polygraphInfo(Polygraph polygraph);
}
