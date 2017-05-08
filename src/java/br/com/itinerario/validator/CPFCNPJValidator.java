package br.com.itinerario.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("CPFCNPJValidator")
public class CPFCNPJValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value != null && value.toString().length() == 14 && DocumentosValidator.isCPF(value.toString()) == false) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido!", null));
        }
        if(value != null && value.toString().length() == 18 && DocumentosValidator.isCNPJ(value.toString()) == false) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CNPJ Inválido!", null));
        }
    }
    
}
