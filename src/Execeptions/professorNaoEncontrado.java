package Execeptions;

public class professorNaoEncontrado extends RuntimeException{
    public professorNaoEncontrado(String msg){
        super(msg);
    }
}
