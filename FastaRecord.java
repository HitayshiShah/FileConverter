package dna;


public class FastaRecord implements DNARecord 
{	
	private String   defline;
	private String   sequence;


	//
	// Add a precondition check: throw RecordFormatException if the 1st char of the defline is 
	// not '>'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if (defline.charAt(0) != '>') {
			throw new RecordFormatException("The first character must be >");
		}
		this.defline = defline;
		this.sequence = sequence;
	}
	
	
	// Initialize defline and sequence from the input record. The defline should be the
	// defline of the fastq record, but with a '>' in the first position rather than a '@'.
	// If you’re not sure how to do this, look up the substring method on the String API page.
	public FastaRecord(FastqRecord fastqRec)
	{
		this.defline = fastqRec.getDefline();
		this.defline = fastqRec.getDefline().replace('@', '>');
		this.sequence = fastqRec.getSequence();
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
	// Provide an equals() method. 
	//
	@Override
	public boolean equals(Object that) {
		FastaRecord check = (FastaRecord)that;
		if (this.defline.equals(check.defline) && this.sequence.equals(check.sequence)) {
			return true;
		}
		return false;
	}

	//
	// Provide a hashCode() method that returns the sum of the hashcodes of 
	// defline and sequence.
	//
	@Override
	public int hashCode() {
		return this.defline.hashCode() + this.sequence.hashCode(); 
	}
}
