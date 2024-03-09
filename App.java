public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);

        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45);

        Carro utilitario = new Carro("Utilitario", TipoCombustivel.DIESEL, 5, 70);

        Carro suv = new Carro("SUV", TipoCombustivel.GASOLINA, 8, 55);

        Carro suvFlex = new Carro("SUVFlex", TipoCombustivel.FLEX, 8, 6, 65);

        System.out.println("Tipos de veiculos:");
        System.out.println(basico);
        System.out.println(esportivo);
        System.out.println(utilitario);
        System.out.println(suv);
        System.out.println(suvFlex);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro esportivo com gasolina");
        esportivo.abastece(TipoCombustivel.GASOLINA, 45);
        System.out.println(esportivo);
        System.out.println("\nViajando com o carro basico");
        esportivo.viaja(250);
        esportivo.viaja(150);
        System.out.println(esportivo);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro utilitario com diesel");
        utilitario.abastece(TipoCombustivel.DIESEL, 70);
        System.out.println(utilitario);
        System.out.println("\nViajando com o carro utilitario");
        utilitario.viaja(250);
        utilitario.viaja(150);
        System.out.println(utilitario);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suv com gasolina");
        suv.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(suv);
        System.out.println("\nViajando com o carro suv");
        suv.viaja(250);
        suv.viaja(150);
        System.out.println(suv);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suv com alcool");
        suv.upgradeMotorParaFlex();
        suv.abastece(TipoCombustivel.ALCOOL, 55);
        System.out.println(suv);
        System.out.println("\nViajando com o carro suv");
        suv.viaja(250);
        suv.viaja(150);
        System.out.println(suv);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suvFlex com alcool");
        suvFlex.abastece(TipoCombustivel.ALCOOL, 65);
        suvFlex.setConsumo(TipoCombustivel.ALCOOL);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro suv");
        suvFlex.viaja(50);
        suvFlex.viaja(50);
        System.out.println(suvFlex);
        suvFlex.setConsumo(TipoCombustivel.GASOLINA);
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suvFlex com gasolina");
        suvFlex.abastece(TipoCombustivel.GASOLINA, 65);

        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro suv");
        suvFlex.viaja(100);
        suvFlex.viaja(150);
        System.out.println(suvFlex);

    }
}
