import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<JobEntity> jobs = new ArrayList<>();

        File File_loader = new File("jobs.txt");

        Scanner scanner_obj = new Scanner(File_loader);
        //job ID
        String jID;
        // start time
        int Stime;
        // duration
        int duration;

        JobEntity job_obj = null;

        while(scanner_obj.hasNext())
        {
            jID = scanner_obj.next();
            Stime = scanner_obj.nextInt();
            duration = scanner_obj.nextInt();

            job_obj = new JobEntity(jID,Stime, duration);

            jobs.add(job_obj);


        }

        scanner_obj.close();


        Fcfs fcfs = new Fcfs(jobs);
        fcfs.execute();

        Hrrn hrrn = new Hrrn(jobs);
        hrrn.execute();

    }


}
