import edu.duke.*;
public class Part1
{
    int findStopCodon(String DNA, int startIndex, String stopCodon)
    {
        int endIndex = startIndex;
        while(endIndex != -1)
        {
            endIndex = DNA.indexOf(stopCodon, endIndex + 1);
            if(endIndex != -1 && (endIndex - startIndex) % 3 == 0)
            {
                return endIndex;
            }
        }
        return DNA.length();
    }
    
    String findGene(String DNA)
    {
        int startIndex = DNA.indexOf("ATG");
        if(startIndex == -1)
            return "";
        int index = findStopCodon(DNA, startIndex, "TAA");
        if(index == DNA.length())
        {
            index = findStopCodon(DNA, startIndex, "TAG");
        }
        if(index == DNA.length())
            return "";
        else
            return DNA.substring(startIndex, index + 3);
    }
    
    void findAllGenes(String DNA)
    {
        String gene = "";
        int count = 1;
        int startIndex = 0;
        int index = -1;
        do
        {
            startIndex = DNA.indexOf("ATG", index + 1);
            if(startIndex == -1)
                break;
            index = findStopCodon(DNA, startIndex, "TAA");
            if(index == DNA.length())
            {
                index = findStopCodon(DNA, startIndex, "TAG");
            }
            if(index == DNA.length())
                break;
            gene = DNA.substring(startIndex, index + 3);
            System.out.println("Gene" + ": " + gene);
        }while(gene != "");
    }
    
    StorageResource getAllGenes(String DNA)
    {
        StorageResource store = new StorageResource();
        String gene = "";
        int count = 1;
        int startIndex = 0;
        int index = -1;
        do
        {
            startIndex = DNA.indexOf("ATG", index + 1);
            if(startIndex == -1)
                break;
            index = findStopCodon(DNA, startIndex, "TAA");
            if(index == DNA.length())
            {
                index = findStopCodon(DNA, startIndex, "TAG");
            }
            if(index == DNA.length())
                break;
            gene = DNA.substring(startIndex, index + 3);
            store.add(gene);
        }while(gene != "");
        return store;
    }
    
    void testGetAllGenes()
    {
        String DNA = "ATAATAAAATAATAAATAAATAGATTAGAATGTAG";
        StorageResource store = new StorageResource(getAllGenes(DNA));
        for(String s : store.data())
            System.out.println(s);
        DNA = "GATCGATAGACTGATAGGGGATGCAGTATATCCCTGGATACAATAGACGCACAGGTTGGAATCCTAAGTGAAGTCGCGCGTCCGAACCCAGCTCTATTTTAGAGGTCATGGGTTCTGGTGCCCGCGAGCCGCGGAACCGATTAGGGGCATGTACAACAATATTTATTAGTCATCTTTCAGACACAATCTCCCAGCTCACTGGTATATAGTTCCTGCTATAATTAGCCTCCCTCATAAGTTGCACTACTTCAGCGTCCCAAATGCACCCTTACCACGAAGACAGGATTGTCCGATCCCATATTACGACCTTGGCAGGGGGTTCGCAAGTCCCACCCCAAACGATGCTGAAGGCTCAGGTTTCACAGGGACAAAAGCTTTAAACGCGAGTTCCCGCTCATAACCTGGACCGAATGCAGAATCATGCATCGTTCCACTGTGTTCGTGTCATCTAGGACGGGCGCAAAGGATATATAATTCAATTTTGAATACCTTATATTATTGTACACCTACCGGTCACCAGCCAACAATGTGCGGATGGCGTTACAACTTTCTGGGCCTAATCTGACCGTTCTAGATACCGCACTCTGGGCAATACGAGGTAAAGCCAGTCACCCAGTGTCGATCAACACCTAACCTAACGGTAAGAGGCTCACATAATGGCACTGTCGGCGTCCCCAGGGTATTTTACGTTAGCATCAGGTGGACTAACATGAATCTTTACTCCCAAGCGAAAACGGGTGCGTGGACTAGCGAGGAGCAAACGAAAATTCTTGGCCTGCTTGGTGTCTCGTATTCCTCTTAGAGATCGACGAAATGTTTCACGACCAAGGGAAAGGTCGCCCTACAAAATAGATTTGCGTTACTCTCTCCATAAGGAGTCCGGTGTAGCGAAGGATCAAGGCGACCCTAGGTAGCAACCGCCGGCTTCGGCGGTAAGGTATCACTCAAGAAGCAGACACAGTAAGACACGGTCTAGCTGACTGTCTATCGGCTAGGTCAA";
        //DNA = "ATGATAAAATAATAAATAAATAGATTAGAATGTAG";
        store = getAllGenes(DNA);
        for(String s : store.data())
            System.out.println(s);
    }
}

