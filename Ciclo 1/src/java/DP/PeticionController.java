package DP;

import MD.Peticion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "peticionController")
@ViewScoped
public class PeticionController extends AbstractController<Peticion> {

    @Inject
    private IdiomaController destinoPeController;
    @Inject
    private IdiomaController idiAbreviacionIdController;

    // Flags to indicate if child collections are empty
    private boolean isUsuarioCollectionEmpty;

    public PeticionController() {
        // Inform the Abstract parent controller of the concrete Peticion Entity
        super(Peticion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        destinoPeController.setSelected(null);
        idiAbreviacionIdController.setSelected(null);
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
        Peticion selected = this.getSelected();
        if (selected != null) {
            PeticionFacade ejbFacade = (PeticionFacade) this.getFacade();
            this.isUsuarioCollectionEmpty = ejbFacade.isUsuarioCollectionEmpty(selected);
        } else {
            this.isUsuarioCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Peticion?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioCollection() {
        Peticion selected = this.getSelected();
        if (selected != null) {
            PeticionFacade ejbFacade = (PeticionFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", ejbFacade.findUsuarioCollection(selected));
        }
        return "/app/usuario/index";
    }

    /**
     * Sets the "selected" attribute of the Idioma controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDestinoPe(ActionEvent event) {
        Peticion selected = this.getSelected();
        if (selected != null && destinoPeController.getSelected() == null) {
            destinoPeController.setSelected(selected.getDestinoPe());
        }
    }

    /**
     * Sets the "selected" attribute of the Idioma controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdiAbreviacionId(ActionEvent event) {
        Peticion selected = this.getSelected();
        if (selected != null && idiAbreviacionIdController.getSelected() == null) {
            idiAbreviacionIdController.setSelected(selected.getIdiAbreviacionId());
        }
    }

}
