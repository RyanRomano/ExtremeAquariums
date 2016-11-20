package v1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by ryan on 11/8/16.
 */
public class TankGUI {
    private Tank tank;
    private ArrayList<TankComponent> components;
    private ArrayList<Fish> fish;
    private Fish currentFish;
    private Component currentComponent;
    private DefaultListModel model;;

    //TODO
    private ArrayList<Fish> currentFishInTank = new ArrayList<Fish>();


    //Panel variables
    private JPanel pnlHeader;       //North Panel
    private JPanel pnlTankContents;     //Center panel
    private JPanel pnlBuild;            //South panel
    private JPanel pnlWest;
    private Container container;

    //Variables using listeners
    private JList listFishToAdd;
    private JButton btnAdd;
    private JButton btnRemove;
    private JPanel pnlYourTank;
    private ArrayList<String> tankList = new ArrayList<String>();
    private JList listTankContents;
    private JLabel lblFishStats;
    private int selectedTankIndex;
    private JButton btnReset;
    private JButton btnBuild;

    JRadioButton radioButtonSmall = new JRadioButton("Small");
    JRadioButton radioButtonMedium = new JRadioButton("Medium");
    JRadioButton radioButtonLarge = new JRadioButton("Large");
    JRadioButton radioButtonExtraLarge = new JRadioButton("Extra Large");

    JRadioButton radioFreshwater = new JRadioButton("Freshwater");
    JRadioButton radioSaltwater = new JRadioButton("Saltwater");

    public TankGUI(Tank tank, ArrayList<TankComponent> components, ArrayList<Fish> fish) {
        this.tank = tank;
        this.components = components;
        this.fish = fish;
        makeFrame();
        addListeners();
    }

