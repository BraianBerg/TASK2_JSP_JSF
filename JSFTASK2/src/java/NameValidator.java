/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
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
@Named(value = "nameValidator")
@FacesValidator("nameValidator")
public class NameValidator implements Validator {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NameValidator() {
    }

   
    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
     
		String model = (String) arg2;

		if (model.length() < 2) {
			FacesMessage msg = new FacesMessage(
					" Minimum length is 2 characters.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
                if(model.length() > 20){
			FacesMessage msg = new FacesMessage(
					" Maximum length is 20 characters.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
                if(isValidName(model)==false){
                    FacesMessage msg = new FacesMessage(
					"Name should contain only letters");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
                }

	}
 

          private boolean isValidName(String name) {
        String regex = "^[a-zA-Z\\\\s]+";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

    
    
}
