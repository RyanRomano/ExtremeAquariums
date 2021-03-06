package v2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
/**
 * The TankGUI class runs the ACME Extreme Aquarium Builder program so that anyone
 * can either customize their own fish tank or use a default or pre-built tank.
 *
 * There are many options for custom tanks, 4 different sizes from small to extra large,
 * salt water or fresh water, live plants, decorations, air pumps, filters, and a variety
 * of many different kinds of salt water and fresh water fish.
 *
 */
public class TankGUI {
    private JFrame frame;
    private Tank tank;
    private ArrayList<TankComponent> components;
    private ArrayList<Fish> fish;
    private Fish currentFish;
    private TankComponent currentComp;
    private DefaultListModel model;

    /**
     * The 4 main panels that make up the tank GUI.
     */

    /** North Panel */
    private JPanel pnlHeader;
    /** Center Panel */
    private JPanel pnlTankContents;
    /** South Panel */
    private JPanel pnlBuild;
    /** West Panel */
    private JPanel pnlWest;
    /** Container of the GUI, which will have all the panels above inside of it */
    private Container container;

    private JButton btnViewPreBuilt;
    private JList listFishToAdd;
    private JList listCompToAdd;
    private JButton btnAddFish;
    private JButton btnAddComp;
    private JButton btnRemove;
    private JPanel pnlYourTank;
    private ArrayList<String> tankList = new ArrayList<String>();
    private JList listTankContents;
    private JLabel lblFishStats;
    private JLabel lblCompStats;
    private int selectedTankIndex;
    private JButton btnReset;
    private JButton btnBuild;

    /**
     * Labels for tank size, water type, and chemical levels.
     */
    JLabel lblMaxVolume;
    JLabel lblVolume;
    JLabel lblWaterType;
    JLabel lblCo2;
    JLabel lblO2;
    JLabel lblNh4;
    JLabel lblPh;
    JLabel lblHardness;

    /**
     * Color variables for the GUI.
     */
    Color clrBg = new Color(236, 236, 236);
    Color clrSecondary = new Color(108, 122, 137);
    Color clrTextLight = Color.WHITE;
    Color clrDark = new Color(34, 49, 63);

    /**
     * 4 Radio buttons for selecting the desired tank size.
     * (Small, Medium, Large, Extra Large)
     */
    JRadioButton radioButtonSmall = new JRadioButton("Small");
    JRadioButton radioButtonMedium = new JRadioButton("Medium");
    JRadioButton radioButtonLarge = new JRadioButton("Large");
    JRadioButton radioButtonExtraLarge = new JRadioButton("Extra Large");

    /**
     * 2 Radio buttons for selecting the tanks water type.
     * (Fresh water or Salt water)
     */
    JRadioButton radioFreshwater = new JRadioButton("Freshwater");
    JRadioButton radioSaltwater = new JRadioButton("Saltwater");

    /**
     * 3-argument constructor for the Tank GUI class.
     * This constructor takes in a tank and 2 array list
     * along with the make frame and add listeners methods.
     *
     * @param tank
     * @param components
     * @param fish
     */
    public TankGUI(Tank tank, ArrayList<TankComponent> components, ArrayList<Fish> fish) {
        this.tank = tank;
        this.components = components;
        this.fish = fish;
        makeFrame();
        addListeners();
    }

