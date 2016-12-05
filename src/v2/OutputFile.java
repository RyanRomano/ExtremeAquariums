package v2;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JOptionPane;
/**
 * Output File class
 * Creates an output file ("output.txt") that displays
 * every component in the fish tank once it is built,
 * this includes the fish, chemical levels,
 * specifications of the tank, & the components of the tank
 */
public class OutputFile {

    private String outputString = "";
    private Tank tank;
    private static final String filename = "output.txt";
    private File file = new File(filename);

    /**
     * 1-argument constructor for the Output File class
     * takes in tank as a parameter.
     * @param tank
     */
    public OutputFile(Tank tank) {

        this.tank = tank;
        this.outputString = createOutputString();
        /**
         * Try catch block
         * Contains a decorator pattern with a buffered writer,
         * an output stream writer, and a file output stream.
         *
         * Writes to the outputString
         */
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(outputString);
            /**
             * Catches an exception and
             * displays a JOptionPane: "error writing output file"
             */
        }catch(Exception e){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Error writing output file.");
        }

        Desktop desktop = Desktop.getDesktop();

        /**
         * Try catch block for opening a file on the desktop
         */

        try {
            desktop.open(file);
            /**
             * Catches an IOException and
             * displays a JOptionPane: "Error opening file output file"
             */
        } catch (IOException e) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Error opening output file.");
        }
    }

    /**
     * Method to create output string
     * @return outputString
     *
     * Uses if and for statements to make sure all parts of the
     * tank are passed to the output string and displayed properly.
     */
    public String createOutputString(){

        String waterType;

        outputString += "----- Output file for your tank -----\r\n";
        outputString += "Tank Volume: " + tank.getTankVolume() + "\r\n";
        outputString += "Used Volume: " + tank.getCurrentVolume() + "\r\n";

        /**
         * If to check which water type the tank is and
         * display either "Fresh water" or "Salt water"
         */
        if (tank.isWaterType()){
            waterType = "Fresh water";
        }else{
            waterType = "Salt water";
        }
        outputString += "Water Type: " + waterType + "\r\n";
        outputString += "O2: " + Water.o2 + "\r\n";
        outputString += "CO2: " + Water.co2 + "\r\n";
        outputString += "NH4: " + Water.nh4 + "\r\n";
        outputString += "Hardness: " + Water.hardness + "\r\n";
        outputString += "pH: " + Water.pH + "\r\n";
        outputString += "\r\n----- Fish in tank -----\r\n";

        /**
         * For statement to get and display
         * the list of fish that are in the tank.
         */
        for(Fish fish : tank.getFishList()){
            outputString += fish.getFishName() + "\r\n";
        }
        outputString += "\r\n----- Components in tank -----\r\n";

        /**
         * For statement to get and display the list
         * of tank components that are in the tank.
         */
        for(TankComponent comp : tank.getComponentsList()){
            outputString += comp.getComponentName() + "\r\n";
        }
        return outputString;
    }
}