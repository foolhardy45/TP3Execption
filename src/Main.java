import ExercicePersonnesMortesEnonce.DeJaMortException;
import ExercicePersonnesMortesEnonce.Personne;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Personne p1 = new Personne("t", 2004);
        Personne p2 = new Personne("A", 45);
        ArrayList Ec1 = new ArrayList<>();
        Ec1.add(p1);
        Ec1.add(p2);
        EtatCivil paris = new EtatCivil(Ec1);
        try {

            p2.meurt(1971);
            System.out.println("t mort");
        } catch (DeJaMortException e) {
            System.out.println("AHAHAHAHAHA IL EST MORT");
        }

        System.out.printf("" + paris.auMoinsUnVivant());
    }
}