import java.util.Scanner;



public class Main {
	public static void Menu () {
		System.out.println("=== MENU INICIAL ===");
		System.out.println("Digite: (1) Criar Conta; (2) Depósito; (3) Saque; (4) Transferência; (5) Sair; (0) Menu Inicial");
	}
	
		
	
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);

		//Criando um vetor para armazenar dados de até 100 clientes
		Cliente[] vetClientes = new Cliente[100];
		int i = 0; //contador de clientes
		
		//Criando um vetor para armazenar dados de até 100 contas
		Conta[] vetContas = new Conta[100];
		int j = 0; //contador de contas
		
		//Exibe na tela o Menu de opçoes e o cliente informa o que deseja fazer pelo scanner
		Menu();
		int n = scan.nextInt();
		
		while (true) {
			
		if (n == 0) {
			System.out.println("Você digitou: (0) Menu Inicial");
			Menu();
			while (n == 0) {
				n = scan.nextInt();
			}
		}
			else if (n == 1) {
			System.out.println("Você digitou: (1) Criar Conta");
			
				System.out.println("Digite o seu nome:");;
				String nome = scan.next();
				System.out.println("Digite o seu cpf:");;
				String cpf = scan.next();
				vetClientes[i] = new Cliente (nome, cpf);
				i++;
				
				System.out.println("Digite: (1) Criar conta corrente ou (2) Criar conta poupança");
				int conta = scan.nextInt();
				if (conta == 1) {
					vetContas[j] = new ContaCorrente(vetClientes[i-1]);
					System.out.println("Conta corrente criada com sucesso! Sua conta é: ");
					System.out.println("Agência: " + vetContas[j].agencia + " Conta: " + vetContas[j].numero);
					j++;
				} else if (conta == 2) {
					vetContas[j] = new ContaPoupanca(vetClientes[i-1]);
					System.out.println("Conta poupança criada com sucesso!Sua conta é: ");
					System.out.println("Agência: " + vetContas[j].agencia + " Conta: " + vetContas[j].numero);
					j++;
				} else {
					System.out.println("Opção inválida.");
				}
			n=0;
		}
			else if (n == 2){
			System.out.println("Você digitou: (2) Depósito");
			System.out.println("Informe a agência e a conta:");
			int ag = scan.nextInt();
			int cta = scan.nextInt();
			System.out.println("Informe o valor a depositar:");
			int valor = scan.nextInt();
			for (int a=0; a<100; a++) {
				if (vetContas[a].getAgencia() == ag && vetContas[a].getNumero() == cta) {
					vetContas[a].depositar(valor);
					System.out.println("Depósito realizado.");
					break;
				} 
			}
			n=0;
		
		}
			else if (n == 3) {
			System.out.println("Você digitou: (3) Saque");
			System.out.println("Informe a agência e a conta:");
			int ag = scan.nextInt();
			int cta = scan.nextInt();
			System.out.println("Informe o valor a sacar:");
			int valor = scan.nextInt();
			for (int a=0; a<100; a++) {
				if (vetContas[a].getAgencia() == ag && vetContas[a].getNumero() == cta) {
					vetContas[a].sacar(valor);
					System.out.println("Saque realizado.");
					break;
				} 
			}
			n=0;
			
		}
			else if (n == 4) {
			System.out.println("Você digitou: (4) Transferência");
			System.out.println("Informe a agência e a conta de origem:");
			int agOrigem = scan.nextInt();
			int ctaOrigem = scan.nextInt();
			System.out.println("Informe o valor a transferir:");
			int valor = scan.nextInt();
			System.out.println("Informe a agência e a conta de destino:");
			int agDestino = scan.nextInt();
			int ctaDestino = scan.nextInt();
			int idDestino = 0;
			for (int b=0; b<100; b++) {
				if (vetContas[b].getAgencia() == agDestino && vetContas[b].getNumero() == ctaDestino) {
					idDestino = b;
				}
			}
			for (int a=0; a<100; a++) {
				if (vetContas[a].getAgencia() == agOrigem && vetContas[a].getNumero() == ctaOrigem) {
					vetContas[a].transferir(valor, vetContas[idDestino]);
					System.out.println("Transferência realizada.");
					break;
				} 
			}
			n=0;
			
		}
			else if (n == 5) {
			break;
		}
		}
		
		
	}

}
