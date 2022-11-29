package co.com.orange.hrm.automation.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.orange.hrm.automation.utils.ErrorsEnum.NOT_EQUALS;

public class AssertionErrorCustomize extends AssertionError {
    private static final Logger logger = LogManager.getLogger(AssertionErrorCustomize.class);

    public AssertionErrorCustomize(AssertionError error) {
        super(error);
    }

    public AssertionErrorCustomize errorMessage() {
        logger.error(NOT_EQUALS.getErrorMessage() + " - " + this.getCause());
        return this;
    }




}
