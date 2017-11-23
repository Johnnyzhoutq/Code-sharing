package com.mwm.test.guava;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class base {
	
	public static void main(String args[]){
		//check(-1,"","","");
		staticOrdering();
		ordering();
	}

	public static void test(){
		Optional<Integer> num  = Optional.of(5);
		System.out.println(num.isPresent());
		System.out.println(num.get());
	}
	
	/**
	 * 检验参数 Preconditions
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param arg4
	 * @return
	 */
	public static boolean check(int arg1, String arg2, String arg3, Object arg4){
		// 检查boolean是否为真  
		// 失败时抛出 IllegalArgumentException 
		// Preconditions.checkArgument(boolean expression, String errMsg, Object... errMsgArgs)
		Preconditions.checkArgument(arg1 > 0, "必须大于0");
		
		// 检查value是否为null  
		// 失败时抛出 NullPointerException  
		// Preconditions.checkNotNull(T reference, String errMsg, Object... errMsgArgs)
		Preconditions.checkNotNull(arg2);

		// 检查对象的一些状态, 不依赖方法参数(相比checkArgument, 在某些情况下更有语义...)  
		// 失败时抛出 IllegalStateException  
		// Preconditions.checkState(boolean expression, String errMsg, Object... errMsgArgs)
		Preconditions.checkState(arg3.equals("3"),"");

		// 检查index是否在合法范围[0, size)(不包含size)  
		// 失败时抛出 IndexOutOfBoundsException  
		// Preconditions.checkElementIndex(int index, int size, String desc)
		Preconditions.checkElementIndex(2,10,"");

		// 检查位置是否在合法范围[0, size](包含size)
		// 失败时抛出 IndexOutOfBoundsException  
		// Preconditions.checkPositionIndex(int index, int size, String desc)
		Preconditions.checkPositionIndex(2,10,"");

		// 检查[start, end)是一个长度为size的集合合法的子集范围
		// 失败时抛出 IndexOutOfBoundsException  
		// Preconditions.checkPositionIndexs(int start, int end, int size)
		Preconditions.checkPositionIndexes(10, 20, 5);
		
		return false;
	}
	
	/**
	 * 比较器(Ordering)
	 * 
	 * Ordering是Guava类库提供的一个犀利强大的比较器工具，Guava的Ordering和JDK Comparator相比功能更强。
	 * 它非常容易扩展，可以轻松构造复杂的comparator，然后用在容器的比较、排序等操作中。
	 */
	public static void staticOrdering(){
		List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");
        System.out.println("list:"+ list);
        
        // 使用Comparable类型的自然顺序， 例如：整数从小到大，字符串是按字典顺序;  
        Ordering<String> naturalOrdering = Ordering.natural();
        // 使用toString()返回的字符串按字典顺序进行排序；
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        // 返回一个所有对象的任意顺序， 即compare(a, b) == 0 就是 a == b (identity equality)。 本身的排序是没有任何含义， 但是在VM的生命周期是一个常量。
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();
        
        System.out.println("naturalOrdering:"+ naturalOrdering.sortedCopy(list));     
        System.out.println("usingToStringOrdering:"+ usingToStringOrdering.sortedCopy(list));        
        System.out.println("arbitraryOrdering:"+ arbitraryOrdering.sortedCopy(list));
	}
	
	/**
	 *  reverse();                            //返回与当前Ordering相反的排序   
	 *	nullsFirst();                         //返回一个将null放在non-null元素之前的Ordering，其他的和原始的Ordering一样  
	 *	nullsLast();                          //返回一个将null放在non-null元素之后的Ordering，其他的和原始的Ordering一样  
	 *	compound(Comparator);                 //返回一个使用Comparator的Ordering，Comparator作为第二排序元素  
	 *	lexicographical();                    //返回一个按照字典元素迭代的Ordering  
	 *	onResultOf(Function);                 //将function应用在各个元素上之后, 在使用原始ordering进行排序  
	 *	greatestOf(Iterable iterable, int k); //返回指定的前k个可迭代的最大的元素，按照当前Ordering从最大到最小的顺序  
	 *	leastOf(Iterable iterable, int k);    //返回指定的前k个可迭代的最小的元素，按照当前Ordering从最小到最大的顺序  
	 *	isOrdered(Iterable);                  //是否有序(前面的元素可以大于或等于后面的元素)，Iterable不能少于2个元素
	 *	isStrictlyOrdered(Iterable);          //是否严格有序(前面的元素必须大于后面的元素)，Iterable不能少于两个元素  
	 *	sortedCopy(Iterable);                 //返回指定的元素作为一个列表的排序副本
	 */
	public static void ordering(){
		List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");
        
        System.out.println("list:"+ list);
        
        Ordering<String> naturalOrdering = Ordering.natural();
        System.out.println("naturalOrdering:"+ naturalOrdering.sortedCopy(list));    

        List<Integer> listReduce= Lists.newArrayList();
        for(int i=9;i>0;i--){
            listReduce.add(i);
        }
        
        List<Integer> listtest= Lists.newArrayList();
        listtest.add(1);
        listtest.add(1);
        listtest.add(1);
        listtest.add(2);
        
        
        Ordering<Integer> naturalIntReduceOrdering = Ordering.natural();
        
        System.out.println("listtest:"+ listtest);
        //是否有序(前面的元素可以大于或等于后面的元素)，Iterable不能少于2个元素
        System.out.println(naturalIntReduceOrdering.isOrdered(listtest));
        //是否严格有序(前面的元素必须大于后面的元素)，Iterable不能少于两个元素  
        System.out.println(naturalIntReduceOrdering.isStrictlyOrdered(listtest));
        
        //返回指定的元素作为一个列表的排序副本
        System.out.println("naturalIntReduceOrdering:"+ naturalIntReduceOrdering.sortedCopy(listReduce));
        System.out.println("listReduce:"+ listReduce);
        
        //排序后  是否有序(前面的元素可以大于或等于后面的元素)，Iterable不能少于2个元素
        System.out.println(naturalIntReduceOrdering.isOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));
        //排序后  是否严格有序(前面的元素必须大于后面的元素)，Iterable不能少于两个元素  
        System.out.println(naturalIntReduceOrdering.isStrictlyOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));
        

        Ordering<String> natural = Ordering.natural();
              
        List<String> abc = ImmutableList.of("a", "b", "c");
        System.out.println(natural.isOrdered(abc));
        System.out.println(natural.isStrictlyOrdered(abc));
        
        //返回与当前Ordering相反的排序   是否有序
        System.out.println("isOrdered reverse :"+ natural.reverse().isOrdered(abc));
 
        List<String> cba = ImmutableList.of("c", "b", "a");
        System.out.println(natural.isOrdered(cba));
        System.out.println(natural.isStrictlyOrdered(cba));
        System.out.println(cba = natural.sortedCopy(cba));
        
        System.out.println("max:"+natural.max(cba));
        System.out.println("min:"+natural.min(cba));
        
        //返回指定的前k个可迭代的最小的元素，按照当前Ordering从最小到最大的顺序  
        System.out.println("leastOf:"+natural.leastOf(cba, 2));
        System.out.println("naturalOrdering:"+ naturalOrdering.sortedCopy(list));    
        System.out.println("leastOf list:"+naturalOrdering.leastOf(list, 3));
        //返回指定的前k个可迭代的最大的元素，按照当前Ordering从最大到最小的顺序 
        System.out.println("greatestOf:"+naturalOrdering.greatestOf(list, 3));
        System.out.println("reverse list :"+ naturalOrdering.reverse().sortedCopy(list));    
        System.out.println("isOrdered list :"+ naturalOrdering.isOrdered(list));
        System.out.println("isOrdered list :"+ naturalOrdering.reverse().isOrdered(list));
        list.add(null);
        System.out.println(" add null list:"+list);
        //返回一个将null放在non-null元素之前的Ordering，其他的和原始的Ordering一样  
        System.out.println("nullsFirst list :"+ naturalOrdering.nullsFirst().sortedCopy(list));
        //返回一个将null放在non-null元素之后的Ordering，其他的和原始的Ordering一样 
        System.out.println("nullsLast list :"+ naturalOrdering.nullsLast().sortedCopy(list));
	}
	
	/**
	 * Object常用方法
	 * 
	 */
	public void equal() {
//		1. 自反性reflexive：任何非空引用x，x.equals(x)返回为true；
//	　　　2. 对称性symmetric：任何非空引用x和y，x.equals(y)返回true当且仅当y.equals(x)返回true；
//	　　　3. 传递性transitive：任何非空引用x和y，如果x.equals(y)返回true，并且y.equals(z)返回true，那么x.equals(z)返回true；
//	　　　4. 一致性consistent：两个非空引用x和y，x.equals(y)的多次调用应该保持一致的结果，（前提条件是在多次比较之间没有修改x和y用于比较的相关信息）；
//	　　　5. 对于所有非null的值x， x.equals(null)都要返回false。 (如果你要用null.equals(x)也可以，会报NullPointerException)。
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a")); 
        System.out.println(Objects.equal("a", null)); 
        System.out.println(Objects.equal(null, null));
    }
}
