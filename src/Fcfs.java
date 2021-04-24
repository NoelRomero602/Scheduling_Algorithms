import java.util.ArrayList;

public class Fcfs extends SchedulerAlgo {
    public Fcfs(ArrayList<JobEntity> list)
    {
        super(list);
    }

    @Override
    public void execute() {

        System.out.println("  First in First Out");
        System.out.println("  ==================");
         super.Print_Jobs();




         while (!this.jobsLeft.isEmpty())
         {

         Next_job(); // get the next job that has the min start time

             while (this.job.getRemaining_duration() > 0 ) // output the job
             {
                 super.print_job();

                 this.job.deduct_duration();
             }

             this.jobsLeft.remove(this.job);

         }

         // reset jobs for next schedular algo
        reset_jobs();
    }


    public void Next_job ( )
    {
        JobEntity min_Job = null;
        int min = 100000;
        for(JobEntity jObj: this.jobsLeft)
        {
            if(jObj.getOriginal_start_time() < min)
            {
                min_Job = jObj;
                min = min_Job.getOriginal_start_time();
            }

        }

       this.job = min_Job;
    }


}
