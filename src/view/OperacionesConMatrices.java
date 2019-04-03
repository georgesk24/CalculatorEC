package view;

import controller.ControllerSumarMatrices;
import javax.swing.JOptionPane;
import model.Fraccion;

public class OperacionesConMatrices {
    

    
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        vistaPrincipal v = new vistaPrincipal();
        v.setVisible(true);
        
    }
    
}
