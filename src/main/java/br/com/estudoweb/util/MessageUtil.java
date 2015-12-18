package br.com.estudoweb.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MessageUtil {

	public static void newMsg(String message, Severity severity) {
		FacesMessage msg = new FacesMessage(severity, message, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
