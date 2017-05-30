package DP;

import MD.Idioma;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "idiomaController")
@ViewScoped
public class IdiomaController extends AbstractController<Idioma> {

    // Flags to indicate if child collections are empty
    private boolean isUsuarioCollectionEmpty;
    private boolean isPeticionCollectionEmpty;
    private boolean isPeticionCollection1Empty;

    public IdiomaController() {
        // Inform the Abstract parent controller of the concrete Idioma Entity
        super(Idioma.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUsuarioCollectionEmpty();
        this.setIsPeticionCollectionEmpty();
        this.setIsPeticionCollection1Empty();
    }

    public boolean getIsUsuarioCollectionEmpty() {
        return this.isUsuarioCollectionEmpty;
    }

    private void setIsUsuarioCollectionEmpty() {
        Idioma selected = this.getSelected();
        if (selected != null) {
            IdiomaFacade ejbFacade = (IdiomaFacade) this.getFacade();
            this.isUsuarioCollectionEmpty = ejbFacade.isUsuarioCollectionEmpty(selected);
        } else {
            this.isUsuarioCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Idioma?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioCollection() {
        Idioma selected = this.getSelected();
        if (selected != null) {
            IdiomaFacade ejbFacade = (IdiomaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", ejbFacade.findUsuarioCollection(selected));
        }
        return "/app/usuario/index";
    }

    public boolean getIsPeticionCollectionEmpty() {
        return this.isPeticionCollectionEmpty;
    }

    private void setIsPeticionCollectionEmpty() {
        Idioma selected = this.getSelected();
        if (selected != null) {
            IdiomaFacade ejbFacade = (IdiomaFacade) this.getFacade();
            this.isPeticionCollectionEmpty = ejbFacade.isPeticionCollectionEmpty(selected);
        } else {
            this.isPeticionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Peticion entities that
     * are retrieved from Idioma?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Peticion page
     */
    public String navigatePeticionCollection() {
        Idioma selected = this.getSelected();
        if (selected != null) {
            IdiomaFacade ejbFacade = (IdiomaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Peticion_items", ejbFacade.findPeticionCollection(selected));
        }
        return "/app/peticion/index";
    }

    public boolean getIsPeticionCollection1Empty() {
        return this.isPeticionCollection1Empty;
    }

    private void setIsPeticionCollection1Empty() {
        Idioma selected = this.getSelected();
        if (selected != null) {
            IdiomaFacade ejbFacade = (IdiomaFacade) this.getFacade();
            this.isPeticionCollection1Empty = ejbFacade.isPeticionCollection1Empty(selected);
        } else {
            this.isPeticionCollection1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Peticion entities that
     * are retrieved from Idioma?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Peticion page
     */
    public String navigatePeticionCollection1() {
        Idioma selected = this.getSelected();
        if (selected != null) {
            IdiomaFacade ejbFacade = (IdiomaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Peticion_items", ejbFacade.findPeticionCollection1(selected));
        }
        return "/app/peticion/index";
    }

}
