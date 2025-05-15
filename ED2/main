import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("Alice", 1000);
        ContaPoupanca cp = new ContaPoupanca("Bob", 1500);
        ContaSalario cs = new ContaSalario("Carlos", 1200);

        cc.depositar(200);
        cp.sacar(100);
        cs.transferir(cc, 300);

        cc.aplicarJurosDiarios();
        cp.aplicarJurosDiarios();
        cs.aplicarJurosDiarios();

        cc.imprimirExtrato();
        cp.imprimirExtrato();
        cs.imprimirExtrato();
    }

 public abstract class Conta{
     protected String cliente;
     protected double saldo;
 
     public Conta(String cliente, double saldo){
        this.cliente = cliente;
        this.saldo = saldo;
     }
 
    
     public void sacar(double valor){
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("cabo a grana patrao");
        }
     }

     public void depositar(double valor){
        saldo += valor;
     }

     public void transferir(Conta destino, double valor){
        if (saldo >= valor){
            this.saldo -= valor;
            destino.depositar(valor);
        } else{
            System.out.println("Erro");
        }
     }
 
     public double getSaldo(){
        return saldo;
     }
 
     public abstract void imprimirExtrato();
     public abstract void aplicarJurosDiarios();
}
    public class ContaCorrente extends Conta{
 
        public ContaCorrente(String cliente, double saldo) {
        super(cliente, saldo);
        }
 
        @Override
        public void aplicarJurosDiarios(){
        saldo += saldo * 0.001;
        }
 
        @Override
        public void imprimirExtrato(){
        System.out.println("Extrato Conta Corrente: ");
        System.out.println("Cliente: " + cliente);
        System.out.println("Saldo: R$" + saldo);
        System.out.println("________________________________________________");
        }
}
    public class ContaPoupanca extends Conta{
 
        public ContaPoupanca(String cliente, double saldo){
            super(cliente, saldo);
        }
 
        @Override
        public void aplicarJurosDiarios(){
        saldo += saldo * 0.0008;
        }
 
        @Override
        public void imprimirExtrato(){
            System.out.println("Extrato Conta Poupança: ");
            System.out.println("Cliente: " + cliente);
            System.out.println("Saldo: R$" + saldo);
            System.out.println("____________________________________");
        }
}
    public class ContaSalario extends Conta{
 
        public ContaSalario(String cliente, double saldo){
            super(cliente, saldo);
        }
 
        @Override
        public void aplicarJurosDiarios(){
        }
 
        @Override
        public void imprimirExtrato(){
            System.out.println("Extrato Conta Salário: ");
            System.out.println("Cliente: " + cliente);
            System.out.println("Saldo: R$" + saldo);
            System.out.println("____________________________________");
        }
}
}
// a gripe vai me matar a gripe vai me matar
// RA: 2024195564