package rpg;

import rpg.factory.GuerreiroFactory;

public class Luta {

    public static void main( String[] args ) {

        Soldado personagem1 = GuerreiroFactory.getSoldado( Racarions.class ,
                                                           "Tristão" );
        Clerigo personagem2 = GuerreiroFactory.getClerigo( Racarions.class ,
                                                           "Merlim" );
        Soldado personagem3 = GuerreiroFactory.getSoldado( Racarions.class ,
                                                           "Angelus" );
        Soldado personagem4 = GuerreiroFactory.getSoldado( Racarions.class ,
                                                           "Micah" );
        Soldado personagem5 = GuerreiroFactory.getSoldado( Omefrons.class ,
                                                           "Azurath" );
        Clerigo personagem6 = GuerreiroFactory.getClerigo( Omefrons.class ,
                                                           "Amam" );
        Clerigo personagem7 = GuerreiroFactory.getClerigo( Omefrons.class ,
                                                           "Ing" );
        Soldado personagem8 = GuerreiroFactory.getSoldado( Omefrons.class ,
                                                           "Fradall" );

        Guerreiro vencedorLuta1 = luta( personagem1 , personagem5 , 1 );
        curar( personagem2 , vencedorLuta1 );
        curar( personagem7 , vencedorLuta1 );

        Guerreiro vencedorLuta2 = luta( personagem2 , personagem6 , 2 );
        curar( personagem2 , vencedorLuta2 );
        curar( personagem7 , vencedorLuta2 );

        Guerreiro vencedorLuta3 = luta( personagem3 , personagem7 , 3 );
        curar( personagem2 , vencedorLuta3 );
        curar( personagem7 , vencedorLuta3 );

        Guerreiro vencedorLuta4 = luta( personagem4 , personagem8 , 4 );
        curar( personagem2 , vencedorLuta4 );
        curar( personagem7 , vencedorLuta4 );

        Guerreiro vencedorLuta5 = luta( vencedorLuta1 , vencedorLuta2 , 5 );
        curar( personagem2 , vencedorLuta5 );
        curar( personagem7 , vencedorLuta5 );

        Guerreiro vencedorLuta6 = luta( vencedorLuta3 , vencedorLuta4 , 6 );
        curar( personagem2 , vencedorLuta6 );
        curar( personagem7 , vencedorLuta6 );

        luta( vencedorLuta5 , vencedorLuta6 , 0 );

    }

    public static void curar( Clerigo clerigo , Guerreiro guerreiro ) {
        Casa casaClerigo = clerigo.getCasa();
        Casa casaGuerreiro = ( ( Personagem ) guerreiro ).getCasa();
        if ( casaClerigo.equals( casaGuerreiro ) ) {
            clerigo.curar( ( Personagem ) guerreiro );
        }
    }

    public static Guerreiro luta( Guerreiro g1 , Guerreiro g2 , int luta ) {
        if ( luta == 0 ) {
            System.out.println( "\n ------ Luta Final ------ " );
        }
        else {
            System.out.println( "\n ------ Luta ------  " + luta );
        }
        System.out.println( "\nEsta luta será entre: " );
        System.out.println( ( Personagem ) g1 );
        System.out.println( "\n------------ X ------------ " );
        System.out.println( ( Personagem ) g2 );
        System.out.println( "\n\t F I G H T !!!!" );
        Guerreiro vencedor = g1.lutar( g2 );
        System.out.println(
                "Vencedor: " + ( ( Personagem ) vencedor ).toString() );
        System.out.println( "\n ------ THE END ------\n" );
        return vencedor;

    }

}
