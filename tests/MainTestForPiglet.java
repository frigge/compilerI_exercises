class MainTest{
    public static void main(String[] arg0){
    	int a;
    	int b;
    	a = 3;
    	b = 4;
    	a = a+b;
    	if(a < 5){
    		a = 0;
    	} else {
    		a = 1;
    	}
    	while(b < a){
        	System.out.println(b);
        	if(a < 3){
        		a = a + 1;
        	} else {
        		a = a;
        	}
    		b = b - 1;
    	}
    }
}