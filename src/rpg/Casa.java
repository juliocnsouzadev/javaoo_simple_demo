package rpg;

public abstract class Casa {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
