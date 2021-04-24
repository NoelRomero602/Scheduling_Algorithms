import java.util.ArrayList;

public class Spn extends SchedulerAlgo {


    public Spn(ArrayList<JobEntity> list) {
        super(list);
    }

    @Override
    public void execute() {
        System.out.println("  SPN");
        System.out.println("  ==================");
        super.Print_Jobs();

        while (!this.jobsLeft.isEmpty())
        {
            Next_job();

            while (this.job.getRemaining_duration() > 0 ) // output the job
            {
                super.print_job();

                this.job.deduct_duration();
                ++this.time_elapsed;
            }

            this.jobsLeft.remove(this.job);
        }

        reset_jobs();
    }

    @Override
    public void Next_job() {
        get_Ready_jobs();
        JobEntity min_Job = null;
        int min = 100000;
        for(JobEntity jObj: this.ready_job_list)
        {
            if(jObj.getOriginal_duration() < min)
            {
                min =jObj.getOriginal_duration();
                min_Job = jObj;
            }

        }

        this.job = min_Job;

        this.ready_job_list.remove(min_Job);
    }

    public void get_Ready_jobs(){
        for(JobEntity jObj: this.jobsLeft)
        {
            if(this.time_elapsed >= jObj.getOriginal_start_time())
            {
                this.ready_job_list.add(jObj);
            }

        }

    }


}
