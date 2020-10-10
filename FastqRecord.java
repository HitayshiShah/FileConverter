package dna;

//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord 
{
	private String   defline;
	private String   sequence;
	private String   quality;

	
	//
	// Constructor that gets the correclty formatted lines
	//
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		if (defline.charAt(0) != '@') {
			throw new RecordFormatException("This string does not begin with the right character '@");

		}
		
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;
	}
	
	
	
	public String getDefline() {
		return this.defline;
	}
	public String getSequence() {
		return this.sequence;
	}
	

	//
	// checks for deep equality
	//
	public boolean equals(Object that) {
		FastqRecord check = (FastqRecord)that;
		if(this.defline.equals(check.defline) && this.sequence.equals(check.sequence) && this.quality.equals(check.quality)) {
			return true;
		}
		return false;
	}
	
	//
	// Checks if the quality of file is low 
	//
	public boolean qualityIsLow()
	{
		if (quality.contains("$") && quality.contains("#")) {
			return true;
		}
		return false;
	}
	
	
	
	public int hashCode()
	{
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}
}
