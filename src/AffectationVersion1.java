import fr.ulille.but.sae2_02.graphes.*;

import java.util.*;

public class AffectationVersion1{

    /**
     * Méthode qui permet de savoir le niveau de compatibilité de 2 adolescent. Il commence avec 10 point, et plus ils seront compatible, plus leurs scores diminueras
     * @param host l'adolescent hôte
     * @param visitor l'adolescent invité
     * @return Le poids de leur compatibilité, plus ils est faible, plus ils sont compatible
     */
    public static double weight (Teenager host, Teenager visitor) {
        double base = 10;
        base -= host.nbLoisirCommun(visitor);
        if(!host.compatibleAnimal(visitor));{
            base += 10;
        }

        return base;
    }

    /**
     * Méthode qui permet de crée les sommets formé par les étudiants pour le graph
     * @param list La liste des étudiants a ajouter
     * @param graph Le graph dans lequel on ajoute les sommets
     */
    public static void addSummit(List<Teenager> list, GrapheNonOrienteValue<Teenager> graph){
        for (Teenager teenager : list) {
            graph.ajouterSommet(teenager);
        }
    }

    /**
     * Méthode qui permet de crée les aretes composant le graph
     * @param guest La liste des étudiants invités a ajouter
     * @param host La liste des étudiants hôtes a ajouter
     * @param graph Le graph dans lequel on ajoute les aretes
     */
    public static void addArete(List<Teenager> guest,List<Teenager> host, GrapheNonOrienteValue<Teenager> graph){
        for (Teenager teenager1 : host) {
            for (Teenager teenager2 : guest){
                graph.ajouterArete(teenager1,teenager2,weight(teenager1,teenager2));
            }
        }
    }

    public static String listToString(List<Teenager> list){
        String ten = "";
        for (Teenager teenager : list){
            ten += teenager.getName() + "\n";
        }
        return ten;
    }

    public static String listAreteToString(List<Arete<Teenager>> list){
        String ten = "";
        for (Arete<Teenager> teenager : list){
            ten += teenager.getExtremite1().getName() + " and " + teenager.getExtremite2().getName()+ ": " +teenager.getPoids() + "\n";
        }
        return ten;
    }
       

    public static void main(String[] args){


        //Création du graph
        GrapheNonOrienteValue<Teenager> graph= new GrapheNonOrienteValue<Teenager>();

        //Création des critéres d'allergie pour les animaux
        Criterion estPasAlergique = new Criterion("no", CriterionName.GUEST_ANIMAL_ALLERGY);
        Criterion estAlergique = new Criterion("yes", CriterionName.GUEST_ANIMAL_ALLERGY);
        Criterion aUnAnimal = new Criterion("yes", CriterionName.HOST_HAS_ANIMAL);
        Criterion aPasAnimal = new Criterion("no", CriterionName.HOST_HAS_ANIMAL);

        

        //Création des requirements a l'aide des critérion précedent
        Map<String, Criterion> guestNoAlergie = new HashMap<>();
        guestNoAlergie.put(CriterionName.GUEST_ANIMAL_ALLERGY.name(), estPasAlergique);
        Map<String, Criterion> guestAlergie = new HashMap<>();
        guestAlergie.put(CriterionName.GUEST_ANIMAL_ALLERGY.name(), estAlergique);
        Map<String, Criterion> hostNoAlergie = new HashMap<>();
        hostNoAlergie.put(CriterionName.HOST_HAS_ANIMAL.name(), aPasAnimal);
        Map<String, Criterion> hostAlergie = new HashMap<>();
        hostAlergie.put(CriterionName.HOST_HAS_ANIMAL.name(), aUnAnimal);
        
        //Création des Teenager a l'aide des requirement précedent
        Teenager A = new Teenager(1, "A", "Adonia", null, null, Country.FRANCE , guestNoAlergie);
        Teenager B = new Teenager(1, "B", "Bellatrix", null, null, Country.FRANCE , guestAlergie);
        Teenager C = new Teenager(1, "C", "Callistra", null, null, Country.FRANCE , guestNoAlergie);
        Teenager X = new Teenager(1, "X", "Xolag", null, null, Country.ITALIE , hostNoAlergie);
        Teenager Y = new Teenager(1, "Y", "Yak", null, null, Country.ITALIE , hostAlergie);
        Teenager Z = new Teenager(1, "Z", "Zander", null, null, Country.ITALIE , hostNoAlergie);

        //Création de liste des étudiants hôtes et invités
        List<Teenager> guest = new ArrayList<Teenager>();
        guest.add(A);
        guest.add(B);
        guest.add(C);
        List<Teenager> host = new ArrayList<Teenager>();
        host.add(X);
        host.add(Y);
        host.add(Z);

        //Création d'une nouvelle affectation
        CalculAffectation<Teenager> calcul = new CalculAffectation<Teenager>(graph,guest,host);

        //Ajout de sommet et aretes au graphe
        addSummit(guest,graph);
        addSummit(host,graph);
        addArete(guest,host,graph);

        System.out.println(listToString(graph.sommets()));
        
        //envoie de la solution
        //System.out.println(graph.toString());
        System.out.println(listAreteToString(calcul.calculerAffectation()));
        //System.out.println(calcul.getCout());
    }
}