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
}