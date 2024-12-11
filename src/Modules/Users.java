package Modules;

public abstract class Users {
    private String name;
    private String cpf;

    public Users(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
