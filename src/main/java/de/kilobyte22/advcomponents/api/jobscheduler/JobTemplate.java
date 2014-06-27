package de.kilobyte22.advcomponents.api.jobscheduler;

public interface JobTemplate {
    String getName();
    String getUsage();
    Job makeJob();
}
