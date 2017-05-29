package DP;

import MD.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private PeticionController codigoPeController;

    // Flags to indicate if child collections are empty
    private boolean isIdiomaCollectionEmpty;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codigoPeController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Peticion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodigoPe(ActionEvent event) {
        Usuario selected = this.getSelected();
        if (selected != null && codigoPeController.getSelected() == null) {
            codigoPeController.setSelected(selected.getCodigoPe());
        }
    }

}
