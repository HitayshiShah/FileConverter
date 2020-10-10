package dna;


public class FastaRecord implements DNARecord 
{	
	private String   defline;
	private String   sequence;


	//constructor that follows this file format
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if (defline.charAt(0) != '>') {
			throw new RecordFormatException("The first character must be >");
		}
		this.defline = defline;
		this.sequence = sequence;
	}
	
	
	//gets the different lines in the file
	public FastaRecord(FastqRecord fastqRec)
	{
		this.defline = fastqRec.getDefline();
		this.defline = fastqRec.getDefline().replace('@', '>');
		this.sequence = fastqRec.getSequence();
	}
	

	
	public String getDefline() {
		return this.defline;
	}
	public String getSequence() {
		return this.sequence;
	}

	
	
	
	@Override
	public boolean equals(Object that) {
		FastaRecord check = (FastaRecord)that;
		if (this.defline.equals(check.defline) && this.sequence.equals(check.sequence)) {
			return true;
		}
		return false;
	}

	
	@Override
	public int hashCode() {
		return this.defline.hashCode() + this.sequence.hashCode(); 
	}
}
