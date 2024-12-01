/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class VerificarCedula {

    private String cedIngresada;

    private String tmp[];
    private int ultiNum = 0, mul = 0, suma = 0, decimaSup = 0, numVerificador = 0, cont = 0, ind = 0;
    private boolean fin;

    private int cedula[], bin[] = {2, 1, 2, 1, 2, 1, 2, 1, 2}, prod[];

    public VerificarCedula(String cedIngresada) {
        this.tmp = cedIngresada.split("");
        cedula = new int[tmp.length];

        for (String v : tmp) {
            cedula[cont] = Integer.parseInt(v);
            cont++;
        }
    }

    public boolean comprobarCedula() {
        if (cedula.length == 10) {
            ultiNum = cedula[cedula.length - 1];
            prod = new int[cedula.length - 1];

            for (int i = 0; i < cedula.length - 1; i++) {

                mul = cedula[i] * bin[i];
                if (mul > 9) {
                    mul = mul - 9;
                }

                prod[i] = mul;
            }

            for (int i : prod) {
                suma += i;
            }

            decimaSup = (((suma / 10) + 1) * 10);

            numVerificador = decimaSup - suma;

            if (numVerificador == ultiNum) {
                fin = true;
            } else {

                fin = false;
            }
        } else {

            fin = false;
        }

        return fin;

    }

    public boolean comprobarExistencia(String archivo, String cedulaBuscar) {

        fin = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea="";

            while ((linea = reader.readLine()) != null) {

               
                if (!linea.equals("")) {
                     tmp = linea.split(", ");
                    if (tmp[1].equalsIgnoreCase(cedulaBuscar)) {
                        fin = true;

                    }
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VerificarCedula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerificarCedula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fin;

    }

}