    /**
     * Method for creating the frame.
     * In this method the tank GUI is created along with all of its parts.
     * This is where all panels are made and then populated with labels, buttons, text boxes, and more.
     */
    public void makeFrame(){
//--------------------------------TOP LEVEL SETTINGS--------------------------
        /**
             * The main frame of the GUI is created and its size is set.
         * The container of the GUI gets the content pane of the frame
         * and its layout and color are both set.
         * A border layout is used for the - 5 regions north, south, east, west, & center.
         */
        this.frame = new JFrame("Acme Aquariums");
        frame.setPreferredSize(new Dimension(1200, 700));
        frame.setMinimumSize(new Dimension(1200, 700));
        container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(clrBg);

//--------------------------------------------------------------------------------------
//-------------------------------TOP PANEL----------------------------------------------
//--------------------------------------------------------------------------------------
        /**
         * This is the Top or North Panel of the tank GUI.
         * This panel is located at the top of the GUI and it contains the name of the GUI
         * and the button for creating the pre-built or default tank option.
         */
        pnlHeader = new JPanel();
        pnlHeader.setLayout(new FlowLayout());
        JLabel lblTankWizard = new JLabel("Acme Aquarium's Create Your Own Tank Wizard - ");
        this.setLightText(lblTankWizard);
        pnlHeader.add(lblTankWizard);
        this.btnViewPreBuilt = new JButton("View Pre-Built");
        //Set button look
        this.setButtonLook(btnViewPreBuilt);

        /**
         * The button is then added to the panel and its color is set.
         * The header panel is then added to the north of the container
         */
        pnlHeader.add(btnViewPreBuilt);
        pnlHeader.setBackground(clrSecondary);
        container.add(pnlHeader, BorderLayout.NORTH);
//--------------------------------------------------------------------------------------
//--------------------------------WEST PANEL--------------------------------------------
//--------------------------------------------------------------------------------------

        /**
         * This is the West Panel of the tank GUI located on the left hand side.
         * This panel contains the 2 radio button groups for selecting tank size and water type.
         * A flow layout is used for this panel.
         */

        /** The west panel is created and its layout, size, and color are set,
         * then it is added to the container
         */
        pnlWest = new JPanel();
        pnlWest.setLayout(new FlowLayout());

        //Border
        pnlWest.setBackground(clrBg);
        pnlWest.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, clrSecondary));

        pnlWest.setPreferredSize(new Dimension(200,300));
        container.add(pnlWest, BorderLayout.WEST);

        /**
         * Sub panel tank attributes is created within the west panel.
         * this will contain 2 more sub panels
         */
        JPanel pnlTankAttributes = new JPanel();
        pnlTankAttributes.setLayout(new BoxLayout(pnlTankAttributes, BoxLayout.Y_AXIS));

        /** sub panel tank size is created within the tank attributes panel. */
        JPanel tankSize = new JPanel();
        tankSize.setLayout(new BoxLayout(tankSize, BoxLayout.Y_AXIS));

        /** sub panel water type is created within the tank attributes panel. */
        JPanel waterType = new JPanel();
        waterType.setLayout(new BoxLayout(waterType, BoxLayout.Y_AXIS));

//---------------------------------TANK SIZE OPTIONS------------------------------------
        /**
         * Tank Size Options
         * A new label is created, the text color is set and
         * a new button group is created and populated.
         *
         * Everything is then added to the tank size sub panel and
         * medium is the default tank size selected when the GUI is opened.
         */
        JLabel tankSizeLabel = new JLabel("Tank Size");
        this.setDarkText(tankSizeLabel);
        ButtonGroup tankSizeButtonGroup = new ButtonGroup();

        tankSizeButtonGroup.add(radioButtonSmall);
        tankSizeButtonGroup.add(radioButtonMedium);
        tankSizeButtonGroup.add(radioButtonLarge);
        tankSizeButtonGroup.add(radioButtonExtraLarge);
        tankSize.add(tankSizeLabel);
        tankSize.add(radioButtonSmall);
        tankSize.add(radioButtonMedium);
        tankSize.add(radioButtonLarge);
        tankSize.add(radioButtonExtraLarge);
        radioButtonMedium.setSelected(true);

