import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

public class PlatformTest {

    /*public static void main(String[] args){

        Platform p = new Platform();
        List<Teenager> l = new ArrayList<Teenager>();
        l.add(teenager1);
        AssertEquals(l, p.addTeenager(teenager1));
    }*/

    @BeforeEach
    public Teenager ten(){
        Criterion estAlergique = new Criterion("yes", CriterionName.GUEST_ANIMAL_ALLERGY);
        Criterion estPasAlergique = new Criterion("no", CriterionName.GUEST_ANIMAL_ALLERGY);

        Criterion aUnAnimal = new Criterion("yes", CriterionName.HOST_HAS_ANIMAL);
        Criterion aPasAnimal = new Criterion("no", CriterionName.HOST_HAS_ANIMAL);


        Criterion possedeVege = new Criterion("végétarien", CriterionName.HOST_FOOD);
        Criterion possedeSport = new Criterion("sport", CriterionName.HOST_FOOD);
        Criterion posseDeNonuts = new Criterion("nonuts", CriterionName.HOST_FOOD);
        Criterion posseDeTout = null;

        Criterion mangeVege = new Criterion("végétarien", CriterionName.GUEST_FOOD);
        Criterion mangeSport = new Criterion("sport", CriterionName.GUEST_FOOD);
        Criterion mangeNotnuts = new Criterion("nonuts", CriterionName.GUEST_FOOD);
        Criterion mangeTout = null;

        Map<String, Criterion> reqMrBouffeTout = new HashMap<>();
        reqMrBouffeTout.put(CriterionName.GUEST_ANIMAL_ALLERGY.name(), estPasAlergique);
        reqMrBouffeTout.put(CriterionName.HOST_HAS_ANIMAL.name(), aPasAnimal);
        reqMrBouffeTout.put(CriterionName.HOST_FOOD.name(), posseDeTout);
        reqMrBouffeTout.put(CriterionName.GUEST_FOOD.name(), mangeTout);

        Teenager teenager1 = new Teenager(1, "MrBouffeTout", "Martin", "F", LocalDate.of(2005, 6, 20), Country.FRANCE , reqMrBouffeTout);
        return teenager1;
    }

    @Test
    public void addTeenagerTest(){
        Platform p = new Platform();
        p.addTeenager(ten());
        assertTrue(p.getTeenagerList().contains(ten()));
    }

    @Test
    public void removeTeenagerTest(){
        Platform p = new Platform();
        p.addTeenager(ten());
        assertTrue(p.getTeenagerList().contains(ten()));
        p.removeTeenager(ten());
        assertFalse(p.getTeenagerList().contains(ten()));
    }

    @Test
    public void purgeInvalidRequirements(){
        Platform p = new Platform();
        p.addTeenager(ten());
        assertTrue(p.getTeenagerList().contains(ten()));
        p.purgeInvalidRequirements();
        assertFalse(p.getTeenagerList().contains(ten()));   

    }

    @Test
    public void printCompatibleTeenagers(){
        Platform p = new Platform();
        p.addTeenager(ten());
        assertTrue(p.getTeenagerList().contains(ten()));
        p.printCompatibleTeenagers();
        assertTrue(p.getTeenagerList().contains(ten()));   
    }
}