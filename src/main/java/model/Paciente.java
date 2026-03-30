package model;

public class Paciente {

    private String nome;
    private String sexo;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String senha;
    private String caminhoFoto;
    private Endereco endereco;

    public Paciente() {
        this.endereco = new Endereco();
    }

    public Paciente(String nome, String sexo, String cpf, String dataNascimento,
            String telefone, String email, String senha, String caminhoFoto,
            Endereco endereco) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.caminhoFoto = caminhoFoto;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpfNumerico() {
        return cpf == null ? "" : cpf.replaceAll("\\D", "");
    }

    public boolean senhaConfere(String senhaInformada) {
        return senha != null && senha.equals(senhaInformada);
    }

    @Override
    public String toString() {
        return nome == null || nome.isBlank() ? "Paciente sem nome" : nome;
    }
}