//--------------------------------WATER TYPE OPTIONS------------------------------------
        /**
         * Water Type Options
         * A new label is created, the text color is set and
         * a new button group is created and populated.
         *
         * Everything is then added to the water type sub panel and
         * freash water is the default water type selected when the GUI is opened.
         */
        JLabel waterTypeLabel = new JLabel("Water Type");
        this.setDarkText(waterTypeLabel);
        ButtonGroup waterTypeButtonGroup = new ButtonGroup();

        waterTypeButtonGroup.add(radioFreshwater);
        waterTypeButtonGroup.add(radioSaltwater);
        waterType.add(waterTypeLabel);
        waterType.add(radioFreshwater);
        waterType.add(radioSaltwater);
        radioFreshwater.setSelected(true);
//---------------------------------ADD TO WEST PANEL------------------------------------
        /** Sub panels for tank size and water type are added to the tank attributes panel */
        pnlTankAttributes.add(tankSize);
        pnlTankAttributes.add(Box.createVerticalStrut(50));
        pnlTankAttributes.add(waterType);
        pnlTankAttributes.add(Box.createVerticalStrut(50));

        /** Sub panel for tank attributes is added to the west panel */
        pnlWest.add(pnlTankAttributes);

//--------------------------------------------------------------------------------------
//---------------------------------CENTER PANEL TOP LEVEL OPTIONS-----------------------
//--------------------------------------------------------------------------------------

        /**
         * This is the Center Panel of the tank GUI.
         * This panel is located in the center of the GUI and
         * it contains all of the tank contents.
         */

        /** This panels options are set, including color, size, layout, etc,
         *  then the panel is added to the container.
         */
        pnlTankContents = new JPanel();
        pnlTankContents.setLayout(new FlowLayout());
        pnlTankContents.setBackground(clrBg);
        JPanel panel1 = new JPanel();				//Panel for available items to add
        panel1.setPreferredSize(new Dimension(300, 550));
        panel1.setBackground(clrSecondary);

        JPanel panelAddSpacing = new JPanel();		//Panel for spacing
        panelAddSpacing.setLayout(new FlowLayout());
        panelAddSpacing.setPreferredSize(new Dimension(150, 60));
        panelAddSpacing.setBackground(clrBg);

        JPanel panel2 = new JPanel();				//Panel for added items
        panel2.setPreferredSize(new Dimension(300,550));
        panel2.setBackground(clrSecondary);


        pnlTankContents.add(panel1);
        pnlTankContents.add(panelAddSpacing);
        pnlTankContents.add(panel2);
        container.add(pnlTankContents, BorderLayout.CENTER);

        pnlBuild = new JPanel();
        pnlBuild.setLayout(new FlowLayout());
        pnlBuild.setBackground(clrSecondary);
        container.add(pnlBuild, BorderLayout.SOUTH);

//--------------------------------------------------------------------------------------
//--------------------------------ADD TO TANK PANEL-------------------------------------
//--------------------------------------------------------------------------------------

        JLabel lblAddToTank = new JLabel("Add To Tank");
        this.setLightText(lblAddToTank);
        panel1.add(lblAddToTank);
