public class demo{
	
	public static void main(String args[]){
	SchedulingRunnable task = new SchedulingRunnable("postTask", "checkHeartTask");
        cronTaskRegistrar.addCronTask(task, "0 0/10 * * * ? *");

	}
}