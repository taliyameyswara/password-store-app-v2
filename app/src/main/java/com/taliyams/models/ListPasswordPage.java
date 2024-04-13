/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taliyams.models;

/**
 *
 * @author taliyameyswara
 */

import com.taliyams.models.cli.HLine;
import com.taliyams.models.cli.Label;
import com.taliyams.models.cli.Space;
import com.taliyams.models.password.DataPassword;
import com.taliyams.models.password.PasswordStore;
import java.util.ArrayList;

public class ListPasswordPage {

    private final HLine hline;
    private final Space space;
    private final Label label;

    public ListPasswordPage(String title, int width) {
        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
    }

    public void draw() {
        drawHeader();
        drawContent();
    }

    public void drawHeader() {
        hline.draw();
        space.draw();
        label.draw();
        space.draw();
        hline.draw();
    }

    public void drawContent() {
        displayPasswordList();
        drawFooter();
    }

    public void displayPasswordList() {
        ArrayList<PasswordStore> passwordList = DataPassword.passData;
        this.space.draw();
        this.label.text = "  Terdapat " + passwordList.size() + " password tersimpan";
        this.label.draw();
        this.label.text = "  -------------------------------------------------------------------------";
        this.label.draw();
      
        if (!passwordList.isEmpty()) {
            for (int i = 0; i < passwordList.size(); i++) {
                PasswordStore passwordData = passwordList.get(i);
                
                String colName = String.format("| %-20s", passwordData.name);
                String colUsername = String.format("| %-20s", passwordData.username);
                String colCategory = String.format("| %-20s |", passwordData.getCategory());
                
                this.label.text =  "  " +  colName + colUsername +  colCategory;
                this.label.draw();
            }
        } else {
            this.label.text =  "  Belum ada password yang tersimpan.";
            this.label.draw();
        }
    }

    public void drawFooter() {
        space.draw();
        hline.draw();
    }
}