    public void makeFrame(){
//--------------------------------TOP LEVEL SETTINGS--------------------------

        JFrame frame = new JFrame("Acme Aquariums");
        frame.setPreferredSize(new Dimension(1200, 600));
        frame.setMinimumSize(new Dimension(1200, 600));
        container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(Color.ORANGE);

//--------------------------------------------------------------------------------------
//-------------------------------TOP PANEL----------------------------------------------
//--------------------------------------------------------------------------------------

        pnlHeader = new JPanel();
        pnlHeader.setLayout(new FlowLayout());
        JLabel lblTankWizard = new JLabel("Custom Tank Wizard");
        pnlHeader.add(lblTankWizard);
        JButton viewPreBuilt = new JButton("View Pre-Built");
        pnlHeader.add(viewPreBuilt);
        pnlHeader.setBackground(Color.BLUE);
        container.add(pnlHeader, BorderLayout.NORTH);
//--------------------------------------------------------------------------------------
//--------------------------------WEST PANEL--------------------------------------------
//--------------------------------------------------------------------------------------


        pnlWest = new JPanel();
        pnlWest.setLayout(new FlowLayout());
        pnlWest.setBackground(Color.RED);
        pnlWest.setPreferredSize(new Dimension(200,300));
        container.add(pnlWest, BorderLayout.WEST);

        JPanel pnlTankAttributes = new JPanel();
        pnlTankAttributes.setLayout(new BoxLayout(pnlTankAttributes, BoxLayout.Y_AXIS));
        //pnlTankAttributes.setLayout(new FlowLayout());
        JPanel tankSize = new JPanel();
        tankSize.setLayout(new BoxLayout(tankSize, BoxLayout.Y_AXIS));
        JPanel waterType = new JPanel();
        waterType.setLayout(new BoxLayout(waterType, BoxLayout.Y_AXIS));
//---------------------------------TANK SIZE OPTIONS------------------------------------
        JLabel tankSizeLabel = new JLabel("Tank Size");
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
//--------------------------------WATER TYPE OPTIONS------------------------------------
        JLabel waterTypeLabel = new JLabel("Water Type");
        ButtonGroup waterTypeButtonGroup = new ButtonGroup();

        waterTypeButtonGroup.add(radioFreshwater);
        waterTypeButtonGroup.add(radioSaltwater);
        waterType.add(waterTypeLabel);
        waterType.add(radioFreshwater);
        waterType.add(radioSaltwater);
//---------------------------------ADD TO WEST PANEL------------------------------------
        pnlTankAttributes.add(tankSize);
        pnlTankAttributes.add(Box.createVerticalStrut(50));
        pnlTankAttributes.add(waterType);
        pnlTankAttributes.add(Box.createVerticalStrut(50));
        pnlWest.add(pnlTankAttributes);

//--------------------------------------------------------------------------------------
//---------------------------------CENTER PANEL TOP LEVEL OPTIONS-----------------------
//--------------------------------------------------------------------------------------

        pnlTankContents = new JPanel();
        pnlTankContents.setLayout(new FlowLayout());
        pnlTankContents.setBackground(Color.pink);
        JPanel panel1 = new JPanel();				//Panel for available items to add
        panel1.setPreferredSize(new Dimension(300, 475));
        panel1.setBackground(Color.GREEN);

        JPanel panelAddButtons = new JPanel();		//Panel for add/remove buttons
        //panelAddButtons.setLayout(new BoxLayout(panelAddButtons, BoxLayout.Y_AXIS));
        panelAddButtons.setLayout(new FlowLayout());
        panelAddButtons.setPreferredSize(new Dimension(200, 88));
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

//--------------------------------------------------------------------------------------
//--------------------------------ADD TO TANK PANEL-------------------------------------
//--------------------------------------------------------------------------------------
        JLabel lblAddToTank = new JLabel("Add To Tank");
        panel1.add(lblAddToTank);
//----------------------------------FISH AVAILABLE PANEL--------------------------------
        JPanel pnlFishToAdd = new JPanel();
        pnlFishToAdd.setBorder(BorderFactory.createLineBorder(Color.black));
        pnlFishToAdd.setLayout(new BoxLayout(pnlFishToAdd, BoxLayout.Y_AXIS));
        pnlFishToAdd.setPreferredSize(new Dimension(290, 215));
        panel1.add(pnlFishToAdd);
        JLabel lblFishToAdd = new JLabel("Fish Available");
        JPanel pnlFishToAddTitle = new JPanel();
        pnlFishToAddTitle.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlFishToAddTitle.setLayout(new FlowLayout());
        pnlFishToAddTitle.add(lblFishToAdd);
        pnlFishToAdd.add(pnlFishToAddTitle);

        //List of available fish
        JPanel pnlFishList = new JPanel();
        pnlFishList.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        pnlFishList.setPreferredSize(new Dimension(280, 200));
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
        fishScroll.setMinimumSize(new Dimension(280, 150));
        fishScroll.setPreferredSize(new Dimension(280, 150));

        //The fish statistics pane
        JPanel pnlFishStats = new JPanel();
        this.lblFishStats = new JLabel("Freshwater, Bottom swimmer, Aggressive");
        //TODO Change with action listener
        pnlFishStats.add(lblFishStats);

        pnlFishList.add(fishScroll);
        pnlFishToAdd.add(pnlFishList);
        pnlFishToAdd.add(pnlFishStats);
//--------------------------------------------------------------------------------------
//-------------------------------TANK COMPONENTS PANEL----------------------------------
//--------------------------------------------------------------------------------------
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
        pnlCompList.setPreferredSize(new Dimension(280, 150));
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
        compScroll.setMinimumSize(new Dimension(280, 145));
        compScroll.setPreferredSize(new Dimension(280, 145));

        //The components statistics pane
        JPanel pnlCompStats = new JPanel();
        JLabel lblCompStats = new JLabel("Powerful filter. Recommended for large tanks.");
        //TODO Change with action listener
        pnlCompStats.add(lblCompStats);

        pnlCompList.add(compScroll);
        pnlCompToAdd.add(pnlCompList);
        pnlCompToAdd.add(pnlCompStats);
//--------------------------------------------------------------------------------------
//--------------------------------ADD REMOVE BUTTONS------------------------------------
//--------------------------------------------------------------------------------------
        JPanel pnlAddBtn = new JPanel();
        this.btnAdd = new JButton("Add to tank");
        pnlAddBtn.add(btnAdd);
        this.btnRemove = new JButton("Remove from tank");
        JPanel pnlRemoveBtn = new JPanel();
        pnlRemoveBtn.add(btnRemove);
        panelAddButtons.add(pnlAddBtn);
        panelAddButtons.add(pnlRemoveBtn);
//--------------------------------------------------------------------------------------
//-------------------------------TANK CONTENTS PANEL------------------------------------
//--------------------------------------------------------------------------------------
        this.pnlYourTank = new JPanel();
        pnlYourTank.setLayout(new FlowLayout());
        pnlYourTank.setPreferredSize(new Dimension(290, 456));
        panel2.add(pnlYourTank);
        JLabel lblYourTank = new JLabel("Your Tank Contents");
        JPanel pnlTankTitle = new JPanel();
        pnlTankTitle.add(lblYourTank);
        pnlYourTank.add(pnlTankTitle);

        JPanel pnlTankList = new JPanel();
        pnlTankList.setPreferredSize(new Dimension(280, 400));
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

        pnlTankList.add(tankScroll);
        pnlYourTank.add(pnlTankList);
//----------------------------------------------------------------------------------------------
//----------------------------------------BOTTOM PANEL------------------------------------------
//----------------------------------------------------------------------------------------------
        this.btnReset = new JButton("Reset");
        pnlBuild.add(btnReset);
        this.btnBuild = new JButton("Build");
        pnlBuild.add(btnBuild);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
//----------------------------------------------------------------------------------------------
//------------------------------------ACTION LISTENERS------------------------------------------
//----------------------------------------------------------------------------------------------

    private void addListeners() {

        this.listFishToAdd.addMouseListener(fishListListener);
        this.btnAdd.addActionListener(addListener);
        this.listTankContents.addMouseListener(tankListListener);
        this.btnRemove.addActionListener(removeListener);
        this.radioButtonSmall.addActionListener(tankSizeListener);
        this.radioButtonMedium.addActionListener(tankSizeListener);
        this.radioButtonLarge.addActionListener(tankSizeListener);
        this.radioButtonExtraLarge.addActionListener(tankSizeListener);
        this.radioFreshwater.addActionListener(waterTypeListener);
        this.radioSaltwater.addActionListener(waterTypeListener);
        this.btnReset.addActionListener(resetListener);
    }

    //Inner classes for action listeners

    //"Add" action listener
    ActionListener addListener = new ActionListener() {
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

            container.validate();
            container.repaint();

        }
    };

