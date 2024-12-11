package Modules;

import Interfaces.AddAluno;

import java.util.ArrayList;

public class Courses implements AddAluno{
    private String name;
    private double quantityHours;
    private Teacher teacher;
    private ArrayList<Aluno> alunos;

    public Courses(ArrayList<Aluno> alunos, String name, double quantityHours, Teacher teacher) {
        this.alunos = alunos;
        this.name = name;
        this.quantityHours = quantityHours;
        this.teacher = teacher;
    }

    public ArrayList<Aluno> getAluno() {
        return alunos;
    }

    public void setAluno(ArrayList<Aluno> aluno) {
        this.alunos = aluno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantityHours() {
        return quantityHours;
    }

    public void setQuantityHours(double quantityHours) {
        this.quantityHours = quantityHours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }
}
