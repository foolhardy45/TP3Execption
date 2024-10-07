
import ExercicePersonnesMortesEnonce.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestEtatCivil {
    private Personne p1;
    private Personne p2;
    private Personne p3;
    private Personne p4;
    private EtatCivil etatCivil = new EtatCivil(new ArrayList<>());


    @BeforeEach
    void setup(){
        System.out.println("On réinitialise le contexte au cas ou on aurait eu un mort entre temps");
        p1 = new Personne("AA",1988);
        p2 = new Personne("BB",1940);
        p3 = new Personne("CC",2000);
        p4 = new Personne("DD",1960);

        etatCivil.ajouterPersonnage(p1);
        etatCivil.ajouterPersonnage(p2);
        etatCivil.ajouterPersonnage(p3);
        etatCivil.ajouterPersonnage(p4);
    }

    @Test
    public void testNombreDeVivantNormal(){
        System.out.println(etatCivil);
        try{
            p1.meurt(2000);
            p2.meurt(2000);
        }catch (Exception e){
            System.out.println("Changement anormal des test");
        }
        assertEquals(2,etatCivil.nombreDeVivant());
    }





    @Test
    public void testNombreDeVivantMort(){
        System.out.println(etatCivil);
        try{
            p1.meurt(2000);
            p2.meurt(2000);
            p3.meurt(2000);
            p4.meurt(2000);
        }catch (Exception e){
            System.out.println("Changement anormal des test");
        }
        assertEquals(0,etatCivil.nombreDeVivant());
    }



    @Test
    public void testNombreDeVivantTousVivant(){
        System.out.println(etatCivil);
        assertEquals(4,etatCivil.nombreDeVivant());
    }

    @Test
    public void testNombreDeMortApres1960Normal() {
        System.out.println(etatCivil);
        try {
            p1.meurt(1970);
            p2.meurt(1950);
            p3.meurt(1999);
        } catch (Exception e) {
            System.out.println("Changement anormal des tests");
        }
        assertEquals(2, etatCivil.nombreDeMortApres1960());
    }

    @Test
    public void testNombreDeMortApres1960AucunMort() {
        System.out.println(etatCivil);
        assertEquals(0, etatCivil.nombreDeMortApres1960());
    }

    @Test
    public void testTousMort() {
        System.out.println(etatCivil);
        try {
            p1.meurt(2000);
            p2.meurt(1999);
            p3.meurt(1980);
            p4.meurt(2000);
        } catch (Exception e) {
            System.out.println("Changement anormal des tests");
        }

        assertTrue(etatCivil.tousMort());
    }

    @Test
    public void testPasTousMort() {
        System.out.println(etatCivil);
        try {
            p1.meurt(2000);
        } catch (Exception e) {
            System.out.println("Changement anormal des tests");
        }
        System.out.println(etatCivil);
        assertFalse(etatCivil.tousMort());
    }

    @Test
    public void testAuMoinsUnVivant() {
        System.out.println(etatCivil);
        assertTrue(etatCivil.auMoinsUnVivant());
    }

    @Test
    public void testAucunVivant() {
        System.out.println(etatCivil);
        try {
            p1.meurt(2000);
            p2.meurt(1999);
            p3.meurt(1980);
            p4.meurt(2000);
        } catch (Exception e) {
            System.out.println("Changement anormal des tests");
        }
        assertFalse(etatCivil.auMoinsUnVivant());
    }

    @Test
    public void testChercherPremierVivantNormal() {
        System.out.println(etatCivil);
        try {
            p1.meurt(2000);
            assertEquals(p2, etatCivil.chercherPremierVivant());
        } catch (Exception e) {
            System.out.println("Changement anormal des tests");
        }
    }




    @Test
    public void testChercherPremierVivantAucunVivant()  {
        System.out.println(etatCivil);

        assertThrows(AucunVivantException.class, () -> {
            try {
                p1.meurt(2000);
                p2.meurt(1999);
                p3.meurt(1980);
                p4.meurt(2000);
            }catch (Exception e){
                System.out.println("Changement anormal des tests");
            }
            etatCivil.chercherPremierVivant();
        });



    }

    @Test
    public void testChercherDernierMortNormal() {
        System.out.println(etatCivil);
        try {
            p1.meurt(2000);
            p2.meurt(1999);
            assertEquals(p2, etatCivil.chercherDernierMort());
        } catch (Exception e) {
            System.out.println("Changement anormal des tests");
        }
    }

    @Test
    public void testChercherDernierMortAucunMort() throws AucunMortException {
        System.out.println(etatCivil);
        assertThrows(AucunMortException.class, () -> {etatCivil.chercherDernierMort();});
    }
    @Test
    public void testChercherPersonneNomExistant() throws FauxNomException {
        System.out.println(etatCivil);
        assertEquals(p1, etatCivil.chercherPersonne("AA"));
    }

    @Test
    public void testChercherPersonneNomInexistant() throws FauxNomException {
        System.out.println(etatCivil);
        assertThrows(FauxNomException.class, () -> {etatCivil.chercherPersonne("NomInconnu");});
    }
















}
