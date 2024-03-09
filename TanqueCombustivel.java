public class TanqueCombustivel {

    private TipoCombustivel tipoCombustivel;
    private int capacidade;
    private int combustivelDisponivel;

    public TanqueCombustivel(TipoCombustivel tipoCombustivel, int capacidade) {
        this.tipoCombustivel = tipoCombustivel;
        this.capacidade = capacidade;
        this.combustivelDisponivel = 0;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getCombustivelDisponivel() {
        return combustivelDisponivel;
    }

    // Retorna false se o tipo de combustivel for incompativel ou se a quantidade
    // for maior que a capacidade livre
    public void abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        // Assumindo que o tanque sempre terá o combustível do último abastecimento
        this.tipoCombustivel = tipoCombustivel;
        this.combustivelDisponivel = Math.min(quantidade, capacidade);
    }

    public boolean gasta(int quantidade) {
        if (getCombustivelDisponivel() - quantidade < 0) {
            return false;
        } else {
            combustivelDisponivel -= quantidade;
            return true;
        }
    }

    @Override
    public String toString() {
        return "TanqueCombustivel [capacidade=" + capacidade + ", combustivelDisponivel=" + combustivelDisponivel
                + ", tipoCombustivel=" + tipoCombustivel + "]";
    }

}
