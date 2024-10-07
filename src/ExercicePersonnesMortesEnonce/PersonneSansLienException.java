package ExercicePersonnesMortesEnonce;

public class PersonneSansLienException extends EtatCivilException {
    public PersonneSansLienException(String nom) {
        super(nom + " n'a aucun lien (mariage ou pacs).");
    }
}

