package piglet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import beaver.Parser.Exception;

public class TestHelper {
	public static Program buildTest(InputStream stream) throws IOException, Exception {
		minijava.Program p = ex5.TestHelper.buildTest(stream);
		return p.toPiglet();
	}

	public static Program buildTest(String codeToBeAppended) throws IOException, Exception {
		minijava.Program p = ex5.TestHelper.buildTest(codeToBeAppended);
		return p.toPiglet();
	}

	public static Program buildTest(File appendCode) throws IOException, Exception {
		minijava.Program p = ex5.TestHelper.buildTest(appendCode);
		return p.toPiglet();
	}
	
	public static List<String> getOutput(File code) throws FileNotFoundException, IOException, Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		Program p = TestHelper.buildTest(new FileInputStream(code));
		List<String> result = TestHelper.getOutput(p);
		return result;
	}
	
	public static List<String> getOutput(String pigletCode) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		PrintStream sout = System.out;
		InputStream sin = System.in;
		
		List<String> result = new ArrayList<>();
		PipedOutputStream outPipeOut = new PipedOutputStream();
		InputStream outPipeIn = new PipedInputStream(outPipeOut);
		PrintStream out = new PrintStream(outPipeOut);
		System.setOut(out);
		
		PipedOutputStream inPipeOut = new PipedOutputStream();
		InputStream inPipeIn = new PipedInputStream(inPipeOut);
		System.setIn(inPipeIn);
		
		String[] params = {};
		Method s = Class.forName("PgInterpreter").getMethod("main", String[].class);
		SendTextRunnable str = new SendTextRunnable(pigletCode, inPipeOut);
		new Thread(str).start();
		s.invoke(null, new Object[]{params});
		System.setOut(sout);
		System.setIn(sin);
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
	
	public static List<String> getOutput(Program p) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		return getOutput(p.toString());
	}
	
	private static class SendTextRunnable implements Runnable {
		private static final int WAIT_DURATION = 200;
		private String text;
		private OutputStream streamToWriteTo;
		
		public SendTextRunnable(String text, OutputStream streamToWriteTo){
			this.text = text;
			this.streamToWriteTo = streamToWriteTo;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(WAIT_DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(streamToWriteTo));
			try {
				w.append(text);
				w.flush();
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
