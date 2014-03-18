package rpg;

public abstract class Personagem {

    private String nome;

    private int energia;

    private int vidas;

    private Casa casa;

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia( int energia ) {
        this.energia = energia;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa( Casa casa ) {
        this.casa = casa;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas( int vidas ) {
        this.vidas = vidas;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nCasa: " + casa + "\nEnergia: " + energia + "\nVidas: " + vidas + "\nTipo: " + this.getClass().getSimpleName();
    }

}
