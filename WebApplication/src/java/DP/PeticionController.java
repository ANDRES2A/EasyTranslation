package DP;

import MD.Peticion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "peticionController")
@ViewScoped
public class PeticionController extends AbstractController<Peticion> {

    @Inject
    private IdiomaController idiAbreviacionIdController;
    @Inject
    private IdiomaController abreviacionIdController;

    public PeticionController() {
        // Inform the Abstract parent controller of the concrete Peticion Entity
        super(Peticion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idiAbreviacionIdController.setSelected(null);
        abreviacionIdController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Idioma controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAbreviacionId(ActionEvent event) {
        Peticion selected = this.getSelected();
        if (selected != null && abreviacionIdController.getSelected() == null) {
            abreviacionIdController.setSelected(selected.getAbreviacionId());
        }
    }

}
