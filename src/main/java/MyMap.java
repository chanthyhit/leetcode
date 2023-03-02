import java.util.*;
import java.util.stream.Collectors;

public class MyMap {

    public static void main(String[] args) {
        //sortedList().forEach(System.out::println);
        //modifyString();
        sortByVal();
        //getRepeatChar();
    }


    static void modifyString(){
        String str = "Huahuw|UEJad|LLJJGF|jwiiwu|GHJjs|jj|";
        String s = str.replace("|","[HELLO]");
        System.out.println(s);
    }
    static List<String> sortedList(){
        String[] strs = {
                "BBBakjfiwijw",
                "!ZZZZijfiwls",
                "AAaajiijjjfj",
                "#XXjdiiwlLLf",
                "1JIJJFIIWLJf",
                "cccjiwijirtl"
        };

        List<String> sorted = new ArrayList<>(Arrays.stream(strs).collect(Collectors.toList()));
        List<String> tmp = sorted.stream().sorted().collect(Collectors.toList());
        return tmp;
    }
    static int[] getRepeatChar(){
        String str = "safioeksauieaaooaytarrabamaaxxxa";
        Set<Character> charSet = str.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        Map<Character, Integer> result = new TreeMap<>();
        List<String> res = new ArrayList<>();

        for(char c : charSet){
            int x = 0;
            int count = 0;
            List<Integer> position = new ArrayList<>();
            for(int y=0; y< str.length(); y++){
                if(c == str.charAt(x)){
                    count ++;
                    result.put(c, count);
                    position.add(x);
                    //System.out.println(str.charAt(x) +" "+ x);
                }
                x ++;
            }
        }
        //result.forEach((k,v)-> System.out.println(k +" "+ v));
        return new int[]{0};
    }
    static void sortByVal(){

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
