package MD;

import MD.Idioma;
import MD.Peticion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T19:40:23")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Idioma> idiomaCollection;
    public static volatile SingularAttribute<Usuario, String> correoUs;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimientoUs;
    public static volatile SingularAttribute<Usuario, String> nombreUs;
    public static volatile CollectionAttribute<Usuario, Peticion> peticionCollection;
    public static volatile SingularAttribute<Usuario, String> passwordUs;

}