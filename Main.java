import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Banco banco = new Banco("Banco do Brasil");
        
        System.out.println("Digite o nome");
        String nome = scan.nextLine();
        System.out.println("Digite o cpf");
        String cpf = scan.nextLine();

        ClientePF clientPF = new ClientePF(nome, cpf);
        banco.addCliente(clientPF);

        System.out.println("Digite o nome");
        String empresa = scan.nextLine();
        System.out.println("Digite o cnpj");
        String cnpj = scan.nextLine();

        ClientePJ clientePJ = new ClientePJ(empresa, cnpj);
        banco.addCliente(clientePJ);

        System.out.print("\n");

        ArrayList<Cliente> clientes = banco.getClientes();
        System.out.println(banco.getNome() + " - Todos os clientes");
        System.out.println(toStringClientes(clientes) + "\n");

        ArrayList<Cliente> clientesPF = banco.getClientesPF();
        System.out.println(banco.getNome() + " - Clientes Pessoa Física");
        System.out.println(toStringClientes(clientesPF) + "\n");

        ArrayList<Cliente> clientesPJ = banco.getClientesPJ();
        System.out.println(banco.getNome() + " - Clientes Pessoa Jurídica");
        System.out.println(toStringClientes(clientesPJ) + "\n");

    }

    public static String toStringClientes(ArrayList<Cliente> clientes) {
        String stringClientes = "--------------------\n";
        for (Cliente cliente : clientes) {
            stringClientes = stringClientes + "Nome: " + cliente.getNome() + "\n";
            if (cliente instanceof ClientePF) {
                stringClientes = stringClientes + "CPF: ";
            } else {
                stringClientes = stringClientes + "CNPJ: ";
            }
            stringClientes = stringClientes + cliente.getDocumento() + "\n";

            stringClientes = stringClientes + "--------------------\n";
        }
        return stringClientes;
    }

}
