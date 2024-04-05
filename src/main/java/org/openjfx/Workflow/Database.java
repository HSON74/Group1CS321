package org.openjfx.Workflow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

/**
 * This base class object will for handling two
 * particular database. One is for immigrant and the
 * another is for dependent.
 */
public class Database {
    // Private class & variable.
    private String dataNameForImmigrant; // The immigrant record the system current accessing.
    private String dataNameForDependent; // The dependent record the system current accessing.

    // protected class & variable.
    protected ArrayList<Immigrant> databaseFormsImmigrant;
    protected ArrayList<Dependent> databaseFormsDependent;

    /*
     * Inital the table by create a table or access
     * the table if the table exist.
     */
    public Database(Form form, String databaseNameImmigrant, String databaseNameDependent) {
        if (databaseNameImmigrant == null) {
            databaseNameImmigrant = "Immigrant";
        }
        if (databaseNameDependent == null) {
            databaseNameDependent = "Dependent";
        }
        this.dataNameForImmigrant = "./src/main/java/org/openjfx/Database/"
                + databaseNameImmigrant
                + ".txt";
        this.dataNameForDependent = "./src/main/java/org/openjfx/Database/"
                + databaseNameDependent + ".txt";
        System.out.println(dataNameForImmigrant);
        System.out.println(dataNameForDependent);
        try {
            // Access to the immgrint record and create a temp database array for
            // application.
            File datafile = new File(dataNameForImmigrant);
            Scanner scr;
            this.databaseFormsImmigrant = new ArrayList<Immigrant>();
            if (datafile.exists()) {
                scr = new Scanner(datafile);
                while (scr.hasNextLine()) {
                    String mystring = scr.nextLine();
                    Immigrant tempImmigrantForm = setRecordtoImmigrant(mystring);
                    this.databaseFormsImmigrant.add(tempImmigrantForm);
                }
                scr.close();
                System.err.println("File Exist");
            } else {
                datafile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(datafile));
                System.err.println("File Exist not exist");
                writer.close();
            }
            // Access to the dependent record and create a temp database array for
            // application.
            Scanner dscr;
            File datafiled = new File(dataNameForDependent);
            this.databaseFormsDependent = new ArrayList<Dependent>();
            if (datafiled.exists()) {
                dscr = new Scanner(datafiled);

                while (dscr.hasNextLine()) {
                    String mystring = dscr.nextLine();
                    Dependent tempDependentForm = setRecordtoDependent(mystring);
                    databaseFormsDependent.add(tempDependentForm);
                }
                dscr.close();
                System.err.println("File Exist");
            } else {
                datafiled.createNewFile();
                BufferedWriter dwriter = new BufferedWriter(new FileWriter(datafiled));
                // writer.write("1");
                dscr = new Scanner(datafiled);
                System.err.println("File Exist not exist");
                dwriter.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.toString());
        }

    }

    /*
     * A method for the add datas from From class format
     * into the system record.
     */
    public boolean addData(Form form) {
        if (form == null) {
            return false;
        }
        if (form.getImmigrant() == null || form.getDependent() == null) {
            return false;
        }
        boolean addDatatoFile = saveData(form);
        // System.out.println("add to system");
        return addDatatoFile;
    }

    // Check the data are in system.
    public boolean checkData(int iPID, int dPID, String result) {
        Immigrant myImmigrant = getDataImmigrant(iPID);
        Dependent myDependent = getDataDependent(dPID);
        if (myImmigrant == null && myDependent == null) {
            result = "both is not system";
            return true;
        }
        if (myImmigrant == null) {
            System.err.println("Immigrant information is not in system");
            result = "Immigrant is not system";
            return false;
        }
        if (myDependent == null) {
            System.err.println("Dependent information is not in system");
            result = "Dependent is not system";
            return false;
        }
        result = "Information need update";
        return true;
    }

    /*
     * The method will search the the Database froms for
     * immigrant using the integer variable iPID, which
     * is immigrant Pid.
     */
    public Immigrant getDataImmigrant(int iPID) {
        if (databaseFormsImmigrant == null) {
            return null;
        }
        for (int i = 0; i < databaseFormsImmigrant.size(); i++) {
            if (databaseFormsImmigrant.get(i).getImmigrantPid() == iPID) {
                return databaseFormsImmigrant.get(i);
            }
        }
        return null;
    }

    /*
     * The method will search the the Database froms for
     * dependent using the integer variable iPID, which
     * is dependent Pid.
     */
    public Dependent getDataDependent(int iPID) {
        if (databaseFormsDependent == null) {
            return null;
        }
        for (int i = 0; i < databaseFormsDependent.size(); i++) {
            if (databaseFormsDependent.get(i).getImmigrantPid() == iPID) {
                return databaseFormsDependent.get(i);
            }
        }
        return null;
    }

    /*
     * The method will search the the Database froms for
     * immigrant using the integer variable social security number, which
     * is immigrant social security number.
     */
    private Immigrant getDataImmigrantSSN(int sSNumber) {
        if (databaseFormsImmigrant == null) {
            return null;
        }
        for (int i = 0; i < databaseFormsImmigrant.size(); i++) {
            if (databaseFormsImmigrant.get(i).getSSNumber() == sSNumber) {
                return databaseFormsImmigrant.get(i);
            }
        }
        return null;
    }

    /*
     * The method will search the the Database froms for
     * Dependent using the integer variable social security number, which
     * is Dependent social security number.
     */
    private Dependent getDataDependentSSN(int sSNumber) {
        if (databaseFormsDependent == null) {
            return null;
        }
        for (int i = 0; i < databaseFormsDependent.size(); i++) {
            if (databaseFormsDependent.get(i).getSSNumber() == sSNumber) {
                return databaseFormsDependent.get(i);
            }
        }
        return null;
    }

    /*
     * A method that save if the form information don't exist in the system.
     */
    private boolean saveData(Form inputForm) {
        if (inputForm.getDependent() == null || inputForm.getImmigrant() == null) {
            return false;
        }
        Immigrant iForm = inputForm.getImmigrant();
        Dependent dForm = inputForm.getDependent();
        String status = "";
        if (checkData(iForm.getImmigrantPid(), dForm.getDependentPid(), status)) {
            if (status.equalsIgnoreCase("both is not system")) {
                dForm.setPrevClaim(dForm.getPrevClaim());
                iForm.setImmigrantPid(dForm.getDependentPid());
                addImmigrantToData(iForm);
                addDependentToData(dForm);
            } else if (status.equalsIgnoreCase("Information need update")) {
                if ((dForm = getDataDependent(dForm.getDependentPid())) != null
                        && (iForm = getDataImmigrant(dForm.getImmigrantPid())) != null) {
                    Dependent tempDform = getDataDependent(dForm.getDependentPid());
                    if (tempDform.getPrevClaim()) {
                        return false;
                    }
                    updateImmigrant(iForm);
                    updateDependent(dForm);
                } else {
                    return false;
                }
            } else {
                if (status.equalsIgnoreCase("Immigrant is not system")) {
                    Dependent tempDform = getDataDependent(dForm.getDependentPid());
                    if (tempDform != null) {
                        if (tempDform.getPrevClaim()) {
                            return false;
                        }
                        dForm.setPrevClaim(dForm.getPrevClaim());
                        iForm.setImmigrantPid(dForm.getDependentPid());
                        addImmigrantToData(iForm);
                        updateDependent(dForm);
                    }
                } else if (status.equalsIgnoreCase("Dependent is not system")) {
                    if ((iForm = getDataImmigrant(dForm.getImmigrantPid())) != null) {
                        dForm.setPrevClaim(dForm.getPrevClaim());
                        iForm.setImmigrantPid(dForm.getDependentPid());
                        updateImmigrant(iForm);
                        addDependentToData(dForm);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * A private method that really add the immigrant
     * information in to the system.
     */
    public boolean addImmigrantToData(Immigrant immigrantForm) {

        String dataStringImmigrant = setImmigranttoRecord(immigrantForm);
        try {
            Files.write(Paths.get(dataNameForImmigrant),
                    dataStringImmigrant.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
     * A private method that really add the dependnet
     * information in to the system aplication record (SAR).
     */
    private boolean addDependentToData(Dependent dependentForm) {
        String dataStringDependent = setDependenttoRecord(dependentForm);
        try {
            Files.write(Paths.get(dataNameForDependent),
                    dataStringDependent.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
     * A method for remove the immigrant information for the
     * the system application record (SAR).
     */
    public boolean removeImmigrant(int pid) {
        ArrayList<Immigrant> temp = new ArrayList<Immigrant>();
        boolean result = false;
        for (int j = 0; j < databaseFormsImmigrant.size(); j++) {
            if (databaseFormsImmigrant.get(j).getImmigrantPid() == pid) {
                updateLine("", dataNameForImmigrant, j + 1, 'd');
                result = true;
            } else {
                temp.add(databaseFormsImmigrant.get(j));
            }
        }
        databaseFormsImmigrant.clear();
        databaseFormsImmigrant = temp;
        return result;
    }

    /*
     * A method for remove the dependent information for the
     * the system application record (SAR).
     */
    public boolean removeDependent(int pid) {
        ArrayList<Dependent> temp = new ArrayList<Dependent>();
        boolean result = false;
        for (int j = 0; j < databaseFormsDependent.size(); j++) {
            if (databaseFormsDependent.get(j).getDependentPid() == pid) {
                updateLine("", dataNameForDependent, j + 1, 'd');
                result = true;
            } else {
                temp.add(databaseFormsDependent.get(j));
            }
        }
        databaseFormsDependent.clear();
        databaseFormsDependent = temp;
        return result;
    }

    /*
     * A method for update the immigrant information in
     * the system application record (SAR).
     */
    public boolean updateImmigrant(Immigrant immigrant) {
        if (immigrant == null || databaseFormsImmigrant == null) {
            return false;
        }
        ArrayList<Immigrant> temp = new ArrayList<Immigrant>();
        boolean result = false;
        for (int j = 0; j < databaseFormsImmigrant.size(); j++) {
            if (databaseFormsImmigrant.get(j).getImmigrantPid() == immigrant.getImmigrantPid()
                    || immigrant.getSSNumber() == databaseFormsImmigrant.get(j).getSSNumber()) {
                String newLine = setImmigranttoRecord(immigrant);
                updateLine(newLine, dataNameForImmigrant, j + 1, 'u');
                temp.add(immigrant);
            } else {
                temp.add(databaseFormsImmigrant.get(j));
            }
        }
        databaseFormsImmigrant.clear();
        databaseFormsImmigrant = temp;
        return result;
    }

    /*
     * A method for update the dependent information in
     * the system application record (SAR).
     */
    public boolean updateDependent(Dependent dependent) {
        if (dependent == null || databaseFormsDependent == null) {
            return false;
        }
        ArrayList<Dependent> temp = new ArrayList<Dependent>();
        boolean result = false;
        for (int j = 0; j < databaseFormsDependent.size(); j++) {
            if (databaseFormsDependent.get(j).getDependent().getDependentPid() == dependent.getDependentPid()
                    || dependent.getSSNumber() == databaseFormsDependent.get(j).getSSNumber()) {
                String newLine = setImmigranttoRecord(dependent);
                updateLine(newLine, dataNameForDependent, j + 1, 'u');
                temp.add(dependent);
            } else {
                temp.add(databaseFormsDependent.get(j));
            }
        }
        databaseFormsDependent.clear();
        databaseFormsDependent = temp;
        return result;
    }

    /*
     * A method for remove or update immigrant information to
     * the system application record (SAR).
     */
    private void updateLine(String lineChange, String DatabaseFile, int changeline, char command) {
        String tempFileString = "./src/main/java/org/openjfx/Database/temp.txt";
        File oldFile = new File(DatabaseFile);
        File newFile = new File(tempFileString);
        int line = 0;
        String currentLine;
        try {
            FileWriter fw = new FileWriter(tempFileString, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(DatabaseFile);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                line++;
                if (changeline != line) {
                    pw.println(currentLine);
                } else {
                    if (command == 'd') {
                        continue;
                    } else if (command == 'u') {
                        pw.println(lineChange);
                    } else {

                    }
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File(DatabaseFile);
            newFile.renameTo(dump);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private String setImmigranttoRecord(Immigrant immigrant) {
        String myString = Helper.nullStringNullString(immigrant.getFirstName()) + "/";
        myString += Helper.nullStringNullString(immigrant.getMiddleName()) + "/";
        myString += Helper.nullStringNullString(immigrant.getLastName()) + "/";
        myString += String.valueOf(immigrant.getAge()) + "/";
        myString += String.valueOf(immigrant.getbirthMonth()) + "/";
        myString += String.valueOf(immigrant.getbirthDay()) + "/";
        myString += String.valueOf(immigrant.getbirthYear()) + "/";
        myString += Helper.nullStringNullString(immigrant.getAddress()) + "/";
        myString += String.valueOf(immigrant.getSSNumber()) + "/";
        myString += Helper.nullStringNullString(immigrant.getRace()) + "/";
        myString += Helper.nullStringNullString(immigrant.getGender()) + "/";
        myString += Helper.BooleantoYN(immigrant.getMarriedStatus()) + "/";
        myString += Helper.nullStringNullString(immigrant.getPhoneNumber()) + "/";
        myString += Helper.nullStringNullString(immigrant.getFatherName()) + "/";
        myString += Helper.nullStringNullString(immigrant.getMotherName()) + "/";
        myString += Helper.BooleantoYN(immigrant.getemploymentStatus()) + "/";
        myString += String.valueOf(immigrant.getImmigrantPid()) + "/";
        myString += String.valueOf(immigrant.getDependentPid()) + "\n";
        return myString;
    }

    private String setDependenttoRecord(Dependent dependent) {
        String myString = Helper.nullStringNullString(dependent.getFirstName()) + "/";
        myString += Helper.nullStringNullString(dependent.getMiddleName()) + "/";
        myString += Helper.nullStringNullString(dependent.getLastName()) + "/";
        myString += String.valueOf(dependent.getAge()) + "/";
        myString += String.valueOf(dependent.getbirthMonth()) + "/";
        myString += String.valueOf(dependent.getbirthDay()) + "/";
        myString += String.valueOf(dependent.getbirthYear()) + "/";
        myString += Helper.nullStringNullString(dependent.getAddress()) + "/";
        myString += String.valueOf(dependent.getSSNumber()) + "/";
        myString += Helper.nullStringNullString(dependent.getRace()) + "/";
        myString += Helper.nullStringNullString(dependent.getGender()) + "/";
        myString += Helper.BooleantoYN(dependent.getMarriedStatus()) + "/";
        myString += Helper.nullStringNullString(dependent.getPhoneNumber()) + "/";
        myString += Helper.nullStringNullString(dependent.getFatherName()) + "/";
        myString += Helper.nullStringNullString(dependent.getMotherName()) + "/";
        myString += Helper.BooleantoYN(dependent.getemploymentStatus()) + "/";
        myString += Helper.BooleantoYN(dependent.getPrevClaim()) + "/";
        myString += String.valueOf(dependent.getDependentPid()) + "\n";
        return myString;
    }

    private Immigrant setRecordtoImmigrant(String record) {
        Immigrant myImmigrant = new Immigrant();
        int i = 0;
        String StringArray[] = record.split("/", 0);
        // System.err.println("Problem 1 in Immigrant");
        myImmigrant.setFirstName(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 2 in Immigrant");
        myImmigrant.setMiddleName(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 3 in Immigrant");
        myImmigrant.setLastName(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 4 in Immigrant");
        myImmigrant.setAge(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 5 in Immigrant");
        myImmigrant.setBirthMonth(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 6 in Immigrant");
        myImmigrant.setBirthDay(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 7 in Immigrant");
        myImmigrant.setBirthYear(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 8 in Immigrant");
        myImmigrant.setAddress(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 9 in Immigrant");
        myImmigrant.setSSNumber(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 10 in Immigrant");
        myImmigrant.setRace(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 11 in Immigrant");
        myImmigrant.setGender(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 12 in Immigrant");
        myImmigrant.setMarried(Helper.yntoBoolean(StringArray[i++]));
        // System.err.println("Problem 12 in Immigrant");
        myImmigrant.setPhoneNumber(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 13 in Immigrant");
        myImmigrant.setFather(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 14 in Immigrant");
        myImmigrant.setMother(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 15 in Immigrant");
        myImmigrant.setemploymentStatus(Helper.yntoBoolean(StringArray[i++]));
        // System.err.println("Problem 16 in Immigrant");
        myImmigrant.setImmigrantPid(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 17 in Immigrant");
        myImmigrant.setDependentPid(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem result in Immigrant");
        return myImmigrant;
    }

    private Dependent setRecordtoDependent(String record) {
        Dependent myDependent = new Dependent();
        int i = 0;
        String StringArray[] = record.split("/", 0);
        // System.err.println("Problem 1 in Dependent");
        myDependent.setFirstName(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 2 in Dependent");
        myDependent.setMiddleName(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 3 in Dependent");
        myDependent.setLastName(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 4 in Dependent");
        myDependent.setAge(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 5 in Dependent");
        myDependent.setBirthMonth(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 6 in Dependent");
        myDependent.setBirthDay(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 7 in Dependent");
        myDependent.setBirthYear(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 8 in Dependent");
        myDependent.setAddress(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 8 in Dependent");
        myDependent.setSSNumber(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem 9 in Dependent");
        myDependent.setRace(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 10 in Dependent");
        myDependent.setGender(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 11 in Dependent");
        myDependent.setMarried(Helper.yntoBoolean(StringArray[i++]));
        // System.err.println("Problem 12 in Dependent");
        myDependent.setPhoneNumber(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 13 in Dependent");
        myDependent.setFather(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 14 in Dependent");
        myDependent.setMother(Helper.nullStringNull(StringArray[i++]));
        // System.err.println("Problem 15 in Dependent");
        myDependent.setemploymentStatus(Helper.yntoBoolean(StringArray[i++]));
        // System.err.println("Problem 16 in Dependent");
        myDependent.setPrevClaim(Helper.yntoBoolean(StringArray[i++]));
        // System.err.println("Problem 17 in Dependent");
        myDependent.setDependentPid(Integer.parseInt(StringArray[i++]));
        // System.err.println("Problem resutl in Dependent");
        return myDependent;
    }

}