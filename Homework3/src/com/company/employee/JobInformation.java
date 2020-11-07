package com.company.employee;

import com.company.info.Date;

public class JobInformation {
    public JobInformation(Date effectiveDate, String location, String division, String department, String jobTitle, String reportsTo) {
        this.effectiveDate = effectiveDate;
        this.location = location;
        this.division = division;
        this.department = department;
        this.jobTitle = jobTitle;
        this.reportsTo = reportsTo;
    }

    @Override
    public String toString() {
        return "JobInformation{" +
                "effectiveDate=" + effectiveDate +
                ", location='" + location + '\'' +
                ", division='" + division + '\'' +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", reportsTo='" + reportsTo + '\'' +
                '}';
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDivision() {
        return division;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    private Date effectiveDate;
    private String location;
    private String division;
    private String department;
    private String jobTitle;
    private String reportsTo;
}
