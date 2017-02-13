import java.io.*;
import java.util.zip.GZIPOutputStream;

public class BatchWriter {
	private  BufferedWriter bw;
	private final String outputFile;
	
	
	public BatchWriter(String outputFile)
	{
	
		try
		{
			OutputStream outputStream = new FileOutputStream(outputFile);
			// wrap if it ends with .gz
			if (outputFile.endsWith(".gz")) {
				outputStream = new GZIPOutputStream(outputStream);
			}
			this.bw = new BufferedWriter(new OutputStreamWriter(outputStream));
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}

		this.outputFile=outputFile;
	}
	
	public void writeBatch(String[] batch)
	{
		try{
			for(String s: batch)
			{
				bw.write(s+"\n");
			}			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}

	}
	
	public void close()
	{
		try
		{
			bw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

}
