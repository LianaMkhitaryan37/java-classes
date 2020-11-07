package com.company.info;

public class AssetDescriptor {
    private String category;
    private String description;
    private final int id;
    private final Date loaned;
    private Date returned;

    public AssetDescriptor(String category, String description, int id, Date loaned) {
        this.category = category;
        this.description = description;
        this.id = id;
        this.loaned = loaned;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Date getLoaned() {
        return loaned;
    }

    public Date getReturned() {
        return returned;
    }

    public void setReturned(Date returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "AssetDescriptor{" +
                "category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", loaned=" + loaned +
                ", returned=" + returned +
                '}';
    }
}
