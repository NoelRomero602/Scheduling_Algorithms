import java.util.ArrayList;

public class Hrrn extends SchedulerAlgo{

    public Hrrn(ArrayList<JobEntity> list) {
        super(list);
    }

    @Override
    public void execute() {

        System.out.println("  Highest Response Ratio Next");
        System.out.println("  ==================");
        super.Print_Jobs();

        while (!this.jobsLeft.isEmpty())
        {

            Next_job();

            while (this.job.getRemaining_duration() > 0 ) // output the job
            {
                super.print_job();

                this.job.deduct_duration();
            }

            this.jobsLeft.remove(this.job);
        }
        ++this.time_elapsed;
    }

    @Override
    public void Next_job() {
        get_Read_jobs();
        int max_ratio = Integer.MIN_VALUE;
        int cur_ratio = Integer.MIN_VALUE;

        JobEntity min_Job = null;

        for(JobEntity jObj : this.ready_job_list)
        {
            cur_ratio = jObj.getHRR(this.time_elapsed);
            if(max_ratio < cur_ratio)
            {
                max_ratio = cur_ratio;
                min_Job = jObj;
            }

        }

        this.job = min_Job;
        this.ready_job_list.remove(min_Job);

    }

    public void get_Read_jobs(){
        for(JobEntity jObj: this.jobsLeft)
        {
            if(this.time_elapsed <= jObj.getOriginal_start_time())
            {
                this.ready_job_list.add(jObj);
            }

        }

    }


}
