import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyMap {

    public static void main(String[] args) {
        String[] arr = {"z","a","b","e","c","d"};
        Map<String, Integer> map = new HashMap<>();
        map.put("z",2);
        map.put("a",1);
        map.put("b",3);

        /*listTesting(arr);
        setTesting(arr);
        mapTesting(map);*/

        /*strReplace();
        mapSortByVal();
        sortedSet();
        countChar();*/
        //countWords();
        //countChar();
        //countChar();

    }



    static void mapTesting(Map<String, Integer> args){
        args.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        BiConsumer<String, Integer> biConsumer = (k,v)-> System.out.println(""+ k +" "+ v);
        args.forEach(biConsumer);

    }

    static void listTesting(String[] args){
        List<String> list = new ArrayList<>(Arrays.asList(args));
        System.out.println("List");
        list.forEach(System.out::print);
    }

    static void setTesting(String[] args){
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(args));
        System.out.println("\nSet");
        set.forEach(System.out::print);
        System.out.println();
    }


    static void strReplace(){
        String str = "Huahuw|UEJad|LLJJGF|jwiiwu|GHJjs|jj|";
        System.out.println(str.replace("|","[HELLO]"));
    }
    static void sortedSet(){
        String[] arr = {
                "BBBakjfiwijw",
                "!ZZZZijfiwls",
                "AAaajiijjjfj",
                "#XXjdiiwlLLf",
                "1JIJJFIIWLJf",
                "cccjiwijirtl"
        };

        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        set.addAll(Arrays.asList(arr));
        set.forEach(System.out::println);
    }

    static void countWords(){
        List<String> words = Arrays.asList("hello", "world", "hello", "java", "world", "hello");

        Map<String, Long> wordCounts = words.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0L, e -> 1L, Long::sum)));


        words.stream()
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.reducing(0L, e->1L, Long::sum))).forEach((k,v)-> System.out.println(k +" "+ v));

        //System.out.println(wordCounts);
    }
    static void countChar(){
        String str = "safioeksauieaaooaytarrabamaaxxxayc";

        Map<Character, List<Integer>> letterPositions = IntStream.range(0, str.length())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(str.charAt(i), i))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        Map<Character, Long> a = IntStream.range(0, str.length())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(str.charAt(i), i))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue,
                                Collectors.reducing(0L, e->1L, Long::sum)
                        ))).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n)->o, LinkedHashMap::new));
        System.out.println(a);
        System.out.println(letterPositions);
    }
    static void countChar1(){
        String[] strings = "safioeksauieaaooaytarrabamaaxxxayc".split("");
        Map<String, Integer> gr=Arrays.stream(strings)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0,e->1,Integer::sum)));
        System.out.println(gr);
    }
    static void mapSortByVal(){

        Map<String, Integer> map = new TreeMap<>();
        map.put("DHUHUHUSS", 22);
        map.put("JIIEEE",1);
        map.put("KIIEEE",11);
        map.put("LIIEEE",9);
        map.put("BIIEEE",10);

        Map<String, Integer> sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n)->o, LinkedHashMap::new));
        sorted.forEach((k,v)-> System.out.println(String.format("%s %s", k, v)));
    }
}
