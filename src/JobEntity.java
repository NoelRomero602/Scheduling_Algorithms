public class JobEntity {
    private String job_id = null;
    private int original_start_time = 0;
    private int temp_start_time = 0;
    private int remaining_duration = 0;
    private int original_duration = 0;

    public int getOriginal_duration() {
        return original_duration;
    }

    public int getHRR(int time_elapsed)
   {

       int w_temp = (time_elapsed - original_start_time);
       int ratio_temp = (w_temp + original_duration) / original_duration;
       return ratio_temp;
   }

    public boolean isEqual(JobEntity jobj)
    {
        return (this.job_id.equals(jobj.job_id)) && (this.original_start_time == jobj.original_start_time)
                && (this.original_duration == jobj.original_duration);
    }

    public JobEntity(String jid, int Stime, int duration )
    {
        this.job_id = jid;
        this.original_start_time = Stime;
        this.temp_start_time = Stime;
        this.remaining_duration = duration;
        this.original_duration = duration;
    }

    public String getJob_id()
    {
        return  this.job_id;
    }

    public int getOriginal_start_time ()
    {
        return  this.original_start_time;
    }

    public int getTemp_start_time()
    {
        return  temp_start_time;
    }

    public int getRemaining_duration ()
    {
        return  this.remaining_duration;
    }

    public void setOriginal_start_time(int st)
    {
        this.temp_start_time = st;
    }

    public void setDuration(int dur) {
        if (remaining_duration > 0 )
        {
            this.remaining_duration = dur;
        }
        else
        {
            this.remaining_duration = 0;
        }
    }

    public void deduct_duration()
    {
       -- this.remaining_duration;
    }

    public void resetDuration()
    {
        this.remaining_duration = this.original_duration;
    }

    public void resetStartTime(){
        this.temp_start_time = this.original_start_time;
    }


}
