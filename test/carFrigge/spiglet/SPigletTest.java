package carFrigge.spiglet;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import carFrigge.kanga.KangaHelper;
import de.tu.testing.TestHelper;
import beaver.Parser.Exception;

public class SPigletTest {
	@Test
	public void testBaseProgram() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/MainTestForPiglet.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(1, result.size());
		assertEquals("15", result.get(0));
	}
	@Test
	public void testMultipleClassDecls() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
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
	public void testArray() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
		File f = new File("tests/carFrigge/MainTestForPigletArray.java");
		spiglet.Program p = TestHelper.buildSpiglet(f);
		List<String> result = TestHelper.getOutput(p);
		assertEquals(2, result.size());
		assertEquals("0", result.get(0));
		assertEquals("1", result.get(1));
	}
	@Test
	public void testParameter() throws IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
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
}
