

package csc223.am;

public class DNA {
    public static String countNucleotides(String dna){
        int count_a = 0;
        int count_c = 0;
        int count_g = 0;
        int count_t = 0;
        for (int i = 0; i < dna.length(); i++){
            if (dna.charAt(i) == 'A'){
                count_a = count_a + 1;
            }
            if (dna.charAt(i) == 'C'){
                count_c = count_c + 1;
            }
            if (dna.charAt(i) == 'G'){
                count_g = count_g + 1;
            }
            if (dna.charAt(i) == 'T'){
                count_t = count_t + 1;
            }
        }
        return count_a + " " + count_c + " " + count_g + " " + count_t;
    }
    public static String transcribe(String dna){
        String out = "";
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'T'){
                out = out + 'U';
            } else {
                out = out + dna.charAt(i);
                }
            }
        
        return out;
    }
    public static String reverseComplement(String dna){
        String holder = "";
        String out = "";
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'A'){
                holder = holder + 'T';
            }
            if (dna.charAt(i) == 'C'){
                holder = holder + 'G';
            }
            if (dna.charAt(i) == 'G'){
                holder = holder + 'C';
            }
            if (dna.charAt(i) == 'T'){
                holder = holder + 'A';
            }
        }

        for (int i2 = holder.length() - 1; i2 >= 0; i2--){
            out = out + holder.charAt(i2);
        }
        return out;
    }
    public static void main(String[] args) {
        String dna_count = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        String dna_transcribe = "GATGGAACTTGACTACGTAAATT";
        String dna_Complement = "AAAACCCGGT";
        String check_count = countNucleotides(dna_count);
        String check_transcribe = transcribe(dna_transcribe);
        String checkComplement = reverseComplement(dna_Complement);
        System.out.println(check_count);
        System.out.println(check_transcribe);
        System.out.println(checkComplement);

    }
}
