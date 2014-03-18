package rpg;

import java.util.Random;

public class Soldado extends Personagem implements Guerreiro {

    private static int contadorDeSoldados = 0;

    public Soldado() {
        contadorDeSoldados++;
        this.setNome( "Soldado " + contadorDeSoldados );
        this.setEnergia( new Random().nextInt( 50 ) );
        this.setVidas( 1 );
    }

    @Override
    public void setVidas( int vidas ) {
        if ( vidas > 3 ) {
            try {
                throw new IlegalNumeroVidasException(
                        "Numero de vidas inválido: " + vidas );
            }
            catch ( IlegalNumeroVidasException ine ) {
                System.out.println( ine.getMessage() );
            }
        }
        else {
            super.setVidas( vidas );
        }
    }

    public static int getContadorDeSoldados() {
        return contadorDeSoldados;
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
            this.setVidas( this.getVidas() - 1 );
            return desafiante;
        }
        this.setEnergia( this.getEnergia() * 2 );
        desafiante.setVidas( this.getVidas() - 1 );
        return this;
    }

}
