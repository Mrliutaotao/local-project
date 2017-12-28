package learn.just.test;

 import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

 
/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月28日下午8:16:30
 * @desc:
 */
public class ListTest {


	public static void main(String[] args) {
		
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(null);
		vector.add(null);
		System.out.println(vector);
		
		/*LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(0);
		linkedList.add(1);
		System.out.println(linkedList);*/
		
		
		
		
		/*List<Integer> aList = new ArrayList<Integer>();
		new ArrayList();
		aList.add(2);
		aList.add(1);
		aList.size();
		aList.set(2, 3);
		List<Integer> bList = new ArrayList<Integer>();
 		Integer [] intArray = new Integer[3];
		System.arraycopy(aList.toArray(), 0, intArray, 0, 1);
		Object[] aObjects = Arrays.copyOf(aList.toArray(),1);
		System.out.println(aObjects);
		System.out.println(intArray);*/

	}

}
