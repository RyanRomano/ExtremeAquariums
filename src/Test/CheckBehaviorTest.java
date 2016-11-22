////----------------------------------------------------------------------------------------------
////------------------------------------ACTION LISTENERS------------------------------------------
////----------------------------------------------------------------------------------------------
//
//private void addListeners() {
//
//        this.listFishToAdd.addMouseListener(fishListListener);
//        this.btnAdd.addActionListener(addListener);
//        this.radioButtonSmall.addActionListener(tankSizeListener);
//        this.radioButtonMedium.addActionListener(tankSizeListener);
//        this.radioButtonLarge.addActionListener(tankSizeListener);
//        this.radioButtonExtraLarge.addActionListener(tankSizeListener);
//        this.radioFreshwater.addActionListener(waterTypeListener);
//        this.radioSaltwater.addActionListener(waterTypeListener);
//        }
//
//        //Inner classes for action listeners
//
//        //"Add" action listener
//        ActionListener addListener = new ActionListener() {
//@Override
//public void actionPerformed(ActionEvent e) {
//
//        if (currentFish != null){
//        tank.addFish(currentFish);
//        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), Water.co2 + " - " + Water.o2+ " - " + Water.nh4);
//        }
//
//        model.removeAllElements();
//        //TODO working only with added fish right now
//        for(int i = 0; i < tank.getFishList().size(); i++){
//        model.addElement(tank.getFishList().get(i).getFishName());
//        }
//
//        container.validate();
//        container.repaint();
//
////            for(int i = 0; i < tank.getFishList().size(); i++){
////                System.out.println(tank.getFishList().get(i).getFishName());
////            }
//
//
//
//        }
//        };
//
//        //"Remove" action listener
//        ActionListener removeListener = new ActionListener() {
//@Override
//public void actionPerformed(ActionEvent e) {
//
//        }
//        };
//
//        //"Fish List" action listener
//        MouseListener fishListListener = new MouseAdapter() {
//public void mouseClicked(MouseEvent e) {
//        String selectedFish = (String) listFishToAdd.getSelectedValue();
//
//        //set current fish
//        for(int i = 0; i < fish.size(); i++){
//        if(fish.get(i).getFishName().equals(selectedFish)){
//        currentFish = fish.get(i);
//        }
//        }
//        //Refresh list of fish in tank
//
//        }
//        };
//
//        ActionListener tankSizeListener= new ActionListener() {
//@Override
//public void actionPerformed(ActionEvent e) {
//        JRadioButton button = (JRadioButton) e.getSource();
//        if (button.getText().equals("Small")){
//        tank.setTankVolume(100);
//        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "100 units");
//        }
//        else if (button.getText().equals("Medium")){
//        tank.setTankVolume(125);
//        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "125 units");
//
//        }
//        else if (button.getText().equals("Large")){
//        tank.setTankVolume(150);
//        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "150 units");
//
//        }
//        else if (button.getText().equals("Extra Large")){
//        tank.setTankVolume(200);
//        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "200 units");
//
//        }
//        }
//        };
//
//        ActionListener waterTypeListener = new ActionListener() {
//@Override
//public void actionPerformed(ActionEvent e) {
//        JRadioButton button = (JRadioButton)e.getSource();
//        if(button.getText().equals("Freshwater")){
//        tank.setWaterType(true);
//        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Freshwater");
//
//        }
//        else if (button.getText().equals("Saltwater")){
//        tank.setWaterType(false);
//        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Saltwater");
//
//        }
//        }
//        };
//
////Update methods
//public void updateTankList(){
//
//
//        }
//
//        }