import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class BatchReader {
	private String inputFile;
	private int blockSize;
	private BufferedReader sr;
	public BatchReader(String inputFile, int blockSize)
	{
		try{
			InputStream inputStream = new FileInputStream(inputFile);
			// wrap if it ends with .gz	
			if (inputFile.endsWith(".gz")) {
				inputStream = new GZIPInputStream(inputStream);
			}
			sr = new BufferedReader(new InputStreamReader(inputStream));
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		this.inputFile=inputFile;
		this.blockSize=blockSize;
	}
	
	
	public String[] getBatch()
	{
		ArrayList<String> toret=new ArrayList<String>();
		try
		{
			String line;
			int eCount=0;
			while(eCount < this.blockSize && (line=sr.readLine())!=null)
			{
				toret.add(line);
				eCount++;
			}		
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		
		
		// Convert to String[]
		String[] tr=new String[toret.size()];
		int counter=0;
		for(String l: toret)
		{
			tr[counter]=l;
			counter++;
		}
		
		return  tr;
	}
	
	public void close()
	{
		try
		{
			sr.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

}
