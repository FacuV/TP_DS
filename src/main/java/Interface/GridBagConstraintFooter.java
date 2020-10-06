package Interface;

import java.awt.*;

public class GridBagConstraintFooter extends GridBagConstraints {
    public GridBagConstraintFooter(){
        weightx = 1;
        gridy = 1;
        fill = GridBagConstraints.BOTH;
        insets = new Insets(5,5,5,5);
    }
}
