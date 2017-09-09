public class Part2
{
    float cgRatio(String DNA)
    {
        int count = 0;
        for(int i = 0; i != DNA.length(); ++i)
        {
            if(DNA.charAt(i) == 'G' || DNA.charAt(i) == 'C')
                count++;
        }
        return (float)count/DNA.length();
    }
    
    void testcgRatio()
    {
        String DNA = "ATGCCATAG";
        System.out.println(cgRatio(DNA));
    }
    
    int countCTG(String DNA)
    {
        int count = 0;
        int index = -1;
        do
        {
            index = DNA.indexOf("CTG", index + 1);
            if(index != -1)
                ++count;
        }while(index != -1);
        return count;
    }
    
    void testCountCTG()
    {
        String DNA = "CTGCTGCTGAATCGTCTG";
        System.out.println(countCTG(DNA));
        DNA = "AATAATAATTAAGATCTATCGA";
        System.out.println(countCTG(DNA));
    }
}