
package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class Marco extends JFrame{
    
    public Marco(){
        
        
    Toolkit t1= getDefaultToolkit();
    
    
    Dimension d=t1.getScreenSize();
    
    int ancho=d.width;
    int alto=d.height;
    
   setSize((ancho/2),(alto/2));
  
   setLocation((ancho/4),(alto/4));     
    
   
   setTitle("Eventos de teclado");
   
   PanelAccion lamina= new PanelAccion();
   
   add(lamina);
   
   
    }}


class PanelAccion extends JPanel{

    
    public PanelAccion(){
    
        //Agregamos los botones
        
//        JButton btnRojo=new JButton("Rojo");
//    
//        JButton btnAmarillo=new JButton("Amarillo");
//    
//        JButton btnAzul=new JButton("Azul");
//    
//    
//        add(btnRojo);
//        add(btnAzul);
//        add(btnAmarillo);        
//        
//    
        
        //Ponemos la lamina a la escucha }
        
        AccionColor accionRojo=new AccionColor("Rojo",new ImageIcon("red.gif"),Color.red);
        AccionColor accionAzul=new AccionColor("Azul",new ImageIcon("azul.gif"),Color.blue);
        AccionColor accionAmarillo=new AccionColor("Amarillo",new ImageIcon("amarillo.gif"),Color.yellow);
        
        
        //vemos otra forma de hacer el botton 
        //Podemos crearlo con una accion
        //JButton btnAmarilo=new JButton(accionAmarillo);
        
        
        //Pero lo hacemos de la forma simplificada 
        add(new JButton(accionAmarillo));
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));
        
        
        //Creamos un objeto de la clase inputMap
        //El mismo proporciaona un vinculo entre un evento y un objeto 
        //En este caso lo vamos a usar para vincular la combinacion de teclas
        InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        
        //Creamos justamente el lector para la combinacion de teclas 
        
        KeyStroke teclaAmarilla=KeyStroke.getKeyStroke("ctrl A");
        KeyStroke teclaAzul=KeyStroke.getKeyStroke("ctrl B");
        KeyStroke teclaRoja=KeyStroke.getKeyStroke("ctrl R");
        
        
        //Asigno la combinacion de teclas a un objeto 
        mapaEntrada.put(teclaAmarilla,"fondo_amarillo");
        
        mapaEntrada.put(teclaAzul,"fondo_azul");
        
        mapaEntrada.put(teclaRoja,"fondo_rojo");
        //Forma reducida
        //mapaEntrada.put(KeyStoke.getKetStroke("ctrl A"),"fondo_amarillo")
        
        
        //Vemos de agregar una accion con un Actionmao
        
        ActionMap mapaAccion=getActionMap();
    
        mapaAccion.put("fondo_amarillo", accionAmarillo);
        mapaAccion.put("fondo_azul", accionAzul);
        mapaAccion.put("fondo_rojo", accionRojo);
        
        
        
    
    
        
        
        
    }
    

    
   private class AccionColor extends AbstractAction{

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    public AccionColor(String nombre, Icon icono, Color colorButton){
    
        //Tomamos constatente para almacenar todos los campos
        //Accion clave valor que vamos a insertar para cada entrada 
        putValue(Action.NAME, nombre);
        //SMALLICON para el icono
        
        putValue(Action.SMALL_ICON,icono);
        
        //Descripcion
        
        putValue(Action.SHORT_DESCRIPTION,"Poner la lamina del color:"+nombre);
        
        //Color
        
        putValue("color_fondo",colorButton);
        
        
        
        
    
            
    }
    
    
    //Tomamos lo que hace en la accion  este va a ser  nuestro oyente 
    @Override
    public void actionPerformed(ActionEvent e) {

        
        //Quiero que con ctrl b ponga azul 
        //Quiero que con ctrl a ponga amarillo 
        //Quiero que con ctrl r ponga rojo 
        
        //almacenamos nombre icono descripccion y accion 
        
        //El color de fondo es el atributo que debe concidir con el de put value 
        
        
        Color c=(Color) getValue("color_fondo");
        
        setBackground(c);
        
        JOptionPane.showMessageDialog(null,"Se ejecuta la accion:"+getValue(Action.NAME));
        
        
        
    }

    

}





}