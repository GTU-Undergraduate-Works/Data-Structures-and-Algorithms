package duraklefkan.cse222.hw05.part1;


public class Main {

    public static void main(String[] args) {

        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        System.out.println("----DOUBLE HASHING MAP TEST 1 ----");
        System.out.println("-------------------------------------------------");
        System.out.println("After adding element to map");
        map.put("151044035", "Simge");
        map.put("111044074", "Sinan");
        map.put("91044066", "Suleyman");
        map.put("141044094", "Taalai");
        map.put("131044010", "Taip");
        map.put("151044010", "Tarık");
        map.put("161044042", "Yasir");
        map.put("131044058", "Yavuz");
        map.put("141044080", "Yunus");
        map.put("151044043", "Yusuf");
        map.put("151044095", "Yusuf");
        map.put("181041038", "Zeyneb");
        map.put("151044011", "Zeynep");
        map.put("131044056", "Taner");
        System.out.println(map);
        System.out.println("Size of map = " + map.size());
        System.out.println("-------------------------------------------------");
        System.out.println("After removing 151044011=Zeynep and 151044035=Simge");
        map.remove("151044011");
        map.remove("151044035");
        System.out.println(map);
        System.out.println("Size of map = " + map.size());
        System.out.println("-------------------------------------------------");
        System.out.println("Values of map");
        System.out.println(map.values());
        System.out.println("-------------------------------------------------");
        System.out.println("Key set of map");
        System.out.println(map.keySet());
        System.out.println("-------------------------------------------------");
        System.out.println("get(141044080) = " + map.get("141044080"));
        if (map.containsKey("111044074"))
            System.out.println("Map contains key 111044074");
        else
            System.out.println("Map does not contain key 161044086");
        if (map.containsKey("161044086"))
            System.out.println("Map contains key 161044086");
        else
            System.out.println("Map does not contain key 161044086");
        if (map.containsValue("Sinan"))
            System.out.println("Map contains value Sinan");
        else
            System.out.println("Map does not contain value Sinan");
        if (map.containsValue("Efkan"))
            System.out.println("Map contains value Efkan");
        else
            System.out.println("Map does not contain value Efkan");
        System.out.println("After clearing map");
        map.clear();
        System.out.println(map);


        DoubleHashingMap<String, Integer> map2 = new DoubleHashingMap<>(17);
        System.out.println("----DOUBLE HASHING MAP TEST 2 ----");
        System.out.println("-------------------------------------------------");
        System.out.println("After adding element to map");
        map2.put("Istanbul", 15029231);
        map2.put("Erzincan", 231511);
        map2.put("Ankara", 5445026);
        map2.put("Kayseri", 1376722);
        map2.put("Sivas", 621301);
        map2.put("Tokat",602086);
        map2.put("Isparta",433830);
        map2.put("Edirne",433830);
        map2.put("Kastamonu",372373);
        map2.put("Siirt",324394);
        map2.put("Karaman",246672);
        map2.put("Kilis",136319);
        map2.put("Bayburt",80417);
        map2.put("Trabzon",786326);
        map2.put("Denizli",1018735);
        map2.put("Manisa",1413041);
        map2.put("Gaziantep",585252);
        map2.put("Batman",2005515);
        map2.put("Aksaray",402404);
        map2.put("Hakkari",275761);
        System.out.println(map2);
        System.out.println("Size of map = " + map2.size());
        System.out.println("-------------------------------------------------");
        System.out.println("After removing Aksaray=402404 and Edirne=433830");
        map2.remove("Aksaray");
        map2.remove("Edirne");
        System.out.println(map2);
        System.out.println("Size of map = " + map2.size());
        System.out.println("-------------------------------------------------");
        System.out.println("Values of map");
        System.out.println(map2.values());
        System.out.println("-------------------------------------------------");
        System.out.println("Key set of map");
        System.out.println(map2.keySet());
        System.out.println("-------------------------------------------------");
        if (map2.containsKey("Erzincan"))
            System.out.println("Map contains key Erzincan");
        else
            System.out.println("Map does not contain key Erzincan");
        if (map2.containsKey("Erzurum"))
            System.out.println("Map contains key Erzurum");
        else
            System.out.println("Map does not contain key Erzurum");
        if (map2.containsValue(433830))
            System.out.println("Map contains value 433830");
        else
            System.out.println("Map does not contain value 433830");
        if (map2.containsValue(1000000))
            System.out.println("Map contains value 1000000");
        else
            System.out.println("Map does not contain value 1000000");
        System.out.println("After clearing map");
        map2.clear();
        System.out.println(map2);


    }
}
