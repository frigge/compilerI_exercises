class MainTest{
    public static void main(String[] arg0){
    	A a;
    	A2 a2;
    	A wirklichA2;
    	
    	System.out.println(100001);
    	a = new A();
    	System.out.println(100002);
    	a2 = new A2();
    	System.out.println(100003);
    	wirklichA2 = new A2();
    	System.out.println(100004);

    	System.out.println(a.getZahl());
    	System.out.println(100005);
    	System.out.println(a2.getZahl());
    	System.out.println(100006);
    	System.out.println(wirklichA2.getZahl());
    }
}

class A{
	public int getZahl(){
		return 1;
	}
}
class A2 extends A{
	public int getZahl(){
		return 2;
	}
}