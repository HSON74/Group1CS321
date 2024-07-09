package org.openjfx.Workflow;

import io.github.pixee.security.BoundedLineReader;
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
    private String dataNameForImmigrant = null; // The immigrant record the system current accessing.
    private String dataNameForDependent = null; // The dependent record the system current accessing.

    // protected class & variable.
    protected ArrayList<Immigrant> databaseFormsImmigrant; // The immigrant record the database.
    protected ArrayList<Dependent> databaseFormsDependent; // The dependent record the database.

    /*
     * Inital the table by create a table or access
     * the table if the table exist.
     */
    public Database(String databaseNameImmigrant, String databaseNameDependent) {
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
        try {
            // Access to the immgrint record and create a temp database array for
            // application.
            File datafile = new File(this.dataNameForImmigrant);
            Scanner scr;
            this.databaseFormsImmigrant = new ArrayList<Immigrant>();
            if (datafile.exists()) {
                scr = new Scanner(datafile);
                while (scr.hasNext()) {
                    String mystring = scr.nextLine();
                    Immigrant tempImmigrantForm = setRecordtoImmigrant(mystring);
                    this.databaseFormsImmigrant.add(tempImmigrantForm);
                }
                scr.close();
            } else {
                datafile.createNewFile();
                // BufferedWriter writer = new BufferedWriter(new FileWriter(datafile));
                System.err.println("File Exist not exist");
                // writer.close();
            }
            // Access to the dependent record and create a temp database array for
            // application.
            Scanner dscr;
            File datafiled = new File(this.dataNameForDependent);
            this.databaseFormsDependent = new ArrayList<Dependent>();
            if (datafiled.exists()) {
                dscr = new Scanner(datafiled);
                while (dscr.hasNext()) {
                    String mystring = dscr.nextLine();
                    Dependent tempDependentForm = setRecordtoDependent(mystring);
                    this.databaseFormsDependent.add(tempDependentForm);
                }
                dscr.close();
            } else {
                datafiled.createNewFile();
                // BufferedWriter dwriter = new BufferedWriter(new FileWriter(datafiled));
                // dscr = new Scanner(datafiled);
                System.err.println("File Exist not exist");
                // dwriter.close();
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    /*
     * A method for the add datas from From class format
     * into the system record.
     */
    public boolean addData(Form form) {

        if (form == null) {
            System.err.println("Error no form is pass in.");
            return false;
        }
        if (form.getImmigrant() == null || form.getDependent() == null) {
            System.err.println("Error form is pass in. Have not Immigrant or Dependent Information");
            return false;
        }
        return saveData(form);
    }

    // Check the data are in system.
    public String checkData(int iPID, int dPID) {
        Immigrant myImmigrant = getDataImmigrant(iPID);
        Dependent myDependent = getDataDependent(dPID);
        if (myImmigrant == null && myDependent == null) {
            return "both is not system";
        } else if (myImmigrant == null) {
            return "Immigrant is not system";

        } else if (myDependent == null) {
            return "Dependent is not system";
        } else {
            return "Information need update";
        }
    }

    /*
     * The method will search the the Database froms for
     * immigrant using the integer variable iPID, which
     * is immigrant Pid.
     */
    public Immigrant getDataImmigrant(int iPID) {
        if (this.databaseFormsImmigrant == null) {
            return null;
        }
        Immigrant result = null;
        for (int i = 0; i < this.databaseFormsImmigrant.size(); i++) {
            if (this.databaseFormsImmigrant.get(i).getImmigrantPid() == iPID) {
                result = this.databaseFormsImmigrant.get(i);
                break;
            }
        }
        return result;
    }

    /*
     * The method will search the the Database froms for
     * dependent using the integer variable iPID, which
     * is dependent Pid.
     */
    public Dependent getDataDependent(int iPID) {
        if (this.databaseFormsDependent == null) {
            return null;
        }
        Dependent result = null;
        for (int i = 0; i < this.databaseFormsDependent.size(); i++) {
            if (this.databaseFormsDependent.get(i).getDependentPid() == iPID) {
                result = this.databaseFormsDependent.get(i);
                break;
            }
        }
        return result;
    }

    /*
     * A method for remove the immigrant information for the
     * the system application record (SAR).
     */
    public boolean removeImmigrant(int pid) {
        ArrayList<Immigrant> temp = new ArrayList<Immigrant>();
        boolean result = false;
        for (int j = 0; j < this.databaseFormsImmigrant.size(); j++) {
            if (this.databaseFormsImmigrant.get(j).getImmigrantPid() == pid) {
                updateLine("", dataNameForImmigrant, j + 1, 'd');
                result = true;
            } else {
                temp.add(this.databaseFormsImmigrant.get(j));
            }
        }
        this.databaseFormsImmigrant.clear();
        this.databaseFormsImmigrant = temp;
        return result;
    }

    /*
     * A method for remove the dependent information for the
     * the system application record (SAR).
     */
    public boolean removeDependent(int pid) {
        ArrayList<Dependent> temp = new ArrayList<Dependent>();
        boolean result = false;
        for (int j = 0; j < this.databaseFormsDependent.size(); j++) {
            if (this.databaseFormsDependent.get(j).getDependentPid() == pid) {
                updateLine("", dataNameForDependent, j + 1, 'd');
                result = true;
            } else {
                temp.add(this.databaseFormsDependent.get(j));
            }
        }
        this.databaseFormsDependent.clear();
        this.databaseFormsDependent = temp;
        return result;
    }

    /*
     * A method for update the immigrant information in
     * the system application record (SAR).
     */
    public boolean updateImmigrant(Immigrant immigrant) {
        if (immigrant == null || this.databaseFormsImmigrant == null) {
            return false;
        }
        ArrayList<Immigrant> temp = new ArrayList<Immigrant>();
        boolean result = false;
        for (int j = 0; j < this.databaseFormsImmigrant.size(); j++) {
            if (this.databaseFormsImmigrant.get(j).getImmigrantPid() == immigrant.getImmigrantPid()
                    || immigrant.getSSNumber() == this.databaseFormsImmigrant.get(j).getSSNumber()) {
                String newLine = setImmigranttoRecord(immigrant);
                updateLine(newLine, this.dataNameForImmigrant, j + 1, 'u');
                temp.add(immigrant);
                result = true;
            } else {
                temp.add(this.databaseFormsImmigrant.get(j));
            }
        }
        this.databaseFormsImmigrant.clear();
        this.databaseFormsImmigrant = temp;
        return result;
    }

    /*
     * A method for update the dependent information in
     * the system application record (SAR).
     */
    public boolean updateDependent(Dependent dependent) {
        System.out.println("It working");
        if (dependent == null || this.databaseFormsDependent == null) {
            return false;
        }
        System.out.println("It working 1");
        ArrayList<Dependent> temp = new ArrayList<Dependent>();
        boolean result = false;
        System.out.println("It working");
        for (int j = 0; j < this.databaseFormsDependent.size(); j++) {
            if (this.databaseFormsDependent.get(j).getDependent().getDependentPid() == dependent.getDependentPid()
                    || dependent.getSSNumber() == this.databaseFormsDependent.get(j).getSSNumber()) {
                String newLine = setDependenttoRecord(dependent);
                updateLine(newLine, dataNameForDependent, j + 1, 'u');
                temp.add(dependent);
                System.out.println("It working");
                result = true;
            } else {
                temp.add(this.databaseFormsDependent.get(j));
            }
        }
        this.databaseFormsDependent.clear();
        this.databaseFormsDependent = temp;
        return result;
    }

    /*
     * The method will search the the Database froms for
     * immigrant using the integer variable social security number, which
     * is immigrant social security number.
     */
    // private Immigrant getDataImmigrantSSN(int sSNumber) {
    // if (databaseFormsImmigrant == null) {
    // return null;
    // }
    // for (int i = 0; i < databaseFormsImmigrant.size(); i++) {
    // if (databaseFormsImmigrant.get(i).getSSNumber() == sSNumber) {
    // return databaseFormsImmigrant.get(i);
    // }
    // }
    // return null;
    // }

    /*
     * The method will search the the Database froms for
     * Dependent using the integer variable social security number, which
     * is Dependent social security number.
     */
    // private Dependent getDataDependentSSN(int sSNumber) {
    // if (databaseFormsDependent == null) {
    // return null;
    // }
    // for (int i = 0; i < databaseFormsDependent.size(); i++) {
    // if (databaseFormsDependent.get(i).getSSNumber() == sSNumber) {
    // return databaseFormsDependent.get(i);
    // }
    // }
    // return null;
    // }

    /*
     * A method that save if the form information don't exist in the system.
     */
    protected boolean saveData(Form inputForm) {
        if (inputForm.getDependent() == null || inputForm.getImmigrant() == null) {
            return false;
        }
        Immigrant iForm = inputForm.getImmigrant();
        Dependent dForm = inputForm.getDependent();
        String status = checkData(iForm.getImmigrantPid(), dForm.getDependentPid());

        if (status.equalsIgnoreCase("both is not system")) {
            dForm.setPrevClaim(true);
            iForm.setDependentPid(dForm.getDependentPid());
            this.databaseFormsImmigrant.add(iForm);
            this.databaseFormsDependent.add(dForm);
            addImmigrantToData(iForm);
            addDependentToData(dForm);
        } else if (status.equalsIgnoreCase("Information need update")) {
            if ((dForm = getDataDependent(dForm.getDependentPid())) != null
                    && (iForm = getDataImmigrant(dForm.getImmigrantPid())) != null) {
                Dependent tempDform = getDataDependent(dForm.getDependentPid());
                if (tempDform.getPrevClaim() && !dForm.getPrevClaim()) {
                    return false;
                }
                dForm.setPrevClaim(true);
                iForm.setDependentPid(dForm.getDependentPid());
                updateImmigrant(iForm);
                updateDependent(dForm);
            }
        } else if (status.equalsIgnoreCase("Immigrant is not system")) {
            Dependent tempDform = getDataDependent(dForm.getDependentPid());
            if (tempDform != null) {
                if (tempDform.getPrevClaim() && !dForm.getPrevClaim()) {
                    return false;
                }
                dForm.setPrevClaim(true);
                iForm.setDependentPid(dForm.getDependentPid());
                this.databaseFormsImmigrant.add(iForm);
                addImmigrantToData(iForm);
                updateDependent(dForm);
            }
        } else if (status.equalsIgnoreCase("Dependent is not system")) {
            if ((iForm = getDataImmigrant(dForm.getImmigrantPid())) != null) {
                dForm.setPrevClaim(true);
                iForm.setDependentPid(dForm.getDependentPid());
                this.databaseFormsDependent.add(dForm);
                updateImmigrant(iForm);
                addDependentToData(dForm);
            }
        } else {
            return false;
        }
        return true;

    }

    /*
     * A private method that really add the immigrant
     * information in to the system.
     */
    private boolean addImmigrantToData(Immigrant immigrantForm) {

        String dataStringImmigrant = setImmigranttoRecord(immigrantForm);
        try {
            Files.write(Paths.get(this.dataNameForImmigrant),
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
            Files.write(Paths.get(this.dataNameForDependent),
                    dataStringDependent.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
     * A method for remove or update immigrant information to
     * the system application record (SAR).
     */
    private void updateLine(String lineChange, String databaseFile, int changeline, char command) {
        String tempFileString = "./src/main/java/org/openjfx/Database/temp.txt";
        File oldFile = new File(databaseFile);
        File newFile = new File(tempFileString);
        int line = 0;
        String currentLine;
        try {
            FileWriter fw = new FileWriter(tempFileString, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(databaseFile);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = BoundedLineReader.readLine(br, 5_000_000)) != null) {
                ++line;
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
            if (!oldFile.delete()) {
                System.err.println(databaseFile + " don't exist");
            }
            File dump = new File(databaseFile);
            newFile.renameTo(dump);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /* */
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
        String stringArray[] = record.split("/", 0);
        myImmigrant.setFirstName(Helper.nullStringNull(stringArray[i++]));
        myImmigrant.setMiddleName(Helper.nullStringNull(stringArray[i++]));
        myImmigrant.setLastName(Helper.nullStringNull(stringArray[i++]));

        myImmigrant.setAge(Integer.parseInt(stringArray[i++]));

        myImmigrant.setBirthMonth(Integer.parseInt(stringArray[i++]));

        myImmigrant.setBirthDay(Integer.parseInt(stringArray[i++]));

        myImmigrant.setBirthYear(Integer.parseInt(stringArray[i++]));

        myImmigrant.setAddress(Helper.nullStringNull(stringArray[i++]));

        myImmigrant.setSSNumber(Integer.parseInt(stringArray[i++]));

        myImmigrant.setRace(Helper.nullStringNull(stringArray[i++]));

        myImmigrant.setGender(Helper.nullStringNull(stringArray[i++]));

        myImmigrant.setMarried(Helper.yntoBoolean(stringArray[i++]));

        myImmigrant.setPhoneNumber(Helper.nullStringNull(stringArray[i++]));

        myImmigrant.setFather(Helper.nullStringNull(stringArray[i++]));

        myImmigrant.setMother(Helper.nullStringNull(stringArray[i++]));
        myImmigrant.setemploymentStatus(Helper.yntoBoolean(stringArray[i++]));
        myImmigrant.setImmigrantPid(Integer.parseInt(stringArray[i++]));
        myImmigrant.setDependentPid(Integer.parseInt(stringArray[i++]));
        return myImmigrant;
    }

    private Dependent setRecordtoDependent(String record) {
        Dependent myDependent = new Dependent();
        int i = 0;
        String stringArray[] = record.split("/", 0);
        myDependent.setFirstName(Helper.nullStringNull(stringArray[i++]));
        myDependent.setMiddleName(Helper.nullStringNull(stringArray[i++]));
        myDependent.setLastName(Helper.nullStringNull(stringArray[i++]));
        myDependent.setAge(Integer.parseInt(stringArray[i++]));
        myDependent.setBirthMonth(Integer.parseInt(stringArray[i++]));
        myDependent.setBirthDay(Integer.parseInt(stringArray[i++]));
        myDependent.setBirthYear(Integer.parseInt(stringArray[i++]));
        myDependent.setAddress(Helper.nullStringNull(stringArray[i++]));
        myDependent.setSSNumber(Integer.parseInt(stringArray[i++]));
        myDependent.setRace(Helper.nullStringNull(stringArray[i++]));
        myDependent.setGender(Helper.nullStringNull(stringArray[i++]));

        myDependent.setMarried(Helper.yntoBoolean(stringArray[i++]));

        myDependent.setPhoneNumber(Helper.nullStringNull(stringArray[i++]));

        myDependent.setFather(Helper.nullStringNull(stringArray[i++]));

        myDependent.setMother(Helper.nullStringNull(stringArray[i++]));

        myDependent.setemploymentStatus(Helper.yntoBoolean(stringArray[i++]));

        myDependent.setPrevClaim(Helper.yntoBoolean(stringArray[i++]));

        myDependent.setDependentPid(Integer.parseInt(stringArray[i++]));

        return myDependent;
    }

}
