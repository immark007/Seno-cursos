package Interfaces;

import Execeptions.AlunoNaoEncontrado;

public interface servicesPadrao {
    void criar(String nome, String cpf);
    void alterar(String cpf, String novoNome) throws AlunoNaoEncontrado;
    void deletar(String cpf);
}
