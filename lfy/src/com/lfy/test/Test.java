package com.lfy.test;

public class Test {
    //插入排序
    public void insertArray(Integer[] in ) {
        int tem = 0;
        int num = 0;
        int upnum = 0;
        for (int i = 0; i < in .length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                num++;
                if ( in [j + 1] < in [j]) {
                    tem = in [j + 1]; in [j + 1] = in [j]; in [j] = tem;
                    upnum++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < in .length; i++) {
            System.out.print( in [i]);
            if (i < in .length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("插入排序循环次数:" + num);
        System.out.println("移动次数：" + upnum);
        System.out.print("\n\n\n");
    }
   //选择排序
    public void chooseArray(Integer[] in ) {
        int tem = 0;
        int num = 0;
        int upnum = 0;
        for (int i = 0; i < in .length; i++) {
            for (int j = 0; j < in .length - 1; j++) {
                num++;
                if ( in [j + 1] < in [j]) {
                    tem = in [j + 1]; in [j + 1] = in [j]; in [j] = tem;
                    upnum++;
                }
            }
        }
        for (int i = 0; i < in .length; i++) {
            System.out.print( in [i]);
            if (i < in .length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("选择排序循环次数:" + num);
        System.out.println("移动次数：" + upnum);
        System.out.print("\n\n\n");
    }
    //冒泡排序
    public void efferArray(Integer[] in ) {
        int tem = 0;
        int num = 0;
        int upnum = 0;
        for (int i = 0; i < in .length; i++) {
            for (int j = i; j < in .length - 1; j++) {
                num++;
                if ( in [j + 1] < in [i]) {
                    tem = in [j + 1]; in [j + 1] = in [i]; in [i] = tem;
                    upnum++;
                }
            }
        }
        for (int i = 0; i < in .length; i++) {
            System.out.print( in [i]);
            if (i < in .length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("冒泡排序循环次数:" + num);
        System.out.println("移动次数：" + upnum);
        System.out.print("\n\n\n");
    }
    //打印乘法口诀
    public void printMulti() {
        for (int j = 1; j < 10; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(i + " * " + j + " = " + j * i + "\t");
            }
            System.out.print("\t\n");
        }
        System.out.print("\n\n\n");
    }
    //打印N * 1 + N * 2 + N * 3 =num的所有组合
    public void printNumAssemble(int num) {
        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < num / 2 + 1; j++) {
                for (int in = 0; in < num / 3 + 1; in ++) {
                    if (i * 1 + j * 2 + in * 3 == num) {
                        System.out.println("小马" + i + ",\t中马" + j + ",\t大马" + in );
                    }
                }
            }
        }
    }
    public void pringString(Integer[] in) {

        for (int i = 0; i < in .length; i++) {
        System.out.print( in [i]);
        if (i < in .length - 1) {
            System.out.print(",");
        }
    }
      System.out.println();
	}
    //插入排序
    public void insertArrayTest(Integer[] in ) {
//    	 Integer in1[] = {
//    	            8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897
//    	        };
        int tem = 0;
        pringString(in);
        for (int i = 0; i < in .length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ( in [j + 1] < in [j]) {
                	System.out.println("in ["+(j + 1)+"]:" +  in [j + 1] + "	in ["+j+"]:" + in [j]);
                    tem = in [j + 1]; in [j + 1] = in [j]; in [j] = tem;
                    pringString(in);
                } else {
                    break;
                }
            }
        }
//        for (int i = 0; i < in .length; i++) {
//            System.out.print( in [i]);
//            if (i < in .length - 1) {
//                System.out.print(",");
//            }
//        }
//        System.out.println();
//        System.out.println("插入排序循环次数:" + num);
//        System.out.println("移动次数：" + upnum);
//        System.out.print("\n\n\n");
    }

    //求阶乘 方法一
    private static int m1(int n) {
    	System.out.println(n);
        if (n == 1) return 1;
        return n *= m1(n - 1);
    }
    //求阶乘 方法二
    public static int m2(int n) {
        if (n == 1) {
            return 1;
        }
        int i = 1;
        int res = 1;
        while (i <= n) {
            res *= i;
            i++;
        }
        return res;
    }

    
    /**
 * @param args
 */
    public static void main(String[] args) {
    	Test jwzw = new Test();
        int num = 3;
//        jwzw.printMulti(); //打印乘法口诀
//        jwzw.printNumAssemble(100); //打印N * 1 + N * 2 + N * 3 =num的所有组合
        Integer in [] = {
            8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897
        };
//        jwzw.efferArray( in ); //冒泡排序
//        Integer in1[] = {
//            8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897
//        };
        Integer in1[] = {
        		15,14,13,12,11,10,9,8,7,6,5,4,3,2,1
        };
//        jwzw.insertArray(in1); //插入排序
        Integer in2[] = {
            8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897
        };
//        jwzw.chooseArray(in2); //选择排序
        //int i = num++;
        //System.out.println(i);
//        System.out.println(1000 >> 2);
//        jwzw.insertArrayTest(in);
        
        int a = 1;
        if(a>0) System.out.println(1);else System.out.println(0);
        
        
    }
}
