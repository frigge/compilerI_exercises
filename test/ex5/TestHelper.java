package ex5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import minijava.MJParser;
import minijava.MJScanner;
import minijava.Program;
import beaver.Parser.Exception;

public class TestHelper {

	private static String baseFile = "tests/BaseTestForType.java";

	public static Program buildTest(InputStream stream) throws IOException, Exception {
		MJParser parser = new MJParser();
		Program ast = (Program) parser.parse(new MJScanner(stream));
		ast.check();
		return ast;
	}

	public static Program buildTest(String codeToBeAppended) throws IOException, Exception {
		PipedInputStream is = new PipedInputStream();
		PipedOutputStream os = new PipedOutputStream(is);

		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(os));
		BufferedReader r = new BufferedReader(new FileReader(new File(baseFile)));
		String line;
		while ((line = r.readLine()) != null) {
			w.append(line).append("\n");
		}
		if (codeToBeAppended != null) {
			w.append(codeToBeAppended);
		}
		w.flush();
		w.close();
		Program p = buildTest(is);
		r.close();
		return p;
	}

	public static Program buildTest(File appendCode) throws IOException, Exception {
		if (appendCode != null) {
			BufferedReader r = new BufferedReader(new FileReader(appendCode));
			StringBuilder b = new StringBuilder();

			String line;
			while ((line = r.readLine()) != null) {
				b.append(line).append("\n");
			}
			r.close();
			return buildTest(b.toString());
		} else {
			return buildTest((String) null);
		}
	}
}