//----------------------------------FISH AVAILABLE PANEL--------------------------------
        JPanel pnlFishToAdd = new JPanel();
        pnlFishToAdd.setLayout(new BoxLayout(pnlFishToAdd, BoxLayout.Y_AXIS));
        pnlFishToAdd.setPreferredSize(new Dimension(290, 252));
        panel1.add(pnlFishToAdd);
        JLabel lblFishToAdd = new JLabel("Fish Available");
        JPanel pnlFishToAddTitle = new JPanel();
        pnlFishToAddTitle.setLayout(new FlowLayout());
        pnlFishToAddTitle.add(lblFishToAdd);
        pnlFishToAdd.add(pnlFishToAddTitle);

        //List of available fish
        JPanel pnlFishList = new JPanel();
        pnlFishList.setPreferredSize(new Dimension(280, 140));
        pnlFishList.setLayout(new FlowLayout());
        ArrayList<String> fishList = new ArrayList<String>();
        for(int i = 0; i < fish.size(); i++){
            fishList.add(fish.get(i).getFishName());
        }
        String[] fishArray = new String[fishList.size()];
        fishArray = fishList.toArray(fishArray);

        this.listFishToAdd = new JList(fishArray);
        listFishToAdd.setLayoutOrientation(JList.VERTICAL);
        listFishToAdd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane fishScroll = new JScrollPane(listFishToAdd);
        fishScroll.setMinimumSize(new Dimension(280, 135));
        fishScroll.setPreferredSize(new Dimension(280, 135));

        //The fish statistics pane
        JPanel pnlFishStats = new JPanel();
        this.lblFishStats = new JLabel("Select a fish to add");
        pnlFishStats.add(lblFishStats);

        //Add button for fish
        JPanel pnlAddFishBtn = new JPanel();
        this.btnAddFish = new JButton("Add Fish to Tank");
        this.setButtonLook(btnAddFish);
        pnlAddFishBtn.add(btnAddFish);

        pnlFishList.add(fishScroll);
        pnlFishToAdd.add(pnlFishList);
        pnlFishToAdd.add(pnlFishStats);
        pnlFishToAdd.add(pnlAddFishBtn);
//--------------------------------------------------------------------------------------
//-------------------------------TANK COMPONENTS PANEL----------------------------------
//--------------------------------------------------------------------------------------
        JPanel pnlCompToAdd = new JPanel();
        pnlCompToAdd.setLayout(new FlowLayout());
        pnlCompToAdd.setPreferredSize(new Dimension(290, 253));
        panel1.add(pnlCompToAdd);
        JLabel lblCompToAdd = new JLabel("Tank Components Available");
        JPanel pnlCompToAddTitle = new JPanel();
        pnlCompToAddTitle.setLayout(new FlowLayout());
        pnlCompToAddTitle.add(lblCompToAdd);
        pnlCompToAdd.add(pnlCompToAddTitle);

        //List of available compnents
        JPanel pnlCompList = new JPanel();
        pnlCompList.setPreferredSize(new Dimension(280, 140));
        pnlCompList.setLayout(new FlowLayout());
        ArrayList<String> compList = new ArrayList<String>();
        for(int i = 0; i < components.size(); i++){
            compList.add(components.get(i).getComponentName());
        }
        String[] compArray = new String[compList.size()];
        compArray = compList.toArray(compArray);

        this.listCompToAdd = new JList(compArray);
        listCompToAdd.setLayoutOrientation(JList.VERTICAL);
        listCompToAdd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane compScroll = new JScrollPane(listCompToAdd);
        compScroll.setMinimumSize(new Dimension(280, 135));
        compScroll.setPreferredSize(new Dimension(280, 135));

        //The components statistics pane
        JPanel pnlCompStats = new JPanel();
        this.lblCompStats = new JLabel("Select a component to add");
        pnlCompStats.add(lblCompStats);

        //Add button for components
        JPanel pnlAddCompBtn = new JPanel();
        this.btnAddComp = new JButton("Add Component to Tank");
        this.setButtonLook(btnAddComp);
        pnlAddCompBtn.add(btnAddComp);

        pnlCompList.add(compScroll);
        pnlCompToAdd.add(pnlCompList);
        pnlCompToAdd.add(pnlCompStats);
        pnlCompToAdd.add(pnlAddCompBtn);
