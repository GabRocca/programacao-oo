public class ProgramaFolha { 
    public static void main(String[] args) {
        Funcionario funcionarioM = new FuncionarioCLT("Carlos", 2000.0); 
        Funcionario funcionarioF = new FuncionarioTemporario("Ana", 2000.0); 

        funcionarioM.exibirDados();
        System.out.println("Salário Final: " + funcionarioM.calcularSalario());  

        System.out.println(); 
        funcionarioF.exibirDados();
        System.out.println("Salário Final: " + funcionarioF.calcularSalario());
    }
}