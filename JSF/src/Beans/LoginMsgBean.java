package Beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginMsgBean {

	private UIComponent component;

	public UIComponent getComponent() {
		return component;
	}

	public void setComponent(UIComponent component) {
		this.component = component;
	}

	/*
	public String sendMessage() {

		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(component.getClientId(), new FacesMessage("Username-Passwort-Kombination falsch"));

		return "";
	}
	*/
}
