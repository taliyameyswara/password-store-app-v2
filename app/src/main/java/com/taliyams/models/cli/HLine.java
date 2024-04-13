/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taliyams.models.cli;

/**
 *
 * @author taliyameyswara
 */
public class HLine {
    private int width;
    
//  Konstruktor dengan parameter width untuk mengeset atribut width. 
    public HLine(int width){
        this.width = width;
    }
    
//  Method draw untuk menampilkan String garis
    public void draw(){
        System.out.print("+");
        for(int i = 0; i<width; i++){
            System.out.print("=");    
        }
        System.out.println("+");
    }
}
