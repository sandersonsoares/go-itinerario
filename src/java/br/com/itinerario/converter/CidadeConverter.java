package br.com.itinerario.converter;

import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cidade.class, value = "CidadeConverter")
public class CidadeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        try {
            DaoGeneric dao = DAOFactory.createCidadeDAO();
            return dao.getById(Long.parseLong(arg2));
        } catch (Exception e) {
            throw new ConverterException("Objeto não encontrado!");
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if (arg2 != null) {
            Cidade cidade = (Cidade) arg2;
            return String.valueOf(cidade.getId());
        }
        return "";
    }
}
