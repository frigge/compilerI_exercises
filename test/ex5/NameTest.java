package ex5;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import minijava.Program;

import org.junit.Test;

import beaver.Parser.Exception;

public class NameTest {

	public Program buildTest(File appendCode) throws IOException, Exception{
		return TestHelper.buildTest(appendCode);
	}
	
	@Test
	public void testDuplicatNameClass() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/name_duplicatNameClass.txt"));
		assertEquals(1, p.error().size());
	}
}
