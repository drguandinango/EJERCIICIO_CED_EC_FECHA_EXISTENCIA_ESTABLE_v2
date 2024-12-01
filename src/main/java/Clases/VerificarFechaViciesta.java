/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author User
 */
public class VerificarFechaViciesta {
    private String fechaIngresada;
    private  String fecha[];
    private  int anio;
    
    private  boolean  fin=true;

    public  boolean anioViciesto(String fechaIngresada) {
        
        this.fechaIngresada = fechaIngresada;
        
         fecha=fechaIngresada.split("/");
         anio=Integer.parseInt(fecha[2]);
          if ((anio%4==0)&&((anio%100!=0)||(anio%400==0))) {
               fin=true;
        }else{
          
             fin=false;
          }
          return  fin;
          
          
    }
    
    
    
    
    
}
