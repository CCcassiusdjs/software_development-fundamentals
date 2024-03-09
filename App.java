public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45);
        Carro utilitario = new Carro("Utilitario", TipoCombustivel.DIESEL, 5, 70);
        Carro suv = new Carro("SUV", TipoCombustivel.GASOLINA, 8, 55);
        Carro suvFlex = new Carro("SUVFlex", TipoCombustivel.FLEX, 8, 6, 65);
        Carro.Econo econo = new Carro.Econo("Econo", TipoCombustivel.GASOLINA, 55, 20, 5000, 10);

        System.out.println("------------------------------------------------");
        System.out.println("Tipos de veículos disponíveis:");
        System.out.println("------------------------------------------------");
        System.out.println(basico);
        System.out.println(esportivo);
        System.out.println(utilitario);
        System.out.println(suv);
        System.out.println(suvFlex);
        System.out.println(econo);
        System.out.println("------------------------------------------------\n");

        realizaOperacoesComCarro(basico, TipoCombustivel.GASOLINA, 55, new int[]{250, 150});
        realizaOperacoesComCarro(esportivo, TipoCombustivel.GASOLINA, 45, new int[]{250, 150});
        realizaOperacoesComCarro(utilitario, TipoCombustivel.DIESEL, 70, new int[]{250, 150});
        realizaOperacoesComCarro(suv, TipoCombustivel.GASOLINA, 55, new int[]{250, 150});
        realizaOperacoesComCarro(suvFlex, TipoCombustivel.ALCOOL, 65, new int[]{50, 50, 100, 150});
        realizaOperacoesComCarro(econo, TipoCombustivel.GASOLINA, 55, new int[]{250, 150});
    }

    private static void realizaOperacoesComCarro(Carro carro, TipoCombustivel combustivel, int quantidadeCombustivel, int[] distancias) {
        System.out.println("------------------------------------------------");
        System.out.println("Operações com o carro: " + carro.getModelo());
        System.out.println("------------------------------------------------");
        carro.abastece(combustivel, quantidadeCombustivel);
        System.out.println("Abastecendo com " + combustivel + ": " + quantidadeCombustivel + " litros");
        System.out.println(carro);
        for (int distancia : distancias) {
            carro.viaja(distancia);
            System.out.println("Viajando " + distancia + " Km");
            System.out.println(carro);
        }
        System.out.println("------------------------------------------------\n");
    }
}
