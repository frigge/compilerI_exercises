package carFrigge.spiglet;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;

import beaver.Parser.Exception;
import de.tu.testing.TestHelper;

public class SPigletTest {
	@Test
	public void testBaseProgram() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/MainTestForPiglet.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(1, result.size());
		assertEquals("15", result.get(0));
	}

	@Test
	public void testMultipleClassDecls() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/MainTestForPigletWithMultipleClassDecls.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(6, result.size());
		assertEquals("1", result.get(0));
		assertEquals("3", result.get(1));
		assertEquals("2", result.get(2));
		assertEquals("3", result.get(3));
		assertEquals("2", result.get(4));
		assertEquals("3", result.get(5));
	}

	@Test
	public void testArray() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/MainTestForPigletArray.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(2, result.size());
		assertEquals("0", result.get(0));
		assertEquals("1", result.get(1));
	}

	@Test
	public void testParameter() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/MainTestForKangaParameter.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(6, result.size());
		assertEquals("1", result.get(0));
		assertEquals("2", result.get(1));
		assertEquals("3", result.get(2));
		assertEquals("4", result.get(3));
		assertEquals("5", result.get(4));
		assertEquals("6", result.get(5));
	}
	@Test
	public void testInnerIf1() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/InnerIf1.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(1, result.size());
		assertEquals("2", result.get(0));
	}
	@Test
	public void testInnerIf2() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/InnerIf2.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(1, result.size());
		assertEquals("1", result.get(0));
	}
	@Test
	public void testInnerIf3() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/InnerIf3.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(2, result.size());
		assertEquals("3", result.get(0));
		assertEquals("4", result.get(1));
	}
	@Test
	public void testInnerIf4() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/InnerIf4.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(1, result.size());
		assertEquals("4", result.get(0));
	}
	@Test
	public void testInnerWhile() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/InnerWhile.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(5, result.size());
		assertEquals("5", result.get(0));
		assertEquals("4", result.get(1));
		assertEquals("3", result.get(2));
		assertEquals("2", result.get(3));
		assertEquals("1", result.get(4));
	}
	@Test
	public void testArrayList() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/ArrayList.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(9, result.size());
		assertEquals("0", result.get(0));
		assertEquals("0", result.get(1));
		assertEquals("1", result.get(2));
		assertEquals("2", result.get(3));
		assertEquals("9", result.get(4));
		assertEquals("5", result.get(5));
		assertEquals("0", result.get(6));
		assertEquals("7", result.get(7));
		assertEquals("9", result.get(8));
	}
	@Test
	public void testArraySize() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/ArraySizeTest.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(1, result.size());
		assertEquals("14", result.get(0));
	}
}
