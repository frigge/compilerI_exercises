package ex5;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import minijava.Program;

import org.junit.Test;

import beaver.Parser.Exception;

public class TypeTest {

	public Program buildTest(File appendCode) throws IOException, Exception{
		return TestHelper.buildTest(appendCode);
	}
	
	@Test
	public void testBaseProgram() throws IOException, Exception {
		Program p = buildTest(null);
		assertEquals(0, p.error().size());
	}

	@Test
	public void testNoError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_allRight.txt"));
		assertEquals(0, p.error().size());
	}

	@Test
	public void testSysoOk() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_sysoWorking.txt"));
		assertEquals(0, p.error().size());
	}

	@Test
	public void testSysoError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_sysoError.txt"));
		assertEquals(1, p.error().size());
	}

	@Test
	public void testMissingType() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_missingType.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testIfNoError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_ifWorking.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testIfError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_ifError.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testWhileNoError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_whileWorking.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testWhileError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_whileError.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testArrayZugriffOk() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_arrayOk.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testFalscherArrayZugriffPos() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_arrayPos.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testFalscherArrayZugriffWert() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_arrayWert.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testFalscherArrayZugriffArray() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_arrayArray.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testGueltigerMethodenAufrufInt() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_methodeInt.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testUnGueltigerMethodenAufrufIntParam() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_methodeIntErrorParam.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testUnGueltigerMethodenAufrufIntWert() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_methodeIntErrorReturn.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testMethodenReturnError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_returnError.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testMethodeVererbung() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_methodeVererbung.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testMethodeParameterVererbung() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_methodeParameterVererbung.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testMethodeParameterVererbungError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_methodeParameterVererbungError.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testMethodeUneindeutig() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_methodeUneindeutig.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testConstructor() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_constructor.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testConstructorError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_constructorError.txt"));
		assertEquals(1, p.error().size());
	}
	
	@Test
	public void testBooleanLit() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_booleanLit.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testThisWorking() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_this.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testThisVererbung() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_thisVererbung.txt"));
		assertEquals(0, p.error().size());
	}
	
	@Test
	public void testThisError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_thisError.txt"));
		assertEquals(1, p.error().size());
	}

}
