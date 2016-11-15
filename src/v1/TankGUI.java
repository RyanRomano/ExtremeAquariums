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
    private JPanel pnlTankContents;     //Center panel
    private JPanel pnlBuild;            //South panel
    private JPanel pnlWest;
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
        container.add(pnlHeader, BorderLayout.NORTH);


        pnlWest = new JPanel();
        pnlWest.setLayout(new FlowLayout());
        pnlWest.setBackground(Color.RED);
        pnlWest.setPreferredSize(new Dimension(200,300));
        container.add(pnlWest, BorderLayout.WEST);

        pnlTankContents = new JPanel();
        pnlTankContents.setLayout(new FlowLayout());
        pnlTankContents.setBackground(Color.pink);
        JPanel panel1 = new JPanel();				//Panel for available items to add
        panel1.setPreferredSize(new Dimension(300, 475));
        panel1.setBackground(Color.GREEN);

        JPanel panelAddButtons = new JPanel();		//Panel for add/remove buttons
        //panelAddButtons.setLayout(new BoxLayout(panelAddButtons, BoxLayout.Y_AXIS));
        panelAddButtons.setLayout(new FlowLayout());
        panelAddButtons.setPreferredSize(new Dimension(200, 70));
        panelAddButtons.setBackground(Color.CYAN);

        JPanel panel2 = new JPanel();				//Panel for added items
        panel2.setPreferredSize(new Dimension(300,475));
        panel2.setBackground(Color.YELLOW);


        pnlTankContents.add(panel1);
        pnlTankContents.add(panelAddButtons);
        pnlTankContents.add(panel2);
        container.add(pnlTankContents, BorderLayout.CENTER);

        pnlBuild = new JPanel();
        pnlBuild.setLayout(new FlowLayout());
        pnlBuild.setBackground(Color.MAGENTA);
        container.add(pnlBuild, BorderLayout.SOUTH);



//-----------------------------PANEL ATTRIBUTES-------------------------------

        //----------------------------West Panel-----------------------------------
        JPanel pnlTankAttributes = new JPanel();
        pnlTankAttributes.setLayout(new BoxLayout(pnlTankAttributes, BoxLayout.Y_AXIS));
        //pnlTankAttributes.setLayout(new FlowLayout());

        JPanel tankSize = new JPanel();
        tankSize.setLayout(new BoxLayout(tankSize, BoxLayout.Y_AXIS));
        JPanel waterType = new JPanel();
        waterType.setLayout(new BoxLayout(waterType, BoxLayout.Y_AXIS));
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));

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


        JLabel waterTypeLabel = new JLabel("Water Type");
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

        pnlTankAttributes.add(tankSizeLabel);
        pnlTankAttributes.add(tankSize);
        pnlTankAttributes.add(Box.createVerticalStrut(50));
        pnlTankAttributes.add(waterType);
        pnlTankAttributes.add(Box.createVerticalStrut(50));
        pnlTankAttributes.add(temp);

        pnlWest.add(pnlTankAttributes);


        //----------------------------------Center Panel-----------------------------
        JButton btnAdd = new JButton("Add >>");
        JButton btnRemove = new JButton("<< Remove");
        panelAddButtons.add(Box.createVerticalStrut(10));
        panelAddButtons.add(btnAdd);
        panelAddButtons.add(Box.createVerticalStrut(20));
        panelAddButtons.add(btnRemove);

        JLabel lblAddToTank = new JLabel("Add To Tank");
        panel1.add(lblAddToTank);
        JPanel pnlFishToAdd = new JPanel();
        pnlFishToAdd.setLayout(new BoxLayout(pnlFishToAdd, BoxLayout.Y_AXIS));
        pnlFishToAdd.setPreferredSize(new Dimension(290, 215));
        panel1.add(pnlFishToAdd);
        JLabel lblFishToAdd = new JLabel("Fish Available");
        JPanel pnlFishToAddTitle = new JPanel();
        pnlFishToAddTitle.setLayout(new FlowLayout());
        pnlFishToAddTitle.add(lblFishToAdd);
        pnlFishToAdd.add(pnlFishToAddTitle);

        //List of available fish
        JPanel pnlFishList = new JPanel();
        pnlFishList.setPreferredSize(new Dimension(280, 200));
        pnlFishList.setLayout(new FlowLayout());
        ArrayList<String> fishList = new ArrayList<String>();
        for(int i = 0; i < fish.size(); i++){
            fishList.add(fish.get(i).getFishName());
        }
        String[] fishArray = new String[fishList.size()];
        fishArray = fishList.toArray(fishArray);

        JList listFishToAdd = new JList(fishArray);
        listFishToAdd.setLayoutOrientation(JList.VERTICAL);
        listFishToAdd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane fishScroll = new JScrollPane(listFishToAdd);
        fishScroll.setMinimumSize(new Dimension(280, 150));
        fishScroll.setPreferredSize(new Dimension(280, 150));

        pnlFishList.add(fishScroll);
        pnlFishToAdd.add(pnlFishList);

        JPanel pnlCompToAdd = new JPanel();
        pnlCompToAdd.setLayout(new FlowLayout());
        pnlCompToAdd.setPreferredSize(new Dimension(290, 215));
        panel1.add(pnlCompToAdd);
        JLabel lblCompToAdd = new JLabel("Tank Components Available");
        JPanel pnlCompToAddTitle = new JPanel();
        pnlCompToAddTitle.setLayout(new FlowLayout());
        pnlCompToAddTitle.add(lblCompToAdd);
        pnlCompToAdd.add(pnlCompToAddTitle);

        //List of available compnents
        JPanel pnlCompList = new JPanel();
        pnlCompList.setPreferredSize(new Dimension(280, 200));
        pnlCompList.setLayout(new FlowLayout());
        ArrayList<String> compList = new ArrayList<String>();
        for(int i = 0; i < components.size(); i++){
            compList.add(components.get(i).getComponentName());
        }
        String[] compArray = new String[compList.size()];
        compArray = compList.toArray(compArray);

        JList listCompToAdd = new JList(compArray);
        listCompToAdd.setLayoutOrientation(JList.VERTICAL);
        listCompToAdd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane compScroll = new JScrollPane(listCompToAdd);
        compScroll.setMinimumSize(new Dimension(280, 150));
        compScroll.setPreferredSize(new Dimension(280, 150));

        pnlCompList.add(compScroll);
        pnlCompToAdd.add(pnlCompList);


        JPanel pnlYourTank = new JPanel();
        pnlYourTank.setLayout(new FlowLayout());
        pnlYourTank.setPreferredSize(new Dimension(290, 456));
        panel2.add(pnlYourTank);
        JLabel lblYourTank = new JLabel("Your Tank Contents");
        pnlYourTank.add(lblYourTank);

        //----------------------------------------South Panel-------------------------------------------
        JButton btnReset = new JButton("Reset");
        pnlBuild.add(btnReset);
        JButton btnBuild = new JButton("Build");
        pnlBuild.add(btnBuild);



        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}