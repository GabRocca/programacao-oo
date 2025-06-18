import ed04.dao.ContatoDAO;
import ed04.dao.ContatoDbDAO;
import ed04.entidade.Contato;
import ed04.dao.ContatoCsvDAO;
import ed04.view.ContatoView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContatoController {
    private final ContatoView view = new ContatoView();
    private final ContatoDAO dao = new ContatoDbDAO();

    public void executar() {
        List<Contato> contatos = new ArrayList<>();

        boolean saida = false;
        do {
            view.exibirMenu();
            int opt = view.lerOpcao();

            switch (opt) {
                case 1:
                    consultarContatos();
                    break;
                case 2:
                    adicionarPessoaFisica(contatos);
                    break;
                case 3:
                    adicionarPessoaJuridica(contatos);
                    break;
                case 4:
                    break;
                case 5:
                    saida = true;
                    break;
                default:
                    view.exibirMensagemDeErro("Opcao invalida");
            }

        } while (!saida);
    }

    private void consultarContatos() {
        try {
            List<Contato> contatos = dao.getContatos();
            view.exibirListarContatos(contatos);
        }
        catch (SecurityException ex) {
            view.exibirMensagemDeErro("Impossível acessar arquivo: " + ex);
        }
        catch (IOException ex) {
            view.exibirMensagemDeErro("Erro ao abrir o arquivo: " + ex);
        } catch (Exception ex) {
            view.exibirMensagemDeErro("Erro ao acessar os dados: " + ex);
        } finally {
            
        }
    }

    private void adicionarPessoaFisica(List<Contato> contatos) {
        try {
            Contato contatoPF = view.exibirAdicionarPessoaFisica();
            contatos.add(contatoPF);
            dao.inserir(contatoPF);
        }
        catch (Exception ex) {
            view.exibirMensagemDeErro("Erro ao abrir o arquivo: " + ex.toString());
        }
    }

    private void adicionarPessoaJuridica(List<Contato> contatos) {
        try {
            Contato contatoPJ = view.exibirAdicionarPessoaJuridica();
            contatos.add(contatoPJ);
            dao.inserir(contatoPJ);
        }
        catch (Exception ex) {
            view.exibirMensagemDeErro("Erro ao abrir o arquivo: " + ex.toString());
        }
    }

}