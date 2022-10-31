package co.com.orange.hrm.automation.builders;

import co.com.orange.hrm.automation.models.IndexLoginModel;

public class IndexLoginBuilder {
    private String userName;
    private String password;

      public IndexLoginBuilder(String userName) {
        this.userName = userName;
    }

    public static IndexLoginBuilder withName(String name) {
        return new IndexLoginBuilder(name);
    }

    public IndexLoginBuilder andPassword(String password) {
        this.password = password;
        return this;
    }

    public IndexLoginModel buildLogin() {
        return new IndexLoginModel(userName, password);
    }


}
