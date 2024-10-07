package ExercicePersonnesMortesEnonce;

public class AscendantDejaDefiniException extends EtatCivilException {
    public AscendantDejaDefiniException(String nom) {
        super("L'ascendant de " + nom + " a déjà été défini.");
    }
}

