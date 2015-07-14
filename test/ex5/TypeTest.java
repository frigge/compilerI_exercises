package ex5;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import minijava.MJParser;
import minijava.MJScanner;
import minijava.Program;

import org.junit.Test;

import beaver.Parser.Exception;

public class TypeTest {
	
	private static String baseFile = "tests/BaseTestForType.java";

	public Program buildTest(InputStream stream) throws IOException, Exception{
		 MJParser parser = new MJParser();
		 Program ast = (Program) parser.parse(new MJScanner(stream));
		 ast.check();
		 return ast;
	}
	
	public Program buildTest(String codeToBeAppended) throws IOException, Exception{
		PipedInputStream is = new PipedInputStream();
		PipedOutputStream os = new PipedOutputStream(is);
		
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(os));
		BufferedReader r = new BufferedReader(new FileReader(new File(baseFile)));
		String line;
		while((line = r.readLine()) != null){
			w.append(line).append("\n");
		}
		if(codeToBeAppended != null){
			w.append(codeToBeAppended);
		}
		w.flush();
		os.close();
		Program p = buildTest(is);
		is.close();
		return p;
	}
	
	public Program buildTest(File appendCode) throws IOException, Exception{
		BufferedReader r = new BufferedReader(new FileReader(appendCode));
		StringBuilder b = new StringBuilder();
		
		String line;
		while((line = r.readLine()) != null){
			b.append(line).append("\n");
		}
		r.close();
		return buildTest(b.toString());
	}
	
	@Test
	public void testBaseProgram() throws IOException, Exception {
		Program p = buildTest("");
		assertEquals(0, p.error().size());
	}

	@Test
	public void testNoError() throws IOException, Exception {
		Program p = buildTest(new File("tests/JUnitTestCases/type_allRight.txt"));
		assertEquals(0, p.error().size());
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

}
