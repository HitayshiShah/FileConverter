package dna;

import java.io.*;
import java.util.*;


public class FileConverter 
{
	File fastq;
	File fasta;
	 
	public FileConverter(File q, File a) {
		fastq = q;
		fasta = a;
	}
	//
	// converts the fastq file to the fasta file
	//
	public void convert() throws IOException
	{
		// Builds chain of readers for reading fast records from the fastq file.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Builds chain of writers for writing fasta records to the fasta file.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		
		// Reads, translates, and writes the file.
		boolean done = false;
		while (!done) {

			try {
				FastqRecord check = fqr.readRecord();
				if (check == null) {
					break;
				}
				if (!check.qualityIsLow()) {
					FastaRecord record = new FastaRecord(check);
					faw.writeRecord(record);
				}
			}
			catch (RecordFormatException x) {
				System.out.println(x.getMessage());
			}
		}	
		
		// Close fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}
		
	
	public static void main(String[] args)
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
