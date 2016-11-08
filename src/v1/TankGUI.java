package v1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ryan on 11/8/16.
 */
public class TankGUI {
    private Tank tank;
    private ArrayList<TankComponent> components;
    private ArrayList<Fish> fish;

    //Panel variables
    private JPanel pnlHeader;       //North Panel
    private JPanel pnlTankAttributes;   //West PAnel
    private JPanel pnlTankContents;     //Center panel
    private JPanel pnlBuild;            //South panel
    private Container container;

    public TankGUI(Tank tank, ArrayList<TankComponent> components, ArrayList<Fish> fish) {
        this.tank = tank;
        this.components = components;
        this.fish = fish;
        makeFrame();
    }

    public void makeFrame(){
//--------------------------------TOP LEVEL SETTINGS--------------------------

        JFrame frame = new JFrame("Acme Aquariums");
        frame.setPreferredSize(new Dimension(1200, 600));
        frame.setMinimumSize(new Dimension(1200, 600));
        container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(Color.ORANGE);

//-------------------------------PANEL HEADER---------------------------------
        pnlHeader = new JPanel();
        pnlHeader.setLayout(new FlowLayout());
        JLabel lblTankWizard = new JLabel("Custom Tank Wizard");
        pnlHeader.add(lblTankWizard);
        JButton viewPreBuilt = new JButton("View Pre-Built");
        pnlHeader.add(viewPreBuilt);
        pnlHeader.setBackground(Color.BLUE);

//-----------------------------PANEL ATTRIBUTES-------------------------------
        pnlTankAttributes = new JPanel();
        pnlTankAttributes.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel tankSize = new JPanel();
        JPanel waterType = new JPanel();
        JPanel temp = new JPanel();

        JLabel tankSizeLabel = new JLabel("Tank Size");
        ButtonGroup tankSizeButtonGroup = new ButtonGroup();
        JRadioButton radioButtonSmall = new JRadioButton("Small");
        JRadioButton radioButtonMedium = new JRadioButton("Medium");
        JRadioButton radioButtonLarge = new JRadioButton("Large");
        JRadioButton radioButtonExtraLarge = new JRadioButton("Extra Large");
        tankSizeButtonGroup.add(radioButtonSmall);
        tankSizeButtonGroup.add(radioButtonMedium);
        tankSizeButtonGroup.add(radioButtonLarge);
        tankSizeButtonGroup.add(radioButtonExtraLarge);

        tankSize.add(tankSizeLabel);
        tankSize.add(radioButtonSmall);
        tankSize.add(radioButtonMedium);
        tankSize.add(radioButtonLarge);
        tankSize.add(radioButtonExtraLarge);


        JLabel waterTypeLabel = new JLabel("Wate Type");
        ButtonGroup waterTypeButtonGroup = new ButtonGroup();
        JRadioButton radioFreshwater = new JRadioButton("Freshwater");
        JRadioButton radioSaltwater = new JRadioButton("Saltwater");
        waterTypeButtonGroup.add(radioFreshwater);
        waterTypeButtonGroup.add(radioSaltwater);
        waterType.add(waterTypeLabel);
        waterType.add(radioFreshwater);
        waterType.add(radioSaltwater);

        JLabel tempLabel = new JLabel("Temperature");
        ButtonGroup tempButtonGroup = new ButtonGroup();
        JRadioButton radioSetMin = new JRadioButton("Set Min Temp");
        JRadioButton radioSetMax = new JRadioButton("Set Max Temp");
        JRadioButton radioCustom = new JRadioButton("Custom Temp");

        tempButtonGroup.add(radioSetMin);
        tempButtonGroup.add(radioSetMax);
        tempButtonGroup.add(radioCustom);

        temp.add(tempLabel);
        temp.add(radioSetMin);
        temp.add(radioSetMax);
        temp.add(radioCustom);





//        pnlTankAttributes.add(tankSize);
//        pnlTankAttributes.add(waterType);
//        pnlTankAttributes.add(temp);
//
//        container.add(pnlHeader, BorderLayout.NORTH);
//        container.add(pnlTankAttributes, BorderLayout.WEST);


        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
