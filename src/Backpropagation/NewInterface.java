/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backpropagation;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public interface NewInterface {   
    public void Graficaerror(ArrayList Array);
    public void Graficarsalidasdeseadas(float [][]Matrizdedatos);
    public void Graficarsalidasdesimulacion(ArrayList _array);
    public void Rellenarlistadeerrores(ArrayList _array);
}
