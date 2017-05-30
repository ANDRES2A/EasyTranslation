package DP;

import MD.Revisor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "revisorController")
@ViewScoped
public class RevisorController extends AbstractController<Revisor> {

    // Flags to indicate if child collections are empty
    private boolean isUsuarioCollectionEmpty;

    public RevisorController() {
        // Inform the Abstract parent controller of the concrete Revisor Entity
        super(Revisor.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUsuarioCollectionEmpty();
    }

    public boolean getIsUsuarioCollectionEmpty() {
        return this.isUsuarioCollectionEmpty;
    }

    private void setIsUsuarioCollectionEmpty() {
        Revisor selected = this.getSelected();
        if (selected != null) {
            RevisorFacade ejbFacade = (RevisorFacade) this.getFacade();
            this.isUsuarioCollectionEmpty = ejbFacade.isUsuarioCollectionEmpty(selected);
        } else {
            this.isUsuarioCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Revisor?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioCollection() {
        Revisor selected = this.getSelected();
        if (selected != null) {
            RevisorFacade ejbFacade = (RevisorFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", ejbFacade.findUsuarioCollection(selected));
        }
        return "/app/usuario/index";
    }

}
