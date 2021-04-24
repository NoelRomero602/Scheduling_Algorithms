import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.math.*;
public abstract class SchedulerAlgo {

    public JobEntity job = null;
    public int time_elapsed = 0;
    public ArrayList<JobEntity> initial_jobList = null;
    public ArrayList<JobEntity> jobsLeft = null;
    public ArrayList<JobEntity>  ready_job_list = null;

    public String mark = "X";
    public String blank= "";


    public List<JobEntity> job_line;

    public SchedulerAlgo(ArrayList<JobEntity> list){
        time_elapsed = 0;
        this.jobsLeft = new ArrayList<>();
        this.initial_jobList = new ArrayList<>();
        ready_job_list =new ArrayList<>();
       for(JobEntity job: list)
       {
           this.initial_jobList.add(job);
           this.jobsLeft.add(job);
       }

    }

public abstract void execute();
    public abstract void Next_job ();

    public void Print_Jobs()
    {
        System.out.printf("  ");
        for(JobEntity jObj: initial_jobList)
        {
            System.out.printf("%s", jObj.getJob_id());
        }
        System.out.print("\n");
    }

    public void print_job()
    {

       int num_spaces = Math.abs(initial_jobList.indexOf(job)  +1 );

       if(num_spaces == 0)
       {
           num_spaces = 1;
       }

        System.out.printf("%-" + num_spaces + "s %s",blank,job.getJob_id());
       System.out.printf("\n");


    }

    public void reset_jobs()
    {
        for(JobEntity jobEntity: this.initial_jobList)
        {
            jobEntity.resetDuration();
            jobEntity.resetStartTime();
        }
    }

}
