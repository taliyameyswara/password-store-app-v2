/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taliyams.models;

import com.taliyams.models.cli.HLine;
import com.taliyams.models.cli.Label;
import com.taliyams.models.cli.SelectInput;
import com.taliyams.models.cli.Space;
import com.taliyams.models.password.DataPassword;

/**
 *
 * @author taliyameyswara
 */
public class MainPage {

    public String title;
    public int width;

    private final HLine hline;
    private final Space space;
    private final Label label;

    // Constructor
    public MainPage(String title, int width) {
        this.width = width;
        this.title = title;
        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
    }

    public void draw() {
        this.drawHeader();
        this.space.draw();
        this.drawContent();
    }

    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    private void drawContent() {
        String[] pages = {"Input Password", "Tampil Password", "Keluar Aplikasi"};
        SelectInput pageSelect = new SelectInput("Pilih halaman berikut:", pages, this.width);

        int select;

        this.label.text = "Selamat datang di aplikasi Password Vault";
        this.label.draw();
        this.label.text = "Simpan password anda dengan aman di sini";
        this.label.draw();
        this.space.draw();

        pageSelect.draw();

        select = pageSelect.getValue() - 1;
            switch (select) {
                case 0 -> {
                    drawFooter();
                    new InputPage("Inputan Password", this.width).draw();
                    new MainPage(this.title, this.width).draw();
                }
                case 1 -> {
                    drawFooter();
                    new ListPasswordPage("List Password Tersimpan", this.width).draw();
                    new MainPage(this.title, this.width).draw();
                }
                case 2 -> {
                    new Label("Terima kasih telah menggunakan aplikasi", this.width).draw();
                    DataPassword.saveCSVData();
                    drawFooter();
                    return;
                }
                default -> {
                    new MainPage(this.title, this.width).draw();
                }

            }
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }

}
