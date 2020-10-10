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
	// Add a precondition check: throw RecordFormatException if the 1st char of the defline is 
	// not '@'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
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
	
	
	// 
	// Provide the 2 methods that satisfy the interface.
	//
	public String getDefline() {
		return this.defline;
	}
	public String getSequence() {
		return this.sequence;
	}
	

	//
	// Provide an equals() method that checks for deep equality of all 3 instance variables. 
	// When checking string variables, be sure to do it like this:  
	//              this.defline.equals(that.defline) 
	// and not like this:  
	//              this.defline == that.defline
	//
	public boolean equals(Object that) {
		FastqRecord check = (FastqRecord)that;
		if(this.defline.equals(check.defline) && this.sequence.equals(check.sequence) && this.quality.equals(check.quality)) {
			return true;
		}
		return false;
	}
	
	//
	// Complete this according to the assignment instructions.
	//
	public boolean qualityIsLow()
	{
		if (quality.contains("$") && quality.contains("#")) {
			return true;
		}
		return false;
	}
	
	
	//
	// Complete this. Return the sum of the hash codes of defline, sequence, and quality.
	//
	public int hashCode()
	{
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}
}
