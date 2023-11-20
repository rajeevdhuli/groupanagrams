class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<Pair<String,String>> list = new ArrayList<>();
        for(String str:words){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String res = String.valueOf(c);
            if(list.size() == 0)
               list.add(new Pair(res,str));
            else if(!list.get(list.size() - 1).getKey().equals(res)){
                list.add(new Pair(res,str));
            }  

        }
        List<String> arrayList = new ArrayList<>();
        for (Pair<String, String> pair : list) {
            arrayList.add(pair.getValue());
        } 
        return arrayList;
    }
}




class Solution {
    public List<String> removeAnagrams(String[] words) {
        String prev ="";
        List<String> li=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            char[] ch=words[i].toCharArray();
            Arrays.sort(ch);
            String curr=String.valueOf(ch);
            if(!curr.equals(prev)){
                li.add(words[i]);
                prev=curr;
            }
        }
        return li;
    }
}
