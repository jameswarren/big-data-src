package manning.bigdata.swa;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class SimpleMerge {
	public static void mergeFolders(String destDir, String sourceDir)	
			throws IOException {
		Path destPath = new Path(destDir);
		Path sourcePath = new Path(sourceDir);
		FileSystem fs = sourcePath.getFileSystem(new Configuration());
		for (FileStatus current : fs.listStatus(sourcePath)) {
			Path curPath = current.getPath();
			fs.rename(curPath, new Path(destPath, curPath.getName()));
		}
	}
}