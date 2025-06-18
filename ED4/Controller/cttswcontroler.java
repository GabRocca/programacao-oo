import ed04.dao.ContatoDAO;
import ed04.dao.ContatoDbDAO;
import ed04.entidade.Contato;
import ed04.view.ContatoSwingView;

import java.util.ArrayList;
import java.util.List;

public class ContatoSwingController {

    private final ContatoSwingView view = new ContatoSwingView();
    private final ContatoDAO dao = new ContatoDbDAO();

    public void executar() {
        List<Contato> contatos = new ArrayList<>();
        boolean saida = false;

        do {
            int opt = view.exibirMenu();

            switch (opt) {
                case 0:
                    consultarContatos();
                    break;
                case 1:
                    adicionarPessoaFisica(contatos);
                    break;
                case 2:
                    adicionarPessoaJuridica(contatos);
                    break;
                case 3:
                    view.exibirMensagemDeErro("Funcionalidade nao existe.");
                    break;
                case 4:
                    saida = true;
                    break;
                default:
                    view.exibirMensagemDeErro("Opçao invalida.");
            }
        } while (!saida);
    }

    private void consultarContatos() {
        try {
            List<Contato> contatos = dao.getContatos();
            view.exibirListarContatos(contatos);
        } catch (Exception ex) {
            view.exibirMensagemDeErro("Erro ao acessar os dados: " + ex);
        }
    }

    private void adicionarPessoaFisica(List<Contato> contatos) {
        try {
            Contato contatoPF = view.exibirAdicionarPessoaFisica();
            contatos.add(contatoPF);
            dao.inserir(contatoPF);
        } catch (Exception ex) {
            view.exibirMensagemDeErro("Erro ao adicionar contato: " + ex);
        }
    }

    private void adicionarPessoaJuridica(List<Contato> contatos) {
        try {
            Contato contatoPJ = view.exibirAdicionarPessoaJuridica();
            contatos.add(contatoPJ);
            dao.inserir(contatoPJ);
        } catch (Exception ex) {
            view.exibirMensagemDeErro("Erro ao adicionar contato: " + ex);
        }
    }
}