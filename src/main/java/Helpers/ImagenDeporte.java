package Helpers;

import Negocio.DeporteDTO;

import javax.swing.*;
import java.awt.*;

public class ImagenDeporte extends JPanel {
    String path;
    ImageIcon imagen;
    public ImagenDeporte(DeporteDTO deporteDTO){
        super();
        setLayout(new GridBagLayout());
        switch (deporteDTO.nombre){
            case "Futbol": path="src/main/java/Iconos/icono_futbol.jpg";
                break;
            case "Baloncesto": path="src/main/java/Iconos/icono_basquet.jpg";
                break;
            case "Voleibol": path="src/main/java/Iconos/icono_voley.jpg";
                break;
            case "Waterpolo": path="src/main/java/Iconos/icono_waterpolo.jpg";
                break;
            case "Polo": path="src/main/java/Iconos/icono_polo.jpg";
                break;
            case "Handball": path="src/main/java/Iconos/icono_handball.jpg";
                break;
            case "League of Legends": path="src/main/java/Iconos/icono_LOL.jpg";
                break;
        }
        imagen=(new ImageIcon(path));
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(imagen.getImage(),0,0,300,300,this);
        setOpaque(false);
        super.paint(g);
    }
    public static class ConstraintBoton extends GridBagConstraints{
        public ConstraintBoton(){
            super();
            weightx=1;weighty=1;
            anchor=GridBagConstraints.NORTHWEST;
            fill=GridBagConstraints.HORIZONTAL;
            gridy=0;gridx=0;
        }
    }
    public static class ConstraintSeparator1 extends GridBagConstraints{
        public ConstraintSeparator1(){
            super();
            weightx=10;weighty=1;
            anchor=GridBagConstraints.CENTER;
            fill=GridBagConstraints.BOTH;
            gridy=0;gridx=1;
        }
    }
    public static class ConstraintSeparator2 extends GridBagConstraints{
        public ConstraintSeparator2(){
            super();
            weightx=5;weighty=5;
            anchor=GridBagConstraints.NORTHWEST;
            fill=GridBagConstraints.BOTH;
            gridy=1;gridx=0;
        }
    }
}
