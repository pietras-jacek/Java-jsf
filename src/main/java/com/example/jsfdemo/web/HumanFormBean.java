package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Human;
import com.example.jsfdemo.service.AdminManager;

@SessionScoped
@Named("humanBean")
public class HumanFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Human human1 = new Human();

	private ListDataModel<Human> human = new ListDataModel<Human>();

	@Inject
	private AdminManager pm;

	public Human getHuman() {
		return human1;
	}

	public void setHuman(Human human) {
		this.human1 = human;
	}

	public ListDataModel<Human> getAllHumans() {
		human1.setWrappedData(pm.getAllHumans());
		return human;
	}

	// Actions
	public String addHuman() {
		pm.addHuman(human1);
		return "showHumans";
		//return null;
	}

	public String deleteHuman() {
		Human humanToDelete = human.getRowData();
		pm.deleteHuman(humanToDelete);
		return null;
	}

	// Validators

	// Business logic validation
	public void uniquePesel(FacesContext context, UIComponent component,
			Object value) {

		String pesel = (String) value;

		for (Human human : pm.getAllHumans()) {
			if (human.getPesel().equalsIgnoreCase(pesel)) {
				FacesMessage message = new FacesMessage(
						"osoba z tym numerem pesle już istnieje w bazie");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}