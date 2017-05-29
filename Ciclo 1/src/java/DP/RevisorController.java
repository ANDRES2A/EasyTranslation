package DP;

import MD.Revisor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "revisorController")
@ViewScoped
public class RevisorController extends AbstractController<Revisor> {

    @Inject
    private IdiomaController abreviacionIdController;

    public RevisorController() {
        // Inform the Abstract parent controller of the concrete Revisor Entity
        super(Revisor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        abreviacionIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Idioma controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAbreviacionId(ActionEvent event) {
        Revisor selected = this.getSelected();
        if (selected != null && abreviacionIdController.getSelected() == null) {
            abreviacionIdController.setSelected(selected.getAbreviacionId());
        }
    }

}
