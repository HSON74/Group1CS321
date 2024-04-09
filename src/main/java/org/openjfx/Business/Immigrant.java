package org.openjfx.Business;

public class Immigrant extends Person {
    private int ImmigrantPid;
    private int DependentPid; // references the dependent to claim
    private Dependent dependent;
    public Dependent getDependent() {
        this.dependent = new Dependent();
        return dependent;
    }

    public void newDependent() {

    }

    public boolean addDependent(Dependent dependent) {
        return true;
    }

    public boolean removeDependent(Dependent dependent) {
        return true;
    }

    /*
     * Setter and Getter Methods for the Immigrant class
     * that extends from the person class.
     */
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public void setMiddleName(String mName) {
        this.middleName = mName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setSSNumber(int ssnumber) {
        this.ssnumber = ssnumber;
    }

    public void setImmigrantPid(int pid) {
        this.ImmigrantPid = pid;
    }

    public void setDependentPid(int dependentPid) {
        this.DependentPid = dependentPid;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFather(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMother(String motherName) {
        this.motherName = motherName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setemploymentStatus(boolean employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    // ..............getter methods................

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getbirthMonth() {
        return birthMonth;
    }

    public int getbirthDay() {
        return birthDay;
    }

    public int getbirthYear() {
        return birthYear;
    }

    public int getSSNumber() {
        return ssnumber;
    }

    public int getImmigrantPid() {
        return ImmigrantPid;
    }

    public int getDependentPid() {
        return DependentPid;
    }

    public String getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public boolean getMarriedStatus() {
        return married;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getAddress() {
        return address;
    }

    public boolean getemploymentStatus() {
        return employmentStatus;
    }
}
