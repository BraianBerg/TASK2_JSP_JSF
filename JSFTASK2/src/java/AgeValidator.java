/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author braia
 */
@ManagedBean
@Named(value = "ageValidator")
@FacesValidator("ageValidator")
public class AgeValidator implements Validator {

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public AgeValidator() {
    }
    
    
    
    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
       String uiage = (String) arg2;
       if (isValidAge(uiage) == false) {
			FacesMessage msg = new FacesMessage(
					" Age should contain only numbers");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
        if (Integer.parseInt(uiage) < 1) {
			FacesMessage msg = new FacesMessage(
					"Age can not be under 1 year");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
        if (Integer.parseInt(uiage) > 125) {
			FacesMessage msg = new FacesMessage(
					"You can not be older than 125");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
        
        
    }
    
    
    private boolean isValidAge(String age) {
        String regex = "\\d+";
        Pattern p = Pattern.compile(regex);
        if (age == null) {
            return false;
        }
        Matcher m = p.matcher(age);
        return m.matches();
    }

    
}