//--------------------------------------------------------------------------------------
//-------------------------------TANK CONTENTS PANEL------------------------------------
//--------------------------------------------------------------------------------------
        JLabel lblYourTank = new JLabel("Your Tank Contents");
        this.setLightText(lblAddToTank);
        panel2.add(lblYourTank);
        this.pnlYourTank = new JPanel();
        pnlYourTank.setLayout(new FlowLayout());
        pnlYourTank.setPreferredSize(new Dimension(290, 536));

        panel2.add(pnlYourTank);

        JPanel pnlTankTitle = new JPanel();
        pnlTankTitle.add(lblYourTank);
        pnlYourTank.add(pnlTankTitle);

        JPanel pnlTankList = new JPanel();
        pnlTankList.setPreferredSize(new Dimension(280, 350));
        pnlTankList.setLayout(new FlowLayout());

        model = new DefaultListModel();
        this.listTankContents = new JList(model);
        listTankContents.setLayoutOrientation(JList.VERTICAL);
        listTankContents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane tankScroll = new JScrollPane(listTankContents);
        tankScroll.setMinimumSize(new Dimension(280, 400));
        tankScroll.setPreferredSize(new Dimension(280, 400));

        //TODO working only with added fish right now
        for(int i = 0; i < tank.getFishList().size(); i++){
            model.addElement(tank.getFishList().get(i).getFishName());
        }

        //Remove button for tank
        this.btnRemove = new JButton("Remove from tank");
        JPanel pnlRemoveBtn = new JPanel();
        this.setButtonLook(btnRemove);
        pnlRemoveBtn.add(btnRemove);

        //Tank stats panel
        JPanel pnlTankStats = new JPanel();
        pnlTankStats.setLayout(new GridLayout(5, 2));
        pnlTankStats.setPreferredSize(new Dimension(280, 95));
        pnlTankStats.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        //Change tank stats
        this.lblMaxVolume = new JLabel("Tank Volume: " + tank.getTankVolume());
        this.lblVolume = new JLabel("Volume Available: " + (tank.getTankVolume() - tank.getCurrentVolume()));
        String waterTypeString = "";
        if(tank.getWater().isFreshWater()){
            waterTypeString = "Freshwater";
        }else if(!tank.getWater().isFreshWater()){
            waterTypeString = "Saltwater";
        }
        this.lblWaterType = new JLabel("Water Type: " + waterTypeString);
        this.lblCo2 = new JLabel("CO2 Level: " + Water.getCo2());
        this.lblO2 = new JLabel("O2 Level: " + Water.getO2());
        this.lblNh4 = new JLabel("NH4 Level: " + Water.getNh4());
        this.lblPh = new JLabel("PH Level: " + Water.getpH());
        this.lblHardness = new JLabel("Water Hardness: " + Water.getHardness());

        //Add tank stats to panel
        pnlTankStats.add(lblMaxVolume);
        pnlTankStats.add(lblVolume);
        pnlTankStats.add(lblWaterType);
        pnlTankStats.add(lblCo2);
        pnlTankStats.add(lblO2);
        pnlTankStats.add(lblNh4);
        pnlTankStats.add(lblPh);
        pnlTankStats.add(lblHardness);

        pnlTankList.add(tankScroll);
        pnlYourTank.add(pnlTankList);
        pnlYourTank.add(pnlRemoveBtn);
        pnlYourTank.add(pnlTankStats);
