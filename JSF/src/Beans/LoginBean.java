package Beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/* Hier soll mit Annotationen die LoginBean unter dem Namen "loginBean" dem JSF-Framework bekannt gemacht werden
 *  und festgelegt werden, dass eine Instanz dieser Bean für eine ganze Sitzung besteht */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static ArrayList<StudentBean> liste = new ArrayList<StudentBean>(Arrays.asList(new StudentBean("admin"),new StudentBean("Timm"),new StudentBean("Jonas"),new StudentBean("Kilian"),new StudentBean("Marco"),new StudentBean("Florian"),new StudentBean("Julian"),new StudentBean("Lucas"),new StudentBean("Alexander"),new StudentBean("Philipp"),new StudentBean("Christian"),new StudentBean("Rebecca"),new StudentBean("Carolin"),new StudentBean("Lukas"),new StudentBean("Samuel"),new StudentBean("Sascha"),new StudentBean("Waldemar"),new StudentBean("Roberto"),new StudentBean("Marius"),new StudentBean("Tobias"),new StudentBean("Christoph"),new StudentBean("Dominic")));
	
	//Login-Button
	private UIComponent button;

	
	/* alle nötigen Instanzvariablen deklarieren */
	@ManagedProperty (value="#{studentBean}")
	private StudentBean studentBean;
	
	

	/* alle nötigen Methoden einer JavaBean angeben */
	public StudentBean getStudentBean() {
		return studentBean;
	}
	
	public void setStudentBean(StudentBean studentBean) {
		this.studentBean = studentBean;
	}
	public ArrayList<StudentBean> getListe(){
		return liste;
	}
	
	public void setListe(ArrayList<StudentBean> liste){
		LoginBean.liste = liste;
	}
	public UIComponent getButton() {
		return this.button;
	}

	public void setButton(UIComponent button) {
		this.button = button;
	}
	
	//Beispiel überlegen
	public void changedUser(ValueChangeEvent event) {
		System.out.println("Der Username hat sich in der Eingabe von " + event.getOldValue() + " zu " + event.getNewValue() + " geändert.");
	
	}
	/**/
	public String login() {
		String user="", pw = "";
		
		//suche in der Liste der gespeichterten Nutzer
		for(StudentBean student : liste){
			if(studentBean.getUsername().equals(student.getUsername())){
				user = student.getUsername();
				pw = student.getPassword(); break;
			}
		}
		if (studentBean.getUsername().equals(user) && studentBean.getPassword().equals(pw) && !user.isEmpty()) {
			studentBean.setAngemeldet(true);
			return "/index.xhtml";
		}else{
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(button.getClientId(), new FacesMessage("Username-Passwort-Kombination falsch"));

			return null;
		}
	}
}
