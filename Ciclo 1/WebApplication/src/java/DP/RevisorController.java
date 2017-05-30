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
    private boolean isIdiomaCollectionEmpty;

    public RevisorController() {
        // Inform the Abstract parent controller of the concrete Revisor Entity
        super(Revisor.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsIdiomaCollectionEmpty();
    }

    public boolean getIsIdiomaCollectionEmpty() {
        return this.isIdiomaCollectionEmpty;
    }

    private void setIsIdiomaCollectionEmpty() {
        Revisor selected = this.getSelected();
        if (selected != null) {
            RevisorFacade ejbFacade = (RevisorFacade) this.getFacade();
            this.isIdiomaCollectionEmpty = ejbFacade.isIdiomaCollectionEmpty(selected);
        } else {
            this.isIdiomaCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Idioma entities that are
     * retrieved from Revisor?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Idioma page
     */
    public String navigateIdiomaCollection() {
        Revisor selected = this.getSelected();
        if (selected != null) {
            RevisorFacade ejbFacade = (RevisorFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Idioma_items", ejbFacade.findIdiomaCollection(selected));
        }
        return "/app/idioma/index";
    }

}
