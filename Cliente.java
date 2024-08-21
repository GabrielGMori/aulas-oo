public abstract class Cliente {

    private String nome;

    Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getDocumento();
    public abstract void setDocumento(String documento);
}