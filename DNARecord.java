package dna;


//
// FastqRecord and FastaRecord should implement this.
//
// Remember that in implementing classes, the interface
// method have to be public.
//


public interface DNARecord 
{
	String		getDefline();
	String		getSequence();
}
