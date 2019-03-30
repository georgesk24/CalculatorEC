
package controller;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.PanelDeterminante;
import view.PanelGaussJordan;
import view.PanelMultiplicarMatrices;
import view.PanelRestarMatrices;
import view.PanelSumarMatrices;
import view.vistaPrincipal;

/**
 *
 * @author SOFTWARE GALAXIA TV
 * Clase controlador de la vista principal (vistaPrincipal.java)
 */
public class ControllerVistaPrincipal implements ActionListener{
    
    //LLamamos las respectivas vistas incluida la vista principal
    
    vistaPrincipal view;
    PanelSumarMatrices panelSumarMatrices;
    PanelRestarMatrices panelRestarMatrices;
    PanelMultiplicarMatrices panelMultiplicarMatrices;
    PanelDeterminante panelDeterminante;
    PanelGaussJordan panelGaussJordan;
    
    /*Creamos un metodo para asignar eventos a los respectivos botones del menu principal*/
    public final void events(){
        view.btnInicio.addActionListener(this);
        view.btnSumar.addActionListener(this);
        view.btnRestar.addActionListener(this);
        view.btnMultiplicar.addActionListener(this);
        view.btnDeterminante.addActionListener(this);
        view.btnGaussJordan.addActionListener(this);
        view.btnSalir.addActionListener(this);
    }
    
    /*metodo constructor de la clase */
    public ControllerVistaPrincipal(vistaPrincipal view){
        this.view=view;
        events();
        
        /*inicializamos los respectivos objetos pertenecientes a la clase JPanel*/
        panelSumarMatrices = new PanelSumarMatrices();
        panelRestarMatrices = new PanelRestarMatrices();
        panelMultiplicarMatrices = new PanelMultiplicarMatrices();
        panelDeterminante = new PanelDeterminante();
        panelGaussJordan = new PanelGaussJordan();
    }

    /*Agregamos un nuevo panel a nuestro JPanel padre (PanelOperaciones)*/
    public void addPanel(JPanel panel){
        
        GridBagConstraints  gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        view.panelOperaciones.add(panel, gridBagConstraints);
                
    }
    
    /*Metodo en el cual controlamos el panel que estara visible dependiendo la opción que seleccionemos
    en nuestro menu principal*/
    public void visualizarPanel(String nombrePanel){
        
        /*trabamos con la estructura de control switch*/
        switch (nombrePanel){
            
            case "Inicio":
                view.panelInicio.setVisible(true);
                panelSumarMatrices.setVisible(false);
                panelRestarMatrices.setVisible(false);
                panelMultiplicarMatrices.setVisible(false);
                panelDeterminante.setVisible(false);
                panelGaussJordan.setVisible(false);
            break;
            
            case "SumarMatriz":
                panelSumarMatrices.setVisible(true);                
                view.panelInicio.setVisible(false);
                panelRestarMatrices.setVisible(false);
                panelMultiplicarMatrices.setVisible(false);
                panelDeterminante.setVisible(false);
                panelGaussJordan.setVisible(false);
            break;
            
            case "RestarMatriz":
                panelRestarMatrices.setVisible(true);                
                view.panelInicio.setVisible(false);
                panelSumarMatrices.setVisible(false);
                panelMultiplicarMatrices.setVisible(false);
                panelDeterminante.setVisible(false);
                panelGaussJordan.setVisible(false);
            break;
            
            case "MultiplicarMatriz":
                panelMultiplicarMatrices.setVisible(true);                
                view.panelInicio.setVisible(false);
                panelSumarMatrices.setVisible(false);
                panelRestarMatrices.setVisible(false);
                panelDeterminante.setVisible(false);
                panelGaussJordan.setVisible(false);
            break;
            
            case "DeterminanteMatriz":
                panelDeterminante.setVisible(true);                
                view.panelInicio.setVisible(false);
                panelSumarMatrices.setVisible(false);
                panelRestarMatrices.setVisible(false);
                panelMultiplicarMatrices.setVisible(false);
                panelGaussJordan.setVisible(false);
            break;
            
            case "GaussJordan":
                panelGaussJordan.setVisible(true);                
                view.panelInicio.setVisible(false);
                panelSumarMatrices.setVisible(false);
                panelRestarMatrices.setVisible(false);
                panelMultiplicarMatrices.setVisible(false);
                panelDeterminante.setVisible(false);
            break;
            
            default:
                JOptionPane.showMessageDialog(null, "Opcion Invalida", "Error", JOptionPane.ERROR_MESSAGE);
                view.panelInicio.setVisible(true);
                panelSumarMatrices.setVisible(false);
                panelRestarMatrices.setVisible(false);
                panelMultiplicarMatrices.setVisible(false);
                panelDeterminante.setVisible(false);
                panelGaussJordan.setVisible(true);
            break;
        }
    
    }
    
    /*Metodo abstracto para controlar los eventos que se ejecuten en la vista principal*/
    @Override
    public void actionPerformed(ActionEvent e) {

        Object evt = e.getSource();
        
        /*Condicionales pertenecientes a los botonees del menu principal
        dependiendo el boton seleccionado se ejecutaran las lineas de codigo dentro
        de los respectivos condicionales*/
        
        if(evt.equals(view.btnInicio)){
            
            //llamamos al metodo addPanel y lo agregamos al JPanel padre de nuestra vista
            addPanel(view.panelInicio);
            visualizarPanel("Inicio");
            
            //agregamos una barra de desplzamiento a el nuevo JPanel 
            view.barraDesplazamientoPanelOperaciones.setViewportView(view.panelInicio);
            view.panelOperaciones.validate();
            
        }else if(evt.equals(view.btnSumar)){
            
            addPanel(panelSumarMatrices);
            visualizarPanel("SumarMatriz");
            view.barraDesplazamientoPanelOperaciones.setViewportView(panelSumarMatrices);
            view.panelOperaciones.validate();
        
        }else if(evt.equals(view.btnRestar)){
            
            addPanel(panelRestarMatrices);
            visualizarPanel("RestarMatriz");
            view.barraDesplazamientoPanelOperaciones.setViewportView(panelRestarMatrices);
            view.panelOperaciones.validate();
        
        }else if(evt.equals(view.btnMultiplicar)){
            
            addPanel(panelMultiplicarMatrices);
            visualizarPanel("MultiplicarMatriz");
            view.barraDesplazamientoPanelOperaciones.setViewportView(panelMultiplicarMatrices);
            view.panelOperaciones.validate();
        
        }else if(evt.equals(view.btnDeterminante)){
            
            addPanel(panelDeterminante);
            visualizarPanel("DeterminanteMatriz");
            view.barraDesplazamientoPanelOperaciones.setViewportView(panelDeterminante);
            view.panelOperaciones.validate();
            
        }else if(evt.equals(view.btnGaussJordan)){
            
            addPanel(panelGaussJordan);
            visualizarPanel("GaussJordan");
            view.barraDesplazamientoPanelOperaciones.setViewportView(panelGaussJordan);
            view.panelOperaciones.validate();
            
        }else if(evt.equals(view.btnSalir)){
            
            /*confirmamos si deseamos salir de la aplicación haciendo uso del metodo 
            showConfirmDialog de la clase JOptionPane*/
            
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            if(confirmar==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        
        
        
    }
    
    
}
