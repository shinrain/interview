import java.util.*;
import java.lang.*;
/*
Boxes
-----
有若干个盒子，每个盒子有length和width，不考虑高度。只要尺寸fit，大盒子就可以放小盒子，但是一层只能套一个，即便还有空余；但可以多层嵌套。  
求最小的面积放所有的盒子  
比如 ``7*7`` , ``5*5``, ``4*6``, ``3*3``, 答案是 ``7*7 + 4*6``.
*/

class solution
{
	static class Boxes implements Comparable
	{
		int i, j;
		Boxes(int _i, int _j)
		{
			i=_i; j=_j;
		}
		public int compareTo(Object o)
		{
			if(o==null || !(o instanceof Boxes)) return -1;
			Boxes b = (Boxes)o;
			return -getArea()+b.getArea();
		}
		int getArea()
		{
			return i*j;
		}
		public String toString()
		{
			return "["+i+", "+j+"]";
		}
	}

	int area(Boxes[] box)
	{
		int n = box.length;
		if(n==0) return 0;
		if(n==1) return box[0].getArea();

		Arrays.sort(box);
		ArrayList<Boxes> list = new ArrayList<>();
		for(Boxes b:box) list.add(b);
		int max = 0;
		while(!list.isEmpty())
		{
			max+=removeBox(list);
		}
		return max;
	}

	int removeBox(ArrayList<Boxes> list)
	{
		if(list.size()==0) return 0;
		Boxes base = list.remove(0);

		ArrayList<Boxes> cp = new ArrayList<>(list);
		list.clear();
		Boxes cur = base;
		for(Boxes b:cp)
		{
			if(b.i<cur.i && b.j<cur.j)
			{
				cur = b;
			}
			else list.add(b);
		}
		return base.getArea();
	}

	public static void main(String[] args) {
		Boxes[] b=  {new Boxes(7,7), new Boxes(5,5), new Boxes(4,6), new Boxes(3,3)};
		System.out.println(new solution().area(b));
	}
}