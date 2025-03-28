
    import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Contato[] contato = new Contato[10];

        int numContatos = 0;


        while(true){
                System.out.println("[1] Adicionar contato");
                System.out.println("[2] Buscar contato");
                System.out.println("[3] Editar contato");
                System.out.println("[4] Excluir contato");
                System.out.println("[5] Listar contatos");
                System.out.println("[6] Sair");
                int opcao = input.nextInt();

                /* Limpa o buffer do teclado */
                input.nextLine();

                switch(opcao){
                    /* Adicionar contato */
                    case 1:
                        while(true) {
                            System.out.print("Informe nome: ");
                            String nome = input.nextLine();
                            System.out.print("Informe telefone: ");
                            String telefone = input.nextLine();
                            if(nome.equals("") || telefone.equals("")) {
                                System.out.println("Um dos campos foi inserido sem nenhum valor!");
                            }else {
                                contato[numContatos] = new Contato(nome, telefone);

                                System.out.println("Contato cadastrado com sucesso!\n");
                                numContatos++;
                                break;
                            }
                        }
                        break;

                    /* Buscar contato */
                    case 2:
                        System.out.println("Digite o nome do contato:");
                        String nomeBuscar = input.nextLine();
                        if(nomeBuscar.equals("")){
                            System.out.println(" Nenhum nome de contato digitado!");
                        }else{
                            buscarContato(nomeBuscar, contato);
                        }

                        break;

                    /* Editar contato */
                    case 3:
                        System.out.println("Digite o nome do contato que deseja editar:");
                        String nomeEditar = input.nextLine();
                        if(nomeEditar.equals("")){
                            System.out.println(" Nenhum nome de contato digitado!");
                        }else{
                            editarContato(nomeEditar, contato);
                        }
                        break;

                    /* Excluir contato */
                    case 4:
                        System.out.println("Digite o nome do contato que deseja excluir:");
                        String nomeExcluir = input.nextLine();
                        if(nomeExcluir.equals("")){
                            System.out.println(" Nenhum nome de contato digitado!");
                        }else {
                            excluirContato(nomeExcluir, contato, numContatos);
                            numContatos--;
                        }
                        break;

                    /* Listar contatos */
                    case 5:

                        for(int i = 0; i < numContatos; i++){
                            System.out.println("Contato: " + (i + 1));
                            System.out.println("Nome: " + contato[i].getNome());
                            System.out.println("Telefone: " + contato[i].getNumero());
                        }

                        break;

                    /* Sair */
                    case 6:
                        input.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opcao invalida!\n");
                }
            }
        }

    public static void buscarContato(String nomeBuscar, Contato[] contatos){
        int numContatos = 0;
        for(Contato contatoTemp : contatos){
            if(contatoTemp.getNome().equals(nomeBuscar)){
                System.out.println("Numero: " + numContatos);
                System.out.println("Nome: " + contatoTemp.getNome());
                System.out.println("Telefone " + contatoTemp.getNumero());

                return;
            }
            numContatos++;
        }
        System.out.println("Contato nao encontrado!");
    }

    public static void editarContato(String nomeBuscar, Contato[] contatos){
        Scanner input = new Scanner(System.in);
        for(Contato contatoTemp : contatos){
            if(contatoTemp.getNome().equals(nomeBuscar)){
                while(true){
                System.out.println("Digite o novo numero para o contato: ");
                String novoNumero = input.nextLine();
                if(novoNumero.equals("")){
                    System.out.println(" Nenhum numero para contato digitado!");
                }else{
                    contatoTemp.setNumero(novoNumero);
                    break;
                }
                }
                return;
            }
        }
        System.out.println("Contato nao encontrado!");
    }

    public static void excluirContato(String nomeBuscar, Contato[] contatos, int numContatos){
        int numeroTempEx = 0;
        for(int i = 0; i <= numContatos; i++){
            if(contatos[i].getNome().equals(nomeBuscar)){
                contatos[i].setNome(null);
                for(int j = numeroTempEx; j < numContatos; j++){
                    if(contatos[j+1] != null) {
                        contatos[j].setNome(contatos[j + 1].getNome());
                        contatos[j].setNumero(contatos[j + 1].getNumero());
                        contatos[j+1].setNome(null);
                        contatos[j+1].setNumero("");
                    }else{
                        return;
                    }
                }
                return;
            }
            numeroTempEx++;
        }
        System.out.println("Contato nao encontrado!");
    }
}

    class Contato{
        private String nome;
        private String numero;

        public Contato(String nome, String numero){
            this.nome = nome;
            this.numero = numero;
        }

        public String getNumero(){
            return this.numero;
        }

        public void setNumero(String numero){
            this.numero = numero;
        }

        public void setNome(String nome){
            this.nome = nome;
        }

        public String getNome(){
            return nome;
        }
    }
