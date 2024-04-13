/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taliyams.models;

import com.taliyams.models.cli.HLine;
import com.taliyams.models.cli.Input;
import com.taliyams.models.cli.Label;
import com.taliyams.models.cli.SelectInput;
import com.taliyams.models.cli.Space;
import com.taliyams.models.password.DataPassword;
import com.taliyams.models.password.PasswordStore;

/**
 *
 * @author taliyameyswara
 */
public class InputPage {

    private final HLine hline;
    private final Space space;
    private final Label label;
    private final int width;

    public InputPage(String title, int width) {
        this.width = width;
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

    public void drawFooter() {
        space.draw();
        hline.draw();
    }

    public void drawContent() {
        displayInputPage();
        drawFooter();
    }

    public void displayInputPage() {
        Input judulInput = new Input("Judul");
        judulInput.draw();
        String judul = judulInput.getValue();

        Input usernameInput = new Input("Username");
        usernameInput.draw();
        String username = usernameInput.getValue();

        Input passwordInput = new Input("Password");
        passwordInput.draw();
        String password = passwordInput.getValue();

        String[] kategori = {"Aplikasi Web", "Aplikasi Mobile", "Akun Lainnya"};
        SelectInput categoryInput = new SelectInput("Kategori", kategori, width);
        categoryInput.draw();
        int category = categoryInput.getValue();

        PasswordStore passwordData = new PasswordStore(judul, username, password, category);
        DataPassword.passData.add(passwordData);

        new Space(width).draw();
        new Label("Input password berhasil dibuat", width).draw();
    }   
}
