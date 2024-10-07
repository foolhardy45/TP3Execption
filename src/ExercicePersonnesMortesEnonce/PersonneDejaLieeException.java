package ExercicePersonnesMortesEnonce;

public class PersonneDejaLieeException extends EtatCivilException {
    public PersonneDejaLieeException(String nom1, String nom2) {
        super(nom1 + " est déjà lié(e) à " + nom2 + ".");
    }
}
