/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gesab001
 */
import  static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycompany.texteditormaven.*;
import java.nio.file.Path;
import javax.swing.JFileChooser;



class TestTextEditor {

    MainFrame mainFrame = new MainFrame(){};

    

    @Test
    void open(){

        JFileChooser jfc = mainFrame.setFilters();
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
                Path path = mainFrame.getFilePath(jfc);
                assertNotEquals("", path);

        } 
    }

    @Test
    void save(){
        String text = "hello world".trim();
        mainFrame.saveDocument(text);
        JFileChooser jfc = mainFrame.setFilters();
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            Path path = mainFrame.getFilePath(jfc);
            String result = mainFrame.getTextArea().trim();
            assertEquals(text, result);
        }
    }
    
    @Test
    void search(){
        mainFrame.search();
    }
}