//----------------------------------------------------------------------------------------------
//----------------------------------------BOTTOM PANEL------------------------------------------
//----------------------------------------------------------------------------------------------
        this.btnReset = new JButton("Reset");
        this.setButtonLook(btnReset);
        pnlBuild.add(btnReset);

        this.btnBuild = new JButton("Build");
        this.setButtonLook(btnBuild);
        pnlBuild.add(btnBuild);
        frame.repaint();
        frame.revalidate();
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
//----------------------------------------------------------------------------------------------
//------------------------------------ACTION LISTENERS------------------------------------------
//----------------------------------------------------------------------------------------------

    /**
     * Method for adding action listeners to the different buttons and lists in the Tank GUI.
     */
    private void addListeners() {
        this.listFishToAdd.addMouseListener(fishListListener);
        this.btnAddFish.addActionListener(addFishListener);
        this.listTankContents.addMouseListener(tankListListener);
        this.btnRemove.addActionListener(removeListener);
        this.radioButtonSmall.addActionListener(tankSizeListener);
        this.radioButtonMedium.addActionListener(tankSizeListener);
        this.radioButtonLarge.addActionListener(tankSizeListener);
        this.radioButtonExtraLarge.addActionListener(tankSizeListener);
        this.radioFreshwater.addActionListener(waterTypeListener);
        this.radioSaltwater.addActionListener(waterTypeListener);
        this.btnReset.addActionListener(resetListener);
        this.btnAddComp.addActionListener(addCompListener);
        this.listCompToAdd.addMouseListener(compListListener);
        this.btnViewPreBuilt.addActionListener(prebuiltListener);
        this.btnBuild.addActionListener(buildListener);
    }

    //Inner classes for action listeners

    //"Add" action listener for fish
    ActionListener addFishListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (currentFish != null){
                tank.addFish(currentFish);
            }

            model.removeAllElements();
            //TODO working only with added fish right now
            for(int i = 0; i < tank.getFishList().size(); i++){
                model.addElement(tank.getFishList().get(i).getFishName());
            }
            for(int i = 0; i < tank.getComponentsList().size(); i++){
                model.addElement(tank.getComponentsList().get(i).getComponentName());
            }

            updateChemicals();
            frame.validate();
            frame.repaint();

        }
    };

    //"Add" action listener for components
    ActionListener addCompListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            if (currentComp != null){
                tank.addComponent(currentComp);
                currentComp.affectEnvironment(true);
            }

            model.removeAllElements();
            //TODO working only with added fish right now
            for(int i = 0; i < tank.getFishList().size(); i++){
                model.addElement(tank.getFishList().get(i).getFishName());
            }
            for(int i = 0; i < tank.getComponentsList().size(); i++){
                model.addElement(tank.getComponentsList().get(i).getComponentName());
            }

            updateChemicals();
            frame.validate();
            frame.repaint();

        }
    };

    //"Remove" action listener
    ActionListener removeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (selectedTankIndex != -1){

                //See if a component and remove it
                if(selectedTankIndex >= tank.getFishList().size()){
                    TankComponent component = tank.getComponentsList().get(selectedTankIndex - (tank.getFishList().size()));
                    model.remove(selectedTankIndex);
                    tank.removeComponent(component);
                    component.affectEnvironment(false);
                }else{
                    //If a fish remove that
                    Fish fish = tank.getFishList().get(selectedTankIndex);
                    model.remove(selectedTankIndex);
                    tank.removeFish(fish);
                }
            }

            selectedTankIndex = -1;

            updateChemicals();
            frame.validate();
            frame.repaint();
        }
    };

    //"Fish List" mouse listener
    MouseListener fishListListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {

            String selectedFish = (String) listFishToAdd.getSelectedValue();

            //set current fish
            for(int i = 0; i < fish.size(); i++){
                if(fish.get(i).getFishName().equals(selectedFish)){
                    currentFish = fish.get(i);
                    lblFishStats.setText("Size: " + String.valueOf(fish.get(i).getVolume()) +
                            " - Level: " + swimLevelToString(fish.get(i).getSwimmingLevel()) +
                            " - Aggression: " + aggroLevelToString(fish.get(i).getAggressionLevel()));

                }
            }
        }
    };

    //"Component List" mouse listener
    MouseListener compListListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {

            String selectedComp = (String) listCompToAdd.getSelectedValue();

            //set current fish
            for(int i = 0; i < components.size(); i++){
                if(components.get(i).getComponentName().equals(selectedComp)){
                    currentComp = components.get(i);

                    //TODO make description for each component
                    lblCompStats.setText("Add " + components.get(i).getComponentName() + " to your tank.");


                }
            }
        }
    };

    //"Tank List" mouse listener
    MouseListener tankListListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            selectedTankIndex = listTankContents.getSelectedIndex();
        }
    };

    //Listener for tank size radio buttons
    ActionListener tankSizeListener= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            if(!(model.isEmpty())){

                int answer = JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),
                        "Changing the tank size will reset the tank build. Are you sure you want to change the size?", "", JOptionPane.YES_NO_OPTION);

                if(answer == 0){

                    model.removeAllElements();

                    tank.getFishList().removeAll(tank.getFishList());
                    tank.getComponentsList().removeAll(tank.getComponentsList());

                    selectedTankIndex = -1;
                    Water.co2 = 50;
                    Water.nh4 = 50;
                    Water.o2 = 50;
                    Water.hardness = 50;
                    Water.pH = 7;
                    tank.setCurrentVolume(0);

                    updateChemicals();
                    frame.validate();
                    frame.repaint();

                    JRadioButton button = (JRadioButton) e.getSource();
                    if (button.getText().equals("Small")){
                        tank.setTankVolume(100);
                    }
                    else if (button.getText().equals("Medium")){
                        tank.setTankVolume(125);

                    }
                    else if (button.getText().equals("Large")){
                        tank.setTankVolume(150);

                    }
                    else if (button.getText().equals("Extra Large")){
                        tank.setTankVolume(200);

                    }
                }else{

                    switch(tank.getTankVolume()){
                        case 100:
                            radioButtonSmall.setSelected(true);
                            break;
                        case 125:
                            radioButtonMedium.setSelected(true);
                            break;
                        case 150:
                            radioButtonLarge.setSelected(true);
                            break;
                        case 200:
                            radioButtonExtraLarge.setSelected(true);
                            break;
                    }

                }


            }else{
                JRadioButton button = (JRadioButton) e.getSource();
                if (button.getText().equals("Small")){
                    tank.setTankVolume(100);
                }
                else if (button.getText().equals("Medium")){
                    tank.setTankVolume(125);

                }
                else if (button.getText().equals("Large")){
                    tank.setTankVolume(150);

                }
                else if (button.getText().equals("Extra Large")){
                    tank.setTankVolume(200);
                }
            }


            updateChemicals();
            frame.validate();
            frame.repaint();
        }
    };

    //Listener for water size radio buttons
    ActionListener waterTypeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(!(model.isEmpty())){

                int answer = JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),
                        "Changing the water type will reset the tank build. Are you sure you want to change the water type?", "", JOptionPane.YES_NO_OPTION);

                if(answer == 0){

                    model.removeAllElements();

                    tank.getFishList().removeAll(tank.getFishList());
                    tank.getComponentsList().removeAll(tank.getComponentsList());

                    selectedTankIndex = -1;
                    Water.co2 = 50;
                    Water.nh4 = 50;
                    Water.o2 = 50;
                    Water.hardness = 50;
                    Water.pH = 7;
                    tank.setCurrentVolume(0);

                    updateChemicals();
                    frame.validate();
                    frame.repaint();

                    JRadioButton button = (JRadioButton)e.getSource();
                    if(button.getText().equals("Freshwater")){
                        tank.setWaterType(true);

                    }
                    else if (button.getText().equals("Saltwater")){
                        tank.setWaterType(false);

                    }


                }else{

                    if(tank.getWater().isFreshWater()){
                        radioFreshwater.setSelected(true);
                    }else{
                        radioSaltwater.setSelected(true);
                    }

                }


            }else{

                JRadioButton button = (JRadioButton)e.getSource();
                if(button.getText().equals("Freshwater")){
                    tank.setWaterType(true);

                }
                else if (button.getText().equals("Saltwater")){
                    tank.setWaterType(false);
                }
            }
            updateChemicals();
            frame.validate();
            frame.repaint();
        }
    };

    //"Reset" action listener
    ActionListener resetListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            model.removeAllElements();

            tank.getFishList().removeAll(tank.getFishList());
            tank.getComponentsList().removeAll(tank.getComponentsList());

            selectedTankIndex = -1;
            Water.co2 = 50;
            Water.nh4 = 50;
            Water.o2 = 50;
            Water.hardness = 50;
            Water.pH = 7;
            tank.setCurrentVolume(0);

            updateChemicals();
            frame.validate();
            frame.repaint();
        }
    };

    //"View Pre-built" action listener
    ActionListener prebuiltListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedTankIndex = -1;
            tank.getWater().setCo2(50);
            tank.getWater().setNh4(50);
            tank.getWater().setO2(50);
            tank.setCurrentVolume(0);
            tank.getWater().setpH(7);

            //Remove everything already added to the tank
            model.removeAllElements();
            tank.getFishList().removeAll(tank.getFishList());
            tank.getComponentsList().removeAll(tank.getComponentsList());

            //Set the pre-built settings
            //Set water to freshwater
            tank.setWaterType(true);
            radioFreshwater.setSelected(true);

            //Set to size large
            tank.setTankVolume(100);
            radioButtonSmall.setSelected(true);

            //Add fish to tank
            tank.addFish(fish.get(0));		//Add gold fish

            //Add components to tank
            tank.addComponent(components.get(10));
            tank.addComponent(components.get(0));
            tank.addComponent(components.get(3));

            //Update JList for fish and components
            for(int i = 0; i < tank.getFishList().size(); i++){
                model.addElement(tank.getFishList().get(i).getFishName());
            }
            for(int i = 0; i < tank.getComponentsList().size(); i++){
                model.addElement(tank.getComponentsList().get(i).getComponentName());
            }
            updateChemicals();
            frame.validate();
            frame.repaint();

        }
    };

    //"Build" action listener
    ActionListener buildListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(tank.getFishList().isEmpty() && tank.getComponentsList().isEmpty()){
                try {
                    throw new EmptyTankException();
                } catch (EmptyTankException e1) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Tank is empty. Cannot build.");
                }
            }else{
                //Create a new output file
                OutputFile file = new OutputFile(tank);
            }
        }
    };

    //Custom button method
    private void setButtonLook(JButton button){
        //Custom button
        button.setBackground(clrDark);
        button.setForeground(clrTextLight);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
    }

    //Custom light text method
    private void setLightText(JLabel label){
        label.setForeground(clrTextLight);
        label.setFont(new Font("Helvetica", Font.BOLD, 16));
    }

    private void setDarkText(JLabel label){
        label.setForeground(clrDark);
        label.setFont(new Font("Helvetica", Font.BOLD, 16));
    }

    private void setMediumText(JLabel label){
        label.setForeground(clrDark);
        label.setFont(new Font("Helvetica", Font.BOLD, 14));
    }

    //Method to update chemicals
    private void updateChemicals(){

        this.lblMaxVolume.setText("Tank Volume: " + tank.getTankVolume());
        this.lblVolume.setText("Volume Available: " + (tank.getTankVolume() - tank.getCurrentVolume()));
        String waterTypeString = "";
        if(tank.getWater().isFreshWater()){
            waterTypeString = "Freshwater";
        }else if(!tank.getWater().isFreshWater()){
            waterTypeString = "Saltwater";
        }
        this.lblWaterType.setText("Water Type: " + waterTypeString);
        this.lblCo2.setText("CO2 Level: " + Water.getCo2());
        this.lblO2.setText("O2 Level: " + Water.getO2());
        this.lblNh4.setText("NH4 Level: " + Water.getNh4());
        this.lblPh.setText("PH Level: " + Water.getpH());
        this.lblHardness.setText("Water Hardness: " + Water.getHardness());

        frame.validate();
        frame.repaint();
    }

    //Method for swimming level string
    private String swimLevelToString(int level){
        switch(level){
            case 0:
                return "Bottom";
            case 1:
                return "Mid";
            case 2:
                return "Top";
            default:
                return "???";
        }
    }

    //Method for aggression level string
    private String aggroLevelToString(int level){

        switch(level){
            case 0:
                return "Peaceful";
            case 1:
                return "Medium";
            case 2:
                return "High";
            default:
                return "???";
        }
    }
}