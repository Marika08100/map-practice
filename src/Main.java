import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Todo Készítsd egy map-et, ami a barátaidnak a régi óvodai jeleit tárolja el!

        Map<String, String> ovodaiJelek = new HashMap<>();

        // TODO Töltsd fel a saját neveddel és jeleddel! Ehhez használd a .put() metódust!

        ovodaiJelek.put("Zámbó Jimmy", "korona");
        ovodaiJelek.put("Marika", "csengő");

        // TODo Vegyél fel egy olyan entry-t is, ahol a kulcs különböző, ám az érték már szerepel az értékek közt!

        ovodaiJelek.put("Robi", "csengő");

        // TODO Vegyél fel egy olyan entry-t, ahol már szereplő kulcsot adsz meg! Mi történik ilyenkor?
        //  Az eredeti érték marad vagy felülíródik vagy összefűzödik?

        ovodaiJelek.put("Robi", "alma");
        System.out.println(ovodaiJelek);

        // TODO Távoltísd el a kulcs alapján az egyik kulcs-érték párt a remove() metódussal!

        ovodaiJelek.remove("Robi");
        System.out.println(ovodaiJelek);

        // TODO Kérd le a .get() metódussal az egyik kulcshoz tartozó értéket és írasd ki!

        System.out.println(ovodaiJelek.get("Marika"));

        // TODO Írd ki az összes kulcsot a .keySet()-tel!

        System.out.println(ovodaiJelek.keySet()); // kulcs
        // TODO Tedd meg ugyanezt az értékekre, keresd meg, melyik metódus használható erre!

        System.out.println(ovodaiJelek.values()); // ertek

        // TODO Vizsgáld meg mi a különbség aközött, ha csak a maped írod ki,
        //  és ha a map entrySet()-jét!

        System.out.println(ovodaiJelek.entrySet()); // kulcs+ertek

        // TODO Hogyan oldanád meg, hogy kicseréld a saját óvodai jeledet egy másikra?

        ovodaiJelek.replace("Zámbó Jimmy ", "korona", "baba");
        ovodaiJelek.put("Zámbó Jimmy", "baba");
        System.out.println(ovodaiJelek.entrySet());


// TODO Írj egy mapet, ami testmagasságaokat tart számon! Add hozzá az alábbi értékeket:

        Map<String, Integer> heightMap = new HashMap<>();
        heightMap.put("Sziproka", 131);
        heightMap.put("Csuporka", 134);
        heightMap.put("Puszedli", 123);
        heightMap.put("X-Professzor", 185);
        heightMap.put("Mohó Jojó", 152);

        // TODO Írasd ki az összes testmagasságot! (A neveket NE!)

        System.out.println(heightMap.values());

        // TODO Írd ki, mekkora a legnagyobb testmagasság!

        int maxHeight = Integer.MIN_VALUE;
        for (int highest : heightMap.values()) {
            if (highest > maxHeight) {
                maxHeight = highest;
            }
        }
        System.out.println(maxHeight);

        // TODO Írd ki, ki a legmagasabb! Ez már sokkal csúnyább megoldás lesz :)
        int highest = Integer.MIN_VALUE;
        for (int height : heightMap.values()) {
            if (height > highest) {
                highest = height;
            }
        }
        for (Map.Entry<String, Integer> entry : heightMap.entrySet()) {
            if (entry.getValue() == highest) {
                System.out.println("Legnagyobb " + entry.getKey());
            }
        }
        // TODO Írd ki, ki a legalacsonyabb!
        int min = Integer.MAX_VALUE;
//        for (int minHeight : heightMap.values()) {
//            if (minHeight < min) {
//                min = minHeight;
//            }
//        }
//        for (Map.Entry<String, Integer> entry : heightMap.entrySet()) {
//            if (entry.getValue() == min) {
//                System.out.println("Legkisebb " + entry.getKey());
//
//            }
        Map.Entry<String, Integer> minEntry = null;
        for (var actual : heightMap.entrySet()) {
            if (actual.getValue() < min) {
                min = actual.getValue();
                minEntry = actual;
            }
        }
        assert minEntry != null;
        System.out.println(minEntry.getKey());


        // TODO Sziporka kiállt az esőbe és nőtt 1 centit: növeld meg a magasságát 1-gyel!
        //  (Ne a put()-ot írd át!) Nem kell túlbonyolítani, 1-2 sor összesen!
        if (!heightMap.containsKey("Sziporka")) {
            heightMap.put("Sziporka", 0);
        }
        heightMap.put("Sziporka", heightMap.get("Sziporka") + 1);

        // TODO 2.c Vissza az iskolapadba!
        //Készítsünk el egy jegyeket eltároló mapet grades néven,
        // ami minden tanulóhoz hozzátársít egy listát, amiben a jegyei szerepelnek!

        Map<String, List<Integer>> grades = new HashMap<>();

        grades.put("Alice", Arrays.asList(5, 2, 1));
        grades.put("Bob", Arrays.asList(4, 3));
        grades.put("Charlie", Arrays.asList(2, 4, 5));


        /**
         * Szorgalmi: Félévi átlag
         * Készíts egy olyan mapet, ami egy névhez társít egy darab jegyet,
         * ez a jegy lesz a tanuló félév végi jegye matekból.
         * Készítsd még ilyen mapeket töriből, irodalomból és kémiából.
         * <p>
         * Ezen mapek alapján fűzz össze egy olyan mapet, ami tartalmazza a tanuló
         * minden egyes tantárgyból kapott félév végi jegyét! Tehát ha Julika 1-est kapott matekból, 3-ast kémiából
         * és matekból és 4-est irodalomból, akkor hozzá ez a
         * négy szám (1, 3, 3, 4) tartozzon az új mapben! (A sorrend nem számít!)
         **/

        Map<String, Integer> math = new HashMap<>();
        math.put("Mary", 5);
        math.put("Chloe", 2);
        Map<String, Integer> history = new HashMap<>();
        history.put("Mary", 4);
        history.put("Chloe", 4);
        Map<String, Integer> literature = new HashMap<>();
        literature.put("Mary", 3);
        literature.put("Chloe", 5);
        Map<String, Integer> chemistry = new HashMap<>();
        chemistry.put("Mary", 5);
        chemistry.put("Chloe", 1);

        Map<String, Map<String, Integer>> semesterGrades = new HashMap<>();
        semesterGrades.put("Math", math);
        semesterGrades.put("History", history);
        semesterGrades.put("Literature", literature);
        semesterGrades.put("Chemistry", chemistry);

        for (String subject : semesterGrades.keySet()) {
            Map<String, Integer> studentGrades = semesterGrades.get(subject);
            for (String student : studentGrades.keySet()) {
                int grade = studentGrades.get(student);
                System.out.println(student + ": " + grade);
            }
            System.out.println();
        }
    }
}


