package com.example.UntitledTestSuite.dataClasses;

public class RepositoryData {
    String name;
    String description;

    public RepositoryData(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }
}
