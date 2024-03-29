public class Carro {

    private String modelo;
    protected Motor motor;
    private TanqueCombustivel tanque;

   
    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoGasolina, int consumoAlcool, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoGasolina, consumoAlcool);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    public static class Econo extends Carro {
        private int reducaoPorKm;
        private int consumoMinimo;

        public Econo(String modelo, TipoCombustivel tipoCombustivel, int capacidadeTanque, 
                     int consumoInicial, int reducaoPorKm, int consumoMinimo) {
            super(modelo, tipoCombustivel, consumoInicial, capacidadeTanque);
            this.reducaoPorKm = reducaoPorKm;
            this.consumoMinimo = consumoMinimo;
        }

        @Override
        public boolean viaja(int distancia) {
            ajustaConsumoEcono();
            return super.viaja(distancia);
        }

        private void ajustaConsumoEcono() {
            int quilometragemAtual = this.motor.getQuilometragem();
            int novoConsumo = Math.max(consumoMinimo, super.motor.getConsumo() - (quilometragemAtual / reducaoPorKm));
            super.motor.setConsumo(novoConsumo, TipoCombustivel.GASOLINA);
        }
    }

    public void upgradeMotorParaFlex() {
        if(this.motor.getTipoMotor() != TipoCombustivel.FLEX) {
            this.motor.setTipoMotor(TipoCombustivel.FLEX);
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setConsumo(TipoCombustivel tipoCombustivel) {
        if (tipoCombustivel == TipoCombustivel.ALCOOL) {
            motor.setConsumo(motor.getConsumo(), TipoCombustivel.ALCOOL);
        }else if (tipoCombustivel == TipoCombustivel.GASOLINA) {
            motor.setConsumo(motor.getConsumo(), TipoCombustivel.GASOLINA);
        }
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        int combustivelNecessario = motor.combustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            tanque.gasta(motor.combustivelNecessario(distancia));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
