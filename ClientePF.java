public class ClientePF extends Cliente {
    
    private String cpf;

    public ClientePF(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return this.cpf;
    }

    @Override
    public void setDocumento(String cpf) {
        this.cpf = cpf;
    }
}
