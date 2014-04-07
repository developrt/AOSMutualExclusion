import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* Application Module */

public class Application {
	static int my_id;

	/*
	 * Thread that generates CS request after a random wait If token is with
	 * this node and the Q is empty no request for CS is generated else Request
	 * for CS is generated
	 */
	public static void main(String args[]) {
		my_id = Integer.parseInt(args[0]);
		int counter = 0;
		DistMutEx distributedMutex = new DistMutEx(my_id);
		while (distributedMutex.csEnter()) {
			//boolean gotToken = distributedMutex.csEnter();
		//	if (gotToken) {
				try {
					
					File file = new File("output.txt");
					// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
						String content = "cs-enter pid" + my_id;
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(content);
						bw.close();
					}
					else{
						FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
						String content = "\ncs-enter pid" + my_id;
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(content);
						bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String content = "\ncs-exit pid" + my_id;
					File file = new File("output.txt");
					// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(content);
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		//	}
			distributedMutex.csLeave();
			counter++;
			if(counter>50)
				break;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		distributedMutex.close();
		System.out.println("Exiting from main method");
	}
}
