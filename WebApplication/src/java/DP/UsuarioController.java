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
    private boolean isRevisorCollectionEmpty;
    private boolean isIdiomaCollectionEmpty;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRevisorCollectionEmpty();
        this.setIsIdiomaCollectionEmpty();
    }

    public boolean getIsRevisorCollectionEmpty() {
        return this.isRevisorCollectionEmpty;
    }

    private void setIsRevisorCollectionEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isRevisorCollectionEmpty = ejbFacade.isRevisorCollectionEmpty(selected);
        } else {
            this.isRevisorCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Revisor entities that are
     * retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Revisor page
     */
    public String navigateRevisorCollection() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Revisor_items", ejbFacade.findRevisorCollection(selected));
        }
        return "/app/revisor/index";
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

}
