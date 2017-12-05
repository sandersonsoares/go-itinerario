
package principal;

import br.com.itinerario.enums.Estados;
import br.com.itinerario.enums.Permissoes;
import br.com.itinerario.enums.Sexo;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Endereco;
import br.com.itinerario.model.Grupo;
import br.com.itinerario.model.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanderson
 */
public class Main {

    public static void main(String[] args) {
        Facade fachada = new Facade();
        
        Endereco endereco = new Endereco();
        endereco.setCep("58704310");
        endereco.setBairro("Belo Horizonte");
        endereco.setCidade("Patos");
        endereco.setEstado(Estados.PARAIBA);
        endereco.setLogradouro("Rua Luiz José");
        endereco.setNumero(624);
        
        Usuario user = new Usuario();
        user.setCpf("888.888.888-88");
        user.setDataNascimento(new Date());
        user.setEmail("admin@admin.com");
        user.setEndereco(endereco);
        
        List<Permissoes> permissoes = new ArrayList<>();
        for (Permissoes p : Permissoes.values()) {
            permissoes.add(p);
        }
        
        Grupo gp = new Grupo();
        gp.setTitulo("Administradores");
        gp.setPermissoes(permissoes);
        
        user.setGrupo(gp);
        user.setNome("Administrador");
        user.setSenha("@dmin456");
        user.setSexo(Sexo.MASCULINO);
        user.setTelefone("(83) 9999-9999");
        user.setStatus(true);
        user.setUsername("admin");
        
        try {
            fachada.cadastrarUsuario(user);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
