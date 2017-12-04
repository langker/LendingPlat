package me.langker.LendingPlat.Util;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import me.langker.LendingPlat.Dao.ProductDao;

@ManagedBean
@SessionScoped
@FacesValidator("calendarValidator")
public class calendarValidator implements Validator {
	@Inject ProductDao pdao;
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Date dateProduct = (Date)component.getAttributes().get("productdate");
		Date input = (Date)value;
		
		if(input.before(dateProduct)==true) {
			throw new ValidatorException(new FacesMessage("date dont figure in the database"));
		}
	}

	private boolean validateDate(Date date2) {
		return false;
	}

}
