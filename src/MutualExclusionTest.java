import java.util.*;
import java.io.*;

public class MutualExclusionTest
{
	public static void main(String[] args) throws Exception
	{
		boolean value = MutualExclusionTest.test("output.txt");
		System.out.println(value);
	}

	public static boolean test(String filename) throws Exception
	{
		File f = new File(filename);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String s;
		ArrayList<String> values = new ArrayList<String>();
		while((s = br.readLine()) !=null) 
		{
			values.add(s);
		}
		boolean bool = true;
		ListIterator<String> li = values.listIterator();
		String firstvalue = li.next();
		int counter = 1;
		while(li.hasNext())
		{
			String previous = li.previous();
			String dummy = li.next();
			String now = li.next();
			StringTokenizer st_previous = new StringTokenizer(previous);
			String enter_leave_previous = st_previous.nextToken();
			String pid_previous = st_previous.nextToken();
			StringTokenizer st_now = new StringTokenizer(now);
			String enter_leave_now = st_now.nextToken();
			String pid_now = st_now.nextToken();

			if(enter_leave_previous.equals("cs-enter"))
			{
				if(!enter_leave_now.equals("cs-exit"))
				{
					bool = false;
					System.out.println("Error around line# " +counter);
					break;
				}
				else
				{
					if(!pid_previous.equals(pid_now))
					{
						bool = false;
						System.out.println("Error around line# " +counter);
						break;
					}

				}

			}
			counter++;
		}
		return bool;
	}
}