package learn.just.test;

/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月30日下午3:13:35
 * @desc:
 */
public class EnumTest {
	
	public enum Color{
		Red(1,"red"),Blue(2,"blue"),Yellow(3,"yellow");
		final String name;
		final int order;
		private Color(int order,String name){
			this.order = order;
			this.name = name;
		}
		public static String getName(int order){
			Color[] color = Color.values();
			for(Color col : color){
				if(col.order == order ){
					return col.name;
				}
			}
			return null;
		}
	}
	public static void main(String[] args) {
		System.out.println(Color.Red.name());
		System.out.println(Color.Red.ordinal());
		System.out.println(Color.getName(1));
		System.out.println(Color.valueOf("Red")); 
	}

}
