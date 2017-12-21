package sample;

import java.io.*;
import java.util.ArrayList;

public class SaveColors {

    private BufferedWriter saveColorWriter;
    private BufferedReader saveColorReader;
    private File saveColorFile;
    private String colorCodes[] = new String[6];

    SaveColors() throws IOException {
        File softwareHomePath = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\" + "ColorCode");
        saveColorFile = new File(softwareHomePath.getAbsolutePath() + "\\SavedColor.pref");
        if (!softwareHomePath.exists()) {
            softwareHomePath.mkdir();
        }
        if (!saveColorFile.exists()) {
            saveColorFile.createNewFile();
        }

        for (int i=0;i<colorCodes.length;i++){
            colorCodes[i] = "";
        }

        saveColorReader = new BufferedReader(new FileReader(saveColorFile));
        initilizeColor();
    }

    public void saveColorToFile(String colorCode){
        try {
            saveColorWriter = new BufferedWriter(new FileWriter(saveColorFile,true));
            saveColorWriter.write(colorCode);
            saveColorWriter.newLine();
            saveColorWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeColor(String colorCode) throws IOException {
        saveColorWriter = new BufferedWriter(new FileWriter(saveColorFile,true));
        saveColorReader = new BufferedReader(new FileReader(saveColorFile));

        for (int index=0;index<colorCodes.length;index++){
            colorCodes[index] = "";
        }

        String data;
        int i=0;
        while ((data = saveColorReader.readLine()) != null){
            if (!data.equals(colorCode)){
                if (i<6)
                    colorCodes[i] = data;
            }
            i++;
        }

        PrintWriter writer = new PrintWriter(saveColorFile);
        writer.print("");
        writer.close();

        for (int j=0;j<colorCodes.length;j++){
            if (!(colorCodes[j].equals(""))){
                saveColorWriter.write(colorCodes[j]);
                saveColorWriter.newLine();
            }
        }

        saveColorWriter.close();
        saveColorReader.close();
    }

    private void initilizeColor() throws IOException {

        String colorCode;
        Integer index=0;
        while ((colorCode = saveColorReader.readLine()) != null){
            if (index<6)
                colorCodes[index] = colorCode;
            index++;
        }
        saveColorReader.close();
    }

    public String[] getColors(){
        return colorCodes;
    }

}
