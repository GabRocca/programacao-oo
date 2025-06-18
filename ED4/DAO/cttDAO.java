import ed04.entidade.Contato;

import java.sql.SQLException;
import java.util.List;

public interface ContatoDAO {
    List<Contato> getContatos() throws Exception;

    void inserir(Contato contato) throws Exception;

    void deletar(Contato contato) throws Exception;

    void atualizar(Contato contato) throws Exception;
}