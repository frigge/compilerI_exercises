class MainTest{
    public static void main(String[] arg0){
    }
}


class FehlerSammlung{
	Integer a;
	MissingType b;
	int c;
	int[] d;
	int x;
	int y;

	Methodensammlung m;
	
	public int funktionierenderArrayZugriff(){
		d[c] = c;
		return 0;
	}
	
	public int falscherArrayZugriffPos(){
		d[a] = c;
		return 0;
	}
	
	public int falscherArrayZugriffValue(){
		d[c] = a;
		return 0;
	}
}

class Integer{
}

class Methodensammlung{
	
}

class A1{
}
class A2 extends A1{
}

class B1{
	public int a(){
		return 0;
	}
}
class B2 extends B1{
	public int b(){
		return 0;
	}
}
