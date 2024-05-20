public class Empregado{
    private String name;
    private String cpf;
    private String birth;
    private String password;
    private boolean adm = false;

    public boolean isAdm() {
        return adm;
    }
    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}