    //"Remove" action listener
    ActionListener removeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (selectedTankIndex != -1){
                Fish fish = tank.getFishList().get(selectedTankIndex);
                model.remove(selectedTankIndex);
                tank.removeFish(fish);
            }

            selectedTankIndex = -1;

        }
    };

    //"Fish List" action listener
    MouseListener fishListListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {

            String selectedFish = (String) listFishToAdd.getSelectedValue();

            //set current fish
            for(int i = 0; i < fish.size(); i++){
                if(fish.get(i).getFishName().equals(selectedFish)){
                    currentFish = fish.get(i);
                    lblFishStats.setText("Size: " + String.valueOf(fish.get(i).getVolume()) +
                            " Level: " + fish.get(i).getSwimmingLevel() +
                            " Agression: " + fish.get(i).getAggressionLevel());

                }
            }
        }
    };

    //"Tank List" action listener
    MouseListener tankListListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {

            selectedTankIndex = listTankContents.getSelectedIndex();

        }
    };

    ActionListener tankSizeListener= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton button = (JRadioButton) e.getSource();
            if (button.getText().equals("Small")){
                tank.setTankVolume(100);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "100 units");
            }
            else if (button.getText().equals("Medium")){
                tank.setTankVolume(125);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "125 units");

            }
            else if (button.getText().equals("Large")){
                tank.setTankVolume(150);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "150 units");

            }
            else if (button.getText().equals("Extra Large")){
                tank.setTankVolume(200);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "200 units");

            }
        }
    };

    ActionListener waterTypeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton button = (JRadioButton)e.getSource();
            if(button.getText().equals("Freshwater")){
                tank.setWaterType(true);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Freshwater");

            }
            else if (button.getText().equals("Saltwater")){
                tank.setWaterType(false);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Saltwater");

            }
        }
    };

    //"Reset" action listener
    ActionListener resetListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            model.removeAllElements();

            tank.getFishList().removeAll(tank.getFishList());

            selectedTankIndex = -1;
            Water.co2 = 50;
            Water.nh4 = 50;
            Water.o2 = 50;
            tank.setCurrentVolume(0);
        }
    };



}