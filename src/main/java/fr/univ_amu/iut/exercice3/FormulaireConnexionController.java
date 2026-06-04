package fr.univ_amu.iut.exercice3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Contrôleur de vue de l'exercice 3.
 *
 * <p>Le contrôleur ne contient toujours aucune logique : il lie les champs aux propriétés du
 * ViewModel (bidirectionnel), lie le statut (sens unique), désactive le bouton tant que le
 * formulaire n'est pas validable, et fait suivre le clic vers la commande.
 */
public class FormulaireConnexionController {

  private final FormulaireConnexionViewModel viewModel;

  @FXML private TextField champIdentifiant;
  @FXML private PasswordField champMotDePasse;
  @FXML private Button boutonValider;
  @FXML private Label labelStatut;

  public FormulaireConnexionController(FormulaireConnexionViewModel viewModel) {
    this.viewModel = viewModel;
  }

  @FXML
  private void initialize() {
    boutonValider.disableProperty().bind(viewModel.validableProperty().not());
    viewModel.identifiantProperty().bindBidirectional(champIdentifiant.textProperty());
    viewModel.motDePasseProperty().bindBidirectional(champMotDePasse.textProperty());
    labelStatut.textProperty().bind(viewModel.statutProperty());
  }

  @FXML
  private void surValider() {
    viewModel.connecterCommand();
  }
}
