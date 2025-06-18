import ed04.entidade.Contato;
import ed04.entidade.PessoaFisica;
import ed04.entidade.PessoaJuridica;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoCsvDAO implements ContatoDAO {

    @Override
    public List<Contato> getContatos() throws IOException {
        return carregar();
    }

    @Override
    public void inserir(Contato contato) throws IOException {
        salvar(contato);
    }

    @Override
    public void deletar(Contato contato) throws IOException {
        throw new UnsupportedOperationException("Operação de exclusão não suportada para CSV.");
    }

    @Override
    public void atualizar(Contato contato) throws IOException {
        throw new UnsupportedOperationException("Operação de atualização não suportada para CSV.");
    }

    public void salvar(Contato contato) throws IOException {
        
        List<String> lista = new ArrayList<>();
        lista.add(toCsv(contato));

        Path arquivo = Paths.get("contatos.csv");
        if (!Files.exists(arquivo)) {
            Files.createFile(arquivo);
        }

        Files.write(Paths.get("contatos.csv"),
                lista,
                StandardOpenOption.APPEND);
    }

    public void salvar(List<Contato> contatos) throws IOException {
        List<String> lista = new ArrayList<>();
        for (Contato contato : contatos) {
            lista.add(toCsv(contato));
        }

        Path arquivo = Paths.get("contatos.csv");
        if (!Files.exists(arquivo)) {
            Files.createFile(arquivo);
        }

        Files.write(Paths.get("contatos.csv"),
                lista,
                StandardOpenOption.APPEND);

    }

    public List<Contato> carregar() throws IOException {
        List<Contato> contatos = new ArrayList<>();

        Path arquivo = Paths.get("contatos.csv");
        if (Files.exists(arquivo)) {
            List<String> linhas = Files.readAllLines(arquivo);
            for (String linha : linhas) {
                String[] tokens = linha.split(",");
                if (tokens[3].equals("CPF")) {
                    Contato contato = new PessoaFisica(
                            tokens[0], 
                            tokens[1], 
                            tokens[2], 
                            tokens[4]  
                    );
                    contatos.add(contato);
                } else if (tokens[3].equals("CNPJ")) {
                    Contato contato = new PessoaJuridica(
                            tokens[0], 
                            tokens[1], 
                            tokens[2], 
                            tokens[4]  
                    );
                    contatos.add(contato);
                } else {
                    throw new IOException("Documento não é CPF nem CNPJ");
                }
            }
        }
        return contatos;
    }

    private String toCsv(Contato contato) {
        if (contato instanceof PessoaFisica) {
            return toCsv((PessoaFisica) contato);
        } else if (contato instanceof PessoaJuridica) {
            toCsv((PessoaJuridica) contato);
        }

        return contato.getNome()
                + ","
                + contato.getEmail()
                + ","
                + contato.getTelefone()
                + ",N/A,N/A";
    }


    private String toCsv(PessoaFisica contato) {
        return contato.getNome()
                + ","
                + contato.getEmail()
                + ","
                + contato.getTelefone()
                + ",CPF,"
                + contato.getCpf();
    }

    private String toCsv(PessoaJuridica contato) {
        return contato.getNome()
                + ","
                + contato.getEmail()
                + ","
                + contato.getTelefone()
                + ",CNPJ,"
                + contato.getCnpj();
    }


}