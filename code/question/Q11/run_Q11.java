import java.util.*;

class run{

	static void subset( Object[] s, Object[] c, int level, LinkedList<Object> Q){
		if(level >= s.length){

			Iterator<Object> it = Q.iterator();
			while(it.hasNext()){
				System.out.print((Character)(it.next())+" ");
			}
				System.out.println();
				return;
		}

		for(int i = 0; i< (Integer)(c[level])+1; i++){
			subset(s,c,level+1,Q);
			Q.addLast(s[level]);			
		}
		for(int i = 0; i< (Integer)(c[level])+1; i++)
			Q.removeLast();
	}

	public static void main(String[] args){
		
		String s = "122";
		char[] st = s.toCharArray();

		Map<Character, Integer> map =  new TreeMap<Character, Integer>();

		for(int i = 0; i<st.length; i++)
			if(map.containsKey(st[i]))
				map.put(st[i], map.get(st[i])+1);
			else
				map.put(st[i], 1);
		LinkedList<Object> Q = new LinkedList<Object>();
		Object[] m1 = map.keySet().toArray();
		Object[] m2 = map.values().toArray();
		for(int i=0; i< m1.length; i++)
			System.out.print("Key "+(Character)(m1[i])+"; Value: "+ (Integer)(m2[i]));

		System.out.println();
		subset(map.keySet().toArray(), map.values().toArray(), 0, Q);	

	}



}
