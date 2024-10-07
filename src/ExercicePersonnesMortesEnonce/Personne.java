package ExercicePersonnesMortesEnonce;

public class Personne {

    private final int anneeNaissance;
    private int anneeMort;
    private final String nom;

    // Ajout des nouveaux attributs
    private Personne descendantDe;
    private Personne ascendantDe;
    private Personne lieA;
    private String dateLien;

    public Personne(String nom, int naissance) {
        this.nom = nom;
        this.anneeNaissance = naissance;
        this.anneeMort = -1;
        this.descendantDe = null;
        this.ascendantDe = null;
        this.lieA = null;
        this.dateLien = null;
    }

    // Getters et setters pour les nouveaux attributs

    public Personne getDescendantDe() {
        return descendantDe;
    }

    public Personne getAscendantDe() {
        return ascendantDe;
    }

    public Personne getLieA() {
        return lieA;
    }


    public String getDateLien() {
        return dateLien;
    }

    public void afficherLien() {
        if (lieA != null && dateLien != null) {
            System.out.println(nom + " est lié(e) à " + lieA.getNom() + " depuis " + dateLien);
        } else {
            System.out.println(nom + " n'a pas de lien (mariage/pacs).");
        }
    }

    public void setLien(Personne lieA, String dateLien) throws PersonneDejaLieeException {
        if (this.lieA != null) {
            throw new PersonneDejaLieeException(this.nom, lieA.getNom());
        }
        this.lieA = lieA;
        this.dateLien = dateLien;
    }

    public void setDescendantDe(Personne descendantDe) throws DescendantDejaDefiniException {
        if (this.descendantDe != null) {
            throw new DescendantDejaDefiniException(this.nom);
        }
        this.descendantDe = descendantDe;
    }

    public void setAscendantDe(Personne ascendantDe) throws AscendantDejaDefiniException {
        if (this.ascendantDe != null) {
            throw new AscendantDejaDefiniException(this.nom);
        }
        this.ascendantDe = ascendantDe;
    }



    public int getAnneeMort() throws PasMortException {
        if (anneeMort != -1) {
            return anneeMort;
        } else {
            throw new PasMortException();
        }
    }

    public int getAnneeNaissance() {
        return this.anneeNaissance;
    }

    public void meurt(int annee) throws DeJaMortException {
        if (anneeMort != -1)
            throw new DeJaMortException();
        else
            anneeMort = annee;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Personne [Nom = " + nom + ", Année de Naissance = " + anneeNaissance + ", Année de Mort = " + anneeMort + "]";
    }
}

