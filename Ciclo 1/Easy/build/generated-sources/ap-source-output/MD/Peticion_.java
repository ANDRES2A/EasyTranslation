package MD;

import MD.Idioma;
import MD.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T19:40:23")
@StaticMetamodel(Peticion.class)
public class Peticion_ { 

    public static volatile SingularAttribute<Peticion, String> descripcionPe;
    public static volatile SingularAttribute<Peticion, String> estadoPe;
    public static volatile SingularAttribute<Peticion, Usuario> correoUs;
    public static volatile SingularAttribute<Peticion, Date> fechaEmisionPe;
    public static volatile SingularAttribute<Peticion, String> tipoPe;
    public static volatile SingularAttribute<Peticion, BigDecimal> codigoPe;
    public static volatile SingularAttribute<Peticion, Idioma> idiAbreviacionId;
    public static volatile SingularAttribute<Peticion, Idioma> abreviacionId;

}