package br.com.estudoweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.estudoweb.domain.Role;
import br.com.estudoweb.service.RoleService;

@Component
public class RoleConverter implements Converter {

	@Autowired
	RoleService roleservice;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String id) {
		try {
			return roleservice.seachWithId(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object objRole) {

		try {
			Role role = (Role) objRole;
			return role.getId().toString();
		} catch (Exception e) {
			return null;
		}

	}

}
