/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import config.log.Log;
import config.log.LogInsert;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Maquinas;
import service.LogService;
import service.MaquinasService;
import service.RebootService;

/**
 *
 * @author sofia
 */
public class Reboot {

    public static void main(String[] args) {
        
        Maquinas maquina = MaquinasService.getMaquinaAzure();
        Log logInsert = new LogInsert("", maquina.getNomeMaquina(), "");

        
        logInsert.criarLog();
        LogService.criarAlerta(maquina);

        try {
            RebootService.rebootar(maquina.getIdMaquina());
        } catch (InterruptedException ex) {
            Logger.getLogger(Reboot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
