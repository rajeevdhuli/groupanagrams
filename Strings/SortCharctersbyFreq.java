o(NLOGN) 
class Solution {
    public static class Pair {
        public char character;
        public int number;

        public Pair(char character, int number) {
            this.character = character;
            this.number = number;
        }
    }
    public String frequencySort(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        String str = "";
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        List<Pair> list = new ArrayList<>();
        for(Character key : mp.keySet()){
            list.add(new Pair(key,mp.get(key)));
        }
        Collections.sort(list, (a, b) -> b.number - a.number);
        StringBuilder result = new StringBuilder();
        for (Pair pair : list) {
            for (int i = 0; i < pair.number; i++) {
                result.append(pair.character);
            }
        }
        return result.toString();
    }
}
