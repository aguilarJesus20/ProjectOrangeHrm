package co.com.orange.hrm.automation.models;

import io.cucumber.datatable.DataTable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VacancyModels {
    private String vacancyName;
    private String jobTitle;
    private String description;
    private String hiringManager;
    private String numberPositions;
    private List<String> table;


}
