package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqRecord.
//


public class FastqReader 
{
	private BufferedReader   theBufferedReader;
	
	
	public FastqReader(BufferedReader br) 
	{
		theBufferedReader = br;
	}
	
	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Reads the defline from the BufferedReader.
		String defline = theBufferedReader.readLine();
		if (defline == null) {
			return null;
		}

		// Read the next 3 lines from the buffered reader. Constructs and returns
		// a FastqRecord.
		String sequence = theBufferedReader.readLine();
		String plus = theBufferedReader.readLine();
		if (!plus.equals("+")) {
			throw new RecordFormatException("There should be a + symbol here.");
		}
		String quality = theBufferedReader.readLine();
		if (quality == null) {
			return null;
		}
		FastqRecord record = new FastqRecord(defline,sequence,quality);
		return record;
	}
	
	
	
}
