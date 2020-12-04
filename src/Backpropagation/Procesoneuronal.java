package Backpropagation;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Procesoneuronal implements Runnable {

    public Map<Integer, float[][]> Diccionariodepesos = new HashMap<>();
    public Map<Integer, float[]> Diccionariodeumbrales = new HashMap<>();
    public Map<Integer, float[][]> Diccionariodesalidasdecapa = new HashMap<>();
    public Map<Integer, float[]>diccionariodeerrornolinealdeneuronasporcapaoscultas = new HashMap<>();
    public float[] arraydeerrornolinealporneuronasdecapasocultas = null;
    public JTable Tabla;
    public String Regla;
    public String Funsalida;
    public float[] Mayent;
    public float[] Maysal;
    
    public ArrayList erroresdeiteracion = null;
    public ArrayList array = new ArrayList();
    public List<String> registros = new ArrayList<>();
    public List<String> listadesalidasdelared = new ArrayList<>();
    public int entradas = 0;
    public int salidas = 0;
    public int patrones = -1;
    public float[] umbrales;
    public int[] salidasdelared;
    public float[] erroreslineales;
    public float[] errordelospatrones;
    public float[][] pesos;
    public float[][] matrizdedatos;
    public float error = 1000;
    public float errormaximopermitido;
    public float ratadeaprendizaje;
    public int numerodeiteraciones;
    public int numerodecapasocultas;
    public float[][] salidadecapaactual;
    public float[][] salidadecapaanterior;
    public String[] funcionesdeactivaciones;
    NewInterface ni;
    public JButton Entrenar;
    public String nombredearchivos;

    public Procesoneuronal(NewInterface ni, JButton Entrenar) {
        this.ni = ni;
        this.Entrenar = Entrenar;
    }

    private void Entrenamiento() throws HeadlessException, IOException {
        funcionesdeactivaciones = new String[numerodecapasocultas + 1];        
        if(erroresdeiteracion == null){
            erroresdeiteracion = new ArrayList();
        }
        for (int iteraciones = 1; iteraciones <= numerodeiteraciones; iteraciones++) {
            errordelospatrones = new float[patrones];        
            for (int pt = 0; pt < patrones; pt++) {
                float[] arraydeerroresdeneuronasendiccionario = null;
                float[][] arraydesalidasdecapasocultasanterior = null;
                Diccionariodesalidasdecapa.clear();
                for (int cp = 0; cp <= numerodecapasocultas; cp++) {
                    pesos = Diccionariodepesos.get(cp);
                    umbrales = Diccionariodeumbrales.get(cp);
                    salidadecapaactual = new float[patrones][pesos.length];
                    if (cp > 0)
                        salidadecapaanterior = Diccionariodesalidasdecapa.get(cp-1);
                    for (int i = 0; i < pesos.length; i++)
                    {
                        salidadecapaactual[pt][i] = 0;
                        if (cp == 0) 
                        {
                            funcionesdeactivaciones[cp] = Tabla.getValueAt(cp, 2).toString();
                            for (int j = 0; j < entradas; j++)
                                salidadecapaactual[pt][i] += matrizdedatos[pt][j] * pesos[i][j];
                        }else if (cp > 0 && cp < numerodecapasocultas) 
                        {
                            funcionesdeactivaciones[cp] = Tabla.getValueAt(cp, 2).toString();
                            for (int j = 0; j < pesos[0].length; j++)
                                salidadecapaactual[pt][i] += salidadecapaanterior[pt][j] * pesos[i][j];
                        }else if (cp == numerodecapasocultas) 
                        {
                            funcionesdeactivaciones[cp] = Funsalida;
                            for (int j = 0; j < pesos[0].length; j++)
                                salidadecapaactual[pt][i] += salidadecapaanterior[pt][j] * pesos[i][j];
                        }
                        salidadecapaactual[pt][i] -= umbrales[i];
                        if (cp != numerodecapasocultas) {
                            //funcionesdeactivaciones[cp] = Tabla.getValueAt(cp, 2).toString();
                            salidadecapaactual[pt][i] = getFunciondeActivacion(Tabla.getValueAt(cp, 2).toString(), salidadecapaactual[pt][i]);
                        }else 
                            //funcionesdeactivaciones[cp] = Funsalida;
                            salidadecapaactual[pt][i] = getFunciondeActivacion(Funsalida, salidadecapaactual[pt][i]);                         
                    }
                    Diccionariodesalidasdecapa.put(cp, salidadecapaactual);
                }
                //Error lineal de las salidas de la red ....
                erroreslineales = new float[salidas];
                for (int i = 0; i < salidas; i++)
                {
                    erroreslineales[i] = matrizdedatos[pt][i + entradas] - salidadecapaactual[pt][i];
                }
                //COMIENZA AQUÍ LA RETROPROPAGACIÓN, DE CADA NEURONA DESDE LA ÚLTIMA CAPA OCULTA HASTA LA PRIMERA...
                //Error no lineal por neuronas de las capas ocultas....
                for (int capOculta = numerodecapasocultas - 1; capOculta >= 0; capOculta--) {
                //Última capa oculta con salida...
                    if (capOculta == numerodecapasocultas - 1) {
                        arraydeerrornolinealporneuronasdecapasocultas = new float[Integer.parseInt(Tabla.getValueAt(capOculta, 1).toString())];
                        pesos = Diccionariodepesos.get(capOculta + 1);
                        for (int neucapActual = 0; neucapActual < arraydeerrornolinealporneuronasdecapasocultas.length; neucapActual++) {
                            float sumerr = 0;
                            for (int sal = 0; sal < salidas; sal++) {
                                sumerr += (erroreslineales[sal] * pesos[sal][neucapActual]);
                            }
                            arraydeerrornolinealporneuronasdecapasocultas[neucapActual] = sumerr;
                        }
                        diccionariodeerrornolinealdeneuronasporcapaoscultas.put(capOculta, arraydeerrornolinealporneuronasdecapasocultas);
                    } else //Entre capas ocultas....
                    {
                        float[] Errorneuronasiguiente = diccionariodeerrornolinealdeneuronasporcapaoscultas.get(capOculta + 1);
                        arraydeerrornolinealporneuronasdecapasocultas = new float[Integer.parseInt(Tabla.getValueAt(capOculta, 1).toString())];
                        pesos = Diccionariodepesos.get(capOculta +1);
                        for (int neucapActual = 0; neucapActual < arraydeerrornolinealporneuronasdecapasocultas.length; neucapActual++) {
                            float sumerr = 0;
                            for (int neucapaSiguiente = 0; neucapaSiguiente < Errorneuronasiguiente.length; neucapaSiguiente++) {
                                sumerr += (Errorneuronasiguiente[neucapaSiguiente] * pesos[neucapaSiguiente][neucapActual]);
                            }
                            arraydeerrornolinealporneuronasdecapasocultas[neucapActual] = sumerr;
                        }
                        diccionariodeerrornolinealdeneuronasporcapaoscultas.put(capOculta, arraydeerrornolinealporneuronasdecapasocultas);
                    }
                }
                //TERMINA LA RETROPROPAGACIÓN Y SE MODIFICAR PESOS Y UMBRALES CON LOS ERRORES NO LINEALES POR
                //CADA NEURONA DE CADA CAPA OCULTA...
                //Modificacion de pesos y umbrales...
                for (int capOculta = 0; capOculta <= numerodecapasocultas; capOculta++)
                {
                    //Desde la capa entrada hasta la última capa oculta....
                    pesos = Diccionariodepesos.get(capOculta);
                    umbrales = Diccionariodeumbrales.get(capOculta);
                    if (capOculta < numerodecapasocultas)
                        arraydeerroresdeneuronasendiccionario = diccionariodeerrornolinealdeneuronasporcapaoscultas.get(capOculta);
                    salidadecapaactual = Diccionariodesalidasdecapa.get(capOculta);
                    for (int sal = 0; sal < pesos.length; sal++)
                    {            
                        if (capOculta < numerodecapasocultas)
                            umbrales[sal] += 2 * ratadeaprendizaje * getfunDerivada(Tabla.getValueAt(capOculta, 2).toString(), salidadecapaactual[pt][sal]) * arraydeerroresdeneuronasendiccionario[sal];     
                        else
                            umbrales[sal] += 2 * ratadeaprendizaje * erroreslineales[sal];
                        for (int ent = 0; ent < pesos[0].length; ent++)
                        {
                            if (capOculta == 0)
                            {
                                pesos[sal][ent] += 2 * ratadeaprendizaje * getfunDerivada(Tabla.getValueAt(capOculta, 2).toString(), salidadecapaactual[pt][sal]) * arraydeerroresdeneuronasendiccionario[sal] * matrizdedatos[pt][ent];
                            }
                            if (capOculta > 0 && capOculta < numerodecapasocultas)
                            {
                                arraydesalidasdecapasocultasanterior = Diccionariodesalidasdecapa.get(capOculta - 1);
                                pesos[sal][ent] += 2 * ratadeaprendizaje * getfunDerivada(Tabla.getValueAt(capOculta, 2).toString(), salidadecapaactual[pt][sal]) * arraydeerroresdeneuronasendiccionario[sal] * arraydesalidasdecapasocultasanterior[pt][ent];
                            }
                            if (capOculta == numerodecapasocultas)
                            {
                                arraydesalidasdecapasocultasanterior = Diccionariodesalidasdecapa.get(capOculta -1);
                                pesos[sal][ent] += 2 * ratadeaprendizaje * erroreslineales[sal] * arraydesalidasdecapasocultasanterior[pt][ent];
                            }
                        }
                    }
                    Diccionariodepesos.replace(capOculta, pesos);
                    Diccionariodeumbrales.replace(capOculta, umbrales);
                }
                //Calculando el error del patron.
                float totalerrorlineal = 0;
                for (int i = 0; i < salidas; i++)
                {
                    totalerrorlineal = totalerrorlineal + Math.abs(erroreslineales[i]);
                }
                errordelospatrones[pt] = totalerrorlineal / salidas;
                Simular();
            }
            //Error de la iteración.......
            double totalerrorpatron = 0;
            for (int i = 0; i < patrones; i++)
            {
                totalerrorpatron = totalerrorpatron + errordelospatrones[i];
            }
            float erms = (float) (totalerrorpatron / patrones);
            erroresdeiteracion.add(erms);
            //try {
                ni.Graficaerror(erroresdeiteracion);
                ni.Rellenarlistadeerrores(erroresdeiteracion);
            //}catch(Exception e) { }
            if (erms <= errormaximopermitido) {
                JOptionPane.showMessageDialog(null, "La red entrenó", "Notificación", JOptionPane.PLAIN_MESSAGE);    
                nombredearchivos = JOptionPane.showInputDialog("Nombre del archivo para \nguardar Pesos, Umbrales\ny configuración de la red: ");
                Guardarpesosyumbrales();
                break;
            }
            if(iteraciones == numerodeiteraciones){
                JOptionPane.showMessageDialog(null, "La red aun no ha entrenado, intente modificar su configuración", "Notificación", JOptionPane.PLAIN_MESSAGE);    
            }
        }
    }
    
    public void Simular(){
        ArrayList _array = new ArrayList();
        for (int pt = 0; pt < patrones; pt++) {
            Diccionariodesalidasdecapa.clear();
            for (int cp = 0; cp <= numerodecapasocultas; cp++) {
                pesos = Diccionariodepesos.get(cp);
                umbrales = Diccionariodeumbrales.get(cp);
                salidadecapaactual = new float[patrones][pesos.length];
                if (cp > 0)
                    salidadecapaanterior = Diccionariodesalidasdecapa.get(cp-1);
                for (int i = 0; i < pesos.length; i++)
                {
                    salidadecapaactual[pt][i] = 0;
                    if (cp == 0) 
                    {
                        for (int j = 0; j < entradas; j++)
                            salidadecapaactual[pt][i] += matrizdedatos[pt][j] * pesos[i][j];
                    }else if (cp > 0 && cp < numerodecapasocultas) 
                    {
                        for (int j = 0; j < pesos[0].length; j++)
                            salidadecapaactual[pt][i] += salidadecapaanterior[pt][j] * pesos[i][j];
                    }else if (cp == numerodecapasocultas) 
                    {
                        for (int j = 0; j < pesos[0].length; j++)
                            salidadecapaactual[pt][i] += salidadecapaanterior[pt][j] * pesos[i][j];
                    }
                    salidadecapaactual[pt][i] -= umbrales[i];
                    if (cp != numerodecapasocultas) 
                        salidadecapaactual[pt][i] = getFunciondeActivacion(Tabla.getValueAt(cp, 2).toString(), salidadecapaactual[pt][i]);
                    else 
                    {
                        salidadecapaactual[pt][i] = getFunciondeActivacion(Funsalida, salidadecapaactual[pt][i]);
                        _array.add(salidadecapaactual[pt][i]);
                    }
                }
                Diccionariodesalidasdecapa.put(cp, salidadecapaactual);
            }
        }
        ni.Graficarsalidasdesimulacion(_array);
    }
    
    public void Guardarpesosyumbrales() throws IOException{
        try 
            {                
                File directoriodepesos = new File("Carpeta de los pesos - " + nombredearchivos);
                File directoriodeumbrales = new File("Carpeta de los umbrales - " + nombredearchivos);
                File directoriodeconfiguracion = new File("Configuracion de la red - " + nombredearchivos);
                if (!directoriodepesos.exists()) {
                    if (directoriodepesos.mkdirs() && directoriodeumbrales.mkdirs() && directoriodeconfiguracion.mkdirs()) {
                        System.out.println("Directorios creados");
                    } else {
                        System.out.println("Error al crear directorios");
                    }
                } else {
                    for(File file: directoriodepesos.listFiles()) 
                        file.delete();
                    for(File file: directoriodeumbrales.listFiles()) 
                        file.delete();
                    for(File file: directoriodeconfiguracion.listFiles()) 
                        file.delete();
                }
                PrintWriter writer;
                for (int cp = 0; cp <= numerodecapasocultas; cp++) {
                    pesos = Diccionariodepesos.get(cp);
                    writer = new PrintWriter("Carpeta de los pesos - " + nombredearchivos + "/Pesos" + (cp+1) + ".txt");
                    for (int i = 0; i < pesos.length ; i++) {
                        for (int j = 0; j < pesos[i].length; j++) {
                            if (j + 1 < pesos[i].length)
                                writer.print(String.valueOf(pesos[i][j]) + " ");
                            else if (j + 1 == pesos[i].length && i + 1 == pesos.length)
                                writer.print(String.valueOf(pesos[i][j]));
                            else 
                                writer.println(String.valueOf(pesos[i][j]));
                        }
                    }
                    writer.close();
                    umbrales = Diccionariodeumbrales.get(cp);
                    writer = new PrintWriter("Carpeta de los umbrales - " + nombredearchivos + "/Umbrales" + (cp+1) + ".txt");
                    for (int i = 0; i < umbrales.length; i++) {
                        if (i + 1 == umbrales.length)
                            writer.print(String.valueOf(umbrales[i]));
                        else 
                            writer.println(String.valueOf(umbrales[i]));
                    }
                    writer.close();
                }
                writer = new PrintWriter("Configuracion de la red - " + nombredearchivos + "/Configuracion.txt");
                writer.println("CapasOcultas: " + numerodecapasocultas);
                writer.print("FuncionesDeActivaciones: ");
                for (int i = 0; i < funcionesdeactivaciones.length; i++) {
                    if((i + 1) < funcionesdeactivaciones.length){
                        writer.print(funcionesdeactivaciones[i] + " ");
                    } else if((i + 1) == funcionesdeactivaciones.length){
                        writer.println(funcionesdeactivaciones[i]);
                    }
                }
                writer.println("Entradas: " + entradas);
                writer.println("Salidas: " + salidas);
                writer.close();
                JOptionPane.showMessageDialog(null, "Se han guardado los pesos, umbrales y configuración de la red", "Notificación", JOptionPane.PLAIN_MESSAGE);    
            }
            catch (Exception e) { JOptionPane.showMessageDialog(null, "Ocurrió un error."); }
    }

    @Override
    public void run() {
        try {
            Entrenamiento();
        } catch (HeadlessException | IOException ex) {
            Logger.getLogger(Procesoneuronal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public float getFunciondeActivacion(String funcion, float salidaCapa) {
        float res = 0;
        switch (funcion) {
            case "lineal":
                res = salidaCapa;
                break;
            case "bipolar":
                if (salidaCapa >= 0) 
                    res = 1;
                else
                    res = -1;
                break;
            case "sigmoide":
                res = (float) (1 / (1 + Math.pow(Math.E, -salidaCapa)));
                break;
            case "tangenteh":
                res = (float) Math.tanh(salidaCapa);
                break;
            case "seno":
                res = (float) Math.sin(salidaCapa);
                break;
            case "coseno":
                res = (float) Math.cos(salidaCapa);
                break;
            case "gauseana":
                res = (float) Math.pow(Math.E, -Math.pow(salidaCapa, 2));
                break;
        }
        return res;
    }
    
    public float getfunDerivada(String funcion, float salidaCapa)
    {
        float res = 0;
        switch (funcion)
        {
            case "sigmoide":
                res = (float) (Math.pow(Math.E, salidaCapa) / Math.pow((Math.pow(Math.E, salidaCapa) + 1), 2));
                break;
            case "tangenteh":
                res = (float) (1 / Math.pow(Math.cosh(salidaCapa), 2));
                break;
            case "seno":
                res = (float) Math.cos(salidaCapa);
                break;
            case "coseno":
                res = (float) -Math.sin(salidaCapa);
                break;
            case "gauseana":
                res = (float) ((-2) * Math.pow(Math.E, -Math.pow(salidaCapa, 2)) * salidaCapa);
                break;
        }
        return res;
    }
}
