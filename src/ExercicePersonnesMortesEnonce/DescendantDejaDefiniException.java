package ExercicePersonnesMortesEnonce;

public class DescendantDejaDefiniException extends EtatCivilException {
    public DescendantDejaDefiniException(String nom) {
        super("Le descendant de " + nom + " a déjà été défini.");
    }
}

