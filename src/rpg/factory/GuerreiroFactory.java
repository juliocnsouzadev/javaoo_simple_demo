package rpg.factory;

import java.util.HashMap;
import java.util.Map;
import rpg.Casa;
import rpg.Clerigo;
import rpg.Omefrons;
import rpg.Racarions;
import rpg.Soldado;

public class GuerreiroFactory {

    public static Soldado getSoldado( Class casaClass , String nome ) {
        Soldado soldado = new Soldado();
        soldado.setNome( nome );
        soldado.setCasa( getCasa( casaClass ) );
        return soldado;
    }

    public static Clerigo getClerigo( Class casaClass , String nome ) {
        Clerigo clerigo = new Clerigo();
        clerigo.setNome( nome );
        clerigo.setCasa( getCasa( casaClass ) );
        return clerigo;
    }

    private static Casa getCasa( Class casaClass ) {
        Map<Class , Casa> map = new HashMap<>();
        map.put( Racarions.class , new Racarions() );
        map.put( Omefrons.class , new Omefrons() );
        return map.get( casaClass );
    }

}
