package rpg;

import java.util.Random;

public class Clerigo extends Personagem implements Curandeiro , Guerreiro {

    public Clerigo() {
        this.setVidas( 3 );
        this.setEnergia( new Random().nextInt( 50 ) );
        this.setNome( "Sem nome" );
    }

    @Override
    public void curar( Personagem personagemACurar ) {
        if ( this.getEnergia() > 0 ) {
            System.out.println( "\tCurando -> " + personagemACurar.getNome() );
            this.setEnergia( this.getEnergia() - 10 );
            personagemACurar.setEnergia( personagemACurar.getEnergia() + 10 );
        }
    }

    @Override
    public Guerreiro lutar( Guerreiro guerreiroDesfiate ) {
        try {
            Personagem guerreiro2 = ( Personagem ) guerreiroDesfiate;
            return ( Guerreiro ) getVencedor( guerreiro2 );
        }
        catch ( ClassCastException cce ) {
            System.out.println(
                    "Este guerreiro não é uma personagem! Portanto sou o vencedor" + cce.getMessage() );
            return this;
        }

    }

    public Personagem getVencedor( Personagem desafiante ) {
        int desafianteFator = desafiante.getEnergia() + desafiante.getVidas();
        int soldadoFator = this.getEnergia() + this.getVidas();
        if ( desafianteFator > soldadoFator ) {
            desafiante.setEnergia( desafiante.getEnergia() * 2 );
            desafiante.setVidas( this.getVidas() + 1 );
            this.setVidas( this.getVidas() - 1 );
            desafiante.setEnergia( desafiante.getEnergia() + this.getEnergia() );
            this.setEnergia( 0 );
            return desafiante;
        }
        this.setEnergia( this.getEnergia() * 2 );
        desafiante.setVidas( this.getVidas() - 1 );
        this.setVidas( this.getVidas() + 1 );
        this.setEnergia( this.getEnergia() + desafiante.getEnergia() );
        desafiante.setEnergia( 0 );
        return this;
    }

}
