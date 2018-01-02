package learn.just.test;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

 
/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月28日下午10:12:50
 * @desc:
 */
public class SetsTest {

	  
	public static void main(String[] args) {
		 Set<Integer> set = new HashSet<Integer>();
		 set.add(1);
		 set.add(1);
		 set.add(null);
		 System.out.println(set);
		 
		 BitSet bitSet = new BitSet();
		 bitSet.set(1);
		 bitSet.set(2);
		 bitSet.set(70);
		 bitSet.set(70,false);
 		 System.out.println(bitSet.get(70));
		 System.out.println(bitSet.size());

	}

}
