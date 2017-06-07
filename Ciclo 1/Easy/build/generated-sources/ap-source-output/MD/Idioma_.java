package MD;

import MD.Peticion;
import MD.Revisor;
import MD.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T19:40:23")
@StaticMetamodel(Idioma.class)
public class Idioma_ { 

    public static volatile CollectionAttribute<Idioma, Peticion> peticionCollection1;
    public static volatile CollectionAttribute<Idioma, Revisor> revisorCollection;
    public static volatile CollectionAttribute<Idioma, Peticion> peticionCollection;
    public static volatile SingularAttribute<Idioma, String> descripcionId;
    public static volatile SingularAttribute<Idioma, String> abreviacionId;
    public static volatile CollectionAttribute<Idioma, Usuario> usuarioCollection;

}