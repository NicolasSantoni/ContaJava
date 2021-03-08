package nicolass63b;

import java.util.Scanner;

/**
 *
 * @author Nicolas S
 */
public class Banco {
    public static void main(String[] args) {
        Scanner lerDados = new Scanner(System.in);
        ContaCorrente[] cc = new ContaCorrente[10];
        ContaPoupanca[] cp = new ContaPoupanca[10];
        int op;
        int opC;
        int contC = 0;
        int contP = 0;
        int cont = 0;
        String nomeBanco;
        int agencia;
        do {            
            System.out.print("Indique a opção desejada:\n1 - Criar conta corrente\n2 - Criar conta poupança\n3 - Acessar conta corrente\n4 - Acessar conta poupança\n5 - Sair\n");
            op = lerDados.nextInt();
            if (op==1) {
                cc[contC] = new ContaCorrente();
                System.out.print("Indique o nome do banco: ");
                nomeBanco = lerDados.next();
                cc[contC].setNomeBanco(nomeBanco);
                cc[contC].setNumero(contC);
                System.out.print("Indique a agência: ");
                agencia = lerDados.nextInt();
                System.out.print("Indique o limite da conta: ");
                double limite = lerDados.nextFloat();
                cc[contC].setLimite(limite);
                cc[contC].depositar(0);
                contC++;
            }
            else if (op==2) {
                cp[contP] = new ContaPoupanca();
                System.out.print("Indique o nome do banco: ");
                nomeBanco = lerDados.next();
                cp[contP].setNomeBanco(nomeBanco);
                cp[contP].setNumero(contC);
                System.out.print("Indique a agência: ");
                agencia = lerDados.nextInt();
                cp[contP].depositar(0);
                contP++;
            }
            else if (op==3) {              
                System.out.print("Indique o número de sua conta:\n");
                cont = lerDados.nextInt();
                while (contC<=cont || cont<0) {                    
                    System.out.print("Conta não existente. Indique outra:\n");
                    cont = lerDados.nextInt();
                }
                System.out.print("Indique a opção desejada:\n1 - Realizar depósito\n2 - Realizar saque\n3 - Verificar saldo\n");
                opC = lerDados.nextInt();
                if (opC==1) {
                    System.out.print("Indique o valor a ser depositado: ");
                    double valor = lerDados.nextFloat();
                    if ((cc[cont].getSaldo()+valor)>cc[cont].getLimite()) {
                        System.out.println("O depósito não pode ser realizado! Limite ultrapassado.\n");
                    }
                    else {
                        cc[cont].depositar(valor);
                        System.out.println("Depósito realizado com sucesso!\n");
                    }
                }
                else if (opC==2) {
                    System.out.print("Indique o valor a ser sacado: ");
                    double valor = lerDados.nextFloat();
                    if (cc[cont].realizarSaque(valor)) {
                        System.out.println("Saque realizado com sucesso!\n");
                    }
                    else {
                        System.out.println("Saque não realizado! Dinheiro insuficiente.\n");
                    }
                }
                else if (opC==3) {
                    System.out.println("Saldo: "+cc[cont].getSaldo());
                }
            }
            else if (op==4) {
                System.out.print("Indique o número de sua conta:\n");
                cont = lerDados.nextInt();
                while (contP<=cont || cont<0) {                    
                    System.out.print("Conta não existente. Indique outra:\n");
                    cont = lerDados.nextInt();
                }
                System.out.print("Indique a opção desejada:\n1 - Realizar depósito\n2 - Realizar saque\n3 - Verificar saldo\n");
                opC = lerDados.nextInt();
                if (opC==1) {
                    System.out.print("Indique o valor a ser depositado: ");
                    double valor = lerDados.nextFloat();
                    cp[cont].depositar(valor);
                    System.out.println("Depósito realizado com sucesso!\n");
                }
                else if (opC==2) {
                    System.out.print("Indique o valor a ser sacado: ");
                    double valor = lerDados.nextFloat();
                    if (cp[cont].realizarSaque(valor)) {
                        System.out.println("Saque realizado com sucesso!");
                    }
                    else {
                        System.out.println("Saque não realizado! Dinheiro insuficiente.");
                    }
                }
                else if (opC==3) {
                    System.out.println("Saldo: "+cp[cont].getSaldo());
                }
            }
        }
        while (op<5 && op>0);
    }
}
