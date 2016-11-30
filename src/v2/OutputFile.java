package v2;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class OutputFile {

    private String outputString = "";
    private Tank tank;
    private static final String filename = "output.txt";
    private File file = new File(filename);


    public OutputFile(Tank tank) {

        this.tank = tank;
        this.outputString = createOutputString();

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(outputString);
        }catch(Exception e){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Error writing output file.");
        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Error opening output file.");
        }
    }

    public String createOutputString(){

        String waterType;

        outputString += "----- Output file for your tank -----\r\n";
        outputString += "Tank Volume: " + tank.getTankVolume() + "\r\n";
        outputString += "Used Volume: " + tank.getCurrentVolume() + "\r\n";

        if (tank.isWaterType()){
            waterType = "Freshwater";
        }else{
            waterType = "Saltwater";
        }
        outputString += "Water Type: " + waterType + "\r\n";
        outputString += "O2: " + Water.o2 + "\r\n";
        outputString += "CO2: " + Water.co2 + "\r\n";
        outputString += "NH4: " + Water.nh4 + "\r\n";
        outputString += "Hardness: " + Water.hardness + "\r\n";
        outputString += "pH: " + Water.pH + "\r\n";
        outputString += "\r\n----- Fish in tank -----\r\n";

        for(Fish fish : tank.getFishList()){
            outputString += fish.getFishName() + "\r\n";
        }

        outputString += "\r\n----- Components in tank -----\r\n";

        for(TankComponent comp : tank.getComponentsList()){
            outputString += comp.getComponentName() + "\r\n";
        }



        return outputString;
    }

}