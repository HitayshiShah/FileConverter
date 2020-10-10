package dna;

import java.io.*;


//
// Writes a fasta record to a print writer.
//


public class FastaWriter 
{
	PrintWriter thePrintWriter;
	public FastaWriter(PrintWriter pw) 
	{
		thePrintWriter = pw;
	}
	
	// writes the two lines from another file
	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
	}
}
