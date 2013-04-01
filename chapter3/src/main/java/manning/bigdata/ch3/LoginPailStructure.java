package manning.bigdata.ch3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import backtype.hadoop.pail.PailStructure;

public class LoginPailStructure implements PailStructure<Login> {
	public Class getType() {
		return Login.class;
	}

	public byte[] serialize(Login login) {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(byteOut);
		byte[] userBytes = login.userName.getBytes();
		try {
			dataOut.writeInt(userBytes.length);
			dataOut.write(userBytes);
			dataOut.writeLong(login.loginUnixTime);
			dataOut.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return byteOut.toByteArray();
	}

	public Login deserialize(byte[] serialized) {
		DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(
				serialized));
		try {
			byte[] userBytes = new byte[dataIn.readInt()];
			dataIn.read(userBytes);
			return new Login(new String(userBytes), dataIn.readLong());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<String> getTarget(Login object) {
		return Collections.EMPTY_LIST;
	}

	public boolean isValidTarget(String... dirs) {
		return true;
	}
}
