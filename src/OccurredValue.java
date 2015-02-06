import java.util.Random;

public class OccurredValue
{
	static final int ARR_SI = 10;
	static Random random = new Random();
	
	static
	{ random.setSeed(System.currentTimeMillis()); }
	
	static int getRandom(int _low, int _high)
	{ return random.nextInt(_high - _low + 1) + _low; }
	
	public static void main(final String[] _args)
	{
		int[] array = new int[ARR_SI];
		System.out.print("Given array:");
		for (int i = 0; i < array.length; i++)
		{
			array[i] = getRandom(0, 9);
			System.out.print(" " + array[i]);
		}
		System.out.println();
		int minOcc = getRandom(1, 3);
		System.out.println("Min occurred(times): " + minOcc);
		System.out.print("Max occurred(value): " + 
			Integer.toString(solution(minOcc, array)));
	}
	
    static int solution(int _max, int[] _array)
    {
        int ambit = _array.length;
        int[] count = new int[ambit];
        for (int i = 0; i < ambit; i++) count[i] = 0;
        int maxOccurence = _max;
        int index = -1;
        for (int i = 0; i < ambit; i++)
        {
            if (count[_array[i]] > 0)
            {
                int tmp = count[_array[i]];
                count[_array[i]] = ++tmp;
                if (tmp >= maxOccurence)
                {
                    maxOccurence = tmp;
                    index = i;
                }                
            } 
            else count[_array[i]] = 1;
        }
        return (index > -1) ? _array[index] : index;
    }
}