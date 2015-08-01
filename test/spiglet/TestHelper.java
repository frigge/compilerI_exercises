package spiglet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import beaver.Parser.Exception;

public class TestHelper {
	public static Program buildTest(InputStream stream) throws IOException, Exception {
		piglet.Program p = piglet.TestHelper.buildTest(stream);
		return p.toSpiglet();
	}

	public static Program buildTest(String codeToBeAppended) throws IOException, Exception {
		piglet.Program p = piglet.TestHelper.buildTest(codeToBeAppended);
		return p.toSpiglet();
	}

	public static Program buildTest(File appendCode) throws IOException, Exception {
		piglet.Program p = piglet.TestHelper.buildTest(appendCode);
		return p.toSpiglet();
	}
	
	public static List<String> getOutput(File code) throws FileNotFoundException, IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException{
		Program p = TestHelper.buildTest(new FileInputStream(code));
		List<String> result = TestHelper.getOutput(p);
		return result;
	}
	
	public static List<String> getOutput(Program p) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException{
		return piglet.TestHelper.getOutput(p.toString());
	}
}
