/** 
 * Class Description:########
 * Date : 2018年4月10日 下午4:24:54
 * Auth : ccse 
*/  

package com.thd.jvm.gc.log;

public class GcLog {
	
	private Object instance;
	public GcLog(){
		//为了效果明显,开辟一块内存空间
		byte[] m = new byte[20 * 1024 * 1024];
	}
	/**
	 * JVM参数：-verbose:gc -XX:+PrintGCDetails
	 */
	public static void main(String[] args) {
		GcLog m1 = new GcLog();
		GcLog m2 = new GcLog();
		m1.instance = m2;
		m2.instance = m1;
		
		m1 = null;
		m2 = null;
		
		
		System.gc();
		System.out.println("----------- finish -------------");
		
	}
	
	/**
[GC [PSYoungGen: 42261K->568K(75904K)] 42261K->568K(249408K), 0.0011247 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC (System) [PSYoungGen: 568K->0K(75904K)] [ParOldGen: 0K->474K(173504K)] 568K->474K(249408K) [PSPermGen: 2550K->2549K(21248K)], 0.0054587 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
----------- finish -------------
Heap
 PSYoungGen      total 75904K, used 4576K [0x00000007ab4b0000, 0x00000007b0960000, 0x0000000800000000)
  eden space 65088K, 7% used [0x00000007ab4b0000,0x00000007ab928228,0x00000007af440000)
  from space 10816K, 0% used [0x00000007af440000,0x00000007af440000,0x00000007afed0000)
  to   space 10816K, 0% used [0x00000007afed0000,0x00000007afed0000,0x00000007b0960000)
 ParOldGen       total 173504K, used 474K [0x0000000701e00000, 0x000000070c770000, 0x00000007ab4b0000)
  object space 173504K, 0% used [0x0000000701e00000,0x0000000701e76898,0x000000070c770000)
 PSPermGen       total 21248K, used 2559K [0x00000006fcc00000, 0x00000006fe0c0000, 0x0000000701e00000)
  object space 21248K, 12% used [0x00000006fcc00000,0x00000006fce7fe58,0x00000006fe0c0000)
	 */
	//   [PSYoungGen: 42261K->568K(75904K)]    显示被回收了

}
