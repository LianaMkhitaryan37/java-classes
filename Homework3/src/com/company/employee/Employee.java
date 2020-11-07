package com.company.employee;

import com.company.info.AssetDescriptor;
import com.company.info.Date;

enum Gender {
    Male,
    Female,
    Other
}

public class Employee {

    public Employee(String name, Date hireDate, int salary, JobInformation info) {
        this.name = name;
        this.hireDate = hireDate;
        setSalary(salary);
        this.info = info;
        this.assets = new AssetDescriptor[maxAssetCount];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 60000) return;
        this.salary = salary;
    }

    public JobInformation getInfo() {
        return info;
    }

    public boolean hasHealthInsurance() {
        return hasHealthInsurance;
    }

    public void setHealthInsurance(boolean hasHealthInsurance) {
        this.hasHealthInsurance = hasHealthInsurance;
    }

    public void setManager(Date effectiveDate, String name) {
        info.setEffectiveDate(effectiveDate);
        info.setReportsTo(name);
    }

    public void receiveAsset(AssetDescriptor asset) {
        if (assetCount < maxAssetCount) {
            assets[assetCount] = asset;
            ++assetCount;
            ++activeAssetCount;
        }
    }

    public void returnLastAsset(Date date) {
        if (activeAssetCount > 0) {
            return;
        }
        assets[assetCount].setReturned(date);
        activeAssetCount--;
    }

    public void returnAsset(Date date, int assetId) {
        for (int i = 0; i < assetCount; ++i) {
            if (assets[i].getId() == assetId) {
                assets[i].setReturned(date);
                --activeAssetCount;
                return;
            }
        }
    }

    public AssetDescriptor[] getActiveAssets() {
        AssetDescriptor[] elems = new AssetDescriptor[activeAssetCount];
        int count = 0;
        for (AssetDescriptor descriptor : assets) {
            if (descriptor != null && descriptor.getReturned() == null) {
                elems[count++] = descriptor;
            }
        }
        return elems;
    }

    public void printJobInformation() {
        System.out.println(info.toString());
    }

    private int assetCount = 0;
    private int activeAssetCount = 0;
    private String name;
    private String lastName;
    private Date birthDate;
    private String eMail;
    private Gender gender;
    private String phoneNumber;
    private Date hireDate;
    private int salary = 60_000;
    private boolean hasHealthInsurance = false;
    private final byte maxAssetCount = 127;
    private AssetDescriptor[] assets;
    private JobInformation info;


}
