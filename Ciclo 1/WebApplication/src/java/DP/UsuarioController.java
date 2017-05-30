package DP;

import MD.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    // Flags to indicate if child collections are empty
    private boolean isIdiomaCollectionEmpty;
    private boolean isPeticionCollectionEmpty;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsIdiomaCollectionEmpty();
        this.setIsPeticionCollectionEmpty();
    }

    public boolean getIsIdiomaCollectionEmpty() {
        return this.isIdiomaCollectionEmpty;
    }

    private void setIsIdiomaCollectionEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isIdiomaCollectionEmpty = ejbFacade.isIdiomaCollectionEmpty(selected);
        } else {
            this.isIdiomaCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Idioma entities that are
     * retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Idioma page
     */
    public String navigateIdiomaCollection() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Idioma_items", ejbFacade.findIdiomaCollection(selected));
        }
        return "/app/idioma/index";
    }

    public boolean getIsPeticionCollectionEmpty() {
        return this.isPeticionCollectionEmpty;
    }

    private void setIsPeticionCollectionEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isPeticionCollectionEmpty = ejbFacade.isPeticionCollectionEmpty(selected);
        } else {
            this.isPeticionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Peticion entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Peticion page
     */
    public String navigatePeticionCollection() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Peticion_items", ejbFacade.findPeticionCollection(selected));
        }
        return "/app/peticion/index";
    }

}
