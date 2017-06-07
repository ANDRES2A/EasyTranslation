package MD;

import MD.Idioma;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T19:40:23")
@StaticMetamodel(Revisor.class)
public class Revisor_ { 

    public static volatile CollectionAttribute<Revisor, Idioma> idiomaCollection;
    public static volatile SingularAttribute<Revisor, String> nombreRe;
    public static volatile SingularAttribute<Revisor, String> experiencia;
    public static volatile SingularAttribute<Revisor, Date> fechaNacimientoRe;
    public static volatile SingularAttribute<Revisor, String> passwordRe;
    public static volatile SingularAttribute<Revisor, String> correoRe;

}