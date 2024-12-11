package Services;

import Execeptions.AlunoNaoEncontrado;
import Execeptions.NotFoundAlunos;
import Interfaces.servicesPadrao;
import Modules.Aluno;

import java.util.ArrayList;

public class AlunoServices implements servicesPadrao {
    private ArrayList<Aluno> alunos;

    public AlunoServices(){
        this.alunos = new ArrayList<>();
    }

    public ArrayList<Aluno> listarAlunos() throws NotFoundAlunos {
        if(alunos.isEmpty()){
            throw new NotFoundAlunos("A lista de alunos está vazia");
        }

        return alunos;
    }

    @Override
    public void criar(String nome, String cpf) {
        Aluno aluno = new Aluno(nome, cpf);
        alunos.add(aluno);
    }

    @Override
    public void alterar(String cpf, String novoNome) throws AlunoNaoEncontrado {
        for(Aluno aluno: alunos){
            if(aluno.getCpf().equals(cpf)){
                aluno.setName(novoNome);
                return;
            }
        }
        throw new AlunoNaoEncontrado("Aluno com o cpf: " + cpf + " não encontrado");
    }

    @Override
    public void deletar(String cpf) {
        for(Aluno aluno: alunos){
            if(aluno.getCpf().equals(cpf)){
                alunos.remove(aluno);
            }
        }
    }
}
