import ExercicePersonnesMortesEnonce.*;

import java.util.ArrayList;


public class EtatCivil {

    private final ArrayList<Personne> registre;


    public EtatCivil(ArrayList<Personne> l) {
        registre = l;

    }

    public void ajouterPersonnage(Personne p){
        registre.add(p);
    }

    public int nombreDeVivant() {
        int compteur = 0;
        for (Personne p : registre) {
            try {
                p.getAnneeMort();
            } catch (PasMortException e) {
                compteur++;
            }
        }
        return compteur;
    }

    public int nombreDeMortApres1960() {
        int compteur = 0;
        for (Personne p : registre) {
            try {
                if (p.getAnneeMort() > 1960) {
                    compteur++;
                }
            } catch (PasMortException e) {
            }
        }
        return compteur;
    }

    public boolean tousMort() {
        for (Personne p : registre) {
            try {
                if (p.getAnneeMort() == -1) {
                    return false;
                }
            } catch (PasMortException e) {
                return false;
            }
        }
        return true;
    }

    public boolean auMoinsUnVivant() {
        for (Personne p : registre) {
            try {
                p.getAnneeMort();
            } catch (PasMortException e) {
                return true;
            }
        }
        return false;
    }

    public Personne chercherPremierVivant() throws AucunVivantException {
        for (Personne p : registre) {
            try {
                p.getAnneeMort();
            } catch (PasMortException e) {
                return p;
            }
        }
        throw new AucunVivantException();
    }

    public Personne chercherDernierMort() throws AucunMortException {
        for (int i = registre.size() - 1; i >= 0; i--) {
            Personne p = registre.get(i);
            try {
                if (p.getAnneeMort() != -1) {
                    return p;
                }
            } catch (PasMortException e) {

            }
        }
        throw new AucunMortException();
    }

    public Personne chercherPersonne(String nom) throws FauxNomException {
        for (Personne p : registre) {
            if (p.getNom().equals(nom)) {
                return p;
            }
        }
        throw new FauxNomException();
    }

    public void enregistrerMort(String nom, int annemort) throws FauxNomException, DeJaMortException {
        Personne p = chercherPersonne(nom);
        p.meurt(annemort);
    }

    public void suppPersonne(String nom) throws FauxNomException{
        Personne p = chercherPersonne(nom);
        registre.remove(p);
    }


    public void definirAscendant(String nomAscendant, String nomDescendant) throws FauxNomException, AscendantDejaDefiniException, DescendantDejaDefiniException {
        Personne ascendant = chercherPersonne(nomAscendant);
        Personne descendant = chercherPersonne(nomDescendant);
        descendant.setAscendantDe(ascendant);
        ascendant.setDescendantDe(descendant);
        System.out.println(ascendant.getNom() + " est maintenant l'ascendant de " + descendant.getNom());
    }

    public void lierPersonnes(String nom1, String nom2, String dateLien) throws FauxNomException, PersonneDejaLieeException {
        Personne p1 = chercherPersonne(nom1);
        Personne p2 = chercherPersonne(nom2);
        p1.setLien(p2, dateLien);
        p2.setLien(p1, dateLien);
        System.out.println(p1.getNom() + " et " + p2.getNom() + " sont maintenant liés (mariage/pacs) depuis " + dateLien);
    }





    @Override
    public String toString() {
        return "EtatCivil [registre=" + registre + "]";
    }


}
