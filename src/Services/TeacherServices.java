package Services;

import Execeptions.AlunoNaoEncontrado;
import Interfaces.servicesPadrao;
import Modules.Teacher;

import java.util.ArrayList;

public class TeacherServices implements servicesPadrao {
    ArrayList<Teacher> teacher;

    public TeacherServices(){
        this.teacher = new ArrayList<>();
    }

    @Override
    public void criar(String nome, String cpf) {
        Teacher professor = new Teacher(nome,cpf);
        teacher.add(professor);
    }

    @Override
    public void alterar(String cpf, String novoNome) throws AlunoNaoEncontrado {
        for(Teacher professor: teacher){
            if(professor.getCpf().equals(cpf)){
                professor.setName(novoNome);
            }
        }

        throw new AlunoNaoEncontrado("Professor não cadastrado");
    }

    @Override
    public void deletar(String cpf) {
        for(Teacher professor: teacher){
            if(professor.getCpf().equals(cpf)){
                teacher.remove(professor);
            }
        }
    }

    public ArrayList<Teacher> listarProfessores(){
        return teacher;
    }
}
