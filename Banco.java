import java.util.ArrayList;

public class Banco {
    
    private String nome;

    private ArrayList<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientesPF() {
        ArrayList<Cliente> clientesPF = new ArrayList<>();
        for (Cliente cliente : this.clientes) {
            if (cliente instanceof ClientePF) {
                clientesPF.add(cliente);
            }
        }
        return clientesPF;
    }

    public ArrayList<Cliente> getClientesPJ() {
        ArrayList<Cliente> clientesPJ = new ArrayList<>();
        for (Cliente cliente : this.clientes) {
            if (cliente instanceof ClientePJ) {
                clientesPJ.add(cliente);
            }
        }
        return clientesPJ;
    }

}
