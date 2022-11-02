package co.com.orange.hrm.automation.models;

import java.util.List;
import java.util.Map;

public class VacancyDataTable {
    private List<Map<String, String>> data;

    public List<Map<String, String>> getData() {
        return data;
    }

    public VacancyDataTable(List<Map<String, String>> data) {
        this.data = data;
    }

    public String getVacancyName() {
        return data.get(0).get("vacancyName");

    }

    public String getJobTitle() {
        return data.get(0).get("jobTitle");
    }

    public String getDescription() {
        return data.get(0).get("description");
    }

    public String getHiringManager() {
        return data.get(0).get("hiringManager");
    }

    public String getNumberPosition() {
        return data.get(0).get("numberPositions");
    }


}
