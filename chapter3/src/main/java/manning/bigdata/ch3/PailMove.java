package manning.bigdata.ch3;

import java.io.IOException;
import backtype.hadoop.pail.Pail;

public class PailMove {
 
	public static void mergeData(String masterDir, String updateDir)
			throws IOException
	{
		Pail target = new Pail(masterDir); 
		Pail source = new Pail(updateDir);
		target.absorb(source); 
		target.consolidate(); 
	}
}