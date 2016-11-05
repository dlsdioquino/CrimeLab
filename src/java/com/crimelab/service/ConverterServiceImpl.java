/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimelab.service;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import java.io.File;
import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class ConverterServiceImpl implements ConverterService {

    @Override
    public void convert(String tempPath, String fileName) {

        try {

            File inputFile = new File(tempPath + "\\" + fileName + ".xls");
            File outputFile = new File(tempPath + "\\" + fileName + ".pdf");

            // connect to an OpenOffice.org instance running on port 8100
            OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
            connection.connect();

            // convert
            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
            converter.convert(inputFile, outputFile);

            // close the connection
            connection.disconnect();
        } catch (ConnectException ex) {
            Logger.getLogger(ConverterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
