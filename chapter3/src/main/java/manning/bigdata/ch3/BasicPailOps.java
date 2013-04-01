package manning.bigdata.ch3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import backtype.hadoop.pail.Pail;
import backtype.hadoop.pail.Pail.TypedRecordOutputStream;
import backtype.hadoop.pail.PailSpec;
import backtype.hadoop.pail.SequenceFileFormat;

public class BasicPailOps {

	public static void simpleIO() throws IOException {
		Pail pail = Pail.create("/tmp/mypail"); 
		TypedRecordOutputStream os = pail.openWrite(); 
		os.writeObject(new byte[] {1, 2, 3}); 
		os.writeObject(new byte[] {1, 2, 3, 4});
		os.writeObject(new byte[] {1, 2, 3, 4, 5});
		os.close(); 
	}
	
	public static void writeLogins() throws IOException {
		Pail<Login> loginPail = Pail
				.create("/tmp/logins", new LoginPailStructure());
		TypedRecordOutputStream out = loginPail.openWrite();
		out.writeObject(new Login("alex", 1352679231));
		out.writeObject(new Login("bob", 1352674216));
		out.close();
	}
	
	public static void readLogins() throws IOException {
		Pail<Login> loginPail = new Pail<Login>("/tmp/logins");
		for (Login l : loginPail) {
			System.out.println(l.userName + " " + l.loginUnixTime);
		}
	}
	
	public static void appendData() throws IOException {
		Pail<Login> loginPail = new Pail<Login>("/tmp/logins");
		Pail<Login> updatePail = new Pail<Login>("/tmp/updates");
		loginPail.absorb(updatePail);
	}
	
	public static void partitionData() throws IOException {
		Pail<Login> pail = Pail.create("/tmp/partitioned_logins",
				new PartitionedLoginPailStructure());
		TypedRecordOutputStream os = pail.openWrite();
		os.writeObject(new Login("chris", 1352702020));
		os.writeObject(new Login("david", 1352788472));
		os.close();
	}
	
	public static void createCompressedPail() throws IOException {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(SequenceFileFormat.CODEC_ARG, SequenceFileFormat.CODEC_ARG_GZIP);
		options.put(SequenceFileFormat.TYPE_ARG, SequenceFileFormat.TYPE_ARG_BLOCK);
		LoginPailStructure struct = new LoginPailStructure();
		Pail compressed = Pail.create("/tmp/compressed", new PailSpec(
				"SequenceFile", options, struct));
	}
}