package carFrigge.kanga;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import beaver.Parser.Exception;
import de.tu.testing.TestHelper;

public class KangaHelper {
	public static List<String> getOutput(File f) throws IOException, Exception{
		spiglet.Program sp = TestHelper.buildSpiglet(f);
		kanga.Program kp = sp.toKanga();
		System.out.println(kp.print().getString());
		
		PrintStream sout = System.out;
		PipedOutputStream outPipeOut = new PipedOutputStream();
		InputStream outPipeIn = new PipedInputStream(outPipeOut);
		PrintStream out = new PrintStream(outPipeOut);
		List<String> result = new ArrayList<>();
		System.setOut(out);
		kp.execute();
		System.setOut(sout);
		out.flush();
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(outPipeIn));
		String line;
		while((line = in.readLine()) != null){
			result.add(line);
		}
		in.close();
		return result;
	}
}
