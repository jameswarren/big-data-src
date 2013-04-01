package manning.bigdata.ch3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartitionedLoginPailStructure extends LoginPailStructure {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public List<String> getTarget(Login object) {
		ArrayList<String> directoryPath = new ArrayList<String>();
		Date date = new Date(object.loginUnixTime * 1000L);
		directoryPath.add(formatter.format(date));
		return directoryPath;
	}

	public boolean isValidTarget(String... strings) {
		if (strings.length != 1)
			return false;
		try {
			return (formatter.parse(strings[0]) != null);
		} catch (ParseException e) {
			return false;
		}
	}
}