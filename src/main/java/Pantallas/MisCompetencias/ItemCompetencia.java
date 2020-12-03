package Pantallas.MisCompetencias;
import javax.swing.*;
import java.awt.*;

public class ItemCompetencia extends JButton {
    JLabel name = new JLabel();

    public ItemCompetencia (String text) {
        super(text);
        setBackground(Color.green);
        setPreferredSize(new Dimension(0,100));
        setText(text);
    };
};
