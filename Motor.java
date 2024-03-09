public class Motor {

    private TipoCombustivel tipoMotor;
    private int consumoGasolina;
    private int consumoAlcool;
    private int quilometragem;
    private int consumo;

    public Motor(TipoCombustivel tipoMotor, int consumoGasolina, int consumoAlcool) {
        this.tipoMotor = tipoMotor;
        this.consumoGasolina = consumoGasolina;
        this.consumoAlcool = consumoAlcool;
    }

    public void setTipoMotor(TipoCombustivel tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public int getConsumo() {
        // Assegura que o consumo nunca seja zero
        if (tipoMotor == TipoCombustivel.GASOLINA) {
            return consumoGasolina > 0 ? consumoGasolina : 1;
        } else if (tipoMotor == TipoCombustivel.ALCOOL) {
            return consumoAlcool > 0 ? consumoAlcool : 1;
        } else {
            // Para FLEX, você pode definir um padrão (ex: consumoGasolina) ou tratar de forma diferente
            return consumoGasolina > 0 ? consumoGasolina : 1;
        }
    }

    public void setConsumo(int consumo, TipoCombustivel combustivel){
        if (combustivel == TipoCombustivel.ALCOOL) {
            this.consumoAlcool = consumo;
        }else if (combustivel == TipoCombustivel.GASOLINA) {
            this.consumoGasolina = consumo;
        }
    }

    public int combustivelNecessario(int distancia) {
        return distancia / getConsumo();
    }

    public Motor(TipoCombustivel tipoMotor, int consumo) {
        this.tipoMotor = tipoMotor;
        this.consumo = consumo;
    }

    public TipoCombustivel getTipoMotor(){
        return this.tipoMotor;
    }

    public int getQuilometragem(){
        return this.quilometragem;
    }

    public void percorre(int distancia) {
        quilometragem += distancia;
    }

    @Override
    public String toString() {
        return "Motor [consumo=" + consumo + ", quilometragem=" + quilometragem + ", tipoMotor=" + tipoMotor + "]";
    }
}