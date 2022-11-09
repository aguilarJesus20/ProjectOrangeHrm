package co.com.orange.hrm.automation.builders;

import co.com.orange.hrm.automation.models.VacancyModels;

import java.util.List;

public class DataVacancyBuilder {
    private String vacancyName;
    private String jobTitle;
    private String description;
    private String hiringManager;
    private String numberPositions;
    private List<String> vacancy;


    public DataVacancyBuilder(List<String> vacancy) {
        this.vacancy = vacancy;
    }

    public static DataVacancyBuilder withVacancy(List<String> vacancy) {
        return new DataVacancyBuilder(vacancy);
    }


    public DataVacancyBuilder withVacancyName() {
        this.vacancyName = vacancy.get(0);
        return this;
    }

    public DataVacancyBuilder withJobTitle() {
        this.jobTitle = vacancy.get(1);
        return this;
    }
    public DataVacancyBuilder withDescription() {
        this.description = vacancy.get(2);
        return this;
    }
    public DataVacancyBuilder withHiringManager() {
        this.hiringManager = vacancy.get(3);
        return this;
    }
    public DataVacancyBuilder withNumberPositions() {
        this.numberPositions = vacancy.get(4);
        return this;
    }

    public VacancyModels buildVacancyData() {
        return new VacancyModels(vacancyName, jobTitle, description, hiringManager, numberPositions,vacancy);
    }


}
